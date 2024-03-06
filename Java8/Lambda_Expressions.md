# Lambda Expressions in Java 8

Lambda expressions are one of the most significant features introduced in Java 8. They represent a step forward in
Java's programming paradigm, allowing you to write more concise and readable code, especially when working with
collections and APIs designed for functional programming. This document provides an overview of lambda expressions,
their syntax, and examples of how to use them effectively.
![Lambda.jpg](..%2Fimages%2FLambda.jpg)

## What Are Lambda Expressions?

Lambda expressions are a way to define anonymous methods (functions not bound to a name) and treat them as first-class
citizens. They enable you to write function implementations directly in the body of code where they are needed, often
passed as arguments to other methods, such as those found in the Streams API.

## Syntax

The syntax of a lambda expression is characterized by the following components:

- A comma-separated list of parameters: `(param1, param2)`
- The arrow token: `->`
- A body, which can be a single expression or a statement block: `expression` or `{ statements }`

## Examples

Here are some examples of lambda expressions:

1) No parameters:

```java
() -> System.out.println("Welcome Lambdas!");
```

2) One parameter (the parenthesis is optional for one parameter):

```java
s -> System.out.println(s);
```

or

```java
(String s) -> System.out.println(s);
```

3) Multiple parameters:

```java
(int a, int b) -> { return a + b; }
```

## Using Lambda Expressions

Lambda expressions are commonly used with functional interfaces—interfaces with a single abstract method. Java 8
includes many built-in functional interfaces in the `java.util.function` package, such
as `Predicate<T>`, `Function<T,R>`, and `Consumer<T>`.

### Example with Collections

Before Java 8, iterating over a collection and performing an action on each element required verbose syntax. Lambda
expressions make this process more succinct and readable.

#### Old Way (Java 7 and before):

```java
List<String> list = Arrays.asList("apple", "banana", "cherry");
for (String s : list) {
    System.out.println(s);
}
```

#### New Way (Java 8 with Lambda):

```java
List<String> list = Arrays.asList("apple", "banana", "cherry");
list.forEach(s -> System.out.println(s));
```

### Example with Threads

Lambda expressions simplify the syntax when creating new threads with specific tasks.

#### Old Way (Java 7 and before):

```java
new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("Thread running");
    }
}).start();
```

#### New Way (Java 8 with Lambda):

```java
new Thread(() -> System.out.println("Thread running")).start();
```

## Benefits of Using Lambda Expressions

- Conciseness: Lambda expressions reduce the boilerplate code associated with anonymous class implementations.
- Readability: They make your code more readable by keeping the focus on the operation's logic rather than its syntax.
- Functional Programming: Lambda expressions facilitate functional programming in Java, allowing for cleaner, more
  modular code, and easier parallel execution.

## Conclusion

Lambda expressions in Java 8 introduced a powerful, concise way to implement functional programming concepts. They have
significantly improved the language's expressiveness and opened up new possibilities for tackling complex problems more
elegantly. By leveraging lambda expressions, developers can write more readable, maintainable, and efficient code.