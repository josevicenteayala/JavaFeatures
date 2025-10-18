# Stream API in Java 8

## Introduction

The Stream API is one of the most significant features introduced in Java 8. It provides a functional approach to processing collections of objects, enabling developers to write cleaner, more concise, and more readable code.

## What is a Stream?

A Stream represents a sequence of elements supporting sequential and parallel aggregate operations. Streams don't store data; they operate on the data from a source (like collections, arrays, or I/O channels).

## Key Characteristics

- **Not a data structure**: Streams don't store elements
- **Functional in nature**: Operations on streams produce a result without modifying the source
- **Lazy evaluation**: Intermediate operations are lazy and only executed when a terminal operation is invoked
- **Possibly unbounded**: Streams can be infinite
- **Consumable**: Stream elements can only be visited once

## Creating Streams

### From Collections
```java
List<String> list = Arrays.asList("a", "b", "c");
Stream<String> stream = list.stream();
```

### From Arrays
```java
String[] array = {"a", "b", "c"};
Stream<String> stream = Arrays.stream(array);
```

### From Values
```java
Stream<String> stream = Stream.of("a", "b", "c");
```

### From Files
```java
Stream<String> lines = Files.lines(Paths.get("file.txt"));
```

## Stream Operations

Stream operations are divided into two categories:

### Intermediate Operations
These operations return a new stream and are lazy (not executed until a terminal operation is called).

#### filter()
Filters elements based on a predicate.
```java
list.stream()
    .filter(s -> s.startsWith("a"))
    .collect(Collectors.toList());
```

#### map()
Transforms each element using a function.
```java
list.stream()
    .map(String::toUpperCase)
    .collect(Collectors.toList());
```

#### flatMap()
Flattens nested structures.
```java
listOfLists.stream()
    .flatMap(Collection::stream)
    .collect(Collectors.toList());
```

#### distinct()
Removes duplicate elements.
```java
list.stream()
    .distinct()
    .collect(Collectors.toList());
```

#### sorted()
Sorts elements in natural order or using a comparator.
```java
list.stream()
    .sorted()
    .collect(Collectors.toList());
```

#### limit()
Limits the stream to n elements.
```java
list.stream()
    .limit(5)
    .collect(Collectors.toList());
```

#### skip()
Skips the first n elements.
```java
list.stream()
    .skip(2)
    .collect(Collectors.toList());
```

### Terminal Operations
These operations produce a result or side effect and close the stream.

#### collect()
Collects stream elements into a collection.
```java
List<String> result = stream.collect(Collectors.toList());
Set<String> set = stream.collect(Collectors.toSet());
```

#### forEach()
Performs an action for each element.
```java
stream.forEach(System.out::println);
```

#### reduce()
Reduces the stream to a single value.
```java
int sum = numbers.stream()
    .reduce(0, Integer::sum);
```

#### count()
Counts the elements in the stream.
```java
long count = stream.count();
```

#### anyMatch(), allMatch(), noneMatch()
Checks if elements match a predicate.
```java
boolean hasA = list.stream().anyMatch(s -> s.contains("a"));
boolean allLong = list.stream().allMatch(s -> s.length() > 5);
boolean noneEmpty = list.stream().noneMatch(String::isEmpty);
```

#### findFirst(), findAny()
Finds an element from the stream.
```java
Optional<String> first = stream.findFirst();
Optional<String> any = stream.findAny();
```

## Advanced Operations

### Collectors

#### Grouping
```java
Map<Integer, List<String>> grouped = list.stream()
    .collect(Collectors.groupingBy(String::length));
```

#### Partitioning
```java
Map<Boolean, List<String>> partitioned = list.stream()
    .collect(Collectors.partitioningBy(s -> s.length() > 5));
```

#### Joining
```java
String joined = list.stream()
    .collect(Collectors.joining(", "));
```

#### Mapping
```java
List<Integer> lengths = list.stream()
    .collect(Collectors.mapping(String::length, Collectors.toList()));
```

### Parallel Streams

Parallel streams use multiple threads to process elements.

```java
long count = list.parallelStream()
    .filter(s -> s.length() > 5)
    .count();
```

**When to use parallel streams:**
- Large datasets
- CPU-intensive operations
- No shared mutable state
- Order doesn't matter

**When NOT to use parallel streams:**
- Small datasets (overhead > benefit)
- I/O operations
- Operations with side effects
- Order-dependent operations

## Best Practices

1. **Prefer method references** over lambda expressions when possible
2. **Avoid side effects** in stream operations
3. **Don't modify the source** while streaming
4. **Close streams from I/O** sources using try-with-resources
5. **Be careful with parallel streams** - they're not always faster
6. **Keep it simple** - complex stream chains are hard to debug
7. **Use Optional** with findFirst() and findAny()

## Common Patterns

### Filtering and Mapping
```java
List<String> result = list.stream()
    .filter(s -> s.length() > 3)
    .map(String::toUpperCase)
    .collect(Collectors.toList());
```

### Reducing to Sum
```java
int total = numbers.stream()
    .reduce(0, Integer::sum);
```

### Finding Maximum
```java
Optional<Integer> max = numbers.stream()
    .reduce(Integer::max);
```

### Converting to Map
```java
Map<String, Integer> map = list.stream()
    .collect(Collectors.toMap(
        Function.identity(),
        String::length
    ));
```

## Performance Considerations

1. **Lazy evaluation**: Intermediate operations are not executed until a terminal operation is called
2. **Short-circuiting**: Operations like `findFirst()` and `anyMatch()` can stop processing early
3. **Fusion**: The compiler can combine multiple operations for better performance
4. **Memory**: Streams don't store elements, reducing memory overhead

## Common Mistakes to Avoid

1. **Reusing streams**: Streams can only be used once
2. **Modifying the source**: Don't modify the collection while streaming
3. **Forgetting terminal operation**: Intermediate operations alone don't execute
4. **Overusing parallel streams**: Not always faster, can be slower for small datasets
5. **Side effects in lambdas**: Keep operations pure
