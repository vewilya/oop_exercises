package ch.hslu.oop.SW07.Temperature;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.Disabled;

import nl.jqno.equalsverifier.EqualsVerifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import nl.jqno.equalsverifier.Warning;

public class TemperatureTest {

    @Test 
    void testTemperatureConstructor() {
        Temperature t1 = new Temperature(32.3f);

        assertEquals(32.3f, t1.getTemperatureCelsius());
    }

    @Test
    void testTemperatureKelvinOffset() {
        Temperature t1 = new Temperature(32.4f);

        assertEquals(305.55f, t1.getTempKelvin());
    }

    // -------------------------------- equals(), hashCode(), compareTo() -------------------------------------- //
    @Test
    void testEqualsContract() {
        // EqualsVerifier.simple().forClass(Temperature.class).verify();
        // EqualsVerifier.forClass(Temperature.class).suppress(Warning.NONFINAL_FIELDS).verify(); 
        EqualsVerifier.simple().forClass(Temperature.class).suppress(Warning.NONFINAL_FIELDS).withOnlyTheseFields("temperatureCelsius").verify(); 
    }

    @Test
    void testEquals1() {
        Temperature t1 = new Temperature(23.0f);
        Temperature t2 = t1;

        assertTrue(t1.equals(t2));
    }

    @Test
    void testEquals2() {
        Temperature t1 = new Temperature(23.0f);
        Temperature t2 = new Temperature(23.0f);

        assertTrue(t1.equals(t2));
    }


    @Test
    void testEquals3() {
        Temperature t1 = new Temperature(23.0f);
        Temperature t2 = new Temperature(12.0f);

        assertTrue(!t1.equals(t2));
    }

    @Test
    void testHashCode() {

    }

    @Test
    void testCompareToEqual() {
        Temperature t1 = new Temperature(23.0f);
        Temperature t2 = t1;

        assertEquals(0, t1.compareTo(t2));
        assertEquals(0, t2.compareTo(t1));
    }

    @Test
    void testCompareToBigger() {
        Temperature t1 = new Temperature(23.0f);
        Temperature t2 = new Temperature(33.0f);

        assertEquals(1, t2.compareTo(t1));
    }

    @Test
    void testCompareToSmaller() {
        Temperature t1 = new Temperature(23.0f);
        Temperature t2 = new Temperature(13.0f);

        assertEquals(-1, t2.compareTo(t1));
    }
}
