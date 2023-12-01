/*
 * Copyright 2023 Roland Gisler, Urs Bollhalder, HSLU Informatik, Switzerland
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

package ch.hslu.oop.SW11.csvTemperatureRead;

import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class Reader {
    
    private final String filePath = "oop_exercises/src/main/java/ch/hslu/oop/SW11/csvTemperatureRead/netatmo-export-202301-202304.csv";
    File csvFile = new File(filePath);

    private static final Logger LOG = LoggerFactory.getLogger(Reader.class);

    public Reader() {}


    public static void main(String[] args) {

        // CSV
        final String filePath = "oop_exercises/src/main/java/ch/hslu/oop/SW11/csvTemperatureRead/netatmo-export-202301-202304.csv";
        File csvFile = new File(filePath);
        
        // String Manipulation
        final StringMangler sm = new StringMangler();

        // Temperature History
        TemperatureHistory tHis = new TemperatureHistory();

        // Logger
        LOG.info("File exists: {}", csvFile.exists());
        
        if (csvFile.exists()) {
            try (BufferedReader br = 
                new BufferedReader(new InputStreamReader( 
                    new FileInputStream(csvFile), Charset.forName("UTF-8")))) {
               
                String line;
                
                while ((line = br.readLine()) != null) {
                    
                    Float t = Float.valueOf(sm.getSplitPart(line, ";", 2));
                    String timestampAsString = sm.getSplitPart(line, ";", 1);
                    LocalDateTime timestamp = sm.formatLTD(timestampAsString);

                    // Add Temperatures to History
                    tHis.add(Temperature.createFromCelsius(t));
                }

                System.out.println("Number of Temperatures: " + tHis.getCount());
                
                System.out.println("Minimum Temperature: " + tHis.getMinTemperature());
                System.out.println("Maximum Temperature: " + tHis.getMaxTemperature());
                System.out.println("Average Temperature: " + tHis.getAverageTemperature());
                
            } catch (IOException ioe) {
                LOG.error(ioe.getMessage(), ioe);
            }
        }
    }
}
