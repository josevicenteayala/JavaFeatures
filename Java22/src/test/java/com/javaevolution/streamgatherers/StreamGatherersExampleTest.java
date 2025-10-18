package com.javaevolution.streamgatherers;

import com.javaevolution.streamgatherers.StreamGatherersExample.Pair;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StreamGatherersExampleTest {

    private final StreamGatherersExample example = new StreamGatherersExample();

    @Test
    void processInWindows_shouldCreateFixedSizeWindows() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<List<Integer>> windows = example.processInWindows(numbers, 2);
        
        assertEquals(3, windows.size());
        assertEquals(Arrays.asList(1, 2), windows.get(0));
        assertEquals(Arrays.asList(3, 4), windows.get(1));
        assertEquals(Arrays.asList(5, 6), windows.get(2));
    }

    @Test
    void processInWindows_withOddElements_shouldHandleRemainder() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<List<Integer>> windows = example.processInWindows(numbers, 2);
        
        assertEquals(3, windows.size());
        assertEquals(Arrays.asList(1, 2), windows.get(0));
        assertEquals(Arrays.asList(3, 4), windows.get(1));
        assertEquals(Arrays.asList(5), windows.get(2));
    }

    @Test
    void slidingWindow_shouldCreateOverlappingWindows() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<List<Integer>> windows = example.slidingWindow(numbers, 3);
        
        assertEquals(3, windows.size());
        assertEquals(Arrays.asList(1, 2, 3), windows.get(0));
        assertEquals(Arrays.asList(2, 3, 4), windows.get(1));
        assertEquals(Arrays.asList(3, 4, 5), windows.get(2));
    }

    @Test
    void calculateRunningAverages_shouldComputeCorrectly() {
        List<Double> numbers = Arrays.asList(2.0, 4.0, 6.0, 8.0);
        List<Double> averages = example.calculateRunningAverages(numbers);
        
        assertEquals(4, averages.size());
        assertEquals(2.0, averages.get(0), 0.001);
        assertEquals(3.0, averages.get(1), 0.001);
        assertEquals(4.0, averages.get(2), 0.001);
        assertEquals(5.0, averages.get(3), 0.001);
    }

    @Test
    void distinctByKey_shouldRemoveDuplicatesByKey() {
        record Person(String name, int age) {}
        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Alice", 35)
        );
        
        List<Person> distinct = example.distinctByKey(people, Person::name);
        
        assertEquals(2, distinct.size());
        assertEquals("Alice", distinct.get(0).name());
        assertEquals("Bob", distinct.get(1).name());
    }

    @Test
    void takeWhileWithLimit_shouldCombineBothOperations() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> result = example.takeWhileWithLimit(numbers, n -> n < 10, 3);
        
        assertEquals(3, result.size());
        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    void foldLeft_shouldAccumulateCorrectly() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum = example.foldLeft(numbers, 0, Integer::sum);
        
        assertEquals(15, sum);
    }

    @Test
    void foldLeft_withStrings_shouldConcatenate() {
        List<String> words = Arrays.asList("Hello", " ", "World");
        String result = example.foldLeft(words, "", String::concat);
        
        assertEquals("Hello World", result);
    }

    @Test
    void scan_shouldReturnIntermediateResults() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> scanned = example.scan(numbers, 0);
        
        assertEquals(Arrays.asList(1, 3, 6, 10), scanned);
    }

    @Test
    void groupAndGather_shouldGroupCorrectly() {
        record Person(String city, String name) {}
        List<Person> people = Arrays.asList(
            new Person("NYC", "Alice"),
            new Person("LA", "Bob"),
            new Person("NYC", "Charlie")
        );
        
        Map<String, List<Person>> grouped = example.groupAndGather(people, Person::city);
        
        assertEquals(2, grouped.size());
        assertEquals(2, grouped.get("NYC").size());
        assertEquals(1, grouped.get("LA").size());
    }

    @Test
    void interleave_shouldMixElementsFromBothLists() {
        List<Integer> list1 = Arrays.asList(1, 3, 5);
        List<Integer> list2 = Arrays.asList(2, 4, 6);
        List<Integer> result = example.interleave(list1, list2);
        
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), result);
    }

    @Test
    void interleave_withDifferentSizes_shouldHandleCorrectly() {
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7);
        List<Integer> list2 = Arrays.asList(2, 4);
        List<Integer> result = example.interleave(list1, list2);
        
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 7), result);
    }

    @Test
    void batch_shouldCreateCorrectBatches() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<List<Integer>> batches = example.batch(numbers, 3);
        
        assertEquals(3, batches.size());
        assertEquals(Arrays.asList(1, 2, 3), batches.get(0));
        assertEquals(Arrays.asList(4, 5, 6), batches.get(1));
        assertEquals(Arrays.asList(7), batches.get(2));
    }

    @Test
    void zip_shouldCombineElementsPairwise() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<Integer> ages = Arrays.asList(30, 25, 35);
        List<Pair<String, Integer>> zipped = example.zip(names, ages);
        
        assertEquals(3, zipped.size());
        assertEquals("Alice", zipped.get(0).first());
        assertEquals(30, zipped.get(0).second());
        assertEquals("Bob", zipped.get(1).first());
        assertEquals(25, zipped.get(1).second());
    }

    @Test
    void zip_withDifferentSizes_shouldUseMinimumSize() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<Integer> ages = Arrays.asList(30, 25);
        List<Pair<String, Integer>> zipped = example.zip(names, ages);
        
        assertEquals(2, zipped.size());
    }

    @Test
    void dropWhile_shouldDropElementsWhilePredicateTrue() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> result = example.dropWhile(numbers, n -> n < 4);
        
        assertEquals(Arrays.asList(4, 5, 6), result);
    }
}
