package ch.hslu.oop.SW08.Temperature;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.Disabled;

import nl.jqno.equalsverifier.EqualsVerifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
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

        assertEquals(32.4f + 273.15f, t1.getTempKelvin());
    }

    @Test
    void testTemperatureChangeTemperature() {
        Temperature t1 = new Temperature(32.4f);
        t1.changeTempRelativeCelsius(50.0f);

        assertEquals(82.4f, t1.getTemperatureCelsius());
    }

    @Test
    void testChangeTempRelativeKelvin() {
        Temperature t1 = new Temperature(21.0f);
        t1.changeTempRelativeKelvin(21.0f);

        assertEquals(42.0f, t1.getTemperatureCelsius());
    }

 
    @Test
    void testConvertCelsiusToKelvin() {
        assertThat(Temperature.convertCelsiusToKelvin(23.0f)).isEqualTo(296.15f); 
        assertThat(Temperature.convertCelsiusToKelvin(23.0f)).isCloseTo(296.15f, within(0.001f));
    }


    // -------------------------------- equals(), hashCode(), compareTo() -------------------------------------- //
    
    // Goddamn Equals Verifier!!!
    // @Disabled
    @Test
    void testEqualsContract() {
        EqualsVerifier.forClass(Temperature.class).suppress(Warning.NONFINAL_FIELDS).withOnlyTheseFields("temperatureCelsius").verify(); 
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
        Temperature t1 = new Temperature(23.0f);
        Temperature t2 = new Temperature(12.0f);

        assertTrue(t1.hashCode() != t2.hashCode());
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
