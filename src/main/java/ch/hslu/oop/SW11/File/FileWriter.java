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

import java.io.BufferedOutputStream;
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
    private static String basePath = "src/main/java/ch/hslu/oop/SW11/File/tmp/";

    public static void main(String[] args) {

        final FileWriter fWriter = new FileWriter();

        /*
         * Write int number to File.
         */
        fWriter.writeIntFile(basePath + "intTest.bin", 1);
        /*
         * Read Integer File.
         */
        LOG.info("Reading integer file: ");
        fWriter.readIntFile(basePath + "intTest.bin");

        // /*
        // * Write Text File.
        // */
        // fWriter.writeTextFile(basePath + "demo.txt", "Write This!!!");

        // /*
        // * Read Text File.
        // */
        // LOG.info("Reading String: ");
        // fWriter.readTextFile(basePath + "demo.txt");
    }

    public void writeTextFile(final String file, final String text) {
        String fileName = file.substring(5).substring(0, 4);
        String fileExtension = file.substring(5).substring(4, 8);
        String filePath = file.substring(0, 5);

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file), Charset.forName("UTF-8"))))) {

            pw.println(text);
            pw.flush();

            LOG.info("Write a file called {} of type {} to {}", fileName.toUpperCase(), fileExtension, filePath);
        } catch (IOException ioe) {
            LOG.error(ioe.getMessage(), ioe);
        }
    }

    /**
     * Method to read a text file.
     * 
     * @param file File path to read from
     */
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

    public void writeIntFile(final String file, final int number) {

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {

            // First out original number from the input.
            dos.write(number);

            int b = 33;
            dos.writeInt(b);
            double d = 0.432543654656d;
            dos.writeDouble(d);

            // Flush Output Stream
            dos.flush();

            LOG.info("Wrote output stream!");
        } catch (IOException ioe) {
            LOG.error(ioe.getMessage(), ioe);
        }
    }

    public void readIntFile(final String file) {
        if (new File(file).exists()) {
            try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {

                // Reverse order reading out
                int integerNumber = dis.read();
                System.out.println(integerNumber);
                int b = dis.readInt();
                System.out.println(b);
                double d = dis.readDouble();
                System.out.println(d);

            } catch (IOException ioe) {
                LOG.error(ioe.getMessage(), ioe);
            }
        }
    }
}
