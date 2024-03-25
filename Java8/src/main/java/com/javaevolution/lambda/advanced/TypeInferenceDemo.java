package com.javaevolution.lambda.advanced;

import java.util.Comparator;

/**
 * Java's type inference with lambda expressions means that the compiler often deduces the datatype of parameters and the return type from the lambda's body, the interface's method declaration, or the context in which the lambda is used.
 */
public class TypeInferenceDemo {

    private TypeInferenceDemo() {
        // Private constructor to prevent instantiation
    }

    public static final Comparator<String> stringLengthComparator = (s1, s2) -> Integer.compare(s1.length(), s2.length());
    public static final Comparator<String> stringLengthComparator2 = Comparator.comparingInt(String::length);
    public static final Comparator<String> stringLengthComparator3 = (s1, s2) -> s1.length() - s2.length();


}
