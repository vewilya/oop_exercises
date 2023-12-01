package ch.hslu.oop.SW10.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.within;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LightsTest {
    @Test
    void testSwitchOff() {

    }

    @Test
    void testSwitchOn() {
        Lights l = new Lights();
        l.switchOn();

        assertEquals(l.isSwitchedOn(), true);
        assertThat(l.isSwitchedOn()).isTrue();
    }

    @Test
    void testSwitchOn2() {
        Lights l = new Lights();
        l.switchOff();

        assertEquals(l.isSwitchedOn(), false);
        assertThat(l.isSwitchedOn()).isFalse();
    }
}
