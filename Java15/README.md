# Java 15 Features Overview

Java 15, released in September 2020, continued to refine preview features and introduced sealed classes.

## Key Features

### 1. Sealed Classes (Preview)

Sealed classes restrict which classes can extend or implement them, providing more control over class hierarchies.

**Example:**
```java
public sealed class Shape permits Circle, Rectangle, Triangle {
    // Common shape behavior
}

public final class Circle extends Shape {
    // Circle implementation
}

public final class Rectangle extends Shape {
    // Rectangle implementation
}

public non-sealed class Triangle extends Shape {
    // Triangle can be extended further
}
```

**Benefits:**
- Better domain modeling
- Exhaustive pattern matching
- Security and maintainability

**Status:** Implementation needed

### 2. Text Blocks (Standard)

Text blocks, introduced as preview in Java 13, became standard in Java 15.

See Java 13 for examples: `../Java13/src/main/java/com/javaevolution/textblocks/`

### 3. Hidden Classes

Classes that cannot be used directly by bytecode of other classes.

### 4. Pattern Matching for instanceof (Second Preview)

Continued refinement of pattern matching feature.

See Java 14 for examples: `../Java14/src/main/java/com/javaevolution/patternmatching/`

### 5. Records (Second Preview)

Continued refinement of records feature.

See Java 14 for examples: `../Java14/src/main/java/com/javaevolution/records/`

### 6. Helpful NullPointerExceptions

Now enabled by default.

## To Be Implemented

- Sealed Classes examples and tests
- Integration examples showing sealed classes with pattern matching
