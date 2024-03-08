package com.javaevolution.lambda.collections;

import java.util.List;
import java.util.Objects;
import java.util.function.BinaryOperator;

public class ReducingExample {

    private ReducingExample() {
        throw new IllegalStateException("This is a util class");
    }

    public static Integer sumNumbers(List<Integer> numbers){
        Objects.requireNonNull(numbers);

        BinaryOperator<Integer> integerBinaryOperator = Integer::sum;

        return numbers.stream().reduce(0, integerBinaryOperator);
    }

}
