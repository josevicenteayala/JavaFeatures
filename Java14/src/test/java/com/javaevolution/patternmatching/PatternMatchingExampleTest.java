package com.javaevolution.patternmatching;

import com.javaevolution.patternmatching.PatternMatchingExample.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatternMatchingExampleTest {

    private final PatternMatchingExample example = new PatternMatchingExample();

    @Test
    void traditionalInstanceOf_givenString_shouldReturnLength() {
        String result = example.traditionalInstanceOf("Hello");
        assertTrue(result.contains("5"));
    }

    @Test
    void traditionalInstanceOf_givenNonString_shouldReturnNotAString() {
        String result = example.traditionalInstanceOf(123);
        assertEquals("Not a string", result);
    }

    @Test
    void patternMatchingInstanceOf_givenString_shouldReturnLength() {
        String result = example.patternMatchingInstanceOf("Hello");
        assertTrue(result.contains("5"));
    }

    @Test
    void patternMatchingInstanceOf_givenNonString_shouldReturnNotAString() {
        String result = example.patternMatchingInstanceOf(123);
        assertEquals("Not a string", result);
    }

    @Test
    void identifyType_givenString_shouldReturnUppercase() {
        String result = example.identifyType("hello");
        assertEquals("String: HELLO", result);
    }

    @Test
    void identifyType_givenInteger_shouldReturnDoubled() {
        String result = example.identifyType(5);
        assertEquals("Integer: 10", result);
    }

    @Test
    void identifyType_givenDouble_shouldReturnFormatted() {
        String result = example.identifyType(3.14159);
        assertTrue(result.contains("3.14"));
    }

    @Test
    void identifyType_givenUnknownType_shouldReturnUnknown() {
        String result = example.identifyType(new Object());
        assertEquals("Unknown type", result);
    }

    @Test
    void isLongString_givenLongString_shouldReturnTrue() {
        assertTrue(example.isLongString("This is a long string"));
    }

    @Test
    void isLongString_givenShortString_shouldReturnFalse() {
        assertFalse(example.isLongString("Short"));
    }

    @Test
    void isLongString_givenNonString_shouldReturnFalse() {
        assertFalse(example.isLongString(123));
    }

    @Test
    void checkNotString_givenString_shouldReturnString() {
        String result = example.checkNotString("hello");
        assertTrue(result.startsWith("String:"));
    }

    @Test
    void checkNotString_givenNonString_shouldReturnNotAString() {
        String result = example.checkNotString(123);
        assertEquals("Not a string", result);
    }

    @Test
    void getLength_givenString_shouldReturnLength() {
        assertEquals(5, example.getLength("Hello"));
    }

    @Test
    void getLength_givenNonString_shouldReturnZero() {
        assertEquals(0, example.getLength(123));
    }

    @Test
    void calculateArea_givenCircle_shouldCalculateCircleArea() {
        Circle circle = new Circle(5);
        double area = example.calculateArea(circle);
        assertEquals(Math.PI * 25, area, 0.001);
    }

    @Test
    void calculateArea_givenRectangle_shouldCalculateRectangleArea() {
        Rectangle rect = new Rectangle(4, 5);
        double area = example.calculateArea(rect);
        assertEquals(20, area);
    }

    @Test
    void calculateArea_givenUnknownShape_shouldReturnZero() {
        Shape shape = new Shape();
        double area = example.calculateArea(shape);
        assertEquals(0, area);
    }

    @Test
    void processValue_givenPositiveInteger_shouldReturnPositive() {
        String result = example.processValue(5);
        assertTrue(result.contains("Positive"));
    }

    @Test
    void processValue_givenNegativeInteger_shouldReturnNegative() {
        String result = example.processValue(-5);
        assertTrue(result.contains("Negative"));
    }

    @Test
    void processValue_givenNonEmptyString_shouldReturnNonEmpty() {
        String result = example.processValue("test");
        assertTrue(result.contains("Non-empty"));
    }

    @Test
    void processValue_givenOtherValue_shouldReturnOther() {
        String result = example.processValue(3.14);
        assertEquals("Other value", result);
    }

    @Test
    void compareTraditionalVsPattern_givenString_shouldReturnLowercase() {
        String result = example.compareTraditionalVsPattern("HELLO");
        assertEquals("hello", result);
    }

    @Test
    void compareTraditionalVsPattern_givenNonString_shouldReturnEmpty() {
        String result = example.compareTraditionalVsPattern(123);
        assertEquals("", result);
    }
}
