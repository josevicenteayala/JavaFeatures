package com.javaevolution.streamgatherers;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Demonstrates Stream Gatherers introduced in Java 22 (JEP 461).
 * Stream Gatherers provide a more flexible and composable way to perform
 * intermediate operations on streams, complementing existing collectors.
 * 
 * Note: This is a preview feature in Java 22. The API may change in future releases.
 * Since we're running on Java 17, we'll demonstrate the concepts using custom collectors
 * that show how gatherers would work.
 */
public class StreamGatherersExample {

    /**
     * Example: Custom windowing operation (sliding window)
     * Groups elements into fixed-size windows
     */
    public static <T> Collector<T, ?, List<List<T>>> windowedCollector(int windowSize) {
        return Collector.of(
            () -> new ArrayList<List<T>>(),
            (acc, item) -> {
                if (acc.isEmpty() || acc.get(acc.size() - 1).size() == windowSize) {
                    acc.add(new ArrayList<>());
                }
                acc.get(acc.size() - 1).add(item);
            },
            (acc1, acc2) -> {
                acc1.addAll(acc2);
                return acc1;
            }
        );
    }

    /**
     * Example: Fixed window processing
     * Processes stream in fixed-size chunks
     */
    public List<List<Integer>> processInWindows(List<Integer> numbers, int windowSize) {
        return numbers.stream()
                .collect(windowedCollector(windowSize));
    }

    /**
     * Example: Sliding window operation
     * Creates overlapping windows of elements
     */
    public List<List<Integer>> slidingWindow(List<Integer> numbers, int windowSize) {
        List<List<Integer>> windows = new ArrayList<>();
        for (int i = 0; i <= numbers.size() - windowSize; i++) {
            windows.add(numbers.subList(i, i + windowSize));
        }
        return windows;
    }

    /**
     * Example: Custom gathering with state
     * Demonstrates stateful stream processing
     */
    public static class RunningAverageGatherer {
        private double sum = 0;
        private int count = 0;

        public void accept(double value) {
            sum += value;
            count++;
        }

        public double getAverage() {
            return count == 0 ? 0 : sum / count;
        }

        public RunningAverageGatherer combine(RunningAverageGatherer other) {
            this.sum += other.sum;
            this.count += other.count;
            return this;
        }
    }

    /**
     * Calculate running averages using custom gatherer concept
     */
    public List<Double> calculateRunningAverages(List<Double> numbers) {
        List<Double> averages = new ArrayList<>();
        double sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
            averages.add(sum / (i + 1));
        }
        return averages;
    }

    /**
     * Example: Distinct by key gatherer
     * Removes duplicates based on a key function
     */
    public <T, K> List<T> distinctByKey(List<T> items, Function<T, K> keyExtractor) {
        Set<K> seen = new HashSet<>();
        return items.stream()
                .filter(item -> seen.add(keyExtractor.apply(item)))
                .collect(Collectors.toList());
    }

    /**
     * Example: Take while with limit
     * Combines takeWhile with limit functionality
     */
    public <T> List<T> takeWhileWithLimit(List<T> items, 
                                           java.util.function.Predicate<T> predicate, 
                                           int maxItems) {
        return items.stream()
                .takeWhile(predicate)
                .limit(maxItems)
                .collect(Collectors.toList());
    }

    /**
     * Example: Fold operation (accumulation with initial value)
     * Demonstrates left fold over stream
     */
    public <T, R> R foldLeft(List<T> items, R initial, 
                              java.util.function.BiFunction<R, T, R> accumulator) {
        R result = initial;
        for (T item : items) {
            result = accumulator.apply(result, item);
        }
        return result;
    }

    /**
     * Example: Scan operation (prefix sum and similar operations)
     * Returns intermediate accumulation results
     */
    public List<Integer> scan(List<Integer> numbers, int initial) {
        List<Integer> result = new ArrayList<>();
        int accumulator = initial;
        for (int number : numbers) {
            accumulator += number;
            result.add(accumulator);
        }
        return result;
    }

    /**
     * Example: Group by and then gather
     * Combines grouping with custom gathering operation
     */
    public <T, K> Map<K, List<T>> groupAndGather(List<T> items, 
                                                   Function<T, K> classifier) {
        return items.stream()
                .collect(Collectors.groupingBy(classifier));
    }

    /**
     * Example: Interleave gatherer
     * Interleaves elements from two sources
     */
    public <T> List<T> interleave(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>();
        int maxSize = Math.max(list1.size(), list2.size());
        for (int i = 0; i < maxSize; i++) {
            if (i < list1.size()) {
                result.add(list1.get(i));
            }
            if (i < list2.size()) {
                result.add(list2.get(i));
            }
        }
        return result;
    }

    /**
     * Example: Batch processing
     * Processes elements in batches with a given size
     */
    public <T> List<List<T>> batch(List<T> items, int batchSize) {
        List<List<T>> batches = new ArrayList<>();
        for (int i = 0; i < items.size(); i += batchSize) {
            batches.add(items.subList(i, Math.min(i + batchSize, items.size())));
        }
        return batches;
    }

    /**
     * Example: Zip operation
     * Combines elements from two lists pairwise
     */
    public record Pair<A, B>(A first, B second) {}

    public <A, B> List<Pair<A, B>> zip(List<A> list1, List<B> list2) {
        int size = Math.min(list1.size(), list2.size());
        List<Pair<A, B>> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(new Pair<>(list1.get(i), list2.get(i)));
        }
        return result;
    }

    /**
     * Example: Drop while gatherer
     * Drops elements while predicate is true, then includes rest
     */
    public <T> List<T> dropWhile(List<T> items, 
                                   java.util.function.Predicate<T> predicate) {
        return items.stream()
                .dropWhile(predicate)
                .collect(Collectors.toList());
    }
}
