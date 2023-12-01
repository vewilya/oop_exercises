package ch.hslu.oop.SW07.Point;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ch.hslu.oop.SW07.Person.Person;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class PointTest {
    @Test
    void testEqualsContract() {
        // EqualsVerifier.forClass(Point.class).verify();
        EqualsVerifier.forClass(Point.class).suppress(Warning.NONFINAL_FIELDS).verify(); 
        // EqualsVerifier.simple().forClass(Point.class).verify();
        // EqualsVerifier.forClass(Point.class).withOnlyTheseFields("x", "y").verify(); 
        
    }

    @Test
    void testEquals() {
        Point p1 = new Point(32, 43);
        Point p2 = p1;

        assertTrue(p1.equals(p2));
    }

    @Test 
    void testEquals2() {
        Point p1 = new Point(4432, -5433);
        Point p2 = new Point(4432, -5433);

        assertTrue(p1.equals(p2));
        assertTrue(p2.equals(p1));
    }

    @Test 
    void testEquals3() {
        Point p1 = new Point(4432, -5433);
        Point p2 = new Point(-4325, 132);

        assertTrue(!p1.equals(p2));
    }

    @Test
    void testHashCodeCopy() {
        Point p1 = new Point(4432, -5433);
        Point p2 = p1;

        assertTrue(p1.hashCode() == p2.hashCode());
    }

    @Test
    void testHashCodeSameParameters() {
        Point p1 = new Point(4432, -5433);
        Point p2 = new Point(4432, -5433);

        assertTrue(p1.hashCode() == p2.hashCode());
    }

    @Test
    void testHashCodeDifferentParameters() {
        Point p1 = new Point(4432, -5433);
        Point p2 = new Point(-4325, 132);

        assertTrue(p1.hashCode() != p2.hashCode());
    }
}
