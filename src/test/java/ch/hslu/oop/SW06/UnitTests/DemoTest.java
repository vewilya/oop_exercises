package ch.hslu.oop.SW06.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ch.hslu.oop.SW06.Demo.Demo;


public class DemoTest {

    @Test 
    void testMax_3a() {
        assertEquals(5, new Demo().max_3a(3, 5, 2));
    }

    @Test
    void testMax_3a2() {
        assertEquals(221, new Demo().max_3a(7, 21, 221));
    }

    @Test
    @DisplayName("😱")
    void testMax_3a3() {
        assertEquals(5, new Demo().max_3a(5, 4, 3));
    }

    @Disabled ("This test is disabled until further notice")
    @Test
    void testMax_3a4() {
        assertThat(new Demo().max_3a(5, 4, 3)).isInstanceOf(Integer.class);
    }

    // Weitere Test schreiben für Fälle bei denen 2 gleich sind

}
