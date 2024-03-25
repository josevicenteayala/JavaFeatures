package com.javaevolution.lambda.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Logger;

/**
 * Lambdas can be replaced with method references when a method already exists to perform the operation.
 * This makes the code cleaner and more readable.
 * Constructor references can be used similarly for object creation.
 */
public class ReferenceDemo {

    private static final Logger LOGGER = Logger.getLogger(ReferenceDemo.class.getName());
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        words.forEach(LOGGER::info);//Method reference

        Supplier<List<String>> listSupplier = Arrays::asList;//Constructor reference
        List<String> newList = listSupplier.get();//Create a new list
        String msg = "New List: " + newList;
        LOGGER.info(msg);
    }
}
