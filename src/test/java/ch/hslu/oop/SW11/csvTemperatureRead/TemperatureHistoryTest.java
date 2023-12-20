package ch.hslu.oop.SW11.csvTemperatureRead;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.within;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.channels.IllegalSelectorException;
import java.time.LocalDateTime;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.hslu.oop.SW11.csvTemperatureRead.Temperature;
import ch.hslu.oop.SW11.csvTemperatureRead.TemperatureEvent;
import ch.hslu.oop.SW11.csvTemperatureRead.TemperatureEventType;
import ch.hslu.oop.SW11.csvTemperatureRead.TemperatureHistory;
import ch.hslu.oop.SW11.csvTemperatureRead.TemperaturePoint;

public class TemperatureHistoryTest {

    private static final Logger LOG = LoggerFactory.getLogger(TemperatureHistoryTest.class);

    @Test
    void testAdd() {
        TemperatureHistory tH = new TemperatureHistory();

        tH.add(new TemperaturePoint(Temperature.createFromCelsius(32.3f), LocalDateTime.now()));

        assertTrue(tH.getCount() == 1);
    }


    @Test
    void testCheckTemperatureExtrema() {

    }

    @Test
    void testClear() {
        TemperatureHistory tH = new TemperatureHistory();

        tH.add(new TemperaturePoint(Temperature.createFromCelsius(32.3f), LocalDateTime.now()));
        tH.add(new TemperaturePoint(Temperature.createFromCelsius(42.3f), LocalDateTime.now()));
        tH.clear();

        assertTrue(tH.getCount() == 0);
    }

    @Test
    void testFireTemperatureEvent() {
        

        assertThat(new TemperatureEvent(this, Temperature.createFromCelsius(23.3f), TemperatureEventType.MIN).getTemperatureEventType()).isEqualTo(TemperatureEventType.MIN);
    }


    @Test
    void testGetAverageTemperature() {
        TemperatureHistory tH = new TemperatureHistory();

        tH.add(new TemperaturePoint(Temperature.createFromCelsius(30.0f), LocalDateTime.now()));
        tH.add(new TemperaturePoint(Temperature.createFromCelsius(40.0f), LocalDateTime.now()));
        tH.add(new TemperaturePoint(Temperature.createFromCelsius(50.0f), LocalDateTime.now()));

        assertThat(tH.getAverageTemperature().getTemperature().getTemperatureCelsius()).isEqualTo(40.0f);
    }

    @Test
    void testGetCount() {
        TemperatureHistory tH = new TemperatureHistory();

        tH.add(new TemperaturePoint(Temperature.createFromCelsius(30.0f), LocalDateTime.now()));
        tH.add(new TemperaturePoint(Temperature.createFromCelsius(40.0f), LocalDateTime.now()));
        tH.add(new TemperaturePoint(Temperature.createFromCelsius(50.0f), LocalDateTime.now()));

        assertTrue(tH.getCount() == 3);

    }

    @Test
    void testGetMaxTemperature() {
        TemperatureHistory tH = new TemperatureHistory();

        tH.add(new TemperaturePoint(Temperature.createFromCelsius(30.0f), LocalDateTime.now()));
        tH.add(new TemperaturePoint(Temperature.createFromCelsius(40.0f), LocalDateTime.now()));
        tH.add(new TemperaturePoint(Temperature.createFromCelsius(50.0f), LocalDateTime.now()));

        assertTrue(tH.getMaxTemperature().getTemperature().getTemperatureCelsius() == 50.0f);
    }

    @Test
    void testGetMinTemperature() {
        TemperatureHistory tH = new TemperatureHistory();

        // tH.add(new TemperaturePoint(Temperature.createFromCelsius(30.0f), LocalDateTime.now()));
        // tH.add(new TemperaturePoint(Temperature.createFromCelsius(40.0f), LocalDateTime.now()));
        tH.add(new TemperaturePoint(Temperature.createFromCelsius(50.0f), LocalDateTime.now()));

        assertThat(tH.getMinTemperature().getTemperature().getTemperatureCelsius()).isEqualTo(50.0f);
    }

    @Test
    void testHashCode() {
        TemperatureHistory tH = new TemperatureHistory();
        TemperatureHistory tH2 = new TemperatureHistory();

        tH.add(new TemperaturePoint(Temperature.createFromCelsius(50.0f), LocalDateTime.now()));
        tH2.add(new TemperaturePoint(Temperature.createFromCelsius(30.0f), LocalDateTime.now()));

        assertTrue(tH.hashCode() != tH2.hashCode());
    }

}
