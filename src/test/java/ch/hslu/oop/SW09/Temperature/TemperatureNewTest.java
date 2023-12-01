package ch.hslu.oop.SW09.Temperature;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TemperatureNewTest {
   
    @Test
    void testCreateFromCelsius() {
        final Exception e = assertThrows(MyTypeErrorException.class, () -> {
                TemperatureNew.createFromCelsius(-2273.151f); 
            });
            assertEquals("Temperature value is exceeding Low Temperature Limit!", e.getMessage());
    }

    @Test
    void testCreateFromKelvin() {
        assertThatThrownBy(() -> {
            TemperatureNew.createFromKelvin(-564.4f); 
        })
        .isInstanceOf(MyTypeErrorException.class).hasMessage("Temperature value is exceeding Low Temperature Limit!");
    }
}
