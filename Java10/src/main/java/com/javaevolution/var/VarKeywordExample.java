package com.javaevolution.var;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Demonstrates Local Variable Type Inference (var keyword) introduced in Java 10.
 * The var keyword allows the compiler to infer the type of a local variable.
 */
public class VarKeywordExample {

    /**
     * Basic usage of var with primitives and objects
     */
    public void basicVarUsage() {
        // Instead of: String message = "Hello";
        var message = "Hello";

        // Instead of: int count = 10;
        var count = 10;

        // Instead of: double price = 99.99;
        var price = 99.99;

        // Instead of: boolean isValid = true;
        var isValid = true;
    }

    /**
     * Using var with collections
     */
    public List<String> varWithCollections() {
        // Instead of: List<String> names = new ArrayList<>();
        var names = new ArrayList<String>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // Instead of: Map<String, Integer> ages = new HashMap<>();
        var ages = new HashMap<String, Integer>();
        ages.put("Alice", 25);
        ages.put("Bob", 30);

        return names;
    }

    /**
     * Using var with streams
     */
    public List<String> varWithStreams(List<String> input) {
        // The type is inferred as List<String>
        var result = input.stream()
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        return result;
    }

    /**
     * Using var in for loops
     */
    public int varInForLoops(List<Integer> numbers) {
        var sum = 0;

        // Enhanced for loop
        for (var number : numbers) {
            sum += number;
        }

        // Traditional for loop
        for (var i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }

        return sum;
    }

    /**
     * Using var with generic types
     */
    public Map<String, List<Integer>> varWithGenerics() {
        // Type is inferred as Map<String, List<Integer>>
        var dataMap = new HashMap<String, List<Integer>>();
        dataMap.put("scores", Arrays.asList(85, 90, 95));
        dataMap.put("ages", Arrays.asList(20, 25, 30));

        return dataMap;
    }

    /**
     * Demonstrates where var cannot be used
     */
    public void limitationsOfVar() {
        // ✓ Can use: local variables with initializer
        var valid = "This works";

        // ✗ Cannot use: without initializer
        // var invalid;

        // ✗ Cannot use: initialized to null
        // var nullVar = null;

        // ✗ Cannot use: method parameters
        // public void method(var param) { }

        // ✗ Cannot use: method return types
        // public var method() { }

        // ✗ Cannot use: fields
        // var field = "Not allowed";

        // ✗ Cannot use: array initializers
        // var array = {1, 2, 3};
    }

    /**
     * Best practices with var
     */
    public void varBestPractices() {
        // Good: type is obvious from the right-hand side
        var name = "John Doe";
        var count = 100;
        var list = new ArrayList<String>();

        // Less ideal: type not immediately clear
        var result = calculate(); // What type is this?

        // Better: explicit type when not obvious
        String betterResult = calculate();
    }

    private String calculate() {
        return "result";
    }

    /**
     * Using var with try-with-resources
     */
    public void varWithTryWithResources() {
        var names = List.of("file1.txt", "file2.txt");

        for (var filename : names) {
            // var can be used in try-with-resources
            // Note: This is just for demonstration
            System.out.println("Processing: " + filename);
        }
    }
}
