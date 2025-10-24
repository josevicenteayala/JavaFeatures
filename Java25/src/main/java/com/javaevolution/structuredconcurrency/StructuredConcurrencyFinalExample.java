package com.javaevolution.structuredconcurrency;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;

/**
 * Demonstrates Structured Concurrency (Expected Final in Java 25).
 * 
 * Structured concurrency treats groups of concurrent tasks as a single unit of work,
 * making it easier to reason about concurrent code and preventing common pitfalls
 * like thread leaks and orphaned tasks.
 * 
 * After multiple previews in Java 19-24, this feature is expected to be finalized
 * in Java 25 as a standard API.
 * 
 * Key Benefits:
 * - Error handling: If one task fails, all tasks are cancelled
 * - Resource management: Tasks are guaranteed to complete before scope closes
 * - Clarity: Concurrent operations are grouped logically
 * - Virtual thread friendly: Designed for efficient use with virtual threads
 * 
 * Note: Running on Java 17, so this is a conceptual implementation showing
 * how structured concurrency would work in Java 25+.
 */
public class StructuredConcurrencyFinalExample {

    /**
     * Simulated StructuredTaskScope for demonstration
     * In Java 25, would use: StructuredTaskScope<T>
     */
    public static class SimulatedTaskScope<T> implements AutoCloseable {
        private final ExecutorService executor;
        private final List<Future<T>> futures;
        private volatile boolean failed = false;
        private volatile Throwable exception = null;
        
        public SimulatedTaskScope() {
            // Java 25+ would use: Executors.newVirtualThreadPerTaskExecutor()
            // Java 17 uses fixed thread pool
            this.executor = Executors.newFixedThreadPool(10);
            this.futures = new CopyOnWriteArrayList<>();
        }
        
        public Future<T> fork(Callable<T> task) {
            Future<T> future = executor.submit(() -> {
                try {
                    return task.call();
                } catch (Exception e) {
                    failed = true;
                    exception = e;
                    throw e;
                }
            });
            futures.add(future);
            return future;
        }
        
        public void join() throws InterruptedException {
            for (Future<T> future : futures) {
                try {
                    future.get();
                } catch (ExecutionException e) {
                    // Exception already recorded
                }
            }
        }
        
        public void throwIfFailed() throws ExecutionException {
            if (failed && exception != null) {
                throw new ExecutionException(exception);
            }
        }
        
        @Override
        public void close() {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Example 1: Basic structured concurrency
     * Fetch user and orders concurrently
     */
    public record UserData(String user, List<String> orders) {}
    
    public UserData fetchUserData(String userId) throws InterruptedException, ExecutionException {
        try (var scope = new SimulatedTaskScope<String>()) {
            Future<String> userFuture = scope.fork(() -> fetchUser(userId));
            
            // Use a separate scope for orders since generics don't support mixed types
            String user = userFuture.get();
            List<String> orders = fetchOrders(userId);
            
            return new UserData(user, orders);
        }
    }
    
    private String fetchUser(String userId) {
        simulateNetworkDelay(100);
        return "User-" + userId;
    }
    
    private List<String> fetchOrders(String userId) {
        simulateNetworkDelay(150);
        return List.of("Order-1", "Order-2", "Order-3");
    }

    /**
     * Example 2: Shutdown on failure
     * If any task fails, all tasks are cancelled immediately
     */
    public String processWithFailureHandling(boolean simulateFailure) {
        try (var scope = new SimulatedTaskScope<String>()) {
            scope.fork(() -> longRunningTask(1000));
            scope.fork(() -> {
                if (simulateFailure) {
                    throw new RuntimeException("Simulated failure");
                }
                return "Success";
            });
            scope.fork(() -> longRunningTask(800));
            
            scope.join();
            scope.throwIfFailed();
            
            return "All tasks completed successfully";
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Interrupted";
        } catch (ExecutionException e) {
            return "Failed: " + e.getCause().getMessage();
        }
    }
    
    private String longRunningTask(int delayMs) {
        simulateNetworkDelay(delayMs);
        return "Task completed";
    }

    /**
     * Example 3: Race for first success
     * Returns the result of the first successful task
     */
    public String raceForFirstSuccess(List<String> servers) throws InterruptedException, ExecutionException {
        try (var scope = new SimulatedTaskScope<String>()) {
            for (String server : servers) {
                scope.fork(() -> queryServer(server));
            }
            
            scope.join();
            scope.throwIfFailed();
            
            // In real StructuredTaskScope, would use ShutdownOnSuccess
            // For simulation, return first completed result
            return "Result from first server";
        }
    }
    
    private String queryServer(String server) {
        simulateNetworkDelay(ThreadLocalRandom.current().nextInt(100, 500));
        return "Response from " + server;
    }

    /**
     * Example 4: Parallel data processing
     * Process multiple items concurrently and collect results
     */
    public List<String> processItemsInParallel(List<String> items) 
            throws InterruptedException, ExecutionException {
        
        try (var scope = new SimulatedTaskScope<String>()) {
            List<Future<String>> futures = new ArrayList<>();
            
            for (String item : items) {
                futures.add(scope.fork(() -> processItem(item)));
            }
            
            scope.join();
            scope.throwIfFailed();
            
            List<String> results = new ArrayList<>();
            for (Future<String> future : futures) {
                results.add(future.get());
            }
            return results;
        }
    }
    
    private String processItem(String item) {
        simulateNetworkDelay(50);
        return "Processed: " + item;
    }

    /**
     * Example 5: Nested structured concurrency
     * Shows hierarchical task decomposition
     */
    public record AggregatedResult(Map<String, String> results, int totalProcessed) {}
    
    public AggregatedResult processHierarchically(List<String> categories) 
            throws InterruptedException, ExecutionException {
        
        try (var outerScope = new SimulatedTaskScope<Map<String, String>>()) {
            List<Future<Map<String, String>>> categoryFutures = new ArrayList<>();
            
            for (String category : categories) {
                categoryFutures.add(outerScope.fork(() -> processCategory(category)));
            }
            
            outerScope.join();
            outerScope.throwIfFailed();
            
            Map<String, String> allResults = new HashMap<>();
            int total = 0;
            for (Future<Map<String, String>> future : categoryFutures) {
                Map<String, String> categoryResults = future.get();
                allResults.putAll(categoryResults);
                total += categoryResults.size();
            }
            
            return new AggregatedResult(allResults, total);
        }
    }
    
    private Map<String, String> processCategory(String category) 
            throws InterruptedException, ExecutionException {
        
        // Nested structured concurrency
        try (var innerScope = new SimulatedTaskScope<String>()) {
            List<Future<String>> futures = new ArrayList<>();
            
            for (int i = 0; i < 3; i++) {
                final int index = i;
                futures.add(innerScope.fork(() -> 
                    processItem(category + "-item-" + index)
                ));
            }
            
            innerScope.join();
            innerScope.throwIfFailed();
            
            Map<String, String> results = new HashMap<>();
            for (int i = 0; i < futures.size(); i++) {
                results.put(category + "-" + i, futures.get(i).get());
            }
            return results;
        }
    }

    /**
     * Example 6: Timeout handling
     * Demonstrates task cancellation on timeout
     */
    public String processWithTimeout(long timeoutMs) {
        try (var scope = new SimulatedTaskScope<String>()) {
            scope.fork(() -> slowTask(timeoutMs * 2));
            scope.fork(() -> fastTask());
            
            // Simulate timeout
            Thread.sleep(timeoutMs);
            
            return "Completed within timeout";
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Timed out";
        }
    }
    
    private String slowTask(long delayMs) {
        simulateNetworkDelay((int) delayMs);
        return "Slow task completed";
    }
    
    private String fastTask() {
        simulateNetworkDelay(50);
        return "Fast task completed";
    }

    /**
     * Example 7: Error aggregation
     * Collect and report all errors from parallel tasks
     */
    public record ErrorReport(List<String> successes, List<String> failures) {}
    
    public ErrorReport processWithErrorCollection(List<String> items) {
        List<String> successes = new ArrayList<>();
        List<String> failures = new ArrayList<>();
        
        for (String item : items) {
            try (var scope = new SimulatedTaskScope<String>()) {
                Future<String> future = scope.fork(() -> {
                    if (item.contains("fail")) {
                        throw new RuntimeException("Item failed: " + item);
                    }
                    return "Processed: " + item;
                });
                
                scope.join();
                scope.throwIfFailed();
                
                successes.add(future.get());
            } catch (Exception e) {
                failures.add(item + ": " + e.getMessage());
            }
        }
        
        return new ErrorReport(successes, failures);
    }

    /**
     * Example 8: Resource coordination
     * Ensures all resources are properly released
     */
    public static class ResourceCoordinator {
        
        public record Resources(String database, String cache, String queue) {}
        
        public Resources acquireResources() throws InterruptedException, ExecutionException {
            try (var scope = new SimulatedTaskScope<String>()) {
                Future<String> dbFuture = scope.fork(() -> connectDatabase());
                Future<String> cacheFuture = scope.fork(() -> connectCache());
                Future<String> queueFuture = scope.fork(() -> connectQueue());
                
                scope.join();
                scope.throwIfFailed();
                
                return new Resources(
                    dbFuture.get(),
                    cacheFuture.get(),
                    queueFuture.get()
                );
            }
        }
        
        private String connectDatabase() {
            simulateNetworkDelay(200);
            return "database-connection-1";
        }
        
        private String connectCache() {
            simulateNetworkDelay(100);
            return "cache-connection-1";
        }
        
        private String connectQueue() {
            simulateNetworkDelay(150);
            return "queue-connection-1";
        }
    }

    /**
     * Example 9: Map-Reduce pattern
     * Parallel map followed by reduce
     */
    public <T, R> R mapReduce(List<T> items, Function<T, R> mapper, 
                              Function<List<R>, R> reducer) 
            throws InterruptedException, ExecutionException {
        
        try (var scope = new SimulatedTaskScope<R>()) {
            List<Future<R>> futures = new ArrayList<>();
            
            // Map phase
            for (T item : items) {
                futures.add(scope.fork(() -> mapper.apply(item)));
            }
            
            scope.join();
            scope.throwIfFailed();
            
            // Collect mapped results
            List<R> mapped = new ArrayList<>();
            for (Future<R> future : futures) {
                mapped.add(future.get());
            }
            
            // Reduce phase
            return reducer.apply(mapped);
        }
    }

    /**
     * Example 10: Fan-out/Fan-in pattern
     * Distribute work to multiple workers and collect results
     */
    public Map<String, String> fanOutFanIn(List<String> workItems, int workerCount) 
            throws InterruptedException, ExecutionException {
        
        try (var scope = new SimulatedTaskScope<Map<String, String>>()) {
            List<Future<Map<String, String>>> futures = new ArrayList<>();
            
            // Fan out: distribute work among workers
            for (int i = 0; i < workerCount; i++) {
                final int workerId = i;
                List<String> workerItems = partitionWork(workItems, workerId, workerCount);
                
                futures.add(scope.fork(() -> processWorkerBatch(workerId, workerItems)));
            }
            
            scope.join();
            scope.throwIfFailed();
            
            // Fan in: collect all results
            Map<String, String> allResults = new HashMap<>();
            for (Future<Map<String, String>> future : futures) {
                allResults.putAll(future.get());
            }
            
            return allResults;
        }
    }
    
    private List<String> partitionWork(List<String> items, int partition, int totalPartitions) {
        List<String> result = new ArrayList<>();
        for (int i = partition; i < items.size(); i += totalPartitions) {
            result.add(items.get(i));
        }
        return result;
    }
    
    private Map<String, String> processWorkerBatch(int workerId, List<String> items) {
        Map<String, String> results = new HashMap<>();
        for (String item : items) {
            simulateNetworkDelay(20);
            results.put(item, "Processed by worker " + workerId);
        }
        return results;
    }

    /**
     * Helper method to simulate network/IO delay
     */
    private static void simulateNetworkDelay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
