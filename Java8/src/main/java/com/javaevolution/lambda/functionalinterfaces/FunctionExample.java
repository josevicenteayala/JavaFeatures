package com.javaevolution.lambda.functionalinterfaces;

import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionExample {

    private FunctionExample() {
        throw new IllegalStateException("This is a util class");
    }

    public static Integer getStringLength(String text) {
        Function<String, Integer> lengthFunction = String :: length;
        return lengthFunction.apply(text);
    }

    public static Integer getStringLengthImprovement(String text) {
        ToIntFunction<String> lengthFunction = String :: length;
        return lengthFunction.applyAsInt(text);
    }
}
