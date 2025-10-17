# Java 12 Features Overview

Java 12, released in March 2019, introduced switch expressions as a preview feature.

## Key Features

### 1. Switch Expressions (Preview)

Switch can now be used as an expression that returns a value, with new arrow syntax.

**Traditional Switch:**
```java
String result;
switch (day) {
    case MONDAY:
        result = "Start of week";
        break;
    case FRIDAY:
        result = "End of week";
        break;
    default:
        result = "Midweek";
}
```

**Switch Expression:**
```java
String result = switch (day) {
    case MONDAY -> "Start of week";
    case FRIDAY -> "End of week";
    default -> "Midweek";
};
```

**With yield for complex logic:**
```java
int result = switch (operator) {
    case "+" -> a + b;
    case "-" -> a - b;
    case "*" -> {
        System.out.println("Multiplying");
        yield a * b;
    }
    default -> throw new IllegalArgumentException();
};
```

See examples in: `src/main/java/com/javaevolution/switchexpr/`

### 2. Compact Number Formatting

Format numbers in a compact, human-readable form.

**Examples:**
```java
NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
fmt.format(1000);      // "1K"
fmt.format(1000000);   // "1M"
fmt.format(1000000000); // "1B"
```

**Long Style:**
```java
NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);
fmt.format(1000);  // "1 thousand"
```

See examples in: `src/main/java/com/javaevolution/compactnumber/`

### 3. Shenandoah GC

Low-pause-time garbage collector.

### 4. JVM Constants API

New API for modeling nominal descriptions of key class-file and run-time artifacts.

## Benefits of Switch Expressions

- More concise code
- No fall-through bugs
- Can be used as expressions
- Exhaustiveness checking by compiler
- Arrow syntax is cleaner than colon syntax
