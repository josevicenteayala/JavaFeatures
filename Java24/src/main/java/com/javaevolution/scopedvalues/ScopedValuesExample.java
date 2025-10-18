package com.javaevolution.scopedvalues;

import java.util.concurrent.*;
import java.util.*;

/**
 * Demonstrates Scoped Values (JEP 487) introduced as a fourth preview in Java 24.
 * 
 * Scoped values provide a way to share immutable data within and across threads
 * more efficiently and safely than ThreadLocal variables. They're particularly
 * useful with virtual threads.
 * 
 * Note: Running on Java 17, so these are conceptual examples showing how
 * scoped values work using ThreadLocal as a simulation.
 */
public class ScopedValuesExample {

    /**
     * Simulated scoped value using ThreadLocal for demonstration
     * In Java 24+, would use: ScopedValue<String> USER_ID = ScopedValue.newInstance();
     */
    private static final ThreadLocal<String> USER_ID = new ThreadLocal<>();
    private static final ThreadLocal<String> REQUEST_ID = new ThreadLocal<>();
    private static final ThreadLocal<Map<String, Object>> CONTEXT = 
            ThreadLocal.withInitial(HashMap::new);

    /**
     * Example: Basic scoped value usage
     * Shows how to set and retrieve scoped values
     */
    public String processWithUserId(String userId, Callable<String> task) throws Exception {
        try {
            USER_ID.set(userId);
            return task.call();
        } finally {
            USER_ID.remove();
        }
    }

    /**
     * Example: Accessing scoped value
     */
    public String getCurrentUserId() {
        String userId = USER_ID.get();
        return userId != null ? userId : "anonymous";
    }

    /**
     * Example: Nested scoped values
     * Demonstrates how scoped values work in nested contexts
     */
    public String processWithContext(String userId, String requestId, 
                                     Callable<String> task) throws Exception {
        try {
            USER_ID.set(userId);
            REQUEST_ID.set(requestId);
            return task.call();
        } finally {
            REQUEST_ID.remove();
            USER_ID.remove();
        }
    }

    /**
     * Example: Scoped values across multiple method calls
     */
    public class ServiceLayer {
        public String processRequest() {
            String userId = getCurrentUserId();
            String requestId = getCurrentRequestId();
            return performOperation(userId, requestId);
        }

        private String performOperation(String userId, String requestId) {
            return logOperation(userId, requestId);
        }

        private String logOperation(String userId, String requestId) {
            return String.format("Operation by user %s, request %s", userId, requestId);
        }
    }

    private String getCurrentRequestId() {
        String requestId = REQUEST_ID.get();
        return requestId != null ? requestId : "no-request";
    }

    /**
     * Example: Scoped values with virtual threads
     * Shows how scoped values are inherited by child threads
     */
    public List<String> processWithVirtualThreads(String userId, 
                                                   List<Callable<String>> tasks) 
            throws InterruptedException, ExecutionException {
        
        USER_ID.set(userId);
        try {
            // Simulate virtual thread execution
            ExecutorService executor = Executors.newFixedThreadPool(4);
            try {
                List<Future<String>> futures = new ArrayList<>();
                
                for (Callable<String> task : tasks) {
                    // Wrap task to inherit scoped value
                    String capturedUserId = USER_ID.get();
                    futures.add(executor.submit(() -> {
                        USER_ID.set(capturedUserId);
                        try {
                            return task.call();
                        } finally {
                            USER_ID.remove();
                        }
                    }));
                }
                
                List<String> results = new ArrayList<>();
                for (Future<String> future : futures) {
                    results.add(future.get());
                }
                return results;
            } finally {
                executor.shutdown();
                executor.awaitTermination(10, TimeUnit.SECONDS);
            }
        } finally {
            USER_ID.remove();
        }
    }

    /**
     * Example: Immutability of scoped values
     * Scoped values are immutable - you can't modify them, only rebind
     */
    public record UserContext(String userId, String role, Set<String> permissions) {}

    private static final ThreadLocal<UserContext> USER_CONTEXT = new ThreadLocal<>();

    public String processWithUserContext(UserContext context, 
                                         Callable<String> task) throws Exception {
        try {
            USER_CONTEXT.set(context);
            return task.call();
        } finally {
            USER_CONTEXT.remove();
        }
    }

    public UserContext getCurrentUserContext() {
        return USER_CONTEXT.get();
    }

    /**
     * Example: Multiple scoped values
     */
    public static class RequestContext {
        private final String userId;
        private final String requestId;
        private final String sessionId;
        private final long startTime;

        public RequestContext(String userId, String requestId, String sessionId) {
            this.userId = userId;
            this.requestId = requestId;
            this.sessionId = sessionId;
            this.startTime = System.currentTimeMillis();
        }

        public String getUserId() { return userId; }
        public String getRequestId() { return requestId; }
        public String getSessionId() { return sessionId; }
        public long getStartTime() { return startTime; }
        public long getDuration() { return System.currentTimeMillis() - startTime; }
    }

    private static final ThreadLocal<RequestContext> REQUEST_CONTEXT = new ThreadLocal<>();

    public <T> T executeInRequestContext(RequestContext context, 
                                         Callable<T> task) throws Exception {
        try {
            REQUEST_CONTEXT.set(context);
            return task.call();
        } finally {
            REQUEST_CONTEXT.remove();
        }
    }

    public RequestContext getRequestContext() {
        return REQUEST_CONTEXT.get();
    }

    /**
     * Example: Conditional scoped values
     */
    public String processWithOptionalContext(String userId, boolean includeContext,
                                             Callable<String> task) throws Exception {
        if (includeContext) {
            return processWithUserId(userId, task);
        } else {
            return task.call();
        }
    }

    /**
     * Example: Scoped values for tracing
     */
    public static class TraceContext {
        private final String traceId;
        private final String spanId;
        private final String parentSpanId;

        public TraceContext(String traceId, String spanId, String parentSpanId) {
            this.traceId = traceId;
            this.spanId = spanId;
            this.parentSpanId = parentSpanId;
        }

        public String getTraceId() { return traceId; }
        public String getSpanId() { return spanId; }
        public String getParentSpanId() { return parentSpanId; }
    }

    private static final ThreadLocal<TraceContext> TRACE_CONTEXT = new ThreadLocal<>();

    public <T> T traceOperation(String operationName, Callable<T> operation) 
            throws Exception {
        TraceContext parent = TRACE_CONTEXT.get();
        String traceId = parent != null ? parent.getTraceId() : generateTraceId();
        String spanId = generateSpanId();
        String parentSpanId = parent != null ? parent.getSpanId() : null;

        TraceContext context = new TraceContext(traceId, spanId, parentSpanId);
        
        try {
            TRACE_CONTEXT.set(context);
            return operation.call();
        } finally {
            TRACE_CONTEXT.remove();
        }
    }

    private String generateTraceId() {
        return UUID.randomUUID().toString();
    }

    private String generateSpanId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public TraceContext getCurrentTrace() {
        return TRACE_CONTEXT.get();
    }

    /**
     * Advantages of Scoped Values over ThreadLocal:
     * 1. Immutable - can't be changed after binding
     * 2. Bounded lifetime - automatically cleaned up
     * 3. Better performance with virtual threads
     * 4. Explicit scope management
     * 5. Type-safe
     */
}
