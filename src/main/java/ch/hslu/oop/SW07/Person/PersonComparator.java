package ch.hslu.oop.SW07.Person;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Comparator;
import java.util.Objects;

public final class PersonComparator implements Comparator<Person>, Comparable<PersonComparator> {

    private static final Logger LOG = LoggerFactory.getLogger(PersonComparator.class);

    public static void main(String[] args) {
        // { hint... 26 letters in alphabet }
        Person p1 = new Person(2234, "Test", "Case");

        Person p4 = new Person(2237, "Zésli", "zunder");

        LOG.info("Comparator comparision: {}", new PersonComparator().compare(p1, p4));

        LOG.info("Person compareTo() comparision: {}", p4.compareTo(p1));

        PersonComparator pc1 = new PersonComparator();
        PersonComparator pc2 = new PersonComparator();

        LOG.info(pc1.toString());

        LOG.info("Compare: {}", pc1.compareTo(pc2));
        LOG.info("Compare: {}", pc1.hashCode() == pc2.hashCode());
    }

    // ---------------------- Constructor ---------------------- //
    public PersonComparator() {
        // default constructor
    }

    /**
     * Overide of the compare method of the Comparator interface for out
     * PersonComparator.
     *
     * @param person1 The first person objcect to compare.
     * @param person2 The decond person object to compare.
     * @return The difference of the alphabetical indices (lastname) as an integer.
     */
    @Override
    public int compare(Person person1, Person person2) {
        // Comparing last names (gets us the difference of the alphabetical position of
        // the bigger)
        int compare = person1.getLastname().compareTo(person2.getLastname());

        if (compare == 0)
            compare = person1.getFirstname().compareTo(person2.getFirstname());

        return compare;
    }

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