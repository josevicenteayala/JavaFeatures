package com.javaevolution.lambda.collections;

import java.util.List;
import java.util.Objects;

public class TransformingExample {

    private TransformingExample() {
        throw new IllegalStateException("This is a util class");
    }

    public static List<Integer> squaredNumbers(List<Integer> numbers) {
        Objects.requireNonNull(numbers);

        return numbers.stream().map(number -> number * number).toList();
    }
}
