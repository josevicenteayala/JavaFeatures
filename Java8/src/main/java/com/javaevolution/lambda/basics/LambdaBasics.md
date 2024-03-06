# Lambda Expressions Basics

Lambda expressions in Java provide a clear and concise way to implement a single method interface using an expression.
They are particularly useful in simplifying the code where an instance of an anonymous class is needed.

![LambdaBasics.jpg](..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2Fimages%2FLambdaBasics.jpg)

## Examples

### SimpleLambdaExample

The `SimpleLambdaExample` demonstrates the basic use of a lambda expression to implement a functional interface. A
functional interface is an interface with a single abstract method. In this example, the `Greeting` interface has a
single method, `sayHello`, which takes a string and returns a greeting message.

```java
Greeting greeting = (String name) -> "Hello, " + name;
```

This lambda expression implements the Greeting interface in a concise way, replacing the need for an anonymous class.

### ComparatorLambdaExample

The ComparatorLambdaExample shows how to use lambda expressions with the Comparator interface to sort a list of strings.
The Comparator interface is a functional interface that compares two objects.

```java
names.sort((String a, String b) ->a.

compareTo(b));
```

This lambda expression implements the Comparator interface, providing a method to compare two strings. The expression is
passed directly to the sort method of the List interface.

```java
private static Comparator<String> getStringComparatorEnhanced() {
    return String::compareTo;
}
```

Method Reference (String::compareTo): This syntax is used to refer directly to the compareTo method of the String class
without executing it. Method references are syntactic sugar in Java, making the code more readable and concise,
especially when the lambda expression is simply calling an existing method.
Functional Interface (Comparator<String>): The Comparator interface is a functional interface, meaning it has a single
abstract method. In this context, it defines how two strings should be compared in terms of their natural ordering.
Natural Ordering: The compareTo method in the String class compares two strings lexicographically, which is considered
their natural ordering.
Using a method reference like String::compareTo is particularly useful when your lambda expression would call a single
method without performing any other operations. This not only makes the code cleaner but also improves its
expressiveness by directly linking the operation to the existing method.

### Conclusion

Lambda expressions simplify the syntax and improve the readability of the code, especially when using functional
interfaces or passing behavior to methods. These examples demonstrate basic usage patterns and how lambda expressions
can make your code more concise and expressive.