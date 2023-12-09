package ch.hslu.oop.SW11.csvTemperatureRead;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TemperaturePointTest {

    private static final Logger LOG = LoggerFactory.getLogger(TemperaturePointTest.class);

    @Test 
    void testConstructor() {
        TemperaturePoint tP = new TemperaturePoint(Temperature.createFromCelsius(23.3f), LocalDateTime.now());
        TemperaturePoint tP2 = new TemperaturePoint(Temperature.createFromCelsius(23.3f), LocalDateTime.now().minusDays(1));

        assertThat(tP.getTemperature()).isEqualTo(tP2.getTemperature());
        assertThat(tP.getLDT()).isNotEqualTo(tP2.getLDT());
    }

    @Test
    void testCreateFromTemperaturePoint() {
        TemperaturePoint tP2 = new TemperaturePoint(Temperature.createFromCelsius(23.3f), LocalDateTime.now().minusDays(1));
        TemperaturePoint tP3 = TemperaturePoint.createFromTemperaturePoint(tP2);
        
        assertThat(tP2.getTemperature()).isEqualTo(tP3.getTemperature());
        assertThat(tP2.getLDT()).isEqualTo(tP3.getLDT());
    }
   
    @Test
    void testGetLDT() {
        TemperaturePoint tP = new TemperaturePoint(Temperature.createFromCelsius(23.3f), LocalDateTime.now());
        assertThat(tP.getLDT().getHour()).isEqualTo(LocalDateTime.now().getHour());
    }

    @Test
    void testGetTemperature() {
        TemperaturePoint tP = new TemperaturePoint(Temperature.createFromCelsius(23.3f), LocalDateTime.now());
        assertThat(tP.getTemperature().getTemperatureCelsius()).isEqualTo(23.3f);
    }

    @Test
    void testEqualsContract() {
        EqualsVerifier.forClass(TemperaturePoint.class).suppress(Warning.NONFINAL_FIELDS).verify(); 
    }

    @Test
    void testEquals() {
        TemperaturePoint tP = new TemperaturePoint(Temperature.createFromCelsius(23.3f), LocalDateTime.now());
        TemperaturePoint tPLater = new TemperaturePoint(Temperature.createFromCelsius(23.3f), LocalDateTime.now());

        assertThat(!tP.equals(tPLater));
    }


    @Test
    void testHashCode() {
        TemperaturePoint tP = new TemperaturePoint(Temperature.createFromCelsius(23.3f), LocalDateTime.now());
        TemperaturePoint tPLater = new TemperaturePoint(Temperature.createFromCelsius(23.3f), LocalDateTime.now());

        assertThat(tP.hashCode() != (tPLater.hashCode()));
    }

    @Test
    void testCompareTo() {
        TemperaturePoint tP = new TemperaturePoint(Temperature.createFromCelsius(23.3f), LocalDateTime.now());
        TemperaturePoint tPMiddle = new TemperaturePoint(Temperature.createFromCelsius(23.3f), LocalDateTime.now());
        TemperaturePoint tPLater = new TemperaturePoint(Temperature.createFromCelsius(23.3f), LocalDateTime.now());

        assertTrue(tP.compareTo(tPMiddle) == -1);
        assertTrue(tP.compareTo(tP) == 0);
        assertTrue(tPMiddle.compareTo(tP) == 1);
        assertTrue(tPLater.compareTo(tPMiddle) == 1);
    }
}
