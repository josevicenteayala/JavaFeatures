package com.javaevolution.streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Demonstrates advanced Stream API operations including reduce, flatMap, and grouping.
 */
public class StreamAdvancedExample {

    /**
     * Reduces stream to a single value using sum.
     */
    public int sumNumbers(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    /**
     * Reduces stream to find maximum value.
     */
    public Optional<Integer> findMax(List<Integer> numbers) {
        return numbers.stream()
                .reduce(Integer::max);
    }

    /**
     * Flattens nested collections using flatMap.
     */
    public List<String> flattenLists(List<List<String>> listOfLists) {
        return listOfLists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    /**
     * Groups elements by a classifier.
     */
    public Map<Integer, List<String>> groupByLength(List<String> list) {
        return list.stream()
                .collect(Collectors.groupingBy(String::length));
    }

    /**
     * Partitions elements based on a predicate.
     */
    public Map<Boolean, List<String>> partitionByLength(List<String> list, int minLength) {
        return list.stream()
                .collect(Collectors.partitioningBy(s -> s.length() >= minLength));
    }

    /**
     * Joins strings with a delimiter.
     */
    public String joinStrings(List<String> list, String delimiter) {
        return list.stream()
                .collect(Collectors.joining(delimiter));
    }

    /**
     * Calculates statistics for numeric stream.
     */
    public IntSummaryStatistics calculateStatistics(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.summarizingInt(Integer::intValue));
    }

    /**
     * Demonstrates parallel stream processing.
     */
    public long countParallel(List<String> list) {
        return list.parallelStream().count();
    }

    /**
     * Chains multiple stream operations.
     */
    public List<String> processStrings(List<String> list) {
        return list.stream()
                .filter(s -> s.length() > 3)
                .map(String::toLowerCase)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Creates a map from stream.
     */
    public Map<String, Integer> toMap(List<String> list) {
        return list.stream()
                .distinct()
                .collect(Collectors.toMap(
                        s -> s,
                        String::length
                ));
    }
}
