package ch.hslu.oop.SW12.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demo-Applikation für {@link ch.hslu.oop.SW07.Person.PersonComparator}-Klasse.
 */
public final class ComparatorDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoApp.class);

    /** Person Example */
    // private static final String NAME = "Jordan";
    // private static final String SURNAME = "Michael";

    /**
     * Privater Konstruktor.
     */
    private ComparatorDemo() {
    }

    /**
     * Main-Methode.
     * @param args Startargumente.
     */
    public static void main(final String[] args) {

        /** Instantiate an empty array list for our Person objects*/
        final List<Person> persons = new ArrayList<Person>();

        /**
         * Filling our array list with a bunch of people.
         */
        persons.add(new Person(1125L, "Michael", "Jordan"));
        persons.add(new Person(9843L, "Steve", "Gordon"));
        persons.add(new Person(8543L, "Mick", "Tracey"));
        persons.add(new Person(7543L, "Dave", "Apelbaum"));
        persons.add(new Person(3325L, "Donovan", "McReary"));
        persons.add(new Person(2315L, "Sebastian", "Van Duik"));

        /**
         * Print out the unsorted array list
         */
        System.out.println("------------------");
        System.out.println("Original Array List:");
        for (Person p : persons) {
            System.out.println(p.toString());
        }

        /**
         * Sort the array list by calling the sort method and passing in an instance of the PersonComparator as an argument.
         */
        // persons.sort(new PersonComparator());
        
        /**
         * Print out the sorted array list.
         */
        System.out.println("------------------");
        System.out.println("Sorted Array List:");
        
        for (Person p : persons) {
            System.out.println(p.toString());
        }

        System.out.println("------------------");
        System.out.println("Max: " + Collections.max(persons));
        
        System.out.println("------------------");
        System.out.println("Min: " + Collections.min(persons));
    }
}
