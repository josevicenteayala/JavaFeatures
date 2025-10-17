package com.javaevolution.patternmatching;

/**
 * Demonstrates Pattern Matching for instanceof introduced in Java 14 (Preview) and standardized in Java 16.
 * Pattern matching eliminates the need for explicit casting after instanceof check.
 */
public class PatternMatchingExample {

    /**
     * Traditional instanceof with casting (pre-Java 14)
     */
    public String traditionalInstanceOf(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            return "String of length: " + str.length();
        }
        return "Not a string";
    }

    /**
     * Pattern matching for instanceof
     */
    public String patternMatchingInstanceOf(Object obj) {
        if (obj instanceof String str) {
            return "String of length: " + str.length();
        }
        return "Not a string";
    }

    /**
     * Pattern matching with multiple checks
     */
    public String identifyType(Object obj) {
        if (obj instanceof String str) {
            return "String: " + str.toUpperCase();
        } else if (obj instanceof Integer num) {
            return "Integer: " + (num * 2);
        } else if (obj instanceof Double dbl) {
            return "Double: " + String.format("%.2f", dbl);
        }
        return "Unknown type";
    }

    /**
     * Pattern matching in complex conditions
     */
    public boolean isLongString(Object obj) {
        return obj instanceof String str && str.length() > 10;
    }

    /**
     * Pattern matching with negation
     */
    public String checkNotString(Object obj) {
        if (!(obj instanceof String str)) {
            return "Not a string";
        }
        return "String: " + str;
    }

    /**
     * Pattern matching in expressions
     */
    public int getLength(Object obj) {
        return obj instanceof String str ? str.length() : 0;
    }

    /**
     * Pattern matching with custom classes
     */
    static class Shape {}
    static class Circle extends Shape {
        private final double radius;
        public Circle(double radius) { this.radius = radius; }
        public double getRadius() { return radius; }
    }
    static class Rectangle extends Shape {
        private final double width;
        private final double height;
        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }
        public double getWidth() { return width; }
        public double getHeight() { return height; }
    }

    public double calculateArea(Shape shape) {
        if (shape instanceof Circle circle) {
            return Math.PI * circle.getRadius() * circle.getRadius();
        } else if (shape instanceof Rectangle rect) {
            return rect.getWidth() * rect.getHeight();
        }
        return 0;
    }

    /**
     * Pattern matching in switch-like logic
     */
    public String processValue(Object value) {
        String result;
        if (value instanceof Integer num && num > 0) {
            result = "Positive integer: " + num;
        } else if (value instanceof Integer num && num < 0) {
            result = "Negative integer: " + num;
        } else if (value instanceof String str && !str.isEmpty()) {
            result = "Non-empty string: " + str;
        } else {
            result = "Other value";
        }
        return result;
    }

    /**
     * Pattern matching reduces boilerplate
     */
    public String compareTraditionalVsPattern(Object obj) {
        // Traditional approach would require:
        // 1. instanceof check
        // 2. Explicit cast
        // 3. Use the casted variable

        // Pattern matching combines all three steps
        if (obj instanceof String str) {
            return str.toLowerCase();
        }
        return "";
    }
}
