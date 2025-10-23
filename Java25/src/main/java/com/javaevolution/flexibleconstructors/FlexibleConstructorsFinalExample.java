package com.javaevolution.flexibleconstructors;

import java.util.*;

/**
 * Demonstrates Flexible Constructor Bodies (Expected Final in Java 25).
 * 
 * After three preview rounds in Java 22-24, this feature allows statements
 * before explicit constructor invocations (super() or this()), providing
 * more flexibility in constructor initialization.
 * 
 * Benefits:
 * - Validation before super() call
 * - Argument preprocessing
 * - Complex initialization logic
 * - Cleaner constructor code
 * 
 * Note: Running on Java 17, these examples show the concept using helper methods.
 * In Java 25+, the validation/preprocessing would happen directly before super().
 */
public class FlexibleConstructorsFinalExample {

    /**
     * Example 1: Validation before super() call
     */
    public static class PositiveNumber extends Number {
        private final long value;

        public PositiveNumber(long value) {
            // Java 25+: validation before super()
            // if (value <= 0) throw new IllegalArgumentException("Must be positive");
            // super();
            this.value = validatePositive(value);
        }

        private static long validatePositive(long value) {
            if (value <= 0) {
                throw new IllegalArgumentException("Value must be positive");
            }
            return value;
        }

        public long getValue() {
            return value;
        }

        @Override
        public int intValue() {
            return (int) value;
        }

        @Override
        public long longValue() {
            return value;
        }

        @Override
        public float floatValue() {
            return value;
        }

        @Override
        public double doubleValue() {
            return value;
        }
    }

    /**
     * Example 2: Argument preprocessing
     */
    public static class NormalizedString {
        private final String value;

        public NormalizedString(String input) {
            // Java 25+: normalization before super()
            this.value = normalizeInput(input);
        }

        private static String normalizeInput(String input) {
            if (input == null) return "";
            return input.trim().toLowerCase();
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * Example 3: Complex validation with multiple fields
     */
    public static class Rectangle {
        private final double width;
        private final double height;

        public Rectangle(double width, double height) {
            // Java 25+: multi-field validation before super()
            validateDimensions(width, height);
            this.width = width;
            this.height = height;
        }

        private static void validateDimensions(double width, double height) {
            if (width <= 0 || height <= 0) {
                throw new IllegalArgumentException("Dimensions must be positive");
            }
            if (width > 10000 || height > 10000) {
                throw new IllegalArgumentException("Dimensions too large");
            }
        }

        public double area() {
            return width * height;
        }
    }

    /**
     * Example 4: Conditional constructor delegation
     */
    public static class SmartList<T> extends ArrayList<T> {
        
        public SmartList(int capacity) {
            super(validateCapacity(capacity));
        }

        public SmartList(List<T> items) {
            super(validateList(items));
        }

        private static int validateCapacity(int capacity) {
            if (capacity < 0) {
                throw new IllegalArgumentException("Capacity must be non-negative");
            }
            return Math.max(capacity, 10);
        }

        private static <T> List<T> validateList(List<T> items) {
            if (items == null) {
                return List.of();
            }
            return new ArrayList<>(items);
        }
    }

    /**
     * Example 5: Range validation
     */
    public static class BoundedInteger {
        private final int value;
        private final int min;
        private final int max;

        public BoundedInteger(int value, int min, int max) {
            // Java 25+: validate before super()
            validateRange(value, min, max);
            this.value = value;
            this.min = min;
            this.max = max;
        }

        private static void validateRange(int value, int min, int max) {
            if (min > max) {
                throw new IllegalArgumentException("min must be <= max");
            }
            if (value < min || value > max) {
                throw new IllegalArgumentException(
                    String.format("Value %d outside range [%d, %d]", value, min, max)
                );
            }
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * Example 6: Builder pattern integration
     */
    public static class Person {
        private final String firstName;
        private final String lastName;
        private final int age;
        private final String email;

        private Person(String firstName, String lastName, int age, String email) {
            // Java 25+: validation before super()
            validatePerson(firstName, lastName, age, email);
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.email = email;
        }

        private static void validatePerson(String firstName, String lastName, int age, String email) {
            if (firstName == null || firstName.isEmpty()) {
                throw new IllegalArgumentException("First name required");
            }
            if (lastName == null || lastName.isEmpty()) {
                throw new IllegalArgumentException("Last name required");
            }
            if (age < 0 || age > 150) {
                throw new IllegalArgumentException("Invalid age");
            }
            if (email != null && !email.contains("@")) {
                throw new IllegalArgumentException("Invalid email");
            }
        }

        public static class Builder {
            private String firstName;
            private String lastName;
            private int age;
            private String email;

            public Builder firstName(String firstName) {
                this.firstName = firstName;
                return this;
            }

            public Builder lastName(String lastName) {
                this.lastName = lastName;
                return this;
            }

            public Builder age(int age) {
                this.age = age;
                return this;
            }

            public Builder email(String email) {
                this.email = email;
                return this;
            }

            public Person build() {
                return new Person(firstName, lastName, age, email);
            }
        }

        public String getFullName() {
            return firstName + " " + lastName;
        }

        public int getAge() {
            return age;
        }

        public String getEmail() {
            return email;
        }
    }

    /**
     * Example 7: Secure initialization
     */
    public static class SecurePassword {
        private final char[] password;

        public SecurePassword(String input) {
            // Java 25+: validation before super()
            validatePasswordStrength(input);
            this.password = input.toCharArray();
        }

        private static void validatePasswordStrength(String password) {
            if (password == null || password.length() < 8) {
                throw new IllegalArgumentException("Password must be at least 8 characters");
            }
            if (!password.matches(".*[A-Z].*")) {
                throw new IllegalArgumentException("Password must contain uppercase letter");
            }
            if (!password.matches(".*[0-9].*")) {
                throw new IllegalArgumentException("Password must contain digit");
            }
        }

        public boolean verify(String input) {
            if (input == null) return false;
            char[] inputChars = input.toCharArray();
            if (inputChars.length != password.length) return false;
            for (int i = 0; i < password.length; i++) {
                if (inputChars[i] != password[i]) return false;
            }
            return true;
        }

        public void clear() {
            Arrays.fill(password, '\0');
        }
    }

    /**
     * Example 8: Immutable collection initialization
     */
    public static class ImmutableConfiguration {
        private final Map<String, String> properties;

        public ImmutableConfiguration(Map<String, String> props) {
            // Java 25+: validation and copying before super()
            this.properties = Map.copyOf(validateAndNormalize(props));
        }

        private static Map<String, String> validateAndNormalize(Map<String, String> props) {
            if (props == null || props.isEmpty()) {
                throw new IllegalArgumentException("Properties cannot be empty");
            }
            Map<String, String> normalized = new HashMap<>();
            for (Map.Entry<String, String> entry : props.entrySet()) {
                if (entry.getKey() == null || entry.getKey().isEmpty()) {
                    throw new IllegalArgumentException("Property key cannot be empty");
                }
                normalized.put(entry.getKey().toLowerCase(), entry.getValue());
            }
            return normalized;
        }

        public String getProperty(String key) {
            return properties.get(key.toLowerCase());
        }

        public Map<String, String> getAllProperties() {
            return properties;
        }
    }
}
