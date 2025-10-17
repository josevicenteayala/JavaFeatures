# Java 17 Features Overview

Java 17 (LTS), released in September 2021, is a Long-Term Support version with significant improvements.

## Key Features

### 1. Sealed Classes (Standard)

Sealed classes restrict which classes can extend or implement them.

**Example:**
```java
public sealed class Vehicle permits Car, Truck, Motorcycle {
    // Vehicle implementation
}

public final class Car extends Vehicle {
    // Car implementation
}

public final class Truck extends Vehicle {
    // Truck implementation  
}

public non-sealed class Motorcycle extends Vehicle {
    // Motorcycle can be extended further
}
```

**Use with Pattern Matching:**
```java
public String describe(Vehicle vehicle) {
    return switch (vehicle) {
        case Car c -> "Car with " + c.getSeats() + " seats";
        case Truck t -> "Truck with " + t.getCapacity() + " capacity";
        case Motorcycle m -> "Motorcycle";
    };
}
```

**Status:** Implementation needed

### 2. Pattern Matching for Switch (Preview)

Enhanced switch statements with pattern matching.

**Example:**
```java
static String formatterPatternSwitch(Object obj) {
    return switch (obj) {
        case Integer i -> String.format("int %d", i);
        case Long l -> String.format("long %d", l);
        case Double d -> String.format("double %f", d);
        case String s -> String.format("String %s", s);
        default -> obj.toString();
    };
}
```

**Status:** Implementation needed

### 3. Strong Encapsulation of JDK Internals

JDK internals are strongly encapsulated (no --illegal-access).

### 4. Enhanced Pseudo-Random Number Generators

New interfaces and implementations for PRNGs.

### 5. macOS Rendering Pipeline

New rendering pipeline for macOS using Apple Metal API.

### 6. Remove RMI Activation

RMI Activation mechanism removed.

### 7. Deprecate the Applet API

Applet API marked for removal.

## Migration from Java 11

- Update third-party libraries that rely on JDK internals
- Test thoroughly due to strong encapsulation
- Consider using sealed classes for domain modeling
- Explore pattern matching for switch

## To Be Implemented

- Sealed Classes comprehensive examples
- Pattern Matching for Switch examples
- Enhanced PRNG examples
