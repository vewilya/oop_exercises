package ch.hslu.oop.SW09.Temperature;

import org.junit.jupiter.api.Test;

import ch.hslu.oop.SW06.Demo.Demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.within;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.channels.IllegalSelectorException;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TemperatureTest {
    @Test 
    void testTemperatureConstructor() {
        Temperature t1 = Temperature.createFromCelsius(32.3f);

        assertEquals(32.3f, t1.getTemperatureCelsius());
    }

    @Test
    void testTemperatureKelvinOffset() {
        Temperature t1 = Temperature.createFromCelsius(32.4f);

        assertEquals(32.4f + 273.15f, t1.getTempKelvin());
    }

    @Test
    void testTemperatureChangeTemperature() {
        Temperature t1 = Temperature.createFromCelsius(32.4f);
        t1.changeTempRelativeCelsius(50.0f);

        assertEquals(82.4f, t1.getTemperatureCelsius());
    }

    @Test
    void testChangeTempRelativeKelvin() {
        Temperature t1 = Temperature.createFromKelvin(21.0f);
        t1.changeTempRelativeKelvin(21.0f);

        assertEquals(42.0f, t1.getTempKelvin());
    }

    @Test
    void testConvertCelsiusToKelvin() {
        assertThat(Temperature.convertCelsiusToKelvin(23.0f)).isEqualTo(296.15f);
        assertThat(Temperature.convertCelsiusToKelvin(23.0f)).isCloseTo(296.15f, within(0.001f));
    }


    // -------------------------------- equals(), hashCode(), compareTo() -------------------------------------- //
    
    // @Disabled
    @Test
    void testEqualsContract() {
        EqualsVerifier.forClass(Temperature.class).suppress(Warning.NONFINAL_FIELDS).withOnlyTheseFields("temperatureCelsius").verify(); 
    }

    @Test
    void testEquals1() {
        Temperature t1 = Temperature.createFromCelsius(23.0f);
        Temperature t2 = t1;

        assertTrue(t1.equals(t2));
    }

    @Test
    void testEquals2() {
        Temperature t1 = Temperature.createFromCelsius(23.0f);
        Temperature t2 = Temperature.createFromCelsius(23.0f);

        assertTrue(t1.equals(t2));
    }


    @Test
    void testEquals3() {
        Temperature t1 = Temperature.createFromCelsius(23.0f);
        Temperature t2 = Temperature.createFromCelsius(12.0f);

        assertTrue(!t1.equals(t2));
    }

    @Test
    void testHashCode() {
        Temperature t1 = Temperature.createFromCelsius(23.0f);
        Temperature t2 = Temperature.createFromCelsius(12.0f);

        assertTrue(t1.hashCode() != t2.hashCode());
    }

    @Test
    void testCompareToEqual() {
        Temperature t1 = Temperature.createFromCelsius(23.0f);
        Temperature t2 = t1;

        assertEquals(0, t1.compareTo(t2));
        assertEquals(0, t2.compareTo(t1));
    }

    @Test
    void testCompareToBigger() {
        Temperature t1 = Temperature.createFromCelsius(23.0f);
        Temperature t2 = Temperature.createFromCelsius(33.0f);

        assertEquals(1, t2.compareTo(t1));
    }

    @Test
    void testCompareToSmaller() {
        Temperature t1 = Temperature.createFromCelsius(23.0f);
        Temperature t2 = Temperature.createFromCelsius(13.0f);

        assertEquals(-1, t2.compareTo(t1));
    }

    // TEST NEW STATIC METHODS 

    @Test
    void testCreateFromCelsius() {
        Temperature newTemp = Temperature.createFromCelsius(29.0f);

        assertThat(newTemp.getTemperatureCelsius()).isEqualTo(29.0f);
    }

    @Test
    void testCreateFromKelvin() {
        Temperature newTemp = Temperature.createFromKelvin(229.0f);

        assertThat(newTemp.getTempKelvin()).isEqualTo(229.0f);
    }

    // TEST EXCEPTION HANDLING

    @Test
    void testExceptionHandling() {
    
        final Exception e = assertThrows(IllegalArgumentException.class, () -> {
                Temperature.createFromCelsius(-2273.151f); 
            });
            assertEquals("Temperature value is exceeding Low Temperature Limit! value should not be lower than -273.15 Kelvin or " + Temperature.convertKelvinToCelsius(-273.15f) + " Celsius repectively!", e.getMessage());
    }

    @Test
    void testExceptionHandlingKelvin() {
        
        final Exception e = assertThrows(IllegalArgumentException.class, () -> {
                Temperature.createFromKelvin(-564.4f); 
            });            assertEquals("Temperature value is exceeding Low Temperature Limit! value should not be lower than -273.15 Kelvin or " + Temperature.convertKelvinToCelsius(-273.15f) + " Celsius repectively!", e.getMessage());

    }
    
    // @Test
    // void testExceptionHandlingKelvinWrongExceptionType() {
        
    //     final Exception e = assertThrows(IllegalSelectorException.class, () -> {
    //             Temperature.createFromKelvin(-564.4f); 
    //         });            assertEquals("Temperature value is exceeding Low Temperature Limit!", e.getMessage());

    // }

    // @Test
    // void testExceptionHandlingKelvinWrongMessage() {
        
    //     final Exception e = assertThrows(IllegalSelectorException.class, () -> {
    //             Temperature.createFromKelvin(-564.4f); 
    //         });            assertEquals("Temperature value is Way Too Low!", e.getMessage());

    // }

    // AssertJ Library
    @Test
    void testExceptionHandlingWithAssertJ() {
        assertThatThrownBy(() -> {
            Temperature.createFromKelvin(-564.4f); 
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Temperature value is exceeding Low Temperature Limit! value should not be lower than -273.15 Kelvin or " + Temperature.convertKelvinToCelsius(-273.15f) + " Celsius repectively!");
    }


}
