# Java 14 Features Overview

Java 14, released in March 2020, introduced records and pattern matching as preview features.

## Key Features

### 1. Records (Preview)

Records provide a compact syntax for declaring classes that are transparent holders for data.

**Traditional Data Class:**
```java
public final class Person {
    private final String name;
    private final int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() { return name; }
    public int getAge() { return age; }
    
    // equals, hashCode, toString implementations...
}
```

**Record:**
```java
public record Person(String name, int age) {}
```

**Record Features:**
- Automatic constructor
- Automatic getters
- Automatic equals(), hashCode(), toString()
- Immutable by default
- Can implement interfaces
- Can have static methods and fields
- Can have additional methods
- Can have validation in compact constructor

**Examples:**
```java
record Point(int x, int y) {
    // Compact constructor with validation
    public Point {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException();
        }
    }
    
    // Additional methods
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }
}
```

See examples in: `src/main/java/com/javaevolution/records/`

### 2. Pattern Matching for instanceof (Preview)

Eliminates the need for explicit casting after instanceof check.

**Before Java 14:**
```java
if (obj instanceof String) {
    String str = (String) obj;
    System.out.println(str.toUpperCase());
}
```

**With Pattern Matching:**
```java
if (obj instanceof String str) {
    System.out.println(str.toUpperCase());
}
```

**Combined with Logical Operators:**
```java
if (obj instanceof String str && str.length() > 5) {
    System.out.println(str);
}
```

**In Ternary Operator:**
```java
int length = obj instanceof String str ? str.length() : 0;
```

See examples in: `src/main/java/com/javaevolution/patternmatching/`

### 3. Helpful NullPointerExceptions

Improved NullPointerException messages that identify precisely which variable was null.

**Before:**
```
Exception in thread "main" java.lang.NullPointerException
```

**Java 14+:**
```
Exception in thread "main" java.lang.NullPointerException: 
    Cannot invoke "String.toLowerCase()" because "str" is null
```

### 4. Switch Expressions (Standard)

Switch expressions, introduced in Java 12, became standard in Java 14.

### 5. Text Blocks (Second Preview)

Text blocks continued as preview feature with minor improvements.

## Benefits

**Records:**
- Less boilerplate code
- Clear intent for data carriers
- Immutability by default
- Works well with pattern matching

**Pattern Matching:**
- More readable code
- Fewer casts
- Type safety
- Foundation for future pattern matching features
