package com.javaevolution.immutable;

import java.util.*;

/**
 * Demonstrates Java 9 factory methods for creating immutable collections.
 * These methods provide a convenient way to create unmodifiable collections.
 */
public class ImmutableCollectionsExample {

    /**
     * Creates an immutable list using List.of()
     */
    public List<String> createImmutableList() {
        return List.of("apple", "banana", "cherry");
    }

    /**
     * Creates an immutable set using Set.of()
     */
    public Set<Integer> createImmutableSet() {
        return Set.of(1, 2, 3, 4, 5);
    }

    /**
     * Creates an immutable map using Map.of()
     */
    public Map<String, Integer> createImmutableMap() {
        return Map.of(
                "one", 1,
                "two", 2,
                "three", 3
        );
    }

    /**
     * Creates an immutable map with more than 10 entries using Map.ofEntries()
     */
    public Map<String, String> createLargeImmutableMap() {
        return Map.ofEntries(
                Map.entry("key1", "value1"),
                Map.entry("key2", "value2"),
                Map.entry("key3", "value3"),
                Map.entry("key4", "value4"),
                Map.entry("key5", "value5"),
                Map.entry("key6", "value6"),
                Map.entry("key7", "value7"),
                Map.entry("key8", "value8"),
                Map.entry("key9", "value9"),
                Map.entry("key10", "value10"),
                Map.entry("key11", "value11")
        );
    }

    /**
     * Demonstrates that immutable collections throw UnsupportedOperationException on modification
     */
    public void demonstrateImmutability() {
        List<String> immutableList = List.of("a", "b", "c");
        // The following would throw UnsupportedOperationException:
        // immutableList.add("d");
        // immutableList.remove(0);
        // immutableList.set(0, "x");
    }

    /**
     * Creates an empty immutable list
     */
    public List<String> createEmptyImmutableList() {
        return List.of();
    }

    /**
     * Creates an empty immutable set
     */
    public Set<String> createEmptyImmutableSet() {
        return Set.of();
    }

    /**
     * Creates an empty immutable map
     */
    public Map<String, String> createEmptyImmutableMap() {
        return Map.of();
    }
}
