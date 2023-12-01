package ch.hslu.oop.SW07.Element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Demo-Applikation für {@link ch.hslu.oop.SW05.Element.Element}-Klasse.
 */
public final class ElementApp {
    
    /**
     * Private Constructor.
     */
    private ElementApp() {
    }

    public static void main(String[] args) {
        /**
         * Instantiate and fill an array list with our 3 elements.
         */
        List<Element> elementList = new ArrayList<>();
        elementList.add(new Mercury());
        elementList.add(new Lead());
        elementList.add(new Nitrogen());

        /**
         * Print out the unsorted array list.
         */
        System.out.println("------------------");
        for (Element element : elementList) {
            System.out.println(element.toString());
        }

        /**
         * Sort our array list using our compareTo implementation on the element class.
         */
        Collections.sort(elementList);

        /**
         * Print out the sorted array list.
         */
        System.out.println("------------------");
        for (Element element : elementList) {
            // System.out.println(element.toString());
            System.out.println(element.getElementClassification());
        }

        System.out.println("------------------");

    }
}
