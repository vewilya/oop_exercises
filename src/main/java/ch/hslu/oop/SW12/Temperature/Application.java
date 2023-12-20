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

package ch.hslu.oop.SW12.Temperature;

import java.beans.PropertyChangeListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO Checke BinärFile
/**
 * Application
 */
public class Application {

    public Application() {
    }

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        String input;
        Scanner scanner = new Scanner(System.in);

        ReaderWriter statsFileRnR = new ReaderWriter();

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
                    temperatureHistory.add(new TemperaturePoint(temperature, LocalDateTime.now()));
                    LOG.info("Entered temperature value is {} Degree Celsius.", input);

                } catch (NumberFormatException nfe) {
                    LOG.error("Please enter a floating point value! Message: {}", nfe.getMessage(), nfe);
                } catch (IllegalArgumentException iae) {
                    LOG.error("Please respect Low Temperature Limit", iae.toString());
                }
            } else if (input.equals("reset")) {
                System.out.println("Reset");

                // Delete Stats File
                statsFileRnR.deleteStatsFile();

                // Reset Temperature History
                temperatureHistory.clear();
            } else {
                LOG.info("Exit Progam");

                if (temperatureHistory.getCount() > 0) {
                    LOG.info("Temperature History {}", temperatureHistory.toString());
                    statsFileRnR.printStatstFile("temperatureStats.bin", temperatureHistory);
                } else
                    LOG.info("Empty temperature history. No file was saved to disk");

                statsFileRnR.readStatsFile("temperatureStats.bin");
            }

        } while (!"exit".equals(input));

        // Avoid Memory Leakage and close scanner object!
        scanner.close();

    } // close main

}