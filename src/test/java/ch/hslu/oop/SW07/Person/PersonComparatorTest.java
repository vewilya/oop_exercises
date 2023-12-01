package ch.hslu.oop.SW07.Person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class PersonComparatorTest {

    @Test
    void testComparatorToString() {
        PersonComparator personComparator = new PersonComparator();

        assertThat(personComparator.toString()).isNotNull();
        assertThat(personComparator.toString()).isInstanceOf(String.class);
    }

    // ------------------------- Equals ------------------------- //
    @Test
    void testComparatorEqualsVerifier() {
        EqualsVerifier.forClass(PersonComparator.class).verify();
    }

    @Test
    void testComparatorEquals() {
        PersonComparator personComparator = new PersonComparator();
        PersonComparator personComparator2 = personComparator;

        assertTrue(personComparator.equals(personComparator2));
    }

    @Test
    void testComparatorNull() {
        PersonComparator personComparator = new PersonComparator();
        PersonComparator personComparator2 = null;

        assertFalse(personComparator.equals(personComparator2));
    }

    // ---------------------- Hash Code -------------------------- // 
    @Test
    void testHashCode() {
        PersonComparator personComparator = new PersonComparator();
        PersonComparator personComparator2 = new PersonComparator();

        assertTrue(personComparator.hashCode() == personComparator2.hashCode());
    }

    // ---------------------- Compare ----------------------- //

    @Test
    void testCompare() {
        PersonComparator personComparator = new PersonComparator();

        Person p1 = new Person(423543654546L, "Ron", "Carter");
        Person p2 = new Person(323543654546L, "Anders", "Bunker");

        assertEquals(1, personComparator.compare(p1, p2));         
        assertEquals(-1, personComparator.compare(p2, p1));
    }

    @Test
    void testCompare2() {
        PersonComparator personComparator = new PersonComparator();

        Person p1 = new Person(423543654546L, "Beta", "Alpha");
        Person p2 = new Person(323543654546L, "Zösli", "Zunder");

        // Comparator returns the difference between p1 and p2 (p1 - p2), which is smaller than 0 (-23).
        assertTrue(0 > personComparator.compare(p1, p2));         
    }

    @Test
    void testCompare3() {
        PersonComparator personComparator = new PersonComparator();

        Person p1 = new Person(423543654546L, "Beta", "Alpha");
        Person p2 = new Person(323543654546L, "Zösli", "Zunder");

        // Comparator returns the difference between p2 and p1 (p2 - p1), which is bigger than 0 (23).
        assertTrue(0 < personComparator.compare(p2, p1));         
    }

    @Test
    void testCompare4() {
        PersonComparator personComparator = new PersonComparator();

        Person p1 = new Person(423543654546L, "Beta", "Alpha");
        Person p2 = p1;

        // Comparator returns the difference between p2 and p1, which should be precisely 0!
        assertTrue(0 == personComparator.compare(p2, p1)); 
        assertTrue(0 == personComparator.compare(p1, p2));         
    }


    @Test
    void testCompareLowerCase() {
        PersonComparator personComparator = new PersonComparator();

        Person p1 = new Person(423543654546L, "beta", "alpha");
        Person p2 = new Person(423543654546L, "beta", "gamma");

        // Same functionality should be working for lowercase letters.
        assertTrue(0 < personComparator.compare(p2, p1));          
    }

    @Test
    void testCompareLowerAndUpperCase() {
        PersonComparator personComparator = new PersonComparator();

        Person p1 = new Person(423543654546L, "Beta", "Alpha");
        Person p2 = new Person(423543654546L, "beta", "gamma");

        // Same functionality should be working for lowercase letters.
        assertTrue(0 < personComparator.compare(p2, p1));          
    }
}
