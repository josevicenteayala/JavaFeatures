package com.javaevolution.primitivetypes;

import com.javaevolution.primitivetypes.PrimitiveTypesExample.Measurement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimitiveTypesExampleTest {

    private final PrimitiveTypesExample example = new PrimitiveTypesExample();

    @Test
    void describePrimitive_withInteger_shouldReturnIntegerValue() {
        String result = example.describePrimitive(42);
        assertTrue(result.contains("Integer"));
        assertTrue(result.contains("42"));
    }

    @Test
    void describePrimitive_withLong_shouldReturnLongValue() {
        String result = example.describePrimitive(42L);
        assertTrue(result.contains("Long"));
        assertTrue(result.contains("42"));
    }

    @Test
    void describePrimitive_withDouble_shouldReturnDoubleValue() {
        String result = example.describePrimitive(42.5);
        assertTrue(result.contains("Double"));
        assertTrue(result.contains("42.5"));
    }

    @Test
    void classifyNumber_withPositiveInteger_shouldReturnPositive() {
        String result = example.classifyNumber(5);
        assertTrue(result.contains("Positive integer"));
        assertTrue(result.contains("5"));
    }

    @Test
    void classifyNumber_withNegativeInteger_shouldReturnNegative() {
        String result = example.classifyNumber(-5);
        assertTrue(result.contains("Negative integer"));
        assertTrue(result.contains("-5"));
    }

    @Test
    void classifyNumber_withZero_shouldReturnZero() {
        String result = example.classifyNumber(0);
        assertEquals("Zero", result);
    }

    @Test
    void classifyNumber_withPositiveDouble_shouldReturnPositiveDouble() {
        String result = example.classifyNumber(3.14);
        assertTrue(result.contains("Positive double"));
    }

    @Test
    void extractAsInt_withInteger_shouldReturnSameValue() {
        int result = example.extractAsInt(42);
        assertEquals(42, result);
    }

    @Test
    void extractAsInt_withLong_shouldConvertToInt() {
        int result = example.extractAsInt(42L);
        assertEquals(42, result);
    }

    @Test
    void extractAsInt_withDouble_shouldConvertToInt() {
        int result = example.extractAsInt(42.7);
        assertEquals(42, result);
    }

    @Test
    void extractAsInt_withString_shouldParseToInt() {
        int result = example.extractAsInt("42");
        assertEquals(42, result);
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
    void checkRange_withLargeInteger_shouldReturnLargeInteger() {
        String result = example.checkRange(999);
        assertTrue(result.contains("Large integer"));
    }

    @Test
    void checkRange_withSmallLong_shouldReturnSmallLong() {
        String result = example.checkRange(500L);
        assertTrue(result.contains("Small long"));
    }

    @Test
    void describeMeasurement_withPositiveValue_shouldReturnPositive() {
        Measurement measurement = new Measurement(10.5, "meters");
        String result = example.describeMeasurement(measurement);
        assertTrue(result.contains("Positive"));
        assertTrue(result.contains("meters"));
    }

    @Test
    void describeMeasurement_withNegativeValue_shouldReturnNegative() {
        Measurement measurement = new Measurement(-5.0, "degrees");
        String result = example.describeMeasurement(measurement);
        assertTrue(result.contains("Negative"));
    }

    @Test
    void describeMeasurement_withZero_shouldReturnZero() {
        Measurement measurement = new Measurement(0.0, "units");
        String result = example.describeMeasurement(measurement);
        assertTrue(result.contains("Zero"));
    }

    @Test
    void evaluateBoolean_withTrue_shouldReturnTrueValue() {
        String result = example.evaluateBoolean(true);
        assertEquals("True value", result);
    }

    @Test
    void evaluateBoolean_withFalse_shouldReturnFalseValue() {
        String result = example.evaluateBoolean(false);
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
    void classifySmallNumber_withPositiveByte_shouldReturnPositiveByte() {
        String result = example.classifySmallNumber((byte) 10);
        assertTrue(result.contains("Positive byte"));
    }

    @Test
    void classifySmallNumber_withPositiveShort_shouldReturnPositiveShort() {
        String result = example.classifySmallNumber((short) 100);
        assertTrue(result.contains("Positive short"));
    }

    @Test
    void calculateSum_withMultipleTypes_shouldSumCorrectly() {
        double sum = example.calculateSum(10, 20L, 5.5, 4.5f);
        assertEquals(40.0, sum, 0.001);
    }

    @Test
    void calculateSum_withEmptyArray_shouldReturnZero() {
        double sum = example.calculateSum();
        assertEquals(0.0, sum, 0.001);
    }

    @Test
    void describePrimitiveOldWay_withInteger_shouldReturnIntegerValue() {
        String result = example.describePrimitiveOldWay(42);
        assertTrue(result.contains("Integer"));
        assertTrue(result.contains("42"));
    }

    @Test
    void analyzeValue_withZeroInteger_shouldReturnZeroInteger() {
        String result = example.analyzeValue(0);
        assertEquals("Zero integer", result);
    }

    @Test
    void analyzeValue_withLargeDouble_shouldReturnLargeDouble() {
        String result = example.analyzeValue(150.0);
        assertTrue(result.contains("Large double"));
    }
}
