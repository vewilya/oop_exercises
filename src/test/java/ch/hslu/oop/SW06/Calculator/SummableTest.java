package ch.hslu.oop.SW06.Calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SummableTest {
    Summable calculator = new Calculator();
    
    @Test
    void testAddition() {    
        assertEquals(33, calculator.addition(10,23));
    }

    @Test
    void testAddition_1() {    
        assertEquals(0, calculator.addition(0,0));
    }

    @Test 
    void testAddition_2() {
        assertEquals(-10, calculator.addition(10, -20));
    }

    @Test
    void testAddition_3() {
        assertEquals(-10, calculator.addition(-20, 10));
    }

    // -2‘147‘483‘648 bis 2‘147‘483‘647
    @Test
    void testAddition_4() {
        assertEquals(-1, calculator.addition(-2147483648, 2147483647));
    }

    @Test
    void testAddition_5() {
        assertEquals(-2, calculator.addition(2147483647, 2147483647));
    }

    @Test
    void testAddition_6() {
        assertEquals(0, calculator.addition(-2147483648, -2147483648));
    }
}
