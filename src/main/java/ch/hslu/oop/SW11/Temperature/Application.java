/*
 * Copyright 2023 Roland Gisler, UrsBollhalder, HSLU Informatik, Switzerland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ch.hslu.oop.SW11.Temperature;

import java.beans.PropertyChangeListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application
 */
public class Application {

    // Logge
    public Application() {
    }

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    private static final void printStatstFile(final String file, final TemperatureHistory tempHis) {

        String basePath = "oop_exercises/src/main/java/ch/hslu/oop/SW11/Temperature/tmp/";
        String filePath = basePath + file;

        int numObjects = tempHis.getCount();
        List<Temperature> tList = tempHis.getTemperatureList();

        if (!new File(basePath).exists())
            new File(basePath).mkdir();

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {

            dos.writeInt(numObjects);

            for (final Temperature t : tList) {
                dos.writeDouble(t.getTemperatureCelsius());
            }

            LOG.info("Wrote Temperature Stats to File!");
            dos.flush();
        } catch (IOException ioe) {
            LOG.error(ioe.getMessage(), ioe);
        }
    }

    private static final void readStatsFile(String file) {
        String basePath = "oop_exercises/src/main/java/ch/hslu/oop/SW11/Temperature/tmp/";
        String filePath = basePath + file;

        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            int numObjects = dis.readInt();
            System.out.println(numObjects);

            for (int i = 0; i < numObjects; i++) {
                double value = dis.readDouble();
                System.out.println(value);
            }

        } catch (IOException ioe) {
            LOG.error(ioe.getMessage(), ioe);
        }

    }

    private final static void deleteStats() {
        File f = new File("oop_exercises/src/main/java/ch/hslu/oop/SW11/Temperature/tmp/temperatureStats.txt");

        if (f.exists())
            f.delete();
    }
    public static void main(String[] args) {

        String input;
        Scanner scanner = new Scanner(System.in);

        TemperatureHistory temperatureHistory = new TemperatureHistory();
        temperatureHistory.addTemperatureEventListener(new TemperatureEventListener() {
            @Override
            public void temperatureEventChange(TemperatureEvent temperatureEvent) {
                // LOG.info("Temperature Event: {}", temperatureEvent.toString());
            }
        });

        do {
            LOG.info("Bitte Temperatur eingeben (oder 'exit' zum Beenden): ");

            input = scanner.next();

            if (!input.equals("exit") && !input.equals("reset")) {
                try {
                    float value = Float.valueOf(input);
                    Temperature temperature = Temperature.createFromCelsius(value);

                    // Adding temperature to history
                    temperatureHistory.add(temperature);
                    LOG.info("Entered temperature value is {} Degree Celsius.", input);

                } catch (NumberFormatException nfe) {
                    LOG.error("Please enter a floating point value! Message: {}", nfe.getMessage(), nfe);
                } catch (IllegalArgumentException iae) {
                    LOG.error("Please respect Low Temperature Limit", iae.toString());
                }
            } else if (input.equals("reset")) {
                System.out.println("Reset");
                
                // Delete Stats File
                deleteStats();

                // Reset Temperature History
                temperatureHistory.clear();
            } else {
                LOG.info("Exit Progam");

                
                if (temperatureHistory.getCount() > 0) {
                    LOG.info("Temperature History {}", temperatureHistory.toString());
                    printStatstFile("temperatureStats.txt", temperatureHistory);
                } else 
                    LOG.info("Empty temperature history. No file was saved to disk");
                    
                readStatsFile("temperatureStats.txt");
            }

        } while (!"exit".equals(input));

        // Avoid Memory Leakage and close scanner object!
        scanner.close();

    } // close main

}