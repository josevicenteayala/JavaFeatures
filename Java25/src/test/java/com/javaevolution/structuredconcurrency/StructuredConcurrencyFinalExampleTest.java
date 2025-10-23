package com.javaevolution.structuredconcurrency;

import com.javaevolution.structuredconcurrency.StructuredConcurrencyFinalExample.*;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StructuredConcurrencyFinalExampleTest {

    private final StructuredConcurrencyFinalExample example = new StructuredConcurrencyFinalExample();

    @Test
    void fetchUserData_shouldReturnCombinedData() throws Exception {
        UserData data = example.fetchUserData("user123");
        
        assertNotNull(data);
        assertTrue(data.user().contains("user123"));
        assertEquals(3, data.orders().size());
    }

    @Test
    void processWithFailureHandling_success_shouldComplete() {
        String result = example.processWithFailureHandling(false);
        assertEquals("All tasks completed successfully", result);
    }

    @Test
    void processWithFailureHandling_failure_shouldReportError() {
        String result = example.processWithFailureHandling(true);
        assertTrue(result.contains("Failed"));
        assertTrue(result.contains("Simulated failure"));
    }

    @Test
    void raceForFirstSuccess_shouldReturnResult() throws Exception {
        List<String> servers = List.of("server1", "server2", "server3");
        String result = example.raceForFirstSuccess(servers);
        
        assertNotNull(result);
        assertTrue(result.contains("server"));
    }

    @Test
    void processItemsInParallel_shouldProcessAll() throws Exception {
        List<String> items = List.of("item1", "item2", "item3");
        List<String> results = example.processItemsInParallel(items);
        
        assertEquals(3, results.size());
        for (String result : results) {
            assertTrue(result.contains("Processed"));
        }
    }

    @Test
    void processHierarchically_shouldAggregateResults() throws Exception {
        List<String> categories = List.of("cat1", "cat2");
        AggregatedResult result = example.processHierarchically(categories);
        
        assertNotNull(result.results());
        assertEquals(6, result.totalProcessed());
    }

    @Test
    void processWithTimeout_shouldComplete() {
        String result = example.processWithTimeout(100);
        assertTrue(result.contains("timeout") || result.contains("Completed"));
    }

    @Test
    void processWithErrorCollection_shouldSeparateSuccessAndFailures() {
        List<String> items = List.of("item1", "fail1", "item2", "fail2");
        ErrorReport report = example.processWithErrorCollection(items);
        
        assertEquals(2, report.successes().size());
        assertEquals(2, report.failures().size());
    }

    @Test
    void resourceCoordinator_shouldAcquireAll() throws Exception {
        ResourceCoordinator coordinator = new ResourceCoordinator();
        ResourceCoordinator.Resources resources = coordinator.acquireResources();
        
        assertNotNull(resources.database());
        assertNotNull(resources.cache());
        assertNotNull(resources.queue());
    }

    @Test
    void mapReduce_shouldProcessAndReduce() throws Exception {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Integer result = example.mapReduce(
            numbers,
            n -> n * 2,
            list -> list.stream().reduce(0, Integer::sum)
        );
        
        assertEquals(30, result);
    }

    @Test
    void fanOutFanIn_shouldDistributeAndCollect() throws Exception {
        List<String> workItems = List.of("w1", "w2", "w3", "w4", "w5");
        Map<String, String> results = example.fanOutFanIn(workItems, 3);
        
        assertEquals(5, results.size());
        for (String key : workItems) {
            assertTrue(results.containsKey(key));
        }
    }
}
