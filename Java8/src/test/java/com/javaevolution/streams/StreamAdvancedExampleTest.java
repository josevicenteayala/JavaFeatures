package com.javaevolution.streams;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StreamAdvancedExampleTest {

    private final StreamAdvancedExample example = new StreamAdvancedExample();

    @Test
    void sumNumbers_shouldReturnSum() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int result = example.sumNumbers(numbers);
        assertEquals(15, result);
    }

    @Test
    void sumNumbers_givenEmptyList_shouldReturnZero() {
        List<Integer> numbers = Collections.emptyList();
        int result = example.sumNumbers(numbers);
        assertEquals(0, result);
    }

    @Test
    void findMax_shouldReturnMaximum() {
        List<Integer> numbers = Arrays.asList(1, 5, 3, 9, 2);
        Optional<Integer> result = example.findMax(numbers);
        assertTrue(result.isPresent());
        assertEquals(9, result.get());
    }

    @Test
    void findMax_givenEmptyList_shouldReturnEmpty() {
        List<Integer> numbers = Collections.emptyList();
        Optional<Integer> result = example.findMax(numbers);
        assertFalse(result.isPresent());
    }

    @Test
    void flattenLists_shouldFlattenNestedLists() {
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d"),
                Arrays.asList("e")
        );
        List<String> result = example.flattenLists(listOfLists);
        assertEquals(Arrays.asList("a", "b", "c", "d", "e"), result);
    }

    @Test
    void groupByLength_shouldGroupByStringLength() {
        List<String> list = Arrays.asList("a", "ab", "abc", "bc", "c");
        Map<Integer, List<String>> result = example.groupByLength(list);
        assertEquals(3, result.size());
        assertEquals(Arrays.asList("a", "c"), result.get(1));
        assertEquals(Arrays.asList("ab", "bc"), result.get(2));
        assertEquals(Collections.singletonList("abc"), result.get(3));
    }

    @Test
    void partitionByLength_shouldPartitionByPredicate() {
        List<String> list = Arrays.asList("a", "ab", "abc", "abcd");
        Map<Boolean, List<String>> result = example.partitionByLength(list, 3);
        assertEquals(2, result.get(false).size());
        assertEquals(2, result.get(true).size());
    }

    @Test
    void joinStrings_shouldJoinWithDelimiter() {
        List<String> list = Arrays.asList("a", "b", "c");
        String result = example.joinStrings(list, ", ");
        assertEquals("a, b, c", result);
    }

    @Test
    void calculateStatistics_shouldReturnCorrectStatistics() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        IntSummaryStatistics stats = example.calculateStatistics(numbers);
        assertEquals(5, stats.getCount());
        assertEquals(15, stats.getSum());
        assertEquals(3.0, stats.getAverage());
        assertEquals(1, stats.getMin());
        assertEquals(5, stats.getMax());
    }

    @Test
    void countParallel_shouldReturnCount() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
        long count = example.countParallel(list);
        assertEquals(5, count);
    }

    @Test
    void processStrings_shouldApplyMultipleOperations() {
        List<String> list = Arrays.asList("HELLO", "world", "JAVA", "hi", "STREAM");
        List<String> result = example.processStrings(list);
        assertEquals(Arrays.asList("hello", "java", "stream", "world"), result);
    }

    @Test
    void toMap_shouldCreateMapFromList() {
        List<String> list = Arrays.asList("a", "ab", "abc");
        Map<String, Integer> result = example.toMap(list);
        assertEquals(3, result.size());
        assertEquals(1, result.get("a"));
        assertEquals(2, result.get("ab"));
        assertEquals(3, result.get("abc"));
    }

    @Test
    void toMap_givenDuplicates_shouldKeepFirst() {
        List<String> list = Arrays.asList("a", "b", "c");
        Map<String, Integer> result = example.toMap(list);
        assertEquals(3, result.size());
    }
}
