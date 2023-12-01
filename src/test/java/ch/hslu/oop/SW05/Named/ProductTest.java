package ch.hslu.oop.SW05.Named;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.assertj.core.api.StringAssert;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import ch.hslu.oop.SW04.Line.Point;
import ch.hslu.oop.SW05.Named.Product;
import nl.jqno.equalsverifier.EqualsVerifier;

/**
 * Tests for the {@link Product} class.
 */
public class ProductTest {
    /**
     * Test of getX method, of class Point.
     */
    @Test
    void testGetName() {
        // Checking if the getName method returns a value of type String
        assertThat(new Product().getName()).isInstanceOf(String.class);
    }

    @Test
    void testGetId() {
        // Checking if the getName method returns a value of type String
        assertThat(new Product().getId()).isInstanceOf(String.class);
    }

    @Test
    void testGetIdLength() {
        // Checking if the getName method returns a value of type String
        assertThat(new Product().getId()).hasSize(13);
    }
}
