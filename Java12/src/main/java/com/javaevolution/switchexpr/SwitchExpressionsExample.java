package com.javaevolution.switchexpr;

/**
 * Demonstrates Switch Expressions introduced in Java 12 (Preview) and standardized in Java 14.
 * Switch expressions allow switch to be used as an expression that returns a value.
 */
public class SwitchExpressionsExample {

    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    /**
     * Traditional switch statement (pre-Java 12)
     */
    public String traditionalSwitch(Day day) {
        String result;
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                result = "6 letters";
                break;
            case TUESDAY:
                result = "7 letters";
                break;
            case THURSDAY:
            case SATURDAY:
                result = "8 letters";
                break;
            case WEDNESDAY:
                result = "9 letters";
                break;
            default:
                throw new IllegalStateException("Invalid day: " + day);
        }
        return result;
    }

    /**
     * Modern switch expression with arrow syntax
     */
    public String switchExpression(Day day) {
        return switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> "6 letters";
            case TUESDAY -> "7 letters";
            case THURSDAY, SATURDAY -> "8 letters";
            case WEDNESDAY -> "9 letters";
        };
    }

    /**
     * Switch expression with yield (for complex logic)
     */
    public int calculateValue(String operator, int a, int b) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                yield a / b;
            }
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };
    }

    /**
     * Switch expression for type checking (requires Java 17+)
     * This is commented out as it requires preview features
     */
    /*
    public Object getTypeInfo(Object obj) {
        return switch (obj) {
            case Integer i -> "Integer with value: " + i;
            case String s -> "String with length: " + s.length();
            case null -> "null value";
            default -> "Unknown type: " + obj.getClass().getSimpleName();
        };
    }
    */

    /**
     * Switch expression with enum
     */
    public String getDayType(Day day) {
        return switch (day) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Weekday";
            case SATURDAY, SUNDAY -> "Weekend";
        };
    }

    /**
     * Switch expression for categorization
     */
    public String categorizeNumber(int number) {
        return switch (number) {
            case 0 -> "Zero";
            case 1, 2, 3, 4, 5 -> "Small";
            case 6, 7, 8, 9, 10 -> "Medium";
            default -> number > 10 ? "Large" : "Negative";
        };
    }

    /**
     * Switch expression with multiple statements
     */
    public String processDay(Day day) {
        return switch (day) {
            case MONDAY -> {
                String message = "Start of work week";
                yield message.toUpperCase();
            }
            case FRIDAY -> {
                String message = "End of work week";
                yield message.toUpperCase();
            }
            case SATURDAY, SUNDAY -> {
                String message = "Weekend";
                yield message.toLowerCase();
            }
            default -> "Regular day";
        };
    }
}
