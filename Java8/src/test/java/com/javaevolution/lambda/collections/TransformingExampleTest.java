package com.javaevolution.lambda.collections;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class TransformingExampleTest {

    @Test
    void squaredNumbers_givenaListOfIntegers_shouldReturnAListOfSquaredNumbers() {
        List<Integer> numbers = List.of(2,5,7,9);
        List<Integer>  squares = TransformingExample.squaredNumbers(numbers);
        assertIterableEquals(List.of(4,25,49,81),squares);
    }
}