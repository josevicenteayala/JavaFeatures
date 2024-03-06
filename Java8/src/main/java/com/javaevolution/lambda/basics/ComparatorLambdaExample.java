package com.javaevolution.lambda.basics;

import static com.javaevolution.lambda.Printer.printLogger;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class ComparatorLambdaExample {

    private static final Logger LOGGER = Logger.getLogger(ComparatorLambdaExample.class.getName());

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Steve", "Anna", "Mike", "John");
        List<String> fruits = Arrays.asList("Pineapple", "Apple", "Orange", "Dragon Fruit");

        printLogger(LOGGER,"Before sorting names: ",names);
        names.sort(getStringComparator());
        printLogger(LOGGER,"After sorting names: ", names);

        printLogger(LOGGER,"Before sorting fruits: ", fruits);
        fruits.sort(getStringComparatorEnhanced());
        printLogger(LOGGER,"After sorting fruits: ", fruits);
    }

    static Comparator<String> getStringComparator() {
        return (String a, String b) -> a.compareTo(b);
    }

    /**
     * Creates and returns a Comparator for Strings using a method reference.
     * <p>
     * This method demonstrates an enhanced way to instantiate a Comparator
     * for Strings by utilizing the method reference syntax, which is a concise
     * and readable alternative to lambda expressions for certain cases.
     *
     * @return A Comparator that compares Strings using their natural ordering.
     */
    static Comparator<String> getStringComparatorEnhanced() {
        // Method reference to String's compareTo method.
        // This is functionally equivalent to (s1, s2) -> s1.compareTo(s2),
        // but is more concise and directly references the existing method.
        return String::compareTo;
    }
}
