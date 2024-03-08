package com.javaevolution.lambda.collections;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class FilteringExampleTest {

    @Test
    void filterNamesByFirstLetter_givenNames_shouldReturnNamesBySpecificLetter() {
        List<String> names = List.of("John", "Jane", "Adam", "Diana");

        assertIterableEquals(List.of("Diana"),FilteringExample.filterNamesByFirstLetter(names,"D"));
    }
}