package com.javaevolution.lambda.basics;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class ComparatorLambdaExampleTest {

    public static final List<String> NAMES_EXPECTED = Arrays.asList("Anna", "John", "Mike", "Steve");

    @Test
    void getStringComparator_givenUnorderedList_shouldOrderTheList() {
        List<String> names = Arrays.asList("Steve", "Anna", "Mike", "John");
        Comparator<String> comparator = ComparatorLambdaExample.getStringComparator();
        names.sort(comparator);
        assertIterableEquals(NAMES_EXPECTED,names);
    }

    @Test
    void getStringComparatorEnhanced_givenUnorderedList_shouldOrderTheList() {
        List<String> names = Arrays.asList("Steve", "Anna", "Mike", "John");
        Comparator<String> comparator = ComparatorLambdaExample.getStringComparatorEnhanced();
        names.sort(comparator);
        assertIterableEquals(NAMES_EXPECTED,names);
    }
}