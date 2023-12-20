package ch.hslu.oop.SW12.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PersonComparator implements Comparable<PersonComparator> {

    private static final Logger LOG = LoggerFactory.getLogger(PersonComparator.class);

    public static void main(String[] args) {

        final PersonComparator pC = new PersonComparator();

        // { hint... 26 letters in alphabet }
        Person p1 = new Person(2234, "Damian", "Case");
        Person p2 = new Person(2235, "Gregory", "Boulder");
        Person p3 = new Person(2236, "Fred", "Wesley");
        Person p4 = new Person(2237, "Zeus", "Zunder");

        final ArrayList<Person> c = new ArrayList<Person>();

        c.add(p1);
        c.add(p2);
        c.add(p3);
        c.add(p4);

        System.out.println("-------------------");

        for (final Person p : c) {
            LOG.info("Person: {}", p.toString());
        }

        Collections.sort(c, pC.lastNameComp.thenComparing(pC.firstNameComp));

        System.out.println("-------------------");

        for (final Person p : c) {
            LOG.info("Person: {}", p.toString());
        }
    }

    // ---------------------- Constructor ---------------------- //
    public PersonComparator() {
    }

    // TODO auf der Personen-Klasse direkt implemetieren!
    public final Comparator<Person> lastNameComp = (p1, p2) -> p1.getLastname().compareTo(p2.getLastname());
    public final Comparator<Person> firstNameComp = (p1, p2) -> p1.getFirstname().compareTo(p2.getFirstname());

    @Override
    public String toString() {
        return "This object represents a person comparator. It compares 2 objects of type person. It does so by returning the difference of the alphabetical index of the lastname as an integer value.";
    }

    @Override
    public boolean equals(Object obj) {
        // if (obj instanceof PersonComparator) {
        // return true;
        // } else {
        // return false;
        // }
        return obj instanceof PersonComparator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toString());
        // return Objects.hash(this.getClass());
    }

    @Override
    public int compareTo(PersonComparator o) {
        return this.toString().compareTo(o.toString());
    }

}