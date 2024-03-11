package com.javaevolution.lambda.methodreferences;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstanceMethodArbitraryObjectTest {

    @Test
    void sortStringsAlphabetically_givenUnsortedStringList_shouldReturnAlphabeticallyOrderedList() {
        List<String> unsordedList = Arrays.asList("three","two","one");
        List<String> expectedList = List.of("one","three","two");

        assertIterableEquals(expectedList, InstanceMethodArbitraryObject.sortStringsAlphabetically(unsordedList));
    }
}