package ch.hslu.oop.SW10.Temperature;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TemperatureEventTest {
    @Test
    void testGetEventName() {
        assertThat(new TemperatureEvent(this, Temperature.createFromCelsius(23.3f), TemperatureEventType.MIN).getTemperatureEventType()).isEqualTo(TemperatureEventType.MIN);
    }

    @Test
    void testGetTemperatureEventType() {
         assertThat(new TemperatureEvent(this, Temperature.createFromCelsius(33.4f), TemperatureEventType.MAX).getTemperatureEventType()).isEqualTo(TemperatureEventType.MAX);
    }
}
