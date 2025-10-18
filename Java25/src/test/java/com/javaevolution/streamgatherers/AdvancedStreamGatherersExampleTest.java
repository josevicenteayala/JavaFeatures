package com.javaevolution.streamgatherers;

import com.javaevolution.streamgatherers.AdvancedStreamGatherersExample.*;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AdvancedStreamGatherersExampleTest {

    @Test
    void groupByBoundary_shouldGroupCorrectly() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 0, 4, 5, 0, 6);
        List<List<Integer>> groups = AdvancedStreamGatherersExample.groupByBoundary(
            numbers, n -> n == 0
        );
        
        assertEquals(3, groups.size());
        assertEquals(Arrays.asList(1, 2, 3, 0), groups.get(0));
        assertEquals(Arrays.asList(4, 5, 0), groups.get(1));
        assertEquals(Arrays.asList(6), groups.get(2));
    }

    @Test
    void rollingAggregator_shouldComputeRollingAverage() {
        RollingAggregator<Integer, Double> aggregator = 
            new RollingAggregator<>(3, list -> 
                list.stream().mapToInt(Integer::intValue).average().orElse(0.0)
            );
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> averages = aggregator.process(numbers);
        
        assertEquals(3, averages.size());
        assertEquals(2.0, averages.get(0), 0.001);  // (1+2+3)/3
        assertEquals(3.0, averages.get(1), 0.001);  // (2+3+4)/3
        assertEquals(4.0, averages.get(2), 0.001);  // (3+4+5)/3
    }

    @Test
    void distinctByKey_shouldRemoveDuplicates() {
        record Person(String name, int age) {}
        
        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Alice", 35),
            new Person("Charlie", 40)
        );
        
        List<Person> distinct = AdvancedStreamGatherersExample.distinctByKey(
            people, 
            Person::name,
            (p1, p2) -> p1.age() > p2.age() ? p1 : p2  // Keep older
        );
        
        assertEquals(3, distinct.size());
        assertEquals("Alice", distinct.get(0).name());
        assertEquals(35, distinct.get(0).age());  // Should keep older Alice
    }

    @Test
    void chunkWhile_shouldGroupConsecutive() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 10, 11, 12, 20, 21);
        List<List<Integer>> chunks = AdvancedStreamGatherersExample.chunkWhile(
            numbers,
            (a, b) -> Math.abs(b - a) <= 5  // Chunk while difference is small
        );
        
        assertEquals(3, chunks.size());
        assertEquals(Arrays.asList(1, 2, 3), chunks.get(0));
        assertEquals(Arrays.asList(10, 11, 12), chunks.get(1));
        assertEquals(Arrays.asList(20, 21), chunks.get(2));
    }

    @Test
    void multiAggregator_shouldComputeMultipleStats() {
        MultiAggregator<Integer> aggregator = new MultiAggregator<>();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        for (Integer num : numbers) {
            aggregator.accept(num, Integer::doubleValue);
        }
        
        Stats stats = aggregator.getStats();
        
        assertEquals(5, stats.count());
        assertEquals(15.0, stats.sum(), 0.001);
        assertEquals(3.0, stats.average(), 0.001);
        assertEquals(1.0, stats.min(), 0.001);
        assertEquals(5.0, stats.max(), 0.001);
    }

    @Test
    void mapWithIndex_shouldIncludeIndex() {
        List<String> items = Arrays.asList("a", "b", "c");
        List<String> indexed = AdvancedStreamGatherersExample.mapWithIndex(
            items,
            (idx, item) -> idx + ":" + item
        );
        
        assertEquals(Arrays.asList("0:a", "1:b", "2:c"), indexed);
    }

    @Test
    void sample_shouldSelectAtIntervals() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> sampled = AdvancedStreamGatherersExample.sample(numbers, 3);
        
        assertEquals(Arrays.asList(0, 3, 6, 9), sampled);
    }

    @Test
    void sample_withInvalidInterval_shouldThrowException() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        assertThrows(IllegalArgumentException.class, 
            () -> AdvancedStreamGatherersExample.sample(numbers, 0));
    }

    @Test
    void partitionBy_shouldSplitByPredicate() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> partitions = 
            AdvancedStreamGatherersExample.partitionBy(numbers, n -> n % 2 == 0);
        
        assertEquals(Arrays.asList(2, 4, 6), partitions.get(true));
        assertEquals(Arrays.asList(1, 3, 5), partitions.get(false));
    }

    @Test
    void flattenDepth_shouldFlattenToSpecifiedDepth() {
        List<?> nested = Arrays.asList(
            1,
            Arrays.asList(2, 3),
            Arrays.asList(Arrays.asList(4, 5), 6)
        );
        
        List<Object> flattened1 = AdvancedStreamGatherersExample.flattenDepth(nested, 1);
        assertEquals(5, flattened1.size());
        
        List<Object> flattened2 = AdvancedStreamGatherersExample.flattenDepth(nested, 2);
        assertEquals(6, flattened2.size());
    }

    @Test
    void findSequences_shouldDetectPatterns() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<List<Integer>> sequences = AdvancedStreamGatherersExample.findSequences(
            numbers,
            seq -> seq.stream().mapToInt(Integer::intValue).sum() == 5,  // 1+4, 2+3
            2
        );
        
        assertFalse(sequences.isEmpty());
        // Should find [1, 2] (sum=3), [2, 3] (sum=5), [4, 5] (sum=9) etc
        // We're looking for sequences where sum == 5
        assertTrue(sequences.stream().anyMatch(seq -> seq.equals(Arrays.asList(2, 3))));
    }

    @Test
    void transformWithState_shouldAccumulateState() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> cumulative = AdvancedStreamGatherersExample.transformWithState(
            numbers,
            0,
            (state, item) -> {
                int newState = state + item;
                return new Pair<>(newState, newState);
            }
        );
        
        assertEquals(Arrays.asList(1, 3, 6, 10, 15), cumulative);
    }

    @Test
    void intersperse_shouldInsertSeparator() {
        List<String> words = Arrays.asList("Hello", "World", "!");
        List<String> interspersed = AdvancedStreamGatherersExample.intersperse(
            words, " "
        );
        
        assertEquals(Arrays.asList("Hello", " ", "World", " ", "!"), interspersed);
    }

    @Test
    void intersperse_withEmptyList_shouldReturnEmpty() {
        List<String> empty = List.of();
        List<String> result = AdvancedStreamGatherersExample.intersperse(empty, ",");
        
        assertTrue(result.isEmpty());
    }

    @Test
    void takeUntilChange_shouldTakeWhilePredicateSame() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 10, 20, 30);
        List<Integer> taken = AdvancedStreamGatherersExample.takeUntilChange(
            numbers,
            n -> n < 10
        );
        
        assertEquals(Arrays.asList(1, 2, 3, 4), taken);
    }

    @Test
    void chunkWhile_withEmptyList_shouldReturnEmpty() {
        List<Integer> empty = List.of();
        List<List<Integer>> chunks = AdvancedStreamGatherersExample.chunkWhile(
            empty,
            (a, b) -> true
        );
        
        assertTrue(chunks.isEmpty());
    }
}
