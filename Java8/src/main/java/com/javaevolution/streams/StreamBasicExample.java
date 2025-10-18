package com.javaevolution.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Demonstrates basic Stream API operations in Java 8.
 * Streams provide a functional approach to processing collections of objects.
 */
public class StreamBasicExample {

    /**
     * Creates a stream from a collection.
     */
    public Stream<String> createStreamFromCollection(List<String> list) {
        return list.stream();
    }

    /**
     * Creates a stream from values.
     */
    public Stream<String> createStreamFromValues() {
        return Stream.of("a", "b", "c");
    }

    /**
     * Filters elements from a stream.
     */
    public List<String> filterStream(List<String> list, String prefix) {
        return list.stream()
                .filter(s -> s.startsWith(prefix))
                .collect(Collectors.toList());
    }

    /**
     * Maps elements to a different type.
     */
    public List<Integer> mapToLength(List<String> list) {
        return list.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }

    /**
     * Sorts elements in a stream.
     */
    public List<String> sortStream(List<String> list) {
        return list.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Counts elements in a stream.
     */
    public long countElements(List<String> list) {
        return list.stream().count();
    }

    /**
     * Finds first element in a stream.
     */
    public Optional<String> findFirst(List<String> list) {
        return list.stream().findFirst();
    }

    /**
     * Checks if any element matches a predicate.
     */
    public boolean anyMatch(List<String> list, String value) {
        return list.stream().anyMatch(s -> s.equals(value));
    }

    /**
     * Checks if all elements match a predicate.
     */
    public boolean allMatch(List<String> list, int minLength) {
        return list.stream().allMatch(s -> s.length() >= minLength);
    }

    /**
     * Collects stream elements to a set.
     */
    public Set<String> collectToSet(List<String> list) {
        return list.stream().collect(Collectors.toSet());
    }
}
