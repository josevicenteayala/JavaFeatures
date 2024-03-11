package com.javaevolution.lambda.methodreferences;

import java.util.List;
import java.util.Objects;

public class StaticMethodReference {

    private StaticMethodReference() {
        throw new IllegalStateException("This is a util class");
    }

    public static List<String> reverseOrderOfElementsInList(List<String> texts) {
        Objects.requireNonNull(texts);
        return texts.stream().map(StaticMethodReference::reverseString).toList();
    }

    private static String reverseString(String text) {
        Objects.requireNonNull(text);

        StringBuilder  builder = new StringBuilder(text);
        return builder.reverse().toString();
    }
}
