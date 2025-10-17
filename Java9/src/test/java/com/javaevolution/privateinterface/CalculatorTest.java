package com.javaevolution.privateinterface;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new BasicCalculator();

    @Test
    void addAndMultiply_shouldAddThenMultiply() {
        int result = calculator.addAndMultiply(2, 3, 4);
        assertEquals(20, result); // (2+3) * 4 = 20
    }

    @Test
    void subtractAndMultiply_shouldSubtractThenMultiply() {
        int result = calculator.subtractAndMultiply(5, 3, 2);
        assertEquals(4, result); // (5-3) * 2 = 4
    }

    @Test
    void add_shouldReturnSum() {
        int result = calculator.add(5, 3);
        assertEquals(8, result);
    }

    @Test
    void subtract_shouldReturnDifference() {
        int result = calculator.subtract(10, 4);
        assertEquals(6, result);
    }

    @Test
    void validateAndAdd_givenValidValues_shouldReturnSum() {
        int result = calculator.validateAndAdd(5, 3);
        assertEquals(8, result);
    }

    @Test
    void validateAndAdd_givenNegativeFirstValue_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.validateAndAdd(-1, 3));
    }

    @Test
    void validateAndAdd_givenNegativeSecondValue_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.validateAndAdd(5, -2));
    }

    @Test
    void validateAndAdd_givenBothNegative_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.validateAndAdd(-1, -2));
    }
}
