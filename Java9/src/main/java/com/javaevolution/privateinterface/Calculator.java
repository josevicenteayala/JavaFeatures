package com.javaevolution.privateinterface;

/**
 * Demonstrates private methods in interfaces introduced in Java 9.
 * Private methods in interfaces help avoid code duplication in default methods.
 */
public interface Calculator {

    /**
     * Default method that uses private method
     */
    default int addAndMultiply(int a, int b, int multiplier) {
        int sum = add(a, b);
        return multiply(sum, multiplier);
    }

    /**
     * Default method that uses private method
     */
    default int subtractAndMultiply(int a, int b, int multiplier) {
        int difference = subtract(a, b);
        return multiply(difference, multiplier);
    }

    /**
     * Private method to avoid code duplication
     * This is only accessible within the interface
     */
    private int multiply(int value, int multiplier) {
        return value * multiplier;
    }

    /**
     * Default method for addition
     */
    default int add(int a, int b) {
        return a + b;
    }

    /**
     * Default method for subtraction
     */
    default int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Private static method for validation
     */
    private static boolean isValid(int value) {
        return value >= 0;
    }

    /**
     * Default method using private static method
     */
    default int validateAndAdd(int a, int b) {
        if (!isValid(a) || !isValid(b)) {
            throw new IllegalArgumentException("Values must be non-negative");
        }
        return add(a, b);
    }
}
