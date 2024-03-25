package com.javaevolution.lambda.advanced;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The Streams API is a powerful tool for processing collections of objects in Java.
 * It allows you to perform operations such as filtering, mapping, and reducing on collections of objects.
 * The Streams API is integrated with the Collections API, so you can easily convert a collection to a stream and back again.

 */
public class StreamsApiIntegrationDemo {
    private StreamsApiIntegrationDemo() {
        // Private constructor to prevent instantiation
    }
    public static List<Integer> sumOfEvenNumbers(Integer[] array) {
        List<Integer> numbers = Arrays.asList(array);
        return Collections.singletonList(numbers.stream().filter(n -> n % 2 == 0).mapToInt(n -> n).sum());
    }

}
