# Java 24 Features Overview

Java 24, released in March 2025, continues refining preview features and introduces performance improvements.

## Key Features

### 1. Scoped Values (JEP 487) ✅ IMPLEMENTED

**Status:** Fourth Preview

Scoped values provide a way to share immutable data within and across threads more efficiently and safely than ThreadLocal variables. They're particularly beneficial for virtual threads.

**See implementation:** `src/main/java/com/javaevolution/scopedvalues/`

**Key Benefits:**
- Immutable by default - cannot be modified after binding
- Better performance than ThreadLocal
- Automatic cleanup with bounded lifetime
- Ideal for virtual threads
- Type-safe and explicit scope management

**Examples:**

```java
// Define scoped value
private static final ScopedValue<String> USER_ID = ScopedValue.newInstance();

// Bind and use scoped value
ScopedValue.where(USER_ID, "user123")
    .run(() -> {
        String userId = USER_ID.get();  // Returns "user123"
        performOperation(userId);
    });

// Nested scoped values
ScopedValue.where(USER_ID, "user123")
    .where(REQUEST_ID, "req456")
    .run(() -> {
        // Both values available here
        String userId = USER_ID.get();
        String requestId = REQUEST_ID.get();
    });

// With virtual threads
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    ScopedValue.where(USER_ID, "user123")
        .run(() -> {
            executor.submit(() -> {
                // USER_ID inherited by virtual thread
                String userId = USER_ID.get();
            });
        });
}
```

**Status:** Fully implemented with comprehensive tests

### 2. Stream Gatherers (JEP 485)

**Status:** Third Preview

Continues evolution of stream gatherers, providing custom intermediate operations for streams.

**Key Updates:**
- API refinements from previous previews
- Performance improvements
- Enhanced composability

### 3. Flexible Constructor Bodies (JEP 483)

**Status:** Third Preview

Third preview of allowing statements before `super()` or `this()` calls in constructors.

### 4. Module Import Declarations (JEP 488)

**Status:** Second Preview

Second preview of simplified module imports.

**Example:**
```java
import module java.base;
```

### 5. Primitive Types in Patterns (JEP 455)

**Status:** Second Preview

Second preview of primitive type pattern matching.

### 6. Vector API (JEP 489)

**Status:** Ninth Incubator

Express vector computations that compile to optimal vector hardware instructions.

### 7. Structured Concurrency (JEP 484)

**Status:** Fourth Preview

Simplifies concurrent programming by treating multiple tasks as a single unit.

**Example Concept:**
```java
try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
    Future<String> user = scope.fork(() -> findUser());
    Future<Integer> order = scope.fork(() -> fetchOrder());
    
    scope.join();
    scope.throwIfFailed();
    
    return new Response(user.resultNow(), order.resultNow());
}
```

### 8. Class-File API (JEP 486)

**Status:** Third Preview

Standard API for parsing, generating, and transforming Java class files.

**Benefits:**
- Replace ASM and other third-party libraries
- Type-safe API
- Better integration with JDK
- Support for new class file features

### 9. Late Barrier Expansion for G1 (JEP 475)

**Status:** Standard

Improves G1 garbage collector performance by deferring barrier expansion to a later compilation phase.

**Benefits:**
- Better compiler optimizations
- Reduced code size
- Improved overall performance

## Performance Improvements

**G1 GC Enhancements:**
- Late barrier expansion for better optimization
- Reduced overhead
- Improved throughput

**Virtual Thread Support:**
- Better scoped values integration
- Improved structured concurrency
- Enhanced performance characteristics

## Migration from Java 23

**Key Improvements:**
- Adopt scoped values for thread-safe data sharing
- Evaluate stream gatherers for complex operations
- Consider flexible constructors for validation
- Update to latest preview feature APIs

**Breaking Changes:**
- Preview feature APIs may have evolved
- Some incubator features updated

## Best Practices

**Scoped Values:**
- Prefer over ThreadLocal for new code
- Use with virtual threads for best performance
- Keep values immutable
- Use clear, descriptive names

**Example Pattern:**
```java
// Define scoped values as static final
private static final ScopedValue<UserContext> USER_CONTEXT = 
    ScopedValue.newInstance();

// Bind in request handlers
ScopedValue.where(USER_CONTEXT, context)
    .run(() -> handleRequest());

// Access in service layers
UserContext context = USER_CONTEXT.get();
```

**Stream Gatherers:**
- Use for custom intermediate operations
- Consider performance implications
- Test thoroughly with large datasets

**Virtual Threads:**
- Use scoped values instead of ThreadLocal
- Avoid pinning with synchronized blocks
- Use structured concurrency for task management

## Implementation Status

✅ **Implemented:**
- Scoped Values (with comprehensive examples and tests)

📝 **Documented:**
- Stream Gatherers (Third Preview)
- Flexible Constructor Bodies (Third Preview)
- Module Import Declarations (Second Preview)
- Primitive Types in Patterns (Second Preview)
- Vector API (Ninth Incubator)
- Structured Concurrency (Fourth Preview)
- Class-File API (Third Preview)
- Late Barrier Expansion for G1

## Building and Testing

```bash
# Build Java 24 module
./gradlew :Java24:build

# Run tests
./gradlew :Java24:test

# Run specific test
./gradlew :Java24:test --tests ScopedValuesExampleTest
```

## Requirements

- JDK 24 or later for full feature support
- Preview features require `--enable-preview` flag
- Examples are designed to compile on Java 17+ where possible

## Comparison: Scoped Values vs ThreadLocal

| Feature | ScopedValue | ThreadLocal |
|---------|-------------|-------------|
| Mutability | Immutable | Mutable |
| Performance | Better | Good |
| Virtual Threads | Optimized | Works but overhead |
| Lifetime | Bounded | Manual cleanup |
| Type Safety | Strong | Strong |
| Inheritance | Explicit | Automatic (InheritableThreadLocal) |

## References

- [JEP 487: Scoped Values (Fourth Preview)](https://openjdk.org/jeps/487)
- [JEP 485: Stream Gatherers (Third Preview)](https://openjdk.org/jeps/485)
- [JEP 483: Flexible Constructor Bodies (Third Preview)](https://openjdk.org/jeps/483)
- [JEP 488: Module Import Declarations (Second Preview)](https://openjdk.org/jeps/488)
- [JEP 475: Late Barrier Expansion for G1](https://openjdk.org/jeps/475)
