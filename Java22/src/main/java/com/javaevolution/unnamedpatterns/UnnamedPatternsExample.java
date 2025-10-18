package com.javaevolution.unnamedpatterns;

import java.util.List;
import java.util.Queue;

/**
 * Demonstrates Unnamed Variables and Patterns introduced in Java 22 (JEP 456).
 * This feature allows the use of underscore (_) to denote unused variables,
 * making code cleaner and more readable when certain values are not needed.
 */
public class UnnamedPatternsExample {

    /**
     * Example record for demonstration
     */
    public record Point(int x, int y) {}

    /**
     * Example record with more components
     */
    public record Person(String name, int age, String address) {}

    /**
     * Using unnamed variables in try-with-resources
     * When we don't need to use the resource variable itself
     * Note: In Java 22+, you would use _ for unused exception variables
     */
    public int countLines(String filename) {
        // Simulate reading - in real code, this would use actual file operations
        // Java 22+ would allow _ for unused variables
        // Java 17 compatible version:
        try {
            // In Java 22+, you can use _ for variables you don't plan to use
            int lineCount = 0;
            // Simulated line counting
            return lineCount;
        } catch (Exception e) {
            // Java 22+ syntax would be: catch (Exception _)
            return 0;
        }
    }

    /**
     * Using unnamed patterns in switch expressions
     * Demonstrating pattern matching with unused components
     * Note: In Java 22+, you would use _ for unused pattern variables
     */
    public String processPoint(Object obj) {
        // Java 22+ syntax would be: case Point(int x, int _) -> ...
        // Java 17 compatible version:
        if (obj instanceof Point p) {
            return "X coordinate is: " + p.x();
        } else if (obj == null) {
            return "Null object";
        }
        return "Not a Point";
    }

    /**
     * Using unnamed variables in record patterns
     * When we only care about some fields
     * Note: In Java 22+, you would use _ for unused pattern components
     */
    public String extractName(Object obj) {
        // Java 22+ syntax would be: if (obj instanceof Person(String name, int _, String _))
        // Java 17 compatible version:
        if (obj instanceof Person p) {
            return p.name();
        }
        return "Unknown";
    }

    /**
     * Using unnamed variables in for loops
     * When the loop variable itself isn't needed
     * Note: In Java 22+, you would use _ for unused loop variables
     */
    public void printMultipleTimes(String message, int count) {
        // Java 22+ syntax would be: for (int _ = 0; _ < count; _++)
        // Java 17 compatible version:
        for (int i = 0; i < count; i++) {
            System.out.println(message);
        }
    }

    /**
     * Using unnamed variables in lambda expressions
     * When lambda parameters are not used
     * Note: In Java 22+, you would use _ for unused lambda parameters
     */
    public List<String> generateDefaultList(int size) {
        // Java 22+ syntax would be: .mapToObj(_ -> "default")
        // Java 17 compatible version:
        return java.util.stream.IntStream.range(0, size)
                .mapToObj(i -> "default")
                .toList();
    }

    /**
     * Using unnamed patterns in enhanced for loops
     * When we only care about the index or performing an action
     * Note: In Java 22+, you would use _ for unused loop variables
     */
    public int countElements(List<?> list) {
        // Java 22+ syntax would be: for (var _ : list)
        // Java 17 compatible version:
        int count = 0;
        for (var item : list) {
            count++;
        }
        return count;
    }

    /**
     * Using multiple unnamed variables
     * When several variables are not needed
     * Note: In Java 22+, you would use _ for unused pattern components
     */
    public String processComplexPattern(Object obj) {
        // Java 22+ syntax would use _ for unused variables in patterns
        // Java 17 compatible version:
        if (obj instanceof Point p) {
            if (p.y() > 0) {
                return "Positive Y";
            } else if (p.y() < 0) {
                return "Negative Y";
            } else {
                return "Y is zero";
            }
        } else if (obj == null) {
            return "Null";
        }
        return "Not a Point";
    }

    /**
     * Using unnamed variables in catch blocks
     * When we don't need exception details
     * Note: In Java 22+, you would use _ for unused exception variables
     */
    public boolean safeOperation(Runnable operation) {
        // Java 22+ syntax would be: catch (Exception _)
        // Java 17 compatible version:
        try {
            operation.run();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Traditional approach without unnamed variables for comparison
     */
    public String extractNameOldWay(Object obj) {
        if (obj instanceof Person p) {
            return p.name();
        }
        return "Unknown";
    }

    /**
     * Demonstrating nested unnamed patterns
     * Note: In Java 22+, nested pattern matching would use _ for unused components
     */
    public record Container(Point point, String label) {}

    public String processContainer(Object obj) {
        // Java 22+ syntax would be: if (obj instanceof Container(Point(int x, int _), String _))
        // Java 17 compatible version:
        if (obj instanceof Container c) {
            return "X coordinate in container: " + c.point().x();
        }
        return "Not a Container";
    }
}
