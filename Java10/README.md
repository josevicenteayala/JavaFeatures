# Java 10 Features Overview

Java 10, released in March 2018, introduced local variable type inference and other improvements.

## Key Features

### 1. Local-Variable Type Inference (var)

The `var` keyword allows the compiler to infer the type of a local variable, reducing verbosity.

**Examples:**
```java
var message = "Hello";  // String
var count = 10;         // int
var list = new ArrayList<String>();  // ArrayList<String>
```

**Where you CAN use var:**
- Local variables with initializers
- For loop indices
- Enhanced for loops

**Where you CANNOT use var:**
- Method parameters
- Method return types
- Fields
- Without an initializer
- Initialized to null

See examples in: `src/main/java/com/javaevolution/var/`

### 2. Application Class-Data Sharing

Improves startup time and reduces memory footprint by sharing class metadata.

### 3. Garbage Collector Interface

Improved GC interface for better garbage collector implementations.

### 4. Additional Unicode Language-Tag Extensions

Better support for internationalization.

## Best Practices with var

1. Use when the type is obvious from the right-hand side
2. Don't use when it reduces readability
3. Good for complex generic types
4. Keep variable names descriptive
