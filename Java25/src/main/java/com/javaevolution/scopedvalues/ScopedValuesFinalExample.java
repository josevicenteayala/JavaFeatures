package com.javaevolution.scopedvalues;

import java.util.concurrent.*;
import java.util.*;
import java.util.function.Supplier;

/**
 * Demonstrates Scoped Values (Expected Final in Java 25).
 * 
 * Scoped values provide immutable, inheritable data sharing across thread boundaries,
 * particularly beneficial for virtual threads. After multiple previews in Java 21-24,
 * this feature is expected to be finalized in Java 25.
 * 
 * Benefits over ThreadLocal:
 * - Immutable: Cannot be changed once set in a scope
 * - Inheritance: Automatically available to child threads
 * - Performance: More efficient with virtual threads
 * - Safety: Prevents accidental modification
 * 
 * Note: Running on Java 17, so these are conceptual examples using ThreadLocal
 * to demonstrate how scoped values work in Java 25+.
 */
public class ScopedValuesFinalExample {

    /**
     * Simulated scoped values using ThreadLocal for demonstration.
     * In Java 25, would use: ScopedValue<T> VALUE = ScopedValue.newInstance();
     */
    private static final ThreadLocal<String> USER_ID = new ThreadLocal<>();
    private static final ThreadLocal<String> REQUEST_ID = new ThreadLocal<>();
    private static final ThreadLocal<String> TENANT_ID = new ThreadLocal<>();
    private static final ThreadLocal<RequestContext> REQUEST_CONTEXT = new ThreadLocal<>();

    /**
     * Request context record for multi-value scoping
     */
    public record RequestContext(
        String userId,
        String requestId,
        String tenantId,
        long timestamp
    ) {}

    /**
     * Example 1: Basic scoped value usage
     * Sets a value for a specific scope and executes a task
     */
    public <T> T runWithUserId(String userId, Supplier<T> task) {
        try {
            USER_ID.set(userId);
            return task.get();
        } finally {
            USER_ID.remove();
        }
    }

    /**
     * Example 2: Accessing current scoped value
     * Retrieves the current value or returns a default
     */
    public String getCurrentUserId() {
        String userId = USER_ID.get();
        return userId != null ? userId : "anonymous";
    }

    /**
     * Example 3: Multiple scoped values
     * Demonstrates setting multiple values in nested scopes
     */
    public <T> T runWithMultipleValues(String userId, String requestId, 
                                       String tenantId, Supplier<T> task) {
        try {
            USER_ID.set(userId);
            REQUEST_ID.set(requestId);
            TENANT_ID.set(tenantId);
            return task.get();
        } finally {
            TENANT_ID.remove();
            REQUEST_ID.remove();
            USER_ID.remove();
        }
    }

    /**
     * Example 4: Scoped values with complex context
     * Shows using a context object for multiple related values
     */
    public <T> T runWithRequestContext(RequestContext context, Supplier<T> task) {
        try {
            REQUEST_CONTEXT.set(context);
            return task.get();
        } finally {
            REQUEST_CONTEXT.remove();
        }
    }

    /**
     * Example 5: Accessing complex context
     */
    public RequestContext getCurrentRequestContext() {
        RequestContext context = REQUEST_CONTEXT.get();
        return context != null ? context : 
            new RequestContext("anonymous", "no-request", "default", System.currentTimeMillis());
    }

    /**
     * Example 6: Scoped values across method call chain
     * Shows how scoped values are accessible throughout the call stack
     */
    public String processWithContext(String userId, String requestId) {
        return runWithMultipleValues(userId, requestId, "tenant-1", () -> {
            return performBusinessLogic();
        });
    }

    private String performBusinessLogic() {
        String userId = getCurrentUserId();
        String requestId = getCurrentRequestId();
        return validateAndProcess(userId, requestId);
    }

    private String validateAndProcess(String userId, String requestId) {
        return logAndComplete(userId, requestId);
    }

    private String logAndComplete(String userId, String requestId) {
        return String.format("Processed request %s for user %s", requestId, userId);
    }

    private String getCurrentRequestId() {
        String requestId = REQUEST_ID.get();
        return requestId != null ? requestId : "no-request";
    }

    private String getCurrentTenantId() {
        String tenantId = TENANT_ID.get();
        return tenantId != null ? tenantId : "default";
    }

    /**
     * Example 7: Inheritance in virtual threads
     * Demonstrates how scoped values are inherited by child threads
     */
    public List<String> processWithInheritance(String userId, List<String> items) 
            throws InterruptedException, ExecutionException {
        
        return runWithUserId(userId, () -> {
            try {
                // Java 25+ would use: Executors.newVirtualThreadPerTaskExecutor()
                // Java 17 uses fixed thread pool
                ExecutorService executor = Executors.newFixedThreadPool(4);
                try {
                    List<Future<String>> futures = new ArrayList<>();
                    
                    for (String item : items) {
                        // Each virtual thread inherits the scoped value
                        futures.add(executor.submit(() -> 
                            processItem(item, getCurrentUserId())
                        ));
                    }
                    
                    List<String> results = new ArrayList<>();
                    for (Future<String> future : futures) {
                        results.add(future.get());
                    }
                    return results;
                } finally {
                    executor.shutdown();
                    executor.awaitTermination(5, TimeUnit.SECONDS);
                }
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private String processItem(String item, String userId) {
        return String.format("%s processed by %s", item, userId);
    }

    /**
     * Example 8: Nested scopes with shadowing
     * Shows how inner scopes can temporarily override outer scope values
     */
    public String processWithNestedScopes(String outerUserId, String innerUserId) {
        return runWithUserId(outerUserId, () -> {
            String result1 = getCurrentUserId(); // Returns outerUserId
            
            String result2 = runWithUserId(innerUserId, () -> {
                return getCurrentUserId(); // Returns innerUserId
            });
            
            String result3 = getCurrentUserId(); // Returns outerUserId again
            
            return String.format("Outer: %s, Inner: %s, Restored: %s", 
                result1, result2, result3);
        });
    }

    /**
     * Example 9: Exception handling with scoped values
     * Demonstrates proper cleanup even when exceptions occur
     */
    public String processWithExceptionHandling(String userId, boolean shouldFail) {
        try {
            return runWithUserId(userId, () -> {
                if (shouldFail) {
                    throw new RuntimeException("Simulated failure");
                }
                return "Success for user: " + getCurrentUserId();
            });
        } catch (RuntimeException e) {
            return "Failed for user: " + getCurrentUserId() + " - " + e.getMessage();
        }
    }

    /**
     * Example 10: Performance comparison simulation
     * Demonstrates why scoped values are more efficient than ThreadLocal
     */
    public static class PerformanceDemo {
        
        public record Stats(long operations, long durationMs, double opsPerSecond) {}
        
        public Stats benchmarkScopedValueOperations(int iterations) {
            long start = System.currentTimeMillis();
            
            for (int i = 0; i < iterations; i++) {
                USER_ID.set("user-" + i);
                String value = USER_ID.get();
                USER_ID.remove();
            }
            
            long duration = System.currentTimeMillis() - start;
            double opsPerSecond = (iterations * 1000.0) / duration;
            
            return new Stats(iterations, duration, opsPerSecond);
        }
    }

    /**
     * Example 11: Multi-tenant application pattern
     * Shows a common use case for scoped values in enterprise applications
     */
    public static class MultiTenantService {
        private final ScopedValuesFinalExample scopedValues;
        
        public MultiTenantService() {
            this.scopedValues = new ScopedValuesFinalExample();
        }
        
        public String processRequest(String tenantId, String userId, String operation) {
            RequestContext context = new RequestContext(
                userId,
                UUID.randomUUID().toString(),
                tenantId,
                System.currentTimeMillis()
            );
            
            return scopedValues.runWithRequestContext(context, () -> {
                return executeOperation(operation);
            });
        }
        
        private String executeOperation(String operation) {
            RequestContext ctx = scopedValues.getCurrentRequestContext();
            return String.format(
                "Tenant %s, User %s executed %s at %d",
                ctx.tenantId(), ctx.userId(), operation, ctx.timestamp()
            );
        }
    }

    /**
     * Example 12: Logging integration pattern
     * Shows how scoped values simplify contextual logging
     */
    public static class ContextualLogger {
        private final ScopedValuesFinalExample scopedValues;
        
        public ContextualLogger() {
            this.scopedValues = new ScopedValuesFinalExample();
        }
        
        public void logWithContext(String message, String level) {
            String userId = scopedValues.getCurrentUserId();
            String requestId = scopedValues.getCurrentRequestId();
            String tenantId = scopedValues.getCurrentTenantId();
            
            String contextualLog = String.format(
                "[%s] [tenant=%s] [user=%s] [request=%s] %s",
                level, tenantId, userId, requestId, message
            );
            
            // In real implementation, would log to actual logger
            System.out.println(contextualLog);
        }
    }

    /**
     * Example 13: Security context pattern
     * Demonstrates using scoped values for security permissions
     */
    public static class SecurityContext {
        
        public record Permissions(Set<String> roles, Set<String> capabilities) {}
        
        private static final ThreadLocal<Permissions> PERMISSIONS = new ThreadLocal<>();
        
        public <T> T runWithPermissions(Set<String> roles, Set<String> capabilities, 
                                       Supplier<T> task) {
            try {
                PERMISSIONS.set(new Permissions(roles, capabilities));
                return task.get();
            } finally {
                PERMISSIONS.remove();
            }
        }
        
        public boolean hasRole(String role) {
            Permissions perms = PERMISSIONS.get();
            return perms != null && perms.roles().contains(role);
        }
        
        public boolean hasCapability(String capability) {
            Permissions perms = PERMISSIONS.get();
            return perms != null && perms.capabilities().contains(capability);
        }
    }
}
