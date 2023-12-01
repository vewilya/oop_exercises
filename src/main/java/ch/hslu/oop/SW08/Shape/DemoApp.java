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
package ch.hslu.oop.SW08.Shape;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demo-Applikation für {@link ch.hslu.oop.SW05.Shape.Shape}-Klasse.
 */
public final class DemoApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoApp.class);

    /** Temperature Example. */
    // private static final int TEMPERATURE = 1000;

    /**
     * Privater Konstruktor.
     */
    private DemoApp() {
    }

    /**
     * Main-Methode.
     * @param args Startargumente.
     */
    public static void main(final String[] args) {
        Rectangle rect = new Rectangle(100, 100, 300, 20);

        int area = rect.getArea();
        int perimeter = rect.getPerimeter();

        LOGGER.info("The Rectangle has an area of {} and a perimeter of {}", area, perimeter);
    }
}
