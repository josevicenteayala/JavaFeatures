# Optional Class in Java 8

## Introduction

The `Optional` class was introduced in Java 8 to address the problem of null pointer exceptions. It's a container object that may or may not contain a non-null value. Optional helps developers write cleaner code by explicitly handling the absence of values.

## Why Optional?

Before Java 8, developers had to manually check for null values:

```java
String value = getValue();
if (value != null) {
    System.out.println(value.toUpperCase());
}
```

With Optional, the code becomes more expressive:

```java
Optional<String> value = getOptionalValue();
value.ifPresent(v -> System.out.println(v.toUpperCase()));
```

## Creating Optional Instances

### Optional.of()
Creates an Optional with a non-null value. Throws NullPointerException if value is null.

```java
Optional<String> optional = Optional.of("Hello");
```

### Optional.ofNullable()
Creates an Optional that may contain null. Returns empty Optional if value is null.

```java
Optional<String> optional = Optional.ofNullable(possiblyNullValue);
```

### Optional.empty()
Creates an empty Optional.

```java
Optional<String> optional = Optional.empty();
```

## Retrieving Values

### get()
Returns the value if present, otherwise throws NoSuchElementException.

```java
String value = optional.get(); // Unsafe if Optional might be empty
```

### orElse()
Returns the value if present, otherwise returns the default value.

```java
String value = optional.orElse("default");
```

### orElseGet()
Returns the value if present, otherwise invokes the supplier and returns the result.

```java
String value = optional.orElseGet(() -> computeDefault());
```

### orElseThrow()
Returns the value if present, otherwise throws an exception.

```java
String value = optional.orElseThrow(() -> new IllegalStateException("No value"));
```

## Transforming Values

### map()
Transforms the value if present using the provided function.

```java
Optional<Integer> length = optional.map(String::length);
```

### flatMap()
Similar to map() but the mapper function returns an Optional.

```java
Optional<String> result = optional.flatMap(this::findRelated);
```

### filter()
Filters the value based on a predicate.

```java
Optional<String> filtered = optional.filter(s -> s.length() > 5);
```

## Conditional Actions

### isPresent()
Returns true if value is present.

```java
if (optional.isPresent()) {
    System.out.println(optional.get());
}
```

### ifPresent()
Executes the consumer if value is present.

```java
optional.ifPresent(value -> System.out.println(value));
```

## Best Practices

1. **Don't use Optional.get() without checking** - Use `orElse()`, `orElseGet()`, or check with `isPresent()` first
2. **Don't use Optional for fields** - Optional is designed for return types, not fields
3. **Don't use Optional in method parameters** - Use overloaded methods instead
4. **Use orElseGet() for expensive defaults** - orElseGet() is lazy, orElse() always evaluates
5. **Chain operations** - Use map(), flatMap(), and filter() to create fluent chains

## Common Use Cases

### Database Queries
```java
Optional<User> user = userRepository.findById(userId);
return user.orElseThrow(() -> new UserNotFoundException(userId));
```

### Configuration Values
```java
Optional<String> config = getConfig("key");
String value = config.orElse("defaultValue");
```

### Null-Safe Processing
```java
Optional.ofNullable(user)
    .map(User::getAddress)
    .map(Address::getCity)
    .orElse("Unknown");
```
