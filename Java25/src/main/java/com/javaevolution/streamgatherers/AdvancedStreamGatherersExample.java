package com.javaevolution.streamgatherers;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * Demonstrates Advanced Stream Gatherers concepts expected in Java 25.
 * 
 * By Java 25, stream gatherers are expected to be finalized or in late preview,
 * offering powerful intermediate operations for streams that go beyond
 * traditional map, filter, and reduce operations.
 * 
 * Note: Running on Java 17, so these are conceptual implementations showing
 * how advanced gatherers would work.
 */
public class AdvancedStreamGatherersExample {

    /**
     * Example: Stateful windowing with custom logic
     * Groups elements based on a predicate boundary
     */
    public static <T> List<List<T>> groupByBoundary(List<T> items, 
                                                      Predicate<T> boundaryPredicate) {
        List<List<T>> groups = new ArrayList<>();
        List<T> currentGroup = new ArrayList<>();
        
        for (T item : items) {
            currentGroup.add(item);
            if (boundaryPredicate.test(item)) {
                groups.add(new ArrayList<>(currentGroup));
                currentGroup.clear();
            }
        }
        
        if (!currentGroup.isEmpty()) {
            groups.add(currentGroup);
        }
        
        return groups;
    }

    /**
     * Example: Rolling aggregation
     * Computes aggregate over a rolling window
     */
    public static class RollingAggregator<T, R> {
        private final int windowSize;
        private final Function<List<T>, R> aggregator;
        private final Deque<T> window = new ArrayDeque<>();

        public RollingAggregator(int windowSize, Function<List<T>, R> aggregator) {
            this.windowSize = windowSize;
            this.aggregator = aggregator;
        }

        public List<R> process(List<T> items) {
            List<R> results = new ArrayList<>();
            
            for (T item : items) {
                window.addLast(item);
                if (window.size() > windowSize) {
                    window.removeFirst();
                }
                if (window.size() == windowSize) {
                    results.add(aggregator.apply(new ArrayList<>(window)));
                }
            }
            
            return results;
        }
    }

    /**
     * Example: Deduplication with key extractor
     * More sophisticated than simple distinct()
     */
    public static <T, K> List<T> distinctByKey(List<T> items, 
                                                Function<T, K> keyExtractor,
                                                BinaryOperator<T> conflictResolver) {
        Map<K, T> seen = new LinkedHashMap<>();
        
        for (T item : items) {
            K key = keyExtractor.apply(item);
            seen.merge(key, item, conflictResolver);
        }
        
        return new ArrayList<>(seen.values());
    }

    /**
     * Example: Chunking with predicate
     * Groups consecutive elements that satisfy a condition
     */
    public static <T> List<List<T>> chunkWhile(List<T> items, 
                                                BiPredicate<T, T> continuePredicate) {
        if (items.isEmpty()) {
            return List.of();
        }
        
        List<List<T>> chunks = new ArrayList<>();
        List<T> currentChunk = new ArrayList<>();
        currentChunk.add(items.get(0));
        
        for (int i = 1; i < items.size(); i++) {
            T current = items.get(i);
            T previous = items.get(i - 1);
            
            if (continuePredicate.test(previous, current)) {
                currentChunk.add(current);
            } else {
                chunks.add(new ArrayList<>(currentChunk));
                currentChunk.clear();
                currentChunk.add(current);
            }
        }
        
        if (!currentChunk.isEmpty()) {
            chunks.add(currentChunk);
        }
        
        return chunks;
    }

    /**
     * Example: Fold with multiple accumulators
     * Computes multiple aggregates in a single pass
     */
    public static class MultiAggregator<T> {
        private int count = 0;
        private double sum = 0.0;
        private double min = Double.MAX_VALUE;
        private double max = Double.MIN_VALUE;

        public void accept(T item, ToDoubleFunction<T> extractor) {
            double value = extractor.applyAsDouble(item);
            count++;
            sum += value;
            min = Math.min(min, value);
            max = Math.max(max, value);
        }

        public Stats getStats() {
            return new Stats(count, sum, sum / count, min, max);
        }
    }

    public record Stats(int count, double sum, double average, double min, double max) {}

    /**
     * Example: Indexed gathering
     * Tracks index during stream processing
     */
    public static <T, R> List<R> mapWithIndex(List<T> items, 
                                               BiFunction<Integer, T, R> mapper) {
        List<R> results = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            results.add(mapper.apply(i, items.get(i)));
        }
        return results;
    }

    /**
     * Example: Sampling gatherer
     * Selects elements at regular intervals
     */
    public static <T> List<T> sample(List<T> items, int interval) {
        if (interval <= 0) {
            throw new IllegalArgumentException("Interval must be positive");
        }
        
        List<T> sampled = new ArrayList<>();
        for (int i = 0; i < items.size(); i += interval) {
            sampled.add(items.get(i));
        }
        return sampled;
    }

    /**
     * Example: Partition by predicate
     * Splits stream into two parts based on predicate
     */
    public static <T> Map<Boolean, List<T>> partitionBy(List<T> items, 
                                                         Predicate<T> predicate) {
        Map<Boolean, List<T>> partitions = new HashMap<>();
        partitions.put(true, new ArrayList<>());
        partitions.put(false, new ArrayList<>());
        
        for (T item : items) {
            partitions.get(predicate.test(item)).add(item);
        }
        
        return partitions;
    }

    /**
     * Example: Flatten with depth limit
     * Flattens nested structures up to a certain depth
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> flattenDepth(List<?> items, int maxDepth) {
        if (maxDepth <= 0) {
            return (List<T>) items;
        }
        
        List<T> result = new ArrayList<>();
        for (Object item : items) {
            if (item instanceof List && maxDepth > 0) {
                result.addAll(flattenDepth((List<?>) item, maxDepth - 1));
            } else {
                result.add((T) item);
            }
        }
        return result;
    }

    /**
     * Example: Sequence detector
     * Finds sequences matching a pattern
     */
    public static <T> List<List<T>> findSequences(List<T> items, 
                                                   Predicate<List<T>> sequencePredicate,
                                                   int sequenceLength) {
        List<List<T>> sequences = new ArrayList<>();
        
        for (int i = 0; i <= items.size() - sequenceLength; i++) {
            List<T> candidate = items.subList(i, i + sequenceLength);
            if (sequencePredicate.test(candidate)) {
                sequences.add(new ArrayList<>(candidate));
            }
        }
        
        return sequences;
    }

    /**
     * Example: Stateful transformation
     * Transforms elements based on accumulated state
     */
    public static <T, R, S> List<R> transformWithState(List<T> items,
                                                        S initialState,
                                                        BiFunction<S, T, Pair<S, R>> transformer) {
        List<R> results = new ArrayList<>();
        S state = initialState;
        
        for (T item : items) {
            Pair<S, R> pair = transformer.apply(state, item);
            state = pair.first();
            results.add(pair.second());
        }
        
        return results;
    }

    public record Pair<A, B>(A first, B second) {}

    /**
     * Example: Intersperse
     * Inserts a separator between elements
     */
    public static <T> List<T> intersperse(List<T> items, T separator) {
        if (items.isEmpty()) {
            return List.of();
        }
        
        List<T> result = new ArrayList<>();
        result.add(items.get(0));
        
        for (int i = 1; i < items.size(); i++) {
            result.add(separator);
            result.add(items.get(i));
        }
        
        return result;
    }

    /**
     * Example: Take/Drop until predicate changes
     * Takes/drops elements until predicate evaluation changes
     */
    public static <T> List<T> takeUntilChange(List<T> items, 
                                               Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        boolean initialState = items.isEmpty() ? false : predicate.test(items.get(0));
        
        for (T item : items) {
            if (predicate.test(item) != initialState) {
                break;
            }
            result.add(item);
        }
        
        return result;
    }
}
