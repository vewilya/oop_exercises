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
package ch.hslu.oop.SW06.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demo-Applikation für {@link ch.hslu.oop.SW06.Named.Product}-Klasse.
 */
public final class DemoApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoApp.class);

    /** Temperature Example. */
    private static final String NAME = "Toaster";

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
        final Product toaster = new Product();
        toaster.setName(NAME);

        String name = toaster.getName();
        String id = toaster.getId();

        // Subtyping / Upcasting / Downcasting
        // product2 als named gecastet.
        Named product2 = new Product();
        product2.setName("Coffee Machine");

        String name2 = product2.getName();

        // Nicht möglich, da diese Methode nur auf der Implementierung Product verfügbar
        // ist und nicht auf dem Interface Named!
        // String id2 = product2.getID();

        // -----------
        toaster.setCategoryName("Kitchenware");
        String productCategory = toaster.getCategoryName();
        LOGGER.info("The category of the toaster is {}", productCategory);

        LOGGER.info("The name of product number 2 is {}", name2);
        LOGGER.info("THe name of the product is {}, and the id is {}", name, id);

        Category category1 = new Category("Utilities");
        Category category2 = new Category("Food");

        String category1Name = category1.getName();
        String category2Name = category2.getName();

        LOGGER.info("The name of Category 1 is {}", category1Name);
        LOGGER.info("The name of Category 2 is {}", category2Name);
    }
}
