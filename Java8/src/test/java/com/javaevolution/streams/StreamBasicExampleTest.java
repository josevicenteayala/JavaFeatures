package com.javaevolution.streams;

import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StreamBasicExampleTest {

    private final StreamBasicExample example = new StreamBasicExample();

    @Test
    void createStreamFromCollection_shouldCreateStream() {
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream = example.createStreamFromCollection(list);
        assertNotNull(stream);
        assertEquals(3, stream.count());
    }

    @Test
    void createStreamFromValues_shouldCreateStream() {
        Stream<String> stream = example.createStreamFromValues();
        assertNotNull(stream);
        assertEquals(3, stream.count());
    }

    @Test
    void filterStream_shouldReturnMatchingElements() {
        List<String> list = Arrays.asList("apple", "apricot", "banana", "avocado");
        List<String> result = example.filterStream(list, "a");
        assertEquals(3, result.size());
        assertTrue(result.contains("apple"));
        assertTrue(result.contains("apricot"));
        assertTrue(result.contains("avocado"));
    }

    @Test
    void mapToLength_shouldReturnLengths() {
        List<String> list = Arrays.asList("a", "ab", "abc");
        List<Integer> result = example.mapToLength(list);
        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    void sortStream_shouldReturnSortedList() {
        List<String> list = Arrays.asList("c", "a", "b");
        List<String> result = example.sortStream(list);
        assertEquals(Arrays.asList("a", "b", "c"), result);
    }

    @Test
    void countElements_shouldReturnCorrectCount() {
        List<String> list = Arrays.asList("a", "b", "c");
        long count = example.countElements(list);
        assertEquals(3, count);
    }

    @Test
    void findFirst_givenNonEmptyList_shouldReturnFirstElement() {
        List<String> list = Arrays.asList("first", "second", "third");
        Optional<String> result = example.findFirst(list);
        assertTrue(result.isPresent());
        assertEquals("first", result.get());
    }

    @Test
    void findFirst_givenEmptyList_shouldReturnEmpty() {
        List<String> list = Collections.emptyList();
        Optional<String> result = example.findFirst(list);
        assertFalse(result.isPresent());
    }

    @Test
    void anyMatch_givenMatchingElement_shouldReturnTrue() {
        List<String> list = Arrays.asList("a", "b", "c");
        boolean result = example.anyMatch(list, "b");
        assertTrue(result);
    }

    @Test
    void anyMatch_givenNonMatchingElement_shouldReturnFalse() {
        List<String> list = Arrays.asList("a", "b", "c");
        boolean result = example.anyMatch(list, "d");
        assertFalse(result);
    }

    @Test
    void allMatch_givenAllMatchingElements_shouldReturnTrue() {
        List<String> list = Arrays.asList("abc", "def", "ghi");
        boolean result = example.allMatch(list, 3);
        assertTrue(result);
    }

    @Test
    void allMatch_givenSomeNonMatchingElements_shouldReturnFalse() {
        List<String> list = Arrays.asList("a", "abc", "def");
        boolean result = example.allMatch(list, 3);
        assertFalse(result);
    }

    @Test
    void collectToSet_shouldReturnSet() {
        List<String> list = Arrays.asList("a", "b", "a", "c");
        Set<String> result = example.collectToSet(list);
        assertEquals(3, result.size());
        assertTrue(result.contains("a"));
        assertTrue(result.contains("b"));
        assertTrue(result.contains("c"));
    }
}
