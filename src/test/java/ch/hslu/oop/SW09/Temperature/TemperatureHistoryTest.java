package ch.hslu.oop.SW09.Temperature;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

public class TemperatureHistoryTest {
    @Test
    void testAdd() {
        TemperatureHistory tD = new TemperatureHistory();
        tD.add(Temperature.createFromCelsius(23.4f));
        tD.add(Temperature.createFromCelsius(24.5f));
        tD.add(Temperature.createFromCelsius(43.11f));

        assertThat(tD.getCount()).isEqualTo(3);
    }

    @Test
    void testClear() {
        TemperatureHistory tD = new TemperatureHistory();
        tD.add(Temperature.createFromCelsius(23.4f));
        tD.add(Temperature.createFromCelsius(24.5f));
        tD.add(Temperature.createFromCelsius(43.11f));

        tD.clear();

        assertThat(tD.getCount()).isEqualTo(0);
    }

    @Test
    void testClearEmpty() {
        TemperatureHistory tD = new TemperatureHistory();
        tD.clear();

        assertThat(tD.getCount()).isEqualTo(0);
    }

    @Test
    void testGetAverageTemperature() {
        TemperatureHistory tD = new TemperatureHistory();

        tD.add(Temperature.createFromCelsius(22.2f));
        tD.add(Temperature.createFromCelsius(42.2f));
        tD.add(Temperature.createFromCelsius(62.2f));

        assertThat(tD.getAverageTemperature().getTemperatureCelsius()).isEqualTo(42.2f);
    }

    @Test
    void testGetCount() {
        TemperatureHistory tD = new TemperatureHistory();

        tD.add(Temperature.createFromCelsius(23.4f));
        tD.add(Temperature.createFromCelsius(24.5f));
        tD.add(Temperature.createFromCelsius(43.11f));

        assertThat(tD.getCount()).isEqualTo(3);
    }

    @Test
    void testGetMaxTemperature() {
        TemperatureHistory tD = new TemperatureHistory();

        tD.add(Temperature.createFromCelsius(19.543f));
        tD.add(Temperature.createFromCelsius(3.2342f));
        tD.add(Temperature.createFromCelsius(43.1123f));

        assertThat(tD.getMaxTemperature().getTemperatureCelsius()).isEqualTo(43.1123f);
    }

    
    // @Disabled
    @Test
    void testGetMaxTemperature2() {
        TemperatureHistory tD = new TemperatureHistory();

        assertThat(tD.getMaxTemperature()).isNull();
    }

    @Test
    void testGetMinTemperature() {
        TemperatureHistory tD = new TemperatureHistory();

        tD.add(Temperature.createFromCelsius(19.543f));
        tD.add(Temperature.createFromCelsius(3.2342f));
        tD.add(Temperature.createFromCelsius(43.1123f));

        // assertThat(tD.getMinTemperature().getTemperatureCelsius()).isCloseTo(3.2342f, 0.001f);
        
        // Same test with delta value
        assertEquals(3.2342f, tD.getMinTemperature().getTemperatureCelsius(), 0.001f);
    }

    // ------------------ CompareTo() ------------------- //
    @Test
    void testCompareTo() {
        TemperatureHistory tD = new TemperatureHistory();
        TemperatureHistory tD2 = new TemperatureHistory();

        tD.add(Temperature.createFromCelsius(23.4f));
        tD2.add(Temperature.createFromCelsius(24.5f));
        tD2.add(Temperature.createFromCelsius(53.4f));

        assertThat(tD.compareTo(tD2)).isEqualTo(-1);
    }

    @Test
    void testCompareToSameSize() {
        TemperatureHistory tD = new TemperatureHistory();
        TemperatureHistory tD2 = new TemperatureHistory();

        tD.add(Temperature.createFromCelsius(23.4f));
        tD2.add(Temperature.createFromCelsius(24.5f));

        assertThat(tD.compareTo(tD2)).isEqualTo(0);
    }

    // ------------------ Equals() ------------------- //
    @Test
    void testEquals() {
        TemperatureHistory tD = new TemperatureHistory();
        TemperatureHistory tD2 = new TemperatureHistory();

        tD.add(Temperature.createFromCelsius(13.4f));
        tD2.add(Temperature.createFromCelsius(11.4f));

        assertThat(tD.equals(tD2)).isFalse();
    }

    @Test
    void testEquals2() {
        TemperatureHistory tD = new TemperatureHistory();
        TemperatureHistory tD2 = tD;

        assertThat(tD.equals(tD2)).isTrue();
    }

    // ------------------ hashCode() ------------------- //
    @Test
    void testHashCode() {
        TemperatureHistory tD = new TemperatureHistory();
        TemperatureHistory tD2 = tD;

        assertThat(tD.hashCode()).isEqualTo(tD2.hashCode());
    }

}
