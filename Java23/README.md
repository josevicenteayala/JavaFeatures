# Java 23 Features Overview

Java 23, released in September 2024, continues Java's evolution with refinements to preview features and new innovations.

## Key Features

### 1. Primitive Types in Patterns, instanceof, and switch (JEP 455) ✅ IMPLEMENTED

**Status:** Preview Feature

Extends pattern matching to work seamlessly with primitive types, allowing direct matching and extraction of primitive values.

**See implementation:** `src/main/java/com/javaevolution/primitivetypes/`

**Key Benefits:**
- Simplifies code when working with boxed primitives
- More intuitive pattern matching
- Better type safety and null handling
- Eliminates unnecessary casting

**Examples:**

```java
// Pattern matching with primitives in instanceof
if (obj instanceof Integer i) {
    System.out.println("Integer: " + i);
}

// Switch with primitive patterns and guards
String result = switch (obj) {
    case Integer i when i > 0 -> "Positive: " + i;
    case Integer i when i < 0 -> "Negative: " + i;
    case Integer i -> "Zero";
    case Long l -> "Long: " + l;
    case Double d -> "Double: " + d;
    default -> "Other type";
};

// Extract primitives from records
if (obj instanceof Point(int x, int y)) {
    System.out.println("Point at " + x + ", " + y);
}
```

**Status:** Fully implemented with comprehensive tests

### 2. Flexible Constructor Bodies (JEP 482) ✅ IMPLEMENTED

**Status:** Second Preview

Allows statements to appear before explicit constructor invocations (`super()` or `this()`), providing more flexibility in constructor initialization.

**See implementation:** `src/main/java/com/javaevolution/flexibleconstructors/`

**Key Benefits:**
- Validate arguments before passing to super()
- Pre-process constructor arguments
- Simplify constructor delegation
- Reduce need for static helper methods

**Examples:**

```java
public class PositiveValue extends Number {
    public PositiveValue(long value) {
        // Validate before super() call (Java 23+)
        if (value <= 0) {
            throw new IllegalArgumentException("Must be positive");
        }
        super();
        this.value = value;
    }
}

public class NormalizedString {
    public NormalizedString(String input) {
        // Process before super() (Java 23+)
        String normalized = input.trim().toLowerCase();
        super();
        this.value = normalized;
    }
}
```

**Status:** Conceptual implementation with working examples

### 3. Markdown Documentation Comments (JEP 467)

**Status:** Standard (Finalized)

Enables markdown syntax in JavaDoc comments, making documentation more expressive and easier to write.

**Key Features:**
- Use markdown formatting in JavaDoc
- Tables, lists, code blocks with markdown syntax
- Better readability in source code
- Backward compatible with HTML

**Examples:**

```java
/**
 * # This is a heading
 * 
 * This method does something **important**.
 * 
 * ## Usage
 * 
 * ```java
 * var result = myMethod(42);
 * ```
 * 
 * - Item 1
 * - Item 2
 * - Item 3
 */
public void myMethod(int value) { }
```

### 4. Module Import Declarations (JEP 476)

**Status:** Preview Feature

Simplifies importing all packages from a module with a single statement.

**Benefits:**
- Reduces boilerplate in module-heavy code
- Clearer dependencies
- Easier to work with modular libraries

**Example:**
```java
import module java.base;  // Import all packages from java.base module

// Instead of:
// import java.util.*;
// import java.io.*;
// import java.nio.*;
// etc.
```

### 5. Scoped Values (JEP 481)

**Status:** Third Preview

Scoped values enable sharing immutable data within and across threads, continuing evolution from Java 22.

**Key Benefits:**
- Better than ThreadLocal for virtual threads
- Immutable by default
- Clear lifetime management
- Memory efficient

### 6. Structured Concurrency (JEP 480)

**Status:** Third Preview

Simplifies concurrent programming by treating multiple tasks as a single unit of work, third preview.

### 7. Stream Gatherers (JEP 473)

**Status:** Second Preview

Continues evolution of stream gatherers from Java 22, providing flexible intermediate operations.

### 8. Vector API (JEP 469)

**Status:** Eighth Incubator

Continues evolution of Vector API for SIMD operations.

### 9. Class-File API (JEP 466)

**Status:** Second Preview

Standard API for parsing, generating, and transforming Java class files.

### 10. ZGC: Generational Mode by Default (JEP 474)

**Status:** Standard

Z Garbage Collector now uses generational mode by default, improving performance for most applications.

**Benefits:**
- Better performance for typical workloads
- Lower memory overhead
- Improved pause times

## Migration from Java 22

**Key Improvements:**
- Adopt primitive type patterns for cleaner code
- Use flexible constructors for better validation
- Consider markdown in JavaDoc for better documentation
- Evaluate module imports for cleaner code

**Breaking Changes:**
- String Templates feature was removed (withdrawn from preview)
- Some preview feature APIs may have changed

## Best Practices

**Primitive Type Patterns:**
- Use for cleaner numeric type handling
- Combine with guards for range checking
- Prefer over manual instanceof + casting

**Flexible Constructors:**
- Validate early before super() calls
- Pre-process arguments for cleaner code
- Reduce complexity in inheritance hierarchies

**Markdown Documentation:**
- Use markdown for tables and lists
- Keep code examples readable
- Maintain backward compatibility

## Implementation Status

✅ **Implemented:**
- Primitive Types in Patterns (with comprehensive examples and tests)
- Flexible Constructor Bodies (with conceptual implementations and tests)

📝 **Documented:**
- Markdown Documentation Comments
- Module Import Declarations
- Scoped Values (Third Preview)
- Structured Concurrency (Third Preview)
- Stream Gatherers (Second Preview)
- Vector API (Eighth Incubator)
- Class-File API (Second Preview)
- ZGC Generational Mode

## Building and Testing

```bash
# Build Java 23 module
./gradlew :Java23:build

# Run tests
./gradlew :Java23:test

# Run specific test
./gradlew :Java23:test --tests PrimitiveTypesExampleTest
```

## Requirements

- JDK 23 or later for full feature support
- Preview features require `--enable-preview` flag
- Examples are designed to compile on Java 17+ where possible

## References

- [JEP 455: Primitive Types in Patterns](https://openjdk.org/jeps/455)
- [JEP 482: Flexible Constructor Bodies](https://openjdk.org/jeps/482)
- [JEP 467: Markdown Documentation Comments](https://openjdk.org/jeps/467)
- [JEP 476: Module Import Declarations](https://openjdk.org/jeps/476)
- [JEP 474: ZGC: Generational Mode by Default](https://openjdk.org/jeps/474)
