package ch.hslu.oop.SW07.Person;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import ch.hslu.oop.SW07.Person.Person;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class PersonTest {
    // @Test 
    // void testDefaultConstructor() {
    //     Person person = new Person();

    //     assertThat(person.getFirstname());
    //     assertThat(person.getLastname());
    //     assertThat(person.getId());
    // }

    @Test
    void testParameterizedConstructor() {
        Person person = new Person(54365476587L, "Brandford", "Marsalis");

        assertThat(person.getFirstname());
        assertThat(person.getLastname());
        assertThat(person.getId());
    }

    @Test
    void testGetId() {
        Person person = new Person(54386547966L, "Michael", "Jordan");
        assertEquals(54386547966L, person.getId());
    }

    @Test
    void testGetFirstname() {
        assertEquals("Michael", new Person(54386547966l, "Michael", "Jordan").getFirstname());
    }

    @Test
    void testGetLastname() {
        assertEquals("Jordan", new Person(54386547966l, "Michael", "Jordan").getLastname());
    }


    // ---------------- Equals Verifier ----------------- // 
    @Test
    void testEqualsContract() {
        // EqualsVerifier.simple().forClass(Person.class).verify(); // NIE MIT SIMPLE()!!!!
        // EqualsVerifier.forClass(Person.class).suppress(Warning.NONFINAL_FIELDS).verify(); 
        EqualsVerifier.forClass(Person.class).withOnlyTheseFields("id").verify();   
    }
    
    // ---------------- Test Equals Implementation ----------------- // 

    @Test
    void testEqualsSame() {

        Person p1 = new Person(423543654546L, "Bobo", "Stenson");
        Person p2 = p1;

        assertTrue(p1.equals(p2));
        assertEquals(true, p1.equals(p2));
        assertEquals(p1, p2);
    }

    @Test
    void testEqualsEqual() {

        Person p1 = new Person(423543654546L, "Keith", "Jarret");
        Person p2 = new Person(423543654546L, "Chris", "Jarret");

        assertTrue(p1.equals(p2));
    }

    @Test 
    void testEqualsDifferent() {
        Person p1 = new Person(421443665400L, "Steve", "Jarret");
        Person p2 = new Person(323543654546L, "Steve", "Jarret");

        assertFalse(p1.equals(p2));
    }

    // ---------------- Test hashCode() Implementation ----------------- // 
    @Test
    void testHashSame1() {
        Person p1 = new Person(423543654546L, "Anders", "Jormin");
        Person p2 = p1;

        assertTrue(p1.hashCode() == p2.hashCode());
    }

    @Test
    void testHashSame2() {
        Person p1 = new Person(423543654546L, "Shaquille", "O'Neil");
        Person p2 = new Person(423543654546L, "Shaquille", "O'Neil");

        assertTrue(p1.hashCode() == p2.hashCode());
    }

    
    @Test
    void testHashDifferent() {
        Person p1 = new Person(423543654546L, "Shaquille", "O'Neil");
        Person p2 = new Person(432754397341L, "Shaquille", "O'Neil");

        assertTrue(p1.hashCode() != p2.hashCode());
    }

    // ---------------- Test compareTo() Implementation ----------------- // 
    @Test
    void testCompareToEquals() {
        Person p1 = new Person(423543654546L, "Anders", "Jormin");
        Person p2 = p1;

        assertEquals(0, p1.compareTo(p2));
    }

    @Test
    void testCompareToBigger() {
        Person p1 = new Person(423543654546L, "Anders", "Jormin");
        Person p2 = new Person(523543654546L, "Anders", "Jormin");

        assertEquals(1, p2.compareTo(p1));
    }

    @Test
    void testCompareToSmaller() {
        Person p1 = new Person(423543654546L, "Anders", "Jormin");
        Person p2 = new Person(323543654546L, "Anders", "Jormin");

        assertEquals(-1, p2.compareTo(p1));
    }
}