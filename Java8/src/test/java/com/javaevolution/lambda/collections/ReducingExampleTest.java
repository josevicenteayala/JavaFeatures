package com.javaevolution.lambda.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class ReducingExampleTest {

    @Test
    void sumNumbers_givenPositiveNumbers_shouldReturnSumOfIntegers() {
        List<Integer> numbers = List.of(2,4,7);

        assertEquals(13,ReducingExample.sumNumbers(numbers));
    }
}