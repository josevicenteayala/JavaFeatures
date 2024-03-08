package com.javaevolution.lambda.functionalinterfaces;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class PredicateExampleTest {

    @Test
    void filterList_givenAIsEvenFilter_shouldReturnEventListNumbers() {
        Predicate<Integer> isEven = x -> x % 2 == 0;

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> evenNumbers = PredicateExample.filterList(numbers, isEven);

        assertEquals(List.of(2,4,6), evenNumbers);
    }
}