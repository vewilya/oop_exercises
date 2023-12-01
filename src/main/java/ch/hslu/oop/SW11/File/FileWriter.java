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

package ch.hslu.oop.SW11.File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FileWriter {

    public FileWriter() {
    }

    private static final Logger LOG = LoggerFactory.getLogger(FileWriter.class);

    public static void main(String[] args) {
        final FileWriter fWriter = new FileWriter();

        // fWriter.writeTextFile("oop_exercises/src/main/java/ch/hslu/oop/SW11/File/tmp/demo.txt");

        // fWriter.readTextFile("oop_exercises/src/main/java/ch/hslu/oop/SW11/File/tmp/demo.txt");
    }

    public void writeTextFile(final String file) {
        String fileName = file.substring(5).substring(0, 4);
        String fileExtension = file.substring(5).substring(4, 8);
        String filePath = file.substring(0, 5);

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file), Charset.forName("UTF-8"))))) {
            pw.println("Short Text");
            pw.flush();

            LOG.info("Write a file called {} of type {} to {}", fileName.toUpperCase(), fileExtension, filePath);
        } catch (IOException ioe) {
            LOG.error(ioe.getMessage(), ioe);
        }
    }

    public void writeIntFile (final int integerNumber) {
        String filePath = "tmp/intTest.txt";
        
        // try (
        //     FileOutputStream fos = new FileOutputStream(filePath);
        //     DataOutputStream dos = new DataOutputStream(fos);
        // ) {

        // }
        
    }


    public void readTextFile(final String file) {
        if (new File(file).exists()) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), Charset.forName("UTF-8")))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException ioe) {
                LOG.error(ioe.getMessage(), ioe);
            }
        }
    }
}
