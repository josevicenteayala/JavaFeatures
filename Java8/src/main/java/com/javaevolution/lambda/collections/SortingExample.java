package com.javaevolution.lambda.collections;

import java.util.List;
import java.util.Objects;

public class SortingExample {

    private SortingExample() {
        throw new IllegalStateException("This is a util class");
    }

    public static List<Integer> sortArray(List<Integer> numbers) {
        Objects.requireNonNull(numbers);

        return numbers.stream().sorted().toList();
    }
}
