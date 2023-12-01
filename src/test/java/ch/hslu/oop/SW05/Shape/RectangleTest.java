package ch.hslu.oop.SW05.Shape;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


/**
 * Test for {@link Rectangle} class.
 */
public class RectangleTest {
    
    @Test
    void testGetArea() {
        assertEquals(20000, new Rectangle(20, 20, 100, 200).getArea());
    }

    @Test
    void testGetPerimeter() {
        assertEquals(300, new Rectangle(20, 20, 100, 50).getPerimeter());
    }
}
