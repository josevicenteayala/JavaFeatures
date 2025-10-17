package com.javaevolution.switchexpr;

import com.javaevolution.switchexpr.SwitchExpressionsExample.Day;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwitchExpressionsExampleTest {

    private final SwitchExpressionsExample example = new SwitchExpressionsExample();

    @Test
    void traditionalSwitch_shouldReturnCorrectLength() {
        assertEquals("6 letters", example.traditionalSwitch(Day.MONDAY));
        assertEquals("7 letters", example.traditionalSwitch(Day.TUESDAY));
        assertEquals("8 letters", example.traditionalSwitch(Day.THURSDAY));
        assertEquals("9 letters", example.traditionalSwitch(Day.WEDNESDAY));
    }

    @Test
    void switchExpression_shouldReturnCorrectLength() {
        assertEquals("6 letters", example.switchExpression(Day.MONDAY));
        assertEquals("6 letters", example.switchExpression(Day.FRIDAY));
        assertEquals("7 letters", example.switchExpression(Day.TUESDAY));
        assertEquals("8 letters", example.switchExpression(Day.SATURDAY));
        assertEquals("9 letters", example.switchExpression(Day.WEDNESDAY));
    }

    @Test
    void calculateValue_shouldPerformCorrectOperation() {
        assertEquals(5, example.calculateValue("+", 2, 3));
        assertEquals(1, example.calculateValue("-", 4, 3));
        assertEquals(12, example.calculateValue("*", 3, 4));
        assertEquals(5, example.calculateValue("/", 10, 2));
    }

    @Test
    void calculateValue_divisionByZero_shouldThrowException() {
        assertThrows(ArithmeticException.class, () -> example.calculateValue("/", 10, 0));
    }

    @Test
    void calculateValue_unknownOperator_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> example.calculateValue("%", 10, 3));
    }

    /*
    // This test requires pattern matching in switch (Java 17+)
    @Test
    void getTypeInfo_shouldReturnCorrectInfo() {
        assertTrue(example.getTypeInfo(42).toString().contains("Integer"));
        assertTrue(example.getTypeInfo("hello").toString().contains("String"));
        assertEquals("null value", example.getTypeInfo(null));
    }
    */

    @Test
    void getDayType_shouldCategorizeCorrectly() {
        assertEquals("Weekday", example.getDayType(Day.MONDAY));
        assertEquals("Weekday", example.getDayType(Day.FRIDAY));
        assertEquals("Weekend", example.getDayType(Day.SATURDAY));
        assertEquals("Weekend", example.getDayType(Day.SUNDAY));
    }

    @Test
    void categorizeNumber_shouldCategorizeCorrectly() {
        assertEquals("Zero", example.categorizeNumber(0));
        assertEquals("Small", example.categorizeNumber(3));
        assertEquals("Medium", example.categorizeNumber(7));
        assertEquals("Large", example.categorizeNumber(100));
        assertEquals("Negative", example.categorizeNumber(-5));
    }

    @Test
    void processDay_shouldProcessCorrectly() {
        assertEquals("START OF WORK WEEK", example.processDay(Day.MONDAY));
        assertEquals("END OF WORK WEEK", example.processDay(Day.FRIDAY));
        assertEquals("weekend", example.processDay(Day.SATURDAY));
        assertEquals("weekend", example.processDay(Day.SUNDAY));
        assertEquals("Regular day", example.processDay(Day.TUESDAY));
    }
}
