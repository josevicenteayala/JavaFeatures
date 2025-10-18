# Java 25 Features Overview

Java 25, released in September 2025, represents the continued evolution of Java with finalized features from previous previews and potential new innovations.

**Note:** As this is a recent release (September 2025), some features may still be in preview or incubator stages. This documentation covers expected features based on the evolution from Java 22-24.

## Key Expected Features

### 1. Stream Gatherers (Expected Final) ✅ IMPLEMENTED

**Status:** Expected Standard (after multiple previews)

Stream gatherers provide custom intermediate operations for streams, offering powerful alternatives to traditional map/filter/reduce patterns.

**See implementation:** `src/main/java/com/javaevolution/streamgatherers/`

**Key Capabilities:**
- Stateful stream processing
- Complex windowing operations
- Custom aggregation patterns
- Indexed transformations
- Sequence detection and pattern matching

**Advanced Examples:**

```java
// Rolling aggregation over windows
RollingAggregator<Integer, Double> aggregator = 
    new RollingAggregator<>(3, list -> 
        list.stream().mapToInt(Integer::intValue).average().orElse(0.0)
    );

// Group by boundary conditions
List<List<Integer>> groups = groupByBoundary(
    numbers, 
    n -> n == 0  // Boundary predicate
);

// Chunk while condition holds
List<List<Integer>> chunks = chunkWhile(
    numbers,
    (a, b) -> Math.abs(b - a) <= 5
);

// Transform with accumulated state
List<Integer> cumulative = transformWithState(
    numbers,
    0,
    (state, item) -> new Pair<>(state + item, state + item)
);

// Distinct by key with conflict resolution
List<Person> distinct = distinctByKey(
    people,
    Person::name,
    (p1, p2) -> p1.age() > p2.age() ? p1 : p2
);
```

**Status:** Fully implemented with comprehensive tests

### 2. Scoped Values (Expected Final)

**Status:** Expected Standard (after four previews)

Scoped values provide immutable, inheritable data sharing across thread boundaries, particularly beneficial for virtual threads.

**Key Benefits:**
- Final API after previews
- Production-ready
- Optimized for virtual threads
- Memory efficient

### 3. Structured Concurrency (Expected Final)

**Status:** Expected Standard (after multiple previews)

Simplifies concurrent programming by treating groups of concurrent tasks as a single unit of work.

**Expected Final Features:**
```java
try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
    Future<User> userFuture = scope.fork(() -> fetchUser());
    Future<Order> orderFuture = scope.fork(() -> fetchOrder());
    
    scope.join();
    scope.throwIfFailed();
    
    return process(userFuture.resultNow(), orderFuture.resultNow());
}
```

### 4. Flexible Constructor Bodies (Expected Final)

**Status:** Expected Standard (after three previews)

Allows statements before explicit constructor invocations.

### 5. Primitive Types in Patterns (Expected Final)

**Status:** Expected Standard (after two previews)

Pattern matching with primitive types in instanceof and switch.

### 6. Module Import Declarations

**Status:** Likely Preview/Standard

Simplified module imports.

### 7. Class-File API

**Status:** Likely Standard (after three previews)

Standard API for class file manipulation.

### 8. Vector API

**Status:** Likely Still Incubating

SIMD vector operations continue evolution.

### 9. Performance Enhancements

**Expected Improvements:**
- G1 GC optimizations
- JIT compiler improvements
- Startup time reductions
- Memory footprint optimizations
- Virtual thread performance improvements

## Potential New Features

### Value Types (Project Valhalla)

**Status:** Possibly Preview

Value types and primitive classes may debut in preview.

**Expected Benefits:**
- Better memory layout
- Improved performance
- Reduced object overhead
- Array of values

### Universal Generics

**Status:** Possibly Preview

Generics that work with primitive types.

**Example Concept:**
```java
ArrayList<int> numbers = new ArrayList<>();  // No boxing
```

## Migration from Java 24

**Key Improvements:**
- Adopt finalized stream gatherers for production use
- Use finalized scoped values API
- Implement structured concurrency for complex workflows
- Update to final preview feature APIs

**Breaking Changes:**
- Preview feature APIs finalized - check for signature changes
- Deprecated features may be removed
- Performance characteristics may change

## Best Practices

**Stream Gatherers:**
```java
// Use for complex stream operations
var result = items.stream()
    .gather(windowGatherer(5))
    .gather(distinctByKeyGatherer(Item::id))
    .toList();
```

**Scoped Values:**
```java
// Production-ready context management
private static final ScopedValue<RequestContext> REQUEST = 
    ScopedValue.newInstance();

ScopedValue.where(REQUEST, context)
    .run(() -> handleRequest());
```

**Structured Concurrency:**
```java
// Reliable concurrent task management
try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
    // Fork multiple tasks
    var tasks = operations.stream()
        .map(op -> scope.fork(() -> execute(op)))
        .toList();
    
    scope.join();
    scope.throwIfFailed();
    
    return tasks.stream()
        .map(Future::resultNow)
        .toList();
}
```

## Performance Characteristics

**Virtual Threads:**
- Fully optimized
- Minimal overhead
- Excellent scalability

**Garbage Collection:**
- G1 continues as default
- ZGC improvements
- Generational collection optimizations

**Startup Performance:**
- CDS improvements
- AOT compilation enhancements
- Faster class loading

## Implementation Status

✅ **Implemented:**
- Advanced Stream Gatherers (with comprehensive examples and tests)

📝 **Expected Features:**
- Scoped Values (Standard)
- Structured Concurrency (Standard)
- Flexible Constructor Bodies (Standard)
- Primitive Types in Patterns (Standard)
- Class-File API (Standard)
- Module Import Declarations
- Vector API (Incubator)
- Value Types (Preview)
- Universal Generics (Preview)

## Building and Testing

```bash
# Build Java 25 module
./gradlew :Java25:build

# Run tests
./gradlew :Java25:test

# Run specific test
./gradlew :Java25:test --tests AdvancedStreamGatherersExampleTest
```

## Requirements

- JDK 25 or later for full feature support
- No preview flags needed for finalized features
- Examples are designed to compile on Java 17+ where possible

## Comparison: Evolution of Stream Gatherers

| Version | Status | Capabilities |
|---------|--------|-------------|
| Java 22 | Preview | Basic gatherers, windowing |
| Java 23 | Second Preview | API refinements |
| Java 24 | Third Preview | Performance improvements |
| Java 25 | Expected Final | Production-ready, full feature set |

## LTS Considerations

Java 25 is not an LTS release. The next LTS is expected in Java 26 or later.

**Recommendations:**
- Evaluate features for adoption
- Consider waiting for next LTS for production systems
- Use for new projects if comfortable with non-LTS

## Looking Forward

**Upcoming Projects:**
- **Project Valhalla:** Value types and primitive classes
- **Project Loom:** Further virtual thread optimizations
- **Project Panama:** Enhanced foreign function interface
- **Project Amber:** Continued language evolution

## References

**Note:** Links will be updated as official JEPs are published

- Stream Gatherers: Expected JEP for final version
- Scoped Values: Expected JEP for final version
- Structured Concurrency: Expected JEP for final version
- [Java 25 Release Notes](https://openjdk.org/projects/jdk/25/) (when available)
- [Project Valhalla](https://openjdk.org/projects/valhalla/)
- [Project Amber](https://openjdk.org/projects/amber/)

## Community Feedback

Java 25 represents years of preview feature refinement. The community has significantly influenced the final APIs through feedback on preview features in Java 22-24.

**Key Improvements from Feedback:**
- Simplified APIs
- Better performance
- Enhanced safety
- Improved ergonomics
