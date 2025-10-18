package com.javaevolution.primitivetypes;

/**
 * Demonstrates Primitive Types in Patterns, instanceof, and switch (JEP 455)
 * introduced as a preview feature in Java 23.
 * 
 * This feature extends pattern matching to work seamlessly with primitive types,
 * allowing direct matching and extraction of primitive values in instanceof and switch.
 * 
 * Note: Running on Java 17, so these are conceptual examples showing the intended behavior.
 */
public class PrimitiveTypesExample {

    /**
     * Example record to demonstrate primitive pattern matching
     */
    public record Measurement(double value, String unit) {}

    /**
     * Example: Pattern matching with primitive types in instanceof
     * Demonstrates how primitive patterns work with Object wrappers
     */
    public String describePrimitive(Object obj) {
        // In Java 23+, this would work directly with primitives
        if (obj instanceof Integer i) {
            return "Integer value: " + i;
        } else if (obj instanceof Long l) {
            return "Long value: " + l;
        } else if (obj instanceof Double d) {
            return "Double value: " + d;
        } else if (obj instanceof Float f) {
            return "Float value: " + f;
        } else if (obj instanceof Boolean b) {
            return "Boolean value: " + b;
        }
        return "Unknown type";
    }

    /**
     * Example: Switch expressions with primitive types
     * Shows pattern matching in switch with primitives
     * Note: In Java 23+, this would use pattern matching with guards
     */
    public String classifyNumber(Object obj) {
        // Java 23+ would use: case Integer i when i > 0 -> ...
        // Java 17 compatible version:
        if (obj == null) {
            return "Null value";
        } else if (obj instanceof Integer i) {
            if (i > 0) return "Positive integer: " + i;
            if (i < 0) return "Negative integer: " + i;
            return "Zero";
        } else if (obj instanceof Long l) {
            if (l > 0L) return "Positive long: " + l;
            return "Non-positive long: " + l;
        } else if (obj instanceof Double d) {
            if (d > 0.0) return "Positive double: " + d;
            return "Non-positive double: " + d;
        }
        return "Not a number";
    }

    /**
     * Example: Primitive conversion and narrowing
     * Demonstrates type conversions with pattern matching
     * Note: In Java 23+, this would use switch with type patterns
     */
    public int extractAsInt(Object obj) {
        // Java 23+ would use: switch with case Integer i -> i
        // Java 17 compatible version:
        if (obj instanceof Integer i) return i;
        if (obj instanceof Long l) return l.intValue();
        if (obj instanceof Double d) return d.intValue();
        if (obj instanceof Float f) return f.intValue();
        if (obj instanceof String s) return Integer.parseInt(s);
        return 0;
    }

    /**
     * Example: Range checking with primitive patterns
     * Shows guard patterns with primitives
     * Note: In Java 23+, this would use switch with guards (when clauses)
     */
    public String checkRange(Number num) {
        // Java 23+ would use: case Integer i when i >= 0 && i < 10 -> ...
        // Java 17 compatible version:
        if (num instanceof Integer i) {
            if (i >= 0 && i < 10) return "Single digit: " + i;
            if (i >= 10 && i < 100) return "Double digit: " + i;
            return "Large integer: " + i;
        } else if (num instanceof Long l) {
            if (l < 1000L) return "Small long: " + l;
            return "Large long: " + l;
        } else if (num instanceof Double d) {
            if (Math.abs(d) < 1.0) return "Fraction: " + d;
            return "Large double: " + d;
        }
        return "Other number type: " + num;
    }

    /**
     * Example: Primitive patterns with records
     * Demonstrates extracting primitives from record components
     * Note: In Java 23+, record deconstruction would be used
     */
    public String describeMeasurement(Object obj) {
        // Java 23+ would use: if (obj instanceof Measurement(double value, String unit))
        // Java 17 compatible version:
        if (obj instanceof Measurement m) {
            double value = m.value();
            String unit = m.unit();
            if (value < 0) {
                return "Negative " + unit + ": " + value;
            } else if (value == 0) {
                return "Zero " + unit;
            } else {
                return "Positive " + unit + ": " + value;
            }
        }
        return "Not a measurement";
    }

    /**
     * Example: Boolean pattern matching
     * Shows pattern matching with boolean primitives
     * Note: In Java 23+, this would use switch with pattern guards
     */
    public String evaluateBoolean(Object obj) {
        // Java 23+ would use: case Boolean b when b -> "True value"
        // Java 17 compatible version:
        if (obj == null) return "Null boolean";
        if (obj instanceof Boolean b) {
            return b ? "True value" : "False value";
        }
        return "Not a boolean";
    }

    /**
     * Example: Character pattern matching
     * Demonstrates patterns with char primitives
     * Note: In Java 23+, this would use switch with character patterns
     */
    public String classifyCharacter(Object obj) {
        // Java 23+ would use: case Character c when Character.isDigit(c) -> ...
        // Java 17 compatible version:
        if (obj == null) return "Null character";
        if (obj instanceof Character c) {
            if (Character.isDigit(c)) return "Digit: " + c;
            if (Character.isLetter(c)) return "Letter: " + c;
            if (Character.isWhitespace(c)) return "Whitespace";
            return "Special character: " + c;
        }
        return "Not a character";
    }

    /**
     * Example: Byte and Short pattern matching
     * Shows patterns with smaller primitive types
     * Note: In Java 23+, this would use switch with byte/short patterns
     */
    public String classifySmallNumber(Object obj) {
        // Java 23+ would use: case Byte b when b > 0 -> ...
        // Java 17 compatible version:
        if (obj instanceof Byte b) {
            return b > 0 ? "Positive byte: " + b : "Non-positive byte: " + b;
        } else if (obj instanceof Short s) {
            return s > 0 ? "Positive short: " + s : "Non-positive short: " + s;
        }
        return "Not a byte or short";
    }

    /**
     * Example: Combining multiple primitive checks
     * Complex pattern matching with multiple primitive types
     * Note: In Java 23+, this would use advanced switch with multiple patterns
     */
    public String analyzeValue(Object obj) {
        // Java 23+ would use sophisticated pattern matching
        // Java 17 compatible version:
        if (obj == null) return "Null value";
        if (obj instanceof Integer i) {
            if (i == 0) return "Zero integer";
            if (i > 100) return "Large integer";
            return "Small positive number";
        } else if (obj instanceof Long l) {
            if (l == 0L) return "Zero long";
            if (l > 100L) return "Large long";
            return "Small positive number";
        } else if (obj instanceof Double d) {
            if (d == 0.0) return "Zero double";
            if (d > 100.0) return "Large double";
            return "Small positive number";
        } else if (obj instanceof Float f) {
            if (f == 0.0f) return "Zero float";
            return "Small positive number";
        }
        return "Non-numeric or negative";
    }

    /**
     * Example: Primitive patterns in method parameters
     * Shows how pattern matching simplifies value extraction
     * Note: In Java 23+, this would use switch with type patterns
     */
    public double calculateSum(Object... values) {
        // Java 23+ would use: switch (value) { case Integer i -> i.doubleValue() }
        // Java 17 compatible version:
        double sum = 0.0;
        for (Object value : values) {
            if (value instanceof Integer i) {
                sum += i.doubleValue();
            } else if (value instanceof Long l) {
                sum += l.doubleValue();
            } else if (value instanceof Double d) {
                sum += d;
            } else if (value instanceof Float f) {
                sum += f.doubleValue();
            }
        }
        return sum;
    }

    /**
     * Traditional approach without primitive patterns for comparison
     */
    public String describePrimitiveOldWay(Object obj) {
        if (obj instanceof Integer) {
            Integer i = (Integer) obj;
            return "Integer value: " + i;
        } else if (obj instanceof Long) {
            Long l = (Long) obj;
            return "Long value: " + l;
        } else if (obj instanceof Double) {
            Double d = (Double) obj;
            return "Double value: " + d;
        }
        return "Unknown type";
    }
}
