# Java 22 Features Overview

Java 22, released in March 2024, introduced several significant features including finalized and preview features.

## Key Features

### 1. Unnamed Variables and Patterns (JEP 456) ✅ IMPLEMENTED

**Status:** Standard (Finalized)

Allows the use of underscore (`_`) to denote variables and patterns that are not used, improving code readability and clarity.

**See implementation:** `src/main/java/com/javaevolution/unnamedpatterns/`

**Key Benefits:**
- Cleaner code when certain values are intentionally unused
- Better communication of intent to other developers
- Works in multiple contexts: lambda parameters, catch blocks, try-with-resources, for loops, and record patterns

**Examples:**

```java
// Unnamed variables in pattern matching
if (obj instanceof Point(int x, int _)) {
    // Only x is needed, y is ignored
    System.out.println("X: " + x);
}

// Unnamed variables in catch blocks
try {
    riskyOperation();
} catch (Exception _) {
    // Exception details not needed
    return defaultValue;
}

// Unnamed variables in for loops
for (int _ = 0; _ < 10; _++) {
    performAction();
}
```

**Status:** Fully implemented with comprehensive tests

### 2. Stream Gatherers (JEP 461) ✅ IMPLEMENTED

**Status:** Preview Feature

A new intermediate stream operation that allows custom, composable operations on stream elements. Gatherers complement existing collectors and provide more flexibility.

**See implementation:** `src/main/java/com/javaevolution/streamgatherers/`

**Key Capabilities:**
- Windowing operations (fixed and sliding windows)
- Stateful stream processing
- Custom accumulation and transformation
- Batching and grouping operations

**Examples:**

```java
// Fixed-size windows
List<List<Integer>> windows = numbers.stream()
    .collect(windowedCollector(3));

// Running averages
List<Double> averages = calculateRunningAverages(numbers);

// Zip two lists together
List<Pair<A, B>> zipped = zip(list1, list2);

// Batch processing
List<List<T>> batches = batch(items, batchSize);
```

**Status:** Implemented with examples demonstrating gatherer concepts

### 3. Foreign Function & Memory API (JEP 454)

**Status:** Standard (Finalized)

The Foreign Function & Memory (FFM) API enables Java programs to interoperate with code and data outside the Java runtime. It allows:
- Calling native libraries without JNI
- Safe and efficient access to foreign memory
- Better performance than JNI

**Key Features:**
- Memory segments for safe access to off-heap memory
- Memory layouts for structured access
- Linker API for calling native functions
- Arena-based memory management

**Example Concepts:**
```java
// Accessing native memory
try (Arena arena = Arena.ofConfined()) {
    MemorySegment segment = arena.allocate(100);
    segment.setAtIndex(ValueLayout.JAVA_INT, 0, 42);
}

// Calling native functions
Linker linker = Linker.nativeLinker();
SymbolLookup stdlib = linker.defaultLookup();
```

**Status:** API documentation provided (requires Java 22+ for execution)

### 4. String Templates (JEP 459)

**Status:** Second Preview

String templates provide string interpolation with embedded expressions. This feature was in preview in Java 21 and continued in Java 22 as a second preview, but was later withdrawn in Java 23.

**Example Concept:**
```java
String name = "John";
int age = 30;
String message = STR."Hello, \{name}! You are \{age} years old.";
```

### 5. Statements before super() (JEP 447)

**Status:** Preview Feature

Allows statements to appear before explicit constructor invocations (`super()` or `this()`), relaxing previous restrictions.

**Example Concept:**
```java
public class PositiveBigInteger extends BigInteger {
    public PositiveBigInteger(long value) {
        if (value <= 0)
            throw new IllegalArgumentException("non-positive value");
        super(value);  // Now allowed after statements
    }
}
```

### 6. Scoped Values (JEP 464)

**Status:** Second Preview

Scoped values enable sharing of immutable data within and across threads. They're more efficient and safer alternatives to thread-local variables.

**Key Benefits:**
- Immutable by default
- Better performance than ThreadLocal
- Clear lifetime management
- Suitable for virtual threads

### 7. Structured Concurrency (JEP 462)

**Status:** Second Preview

Simplifies concurrent programming by treating multiple tasks running in different threads as a single unit of work.

**Benefits:**
- Simplified error handling and cancellation
- Better observability
- Reliability improvements

### 8. Class-File API (JEP 457)

**Status:** Preview Feature

Provides a standard API for parsing, generating, and transforming Java class files, replacing ASM and other third-party libraries.

### 9. Vector API (JEP 460)

**Status:** Seventh Incubator

Express vector computations that compile to optimal vector instructions on supported CPU architectures.

### 10. Region Pinning for G1 GC (JEP 423)

**Status:** Standard

Improves G1 garbage collector by reducing latency for JNI critical regions through region pinning.

## Migration from Java 21

**Key Improvements:**
- Adopt unnamed variables for cleaner code
- Explore stream gatherers for complex stream operations
- Consider Foreign Function & Memory API for native interop
- Evaluate constructor flexibility with statements before super()

**Breaking Changes:**
- Some preview features from Java 21 have evolved
- String templates API may have changed (second preview)

## Best Practices

**Unnamed Variables:**
- Use `_` when a variable is required but not used
- Improves code readability and maintainability
- Clearly communicates intent

**Stream Gatherers:**
- Use for custom intermediate operations
- Consider performance implications
- Combine with existing stream operations

**Foreign Function & Memory API:**
- Prefer over JNI for new native integrations
- Use arenas for memory management
- Follow memory safety guidelines

## Implementation Status

✅ **Implemented:**
- Unnamed Variables and Patterns (with comprehensive examples and tests)
- Stream Gatherers (with conceptual implementations and tests)

📝 **Documented:**
- Foreign Function & Memory API
- String Templates (Preview)
- Statements before super()
- Scoped Values
- Structured Concurrency
- Class-File API
- Vector API
- Region Pinning for G1

## Building and Testing

```bash
# Build Java 22 module
./gradlew :Java22:build

# Run tests
./gradlew :Java22:test

# Run specific test
./gradlew :Java22:test --tests UnnamedPatternsExampleTest
```

## Requirements

- JDK 22 or later for full feature support
- Some features are preview features and require `--enable-preview` flag
- Examples are designed to compile on Java 17+ where possible

## References

- [JEP 456: Unnamed Variables & Patterns](https://openjdk.org/jeps/456)
- [JEP 461: Stream Gatherers](https://openjdk.org/jeps/461)
- [JEP 454: Foreign Function & Memory API](https://openjdk.org/jeps/454)
- [JEP 459: String Templates (Second Preview)](https://openjdk.org/jeps/459)
- [JEP 447: Statements before super(...)](https://openjdk.org/jeps/447)
