# Java 20 Features Overview

Java 20, released in March 2023, continued to refine preview and incubator features.

## Key Features

### 1. Scoped Values (Incubator)

Enables sharing of immutable data within and across threads.

**Example:**
```java
final static ScopedValue<User> CURRENT_USER = ScopedValue.newInstance();

public void processRequest(User user) {
    ScopedValue.where(CURRENT_USER, user)
               .run(() -> handleRequest());
}

public void handleRequest() {
    User user = CURRENT_USER.get();
    // Use user
}
```

**Status:** Implementation needed

### 2. Record Patterns (Second Preview)

Enhanced pattern matching with record deconstruction.

**Example:**
```java
record Point(int x, int y) {}

static void printPoint(Object obj) {
    if (obj instanceof Point(int x, int y)) {
        System.out.println("x: " + x + ", y: " + y);
    }
}

// With switch
static String describe(Object obj) {
    return switch (obj) {
        case Point(int x, int y) -> "Point at " + x + "," + y;
        default -> "Unknown";
    };
}
```

**Status:** Implementation needed

### 3. Pattern Matching for Switch (Fourth Preview)

Continued refinement toward standardization.

See Java 19 README for pattern matching examples.

### 4. Foreign Function & Memory API (Second Preview)

Accessing foreign functions and memory.

### 5. Virtual Threads (Second Preview)

Refinement of virtual threads feature.

See Java 21 for implementation: `../Java21/src/main/java/com/evolution/virtualthreads/`

### 6. Structured Concurrency (Second Incubator)

Continued development of structured concurrency.

### 7. Vector API (Fifth Incubator)

Continued refinement of vector operations.

## Key Concepts

**Scoped Values:**
- Alternative to ThreadLocal
- Immutable and shareable
- Better performance
- Works with virtual threads

**Record Patterns:**
- Deconstruct records in pattern matching
- Nested patterns support
- Cleaner code for data extraction

## Migration Notes

- Consider Scoped Values instead of ThreadLocal
- Use Record Patterns for cleaner pattern matching
- Virtual Threads becoming more stable

## To Be Implemented

- Scoped Values examples
- Record Patterns comprehensive examples
- Integration examples with records and pattern matching
