/*
 * Copyright 2023 Roland Gisler, HSLU Informatik, Switzerland
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
package ch.hslu.oop.SW06.Shape;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demo-Applikation für {@link ch.hslu.oop.SW05.Shape.Shape}-Klasse.
 */
public final class Subtyping {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoApp.class);

    /** Temperature Example. */
    // private static final int TEMPERATURE = 1000;

    /**
     * Privater Konstruktor.
     */
    private Subtyping() {
    }

    /**
     * Main-Methode.
     * @param args Startargumente.
     */
    public static void main(final String[] args) {

        Shape shape1 = new Rectangle(20, 20, 10, 20);
        Shape shape2 = new Circle(50, 60, 20);

        shape1.move(55, 77);
        shape2.move(45, 234);

        // System.out.println(shape2.getDiameter());

        Circle shape3 = (Circle) shape2;
        System.out.println(shape3.getDiameter());

        // Oder einfacher
        int diameter = ((Circle) shape2).getDiameter();
        System.out.println(diameter);
        
        
        // Rectangle rect = new Rectangle(100, 100, 300, 20);

        // int area = rect.getArea();
        // int perimeter = rect.getPerimeter();

        // LOGGER.info("The Rectangle has an area of {} and a perimeter of {}", area, perimeter);
    }
}
