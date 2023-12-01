package ch.hslu.oop.SW05.Element;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import ch.hslu.oop.SW04.Line.Point;
import nl.jqno.equalsverifier.EqualsVerifier;

public class MercuryTest {
    @Test
    void testGetAggregateState() {
        assertEquals("solid", new Mercury().getAggregateState(2));
    }

    @Test
    void testGetBoilingPoint() {
        assertEquals( 357.0f, new Mercury().getBolilingPoint());
    }

    @Test
    void testGetEvaporationPoint() {
        assertEquals( -38.83f, new Mercury().getEvaporationPoint());
    }

    @Test
    void testGetString() {
        assertThat(new Mercury().getString()).isInstanceOf(String.class);
    }
}
