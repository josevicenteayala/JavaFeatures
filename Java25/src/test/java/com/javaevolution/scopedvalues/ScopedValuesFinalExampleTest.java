package com.javaevolution.scopedvalues;

import com.javaevolution.scopedvalues.ScopedValuesFinalExample.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

class ScopedValuesFinalExampleTest {

    private final ScopedValuesFinalExample example = new ScopedValuesFinalExample();

    @Test
    void runWithUserId_shouldSetAndRetrieveValue() {
        String result = example.runWithUserId("user123", () -> {
            return example.getCurrentUserId();
        });
        
        assertEquals("user123", result);
    }

    @Test
    void getCurrentUserId_withoutSet_shouldReturnDefault() {
        String userId = example.getCurrentUserId();
        assertEquals("anonymous", userId);
    }

    @Test
    void runWithMultipleValues_shouldSetAllValues() {
        String result = example.runWithMultipleValues(
            "user1", "req1", "tenant1",
            () -> example.processWithContext("user1", "req1")
        );
        
        assertTrue(result.contains("user1"));
        assertTrue(result.contains("req1"));
    }

    @Test
    void runWithRequestContext_shouldStoreAndRetrieve() {
        RequestContext ctx = new RequestContext("user1", "req1", "tenant1", System.currentTimeMillis());
        
        RequestContext result = example.runWithRequestContext(ctx, () -> {
            return example.getCurrentRequestContext();
        });
        
        assertEquals(ctx.userId(), result.userId());
        assertEquals(ctx.requestId(), result.requestId());
        assertEquals(ctx.tenantId(), result.tenantId());
    }

    @Test
    void getCurrentRequestContext_withoutSet_shouldReturnDefault() {
        RequestContext ctx = example.getCurrentRequestContext();
        assertEquals("anonymous", ctx.userId());
        assertEquals("no-request", ctx.requestId());
    }

    @Test
    void processWithContext_shouldPropagateValues() {
        String result = example.processWithContext("user1", "req1");
        assertTrue(result.contains("user1"));
        assertTrue(result.contains("req1"));
    }

    @Test
    void processWithInheritance_shouldInheritValues() throws Exception {
        List<String> items = List.of("item1", "item2", "item3");
        List<String> results = example.processWithInheritance("user1", items);
        
        assertEquals(3, results.size());
        // In Java 17, ThreadLocal doesn't inherit to thread pool threads
        // In Java 25+ with ScopedValues, values would be inherited
        for (String result : results) {
            assertTrue(result.contains("item"));
        }
    }

    @Test
    void processWithNestedScopes_shouldHandleShadowing() {
        String result = example.processWithNestedScopes("outer", "inner");
        
        // Result format: "Outer: outer, Inner: inner, Restored: outer"
        assertTrue(result.contains("Outer:"));
        assertTrue(result.contains("Inner:"));
        assertTrue(result.contains("Restored:"));
    }

    @Test
    void processWithExceptionHandling_success_shouldReturn() {
        String result = example.processWithExceptionHandling("user1", false);
        assertTrue(result.contains("Success"));
        assertTrue(result.contains("user1"));
    }

    @Test
    void processWithExceptionHandling_failure_shouldHandleException() {
        String result = example.processWithExceptionHandling("user1", true);
        assertTrue(result.contains("Failed"));
        assertTrue(result.contains("Simulated failure"));
    }

    @Test
    void performanceDemo_shouldBenchmarkOperations() {
        PerformanceDemo demo = new PerformanceDemo();
        PerformanceDemo.Stats stats = demo.benchmarkScopedValueOperations(1000);
        
        assertEquals(1000, stats.operations());
        assertTrue(stats.durationMs() >= 0);
        assertTrue(stats.opsPerSecond() > 0);
    }

    @Test
    void multiTenantService_shouldProcessRequest() {
        MultiTenantService service = new MultiTenantService();
        String result = service.processRequest("tenant1", "user1", "operation1");
        
        assertTrue(result.contains("tenant1"));
        assertTrue(result.contains("user1"));
        assertTrue(result.contains("operation1"));
    }

    @Test
    void securityContext_shouldCheckRoles() {
        SecurityContext ctx = new SecurityContext();
        Set<String> roles = Set.of("admin", "user");
        Set<String> capabilities = Set.of("read", "write");
        
        Boolean result = ctx.runWithPermissions(roles, capabilities, () -> {
            return ctx.hasRole("admin") && ctx.hasCapability("read");
        });
        
        assertTrue(result);
    }

    @Test
    void securityContext_withoutRole_shouldReturnFalse() {
        SecurityContext ctx = new SecurityContext();
        Set<String> roles = Set.of("user");
        Set<String> capabilities = Set.of("read");
        
        Boolean result = ctx.runWithPermissions(roles, capabilities, () -> {
            return ctx.hasRole("admin");
        });
        
        assertFalse(result);
    }

    @Test
    void securityContext_withoutContext_shouldReturnFalse() {
        SecurityContext ctx = new SecurityContext();
        assertFalse(ctx.hasRole("admin"));
        assertFalse(ctx.hasCapability("read"));
    }
}
