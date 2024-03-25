package com.javaevolution.lambda.advanced;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.logging.Logger;

/**
 * Lambda expressions can be used to delay computation, which is particularly useful in performance-sensitive applications, allowing code to only execute a lambda when necessary.
 */
public class LazyEvaluationDemo {

    private static final Logger LOGGER = Logger.getLogger(LazyEvaluationDemo.class.getName());
    public static void main(String[] args) {
        boolean isDebugLoggingEnabled = false; // Imagine this is set elsewhere in your application
        logIf(() -> isDebugLoggingEnabled, () -> "This is a debug message.");
    }

    public static void logIf(BooleanSupplier condition, Supplier<String> messageSupplier) {
        if (condition.getAsBoolean()) {
            LOGGER.info(messageSupplier.get());
        }
    }
}
