package com.javaevolution.primitivetypes;

import com.javaevolution.primitivetypes.PrimitiveTypesFinalExample.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimitiveTypesFinalExampleTest {

    private final PrimitiveTypesFinalExample example = new PrimitiveTypesFinalExample();

    @Test
    void classifyInteger_withPositive_shouldReturnPositive() {
        String result = example.classifyInteger(42);
        assertTrue(result.contains("Positive"));
    }

    @Test
    void classifyInteger_withNegative_shouldReturnNegative() {
        String result = example.classifyInteger(-42);
        assertTrue(result.contains("Negative"));
    }

    @Test
    void classifyInteger_withZero_shouldReturnZero() {
        String result = example.classifyInteger(0);
        assertEquals("Zero", result);
    }

    @Test
    void describeLong_withSmall_shouldReturnSmall() {
        String result = example.describeLong(500L);
        assertTrue(result.contains("Small"));
    }

    @Test
    void classifyDouble_withFraction_shouldReturnFraction() {
        String result = example.classifyDouble(0.5);
        assertTrue(result.contains("Fraction"));
    }

    @Test
    void classifyDouble_withInfinite_shouldReturnInfinite() {
        String result = example.classifyDouble(Double.POSITIVE_INFINITY);
        assertTrue(result.contains("Infinite"));
    }

    @Test
    void classifyDouble_withNaN_shouldReturnNaN() {
        String result = example.classifyDouble(Double.NaN);
        assertTrue(result.contains("Not a Number"));
    }

    @Test
    void analyzeFloat_withNormalized_shouldReturnNormalized() {
        String result = example.analyzeFloat(0.5f);
        assertTrue(result.contains("Normalized"));
    }

    @Test
    void describeBoolean_withTrue_shouldReturnTrue() {
        String result = example.describeBoolean(true);
        assertEquals("True value", result);
    }

    @Test
    void describeBoolean_withFalse_shouldReturnFalse() {
        String result = example.describeBoolean(false);
        assertEquals("False value", result);
    }

    @Test
    void classifyCharacter_withDigit_shouldReturnDigit() {
        String result = example.classifyCharacter('5');
        assertTrue(result.contains("Digit"));
    }

    @Test
    void classifyCharacter_withLetter_shouldReturnLetter() {
        String result = example.classifyCharacter('A');
        assertTrue(result.contains("Letter"));
    }

    @Test
    void describeSmallNumber_withByte_shouldReturnByte() {
        String result = example.describeSmallNumber((byte) 10);
        assertTrue(result.contains("Byte"));
    }

    @Test
    void describeSmallNumber_withShort_shouldReturnShort() {
        String result = example.describeSmallNumber((short) 1000);
        assertTrue(result.contains("Short"));
    }

    @Test
    void checkRange_withSingleDigit_shouldReturnSingleDigit() {
        String result = example.checkRange(5);
        assertTrue(result.contains("Single digit"));
    }

    @Test
    void checkRange_withDoubleDigit_shouldReturnDoubleDigit() {
        String result = example.checkRange(42);
        assertTrue(result.contains("Double digit"));
    }

    @Test
    void extractAsInt_withInteger_shouldReturnValue() {
        int result = example.extractAsInt(42);
        assertEquals(42, result);
    }

    @Test
    void extractAsInt_withLong_shouldConvert() {
        int result = example.extractAsInt(100L);
        assertEquals(100, result);
    }

    @Test
    void extractAsInt_withString_shouldParse() {
        int result = example.extractAsInt("123");
        assertEquals(123, result);
    }

    @Test
    void performMathOperation_add_shouldAdd() {
        double result = example.performMathOperation(5, 3, "add");
        assertEquals(8.0, result, 0.001);
    }

    @Test
    void performMathOperation_multiply_shouldMultiply() {
        double result = example.performMathOperation(5, 3, "multiply");
        assertEquals(15.0, result, 0.001);
    }

    @Test
    void analyzeMeasurement_withPositive_shouldReturnPositive() {
        Measurement m = new Measurement(10.5, "kg");
        String result = example.analyzeMeasurement(m);
        assertTrue(result.contains("Positive"));
    }

    @Test
    void analyzePoint_withOrigin_shouldReturnOrigin() {
        Point p = new Point(0, 0);
        String result = example.analyzePoint(p);
        assertEquals("Origin", result);
    }

    @Test
    void analyzePoint_withQuadrant1_shouldReturnQuadrant1() {
        Point p = new Point(5, 5);
        String result = example.analyzePoint(p);
        assertTrue(result.contains("Quadrant I"));
    }

    @Test
    void normalizeScore_withA_shouldReturnA() {
        Score s = new Score(95, 100);
        String result = example.normalizeScore(s);
        assertTrue(result.contains("A"));
    }

    @Test
    void analyzeArray_withIntArray_shouldReturnSum() {
        int[] arr = {1, 2, 3, 4, 5};
        String result = example.analyzeArray(arr);
        assertTrue(result.contains("15"));
    }

    @Test
    void compareNumbers_shouldCompare() {
        int result = example.compareNumbers(5, 3);
        assertTrue(result > 0);
    }

    @Test
    void formatNumber_withInteger_shouldFormat() {
        String result = example.formatNumber(1000);
        assertTrue(result.contains("Integer"));
    }

    @Test
    void safeExtractInt_withNull_shouldReturnDefault() {
        int result = example.safeExtractInt(null, 42);
        assertEquals(42, result);
    }

    @Test
    void safeExtractInt_withInteger_shouldReturnValue() {
        int result = example.safeExtractInt(100, 42);
        assertEquals(100, result);
    }
}
