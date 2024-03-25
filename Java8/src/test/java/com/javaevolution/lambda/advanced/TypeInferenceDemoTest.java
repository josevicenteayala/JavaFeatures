package com.javaevolution.lambda.advanced;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;
import org.junit.jupiter.api.Test;


class TypeInferenceDemoTest {
    @Test
    void stringLengthComparator_withEqualLengthStrings_returnsZero() {
        Comparator<String> comparator = TypeInferenceDemo.stringLengthComparator;
        int result = comparator.compare("test", "demo");
        assertEquals(0, result);
    }

    @Test
    void stringLengthComparator_withDifferentLengthStrings_returnsNonZero() {
        Comparator<String> comparator = TypeInferenceDemo.stringLengthComparator;
        int result = comparator.compare("short", "longer");
        assertEquals(-1, result);
    }

    @Test
    void stringLengthComparator2_withEqualLengthStrings_returnsZero() {
        Comparator<String> comparator = TypeInferenceDemo.stringLengthComparator2;
        int result = comparator.compare("test", "demo");
        assertEquals(0, result);
    }

    @Test
    void stringLengthComparator2_withDifferentLengthStrings_returnsNonZero() {
        Comparator<String> comparator = TypeInferenceDemo.stringLengthComparator2;
        int result = comparator.compare("short", "longer");
        assertEquals(-1, result);
    }

    @Test
    void stringLengthComparator3_withEqualLengthStrings_returnsZero() {
        Comparator<String> comparator = TypeInferenceDemo.stringLengthComparator3;
        int result = comparator.compare("test", "demo");
        assertEquals(0, result);
    }

    @Test
    void stringLengthComparator3_withDifferentLengthStrings_returnsNonZero() {
        Comparator<String> comparator = TypeInferenceDemo.stringLengthComparator3;
        int result = comparator.compare("short", "longer");
        assertEquals(-1, result);
    }
}