package com.javaevolution.primitivetypes;

/**
 * Demonstrates Primitive Types in Patterns (Expected Final in Java 25).
 * 
 * After two preview rounds in Java 23-24, this feature extends pattern matching
 * to work seamlessly with primitive types, allowing direct matching and extraction
 * of primitive values in instanceof and switch expressions.
 * 
 * Benefits:
 * - No manual unboxing required
 * - More efficient pattern matching
 * - Cleaner, more readable code
 * - Seamless primitive-object integration
 * 
 * Note: Running on Java 17, these examples show the concept using traditional
 * instanceof checks. In Java 25+, pattern matching works directly with primitives.
 */
public class PrimitiveTypesFinalExample {

    /**
     * Example record types for demonstrations
     */
    public record Measurement(double value, String unit) {}
    public record Point(int x, int y) {}
    public record Score(float value, int maxScore) {}

    /**
     * Example 1: Pattern matching with Integer
     */
    public String classifyInteger(Object obj) {
        // Java 25+: case Integer i when i > 0 -> "Positive"
        if (obj instanceof Integer i) {
            if (i > 0) return "Positive integer: " + i;
            if (i < 0) return "Negative integer: " + i;
            return "Zero";
        }
        return "Not an integer";
    }

    /**
     * Example 2: Pattern matching with Long
     */
    public String describeLong(Object obj) {
        if (obj instanceof Long l) {
            if (l < 1000L) return "Small long: " + l;
            if (l < 1000000L) return "Medium long: " + l;
            return "Large long: " + l;
        }
        return "Not a long";
    }

    /**
     * Example 3: Pattern matching with Double
     */
    public String classifyDouble(Object obj) {
        if (obj instanceof Double d) {
            if (Math.abs(d) < 1.0) return "Fraction: " + d;
            if (d.isInfinite()) return "Infinite";
            if (d.isNaN()) return "Not a Number";
            return "Regular double: " + d;
        }
        return "Not a double";
    }

    /**
     * Example 4: Pattern matching with Float
     */
    public String analyzeFloat(Object obj) {
        if (obj instanceof Float f) {
            if (f >= 0.0f && f <= 1.0f) return "Normalized: " + f;
            if (f < 0.0f) return "Negative: " + f;
            return "Greater than one: " + f;
        }
        return "Not a float";
    }

    /**
     * Example 5: Pattern matching with Boolean
     */
    public String describeBoolean(Object obj) {
        if (obj instanceof Boolean b) {
            return b ? "True value" : "False value";
        }
        return "Not a boolean";
    }

    /**
     * Example 6: Pattern matching with Character
     */
    public String classifyCharacter(Object obj) {
        if (obj instanceof Character c) {
            if (Character.isDigit(c)) return "Digit: " + c;
            if (Character.isLetter(c)) return "Letter: " + c;
            if (Character.isWhitespace(c)) return "Whitespace";
            return "Special character: " + c;
        }
        return "Not a character";
    }

    /**
     * Example 7: Pattern matching with Byte and Short
     */
    public String describeSmallNumber(Object obj) {
        if (obj instanceof Byte b) {
            return "Byte value: " + b + " (8-bit)";
        } else if (obj instanceof Short s) {
            return "Short value: " + s + " (16-bit)";
        }
        return "Not a byte or short";
    }

    /**
     * Example 8: Range checking with guards
     */
    public String checkRange(Number num) {
        // Java 25+: case Integer i when i >= 0 && i < 10 -> "Single digit"
        if (num instanceof Integer i) {
            if (i >= 0 && i < 10) return "Single digit: " + i;
            if (i >= 10 && i < 100) return "Double digit: " + i;
            if (i >= 100 && i < 1000) return "Triple digit: " + i;
            return "Large number: " + i;
        } else if (num instanceof Long l) {
            if (l < 1000L) return "Small long: " + l;
            return "Large long: " + l;
        } else if (num instanceof Double d) {
            if (Math.abs(d) < 1.0) return "Fraction: " + d;
            return "Large double: " + d;
        }
        return "Other number type";
    }

    /**
     * Example 9: Type conversion with patterns
     */
    public int extractAsInt(Object obj) {
        // Java 25+: switch pattern matching with primitives
        if (obj instanceof Integer i) return i;
        if (obj instanceof Long l) return l.intValue();
        if (obj instanceof Double d) return d.intValue();
        if (obj instanceof Float f) return f.intValue();
        if (obj instanceof String s) {
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        return 0;
    }

    /**
     * Example 10: Mathematical operations with pattern matching
     */
    public double performMathOperation(Object a, Object b, String operation) {
        double aVal = extractAsDouble(a);
        double bVal = extractAsDouble(b);
        
        return switch (operation) {
            case "add" -> aVal + bVal;
            case "subtract" -> aVal - bVal;
            case "multiply" -> aVal * bVal;
            case "divide" -> bVal != 0 ? aVal / bVal : Double.NaN;
            default -> throw new IllegalArgumentException("Unknown operation: " + operation);
        };
    }

    private double extractAsDouble(Object obj) {
        if (obj instanceof Double d) return d;
        if (obj instanceof Float f) return f.doubleValue();
        if (obj instanceof Integer i) return i.doubleValue();
        if (obj instanceof Long l) return l.doubleValue();
        if (obj instanceof String s) {
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                return 0.0;
            }
        }
        return 0.0;
    }

    /**
     * Example 11: Record patterns with primitives
     */
    public String analyzeMeasurement(Object obj) {
        if (obj instanceof Measurement m) {
            double value = m.value();
            if (value < 0) return "Negative measurement: " + m;
            if (value == 0) return "Zero measurement: " + m;
            return "Positive measurement: " + value + " " + m.unit();
        }
        return "Not a measurement";
    }

    /**
     * Example 12: Point coordinate analysis
     */
    public String analyzePoint(Object obj) {
        if (obj instanceof Point p) {
            int x = p.x();
            int y = p.y();
            
            if (x == 0 && y == 0) return "Origin";
            if (x > 0 && y > 0) return "Quadrant I";
            if (x < 0 && y > 0) return "Quadrant II";
            if (x < 0 && y < 0) return "Quadrant III";
            if (x > 0 && y < 0) return "Quadrant IV";
            if (x == 0) return "On Y-axis";
            return "On X-axis";
        }
        return "Not a point";
    }

    /**
     * Example 13: Score normalization
     */
    public String normalizeScore(Object obj) {
        if (obj instanceof Score s) {
            float value = s.value();
            int max = s.maxScore();
            
            float percentage = (value / max) * 100;
            
            if (percentage >= 90) return "A (Excellent)";
            if (percentage >= 80) return "B (Good)";
            if (percentage >= 70) return "C (Average)";
            if (percentage >= 60) return "D (Below Average)";
            return "F (Failing)";
        }
        return "Not a score";
    }

    /**
     * Example 14: Primitive array patterns (conceptual)
     */
    public String analyzeArray(Object obj) {
        if (obj instanceof int[] arr) {
            if (arr.length == 0) return "Empty int array";
            int sum = 0;
            for (int val : arr) sum += val;
            return "Int array with sum: " + sum;
        } else if (obj instanceof double[] arr) {
            if (arr.length == 0) return "Empty double array";
            double sum = 0.0;
            for (double val : arr) sum += val;
            return "Double array with sum: " + sum;
        } else if (obj instanceof boolean[] arr) {
            int trueCount = 0;
            for (boolean val : arr) if (val) trueCount++;
            return "Boolean array: " + trueCount + " true values";
        }
        return "Not a primitive array";
    }

    /**
     * Example 15: Numeric comparison with patterns
     */
    public int compareNumbers(Object a, Object b) {
        double aVal = extractAsDouble(a);
        double bVal = extractAsDouble(b);
        return Double.compare(aVal, bVal);
    }

    /**
     * Example 16: Type-specific formatting
     */
    public String formatNumber(Object obj) {
        if (obj instanceof Integer i) {
            return String.format("Integer: %,d", i);
        } else if (obj instanceof Long l) {
            return String.format("Long: %,d", l);
        } else if (obj instanceof Double d) {
            return String.format("Double: %.2f", d);
        } else if (obj instanceof Float f) {
            return String.format("Float: %.2f", f);
        }
        return "Not a number";
    }

    /**
     * Example 17: Null-safe primitive extraction
     */
    public int safeExtractInt(Object obj, int defaultValue) {
        if (obj == null) return defaultValue;
        if (obj instanceof Integer i) return i;
        if (obj instanceof Number n) return n.intValue();
        return defaultValue;
    }

    /**
     * Example 18: Boxed vs unboxed handling
     */
    public String describeBoxing(Object obj) {
        if (obj instanceof Integer i) {
            // In Java 25+, can pattern match directly on primitive int
            return "Boxed integer: " + i + " (auto-unboxing to: " + i.intValue() + ")";
        }
        return "Not an Integer wrapper";
    }
}
