# Advanced Description of Functional Interfaces
Functional interfaces in Java are a foundational concept that enables lambda expressions and method references. A functional interface has exactly one abstract method (also known as the functional method) but can have multiple default or static methods. The java.util.function package provides several built-in functional interfaces to facilitate common functional programming concepts, such as predicates, functions, consumers, and suppliers.
![FuntionalInterfaces.jpg](..%2F..%2F..%2F..%2F..%2Fresources%2Fimages%2FFuntionalInterfaces.jpg)
- `Predicate<T>`: Represents a predicate (boolean-valued function) of one argument. It's often used for filtering or matching. The `test(T t)` method evaluates this predicate on the given argument.

```java
Predicate<String> stringLengthPredicate = s -> s.length() > 5;
boolean result = stringLengthPredicate.test("JavaEvolution");
```

- `Function<T,R>`: Represents a function that accepts one argument and produces a result. This is a very general functional interface used for transformations.

```java
Function<String, Integer> stringLengthFunction = String::length;
Integer length = stringLengthFunction.apply("Hello");
```

- `Consumer<T>`: Represents an operation that accepts a single input argument and returns no result. Consumers are often used for iterating over collections or performing operations that change the state.

```java
Consumer<String> printConsumer = System.out::println;
printConsumer.accept("Java Evolution");
```

- `Supplier<T>`: Represents a supplier of results. Unlike Function, which requires an input, Supplier has no arguments and is used for lazy generation of values.

```java
Supplier<LocalDate> todaySupplier = LocalDate::now;
LocalDate today = todaySupplier.get();
```

## Example Classes
- PredicateExample: This example demonstrates using `Predicate<T>` to filter data:

```java
Predicate<Integer> isEven = x -> x % 2 == 0;
```
- FunctionExample: This example demonstrates using `Function<T, R>` to calculate some data:

```java
Function<String, Integer> lengthFunction = String :: length;
```
