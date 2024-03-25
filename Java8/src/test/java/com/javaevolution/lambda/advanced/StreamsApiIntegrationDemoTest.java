package com.javaevolution.lambda.advanced;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;


class StreamsApiIntegrationDemoTest {

    @Test
    void sumOfEvenNumbers_withAllEvenNumbers_returnsSum() {
        Integer[] array = {2, 4, 6, 8};
        assertEquals(Collections.singletonList(20), StreamsApiIntegrationDemo.sumOfEvenNumbers(array));
    }

    @Test
    void sumOfEvenNumbers_withMixedNumbers_returnsSumOfEvenNumbers() {
        Integer[] array = {1, 2, 3, 4, 5, 6};
        assertEquals(Collections.singletonList(12), StreamsApiIntegrationDemo.sumOfEvenNumbers(array));
    }

    @Test
    void sumOfEvenNumbers_withAllOddNumbers_returnsZero() {
        Integer[] array = {1, 3, 5, 7};
        assertEquals(Collections.singletonList(0), StreamsApiIntegrationDemo.sumOfEvenNumbers(array));
    }

    @Test
    void sumOfEvenNumbers_withEmptyArray_returnsZero() {
        Integer[] array = {};
        assertEquals(Collections.singletonList(0), StreamsApiIntegrationDemo.sumOfEvenNumbers(array));
    }
}