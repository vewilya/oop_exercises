package ch.hslu.oop.SW05.Switchable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import ch.hslu.oop.SW05.Switchable.Car;;

public class CarTest {
    @Test
    void testGetCarEngineRpm() {
        assertThat(new Car().getCarEngineRpm()).isInstanceOf(Integer.class);
    }

    @Test
    void testIsSwitchedOff() {
        assertEquals(false, new Car().isSwitchedOn());
    }

    @Test
    void testIsSwitchedOn() {
        assertEquals(false, new Car().isSwitchedOn());
    }
}
