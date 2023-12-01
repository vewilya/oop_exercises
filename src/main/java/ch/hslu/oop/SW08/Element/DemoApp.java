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
package ch.hslu.oop.SW08.Element;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demo-Applikation für {@link ch.hslu.oop.SW05.Element.Mercury}-Klasse.
 */
public final class DemoApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoApp.class);

    /** Temperature Example. */
    private static final int TEMPERATURE = -200;

    /**
     * Privater Konstruktor.
     */
    private DemoApp() {
    }

    /**
     * Main-Methode.
     * 
     * @param args Startargumente.
     */
    public static void main(final String[] args) {
        // final Mercury mercury = new Mercury();
        // final Lead lead = new Lead();

        System.out.println("--------------------------------");
        LOGGER.info("Lead New, Classification {}", new Lead().getElementClassification());
        LOGGER.info("Lead New, Boiling Point {}", new Lead().getBoilingPoint());
        LOGGER.info("Lead New, Melting Point {}", new Lead().getEvaporationPoint());

        LOGGER.info("Lead Aggregate State for {}°C is {}", TEMPERATURE, new Lead().getAggregateState(TEMPERATURE));
        System.out.println("--------------------------------");

    }
}
