package com.javaevolution.lambda.advanced;

import java.util.function.Consumer;
import java.util.logging.Logger;

/**
 * Higher-order functions are functions that take other functions as arguments or return them as results.
 * In this example, the createPrinter() function takes a string and returns a consumer that prints the string with a prefix.
 */
public class HigherOrderFunctionDemo {

    private static final String WARNING = "Warning: ";
    private static final Logger LOGGER = Logger.getLogger(HigherOrderFunctionDemo.class.getName());
    public static void main(String[] args) {
        Consumer<String> printer = createPrinter(WARNING);
        printer.accept("Check system health.");
    }

    public static Consumer<String> createPrinter(String prefix) {
        return message -> {
            String formatted = String.format("%s%s", prefix, message);
            LOGGER.info(formatted);
        };
    }
}
