package com.javaevolution.lambda.collections;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SortingExampleTest {

    @Test
    void sortArray_givenUnsortedList_shouldReturnSortedList() {
        List<Integer> numbers = List.of(9,60,48,2,74);
        assertIterableEquals(List.of(2,9,48,60,74), SortingExample.sortArray(numbers));
    }
}