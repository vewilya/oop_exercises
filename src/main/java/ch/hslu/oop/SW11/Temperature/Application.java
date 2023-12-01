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
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO Enter same temperature value?!?
// TODO 
/**
 * Application
 */
public class Application {

    // Logge
    public Application() {
    }

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

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

            if(!input.equals("exit")) {
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
            } else {
                LOG.info("Exit Progam");
                LOG.info("Temperature History {}", temperatureHistory.toString());
            }

        } while (!"exit".equals(input));


        // Avoid Memory Leakage and close scanner object!
        scanner.close();
        
    } // close main
}