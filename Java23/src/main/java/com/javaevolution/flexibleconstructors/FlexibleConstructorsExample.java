package com.javaevolution.flexibleconstructors;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates Flexible Constructor Bodies (JEP 482) introduced as a
 * second preview feature in Java 23.
 * 
 * This feature allows statements to appear before explicit constructor
 * invocations (super() or this()), providing more flexibility in
 * constructor initialization.
 * 
 * Note: Running on Java 17, so these examples show the concept and benefits.
 */
public class FlexibleConstructorsExample {

    /**
     * Example: Validation before super() call
     * Traditional approach requires this pattern with factory methods or helper methods
     */
    public static class PositiveNumber extends Number {
        private final long value;

        // In Java 23+, validation can happen before super()
        public PositiveNumber(long value) {
            // Conceptually, this is where validation would go in Java 23+
            // if (value <= 0) throw new IllegalArgumentException("Value must be positive");
            this.value = validatePositive(value);
        }

        private static long validatePositive(long value) {
            if (value <= 0) {
                throw new IllegalArgumentException("Value must be positive");
            }
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
     * Example: Pre-processing arguments before super() call
     */
    public static class NormalizedString {
        private final String value;

        public NormalizedString(String input) {
            // In Java 23+, normalization could happen before super()
            this.value = normalizeInput(input);
        }

        private static String normalizeInput(String input) {
            if (input == null) {
                return "";
            }
            return input.trim().toLowerCase();
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * Example: Conditional constructor delegation
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
            return Math.max(capacity, 10); // Minimum capacity of 10
        }

        private static <T> List<T> validateList(List<T> items) {
            if (items == null) {
                throw new IllegalArgumentException("List cannot be null");
            }
            return items;
        }
    }

    /**
     * Example: Complex initialization logic
     */
    public static class ConfiguredService {
        private final String endpoint;
        private final int timeout;
        private final boolean ssl;

        public ConfiguredService(String rawEndpoint, int rawTimeout) {
            // In Java 23+, this logic could be before super()
            this.endpoint = processEndpoint(rawEndpoint);
            this.timeout = processTimeout(rawTimeout);
            this.ssl = determineSsl(rawEndpoint);
        }

        private static String processEndpoint(String raw) {
            if (raw == null || raw.isEmpty()) {
                return "localhost";
            }
            return raw.replaceAll("^(http://|https://)", "");
        }

        private static int processTimeout(int timeout) {
            if (timeout <= 0) {
                return 30000; // Default 30 seconds
            }
            return Math.min(timeout, 300000); // Max 5 minutes
        }

        private static boolean determineSsl(String endpoint) {
            return endpoint != null && endpoint.startsWith("https://");
        }

        public String getEndpoint() {
            return endpoint;
        }

        public int getTimeout() {
            return timeout;
        }

        public boolean isSsl() {
            return ssl;
        }
    }

    /**
     * Example: Sharing validation logic across constructors
     */
    public static class BoundedValue {
        private final double value;
        private final double min;
        private final double max;

        public BoundedValue(double value, double min, double max) {
            validateBounds(min, max);
            this.min = min;
            this.max = max;
            this.value = clamp(value, min, max);
        }

        public BoundedValue(double value, double max) {
            this(value, 0.0, max);
        }

        private static void validateBounds(double min, double max) {
            if (min > max) {
                throw new IllegalArgumentException("Min must be <= max");
            }
        }

        private static double clamp(double value, double min, double max) {
            return Math.max(min, Math.min(max, value));
        }

        public double getValue() {
            return value;
        }

        public double getMin() {
            return min;
        }

        public double getMax() {
            return max;
        }
    }

    /**
     * Example: Logging and debugging before construction
     * Shows how pre-super() statements can aid debugging
     */
    public static class AuditedObject {
        private final String id;
        private final long createdAt;

        public AuditedObject(String id) {
            // In Java 23+, logging could happen before super()
            long timestamp = System.currentTimeMillis();
            String processedId = processId(id, timestamp);
            
            this.id = processedId;
            this.createdAt = timestamp;
        }

        private static String processId(String id, long timestamp) {
            if (id == null || id.isEmpty()) {
                return "AUTO_" + timestamp;
            }
            // Log creation (in real code)
            return id;
        }

        public String getId() {
            return id;
        }

        public long getCreatedAt() {
            return createdAt;
        }
    }

    /**
     * Example: Builder pattern integration
     */
    public static class Person {
        private final String firstName;
        private final String lastName;
        private final int age;

        private Person(Builder builder) {
            this.firstName = validateNotEmpty(builder.firstName, "First name");
            this.lastName = validateNotEmpty(builder.lastName, "Last name");
            this.age = validateAge(builder.age);
        }

        private static String validateNotEmpty(String value, String fieldName) {
            if (value == null || value.isEmpty()) {
                throw new IllegalArgumentException(fieldName + " cannot be empty");
            }
            return value;
        }

        private static int validateAge(int age) {
            if (age < 0 || age > 150) {
                throw new IllegalArgumentException("Invalid age: " + age);
            }
            return age;
        }

        public static class Builder {
            private String firstName;
            private String lastName;
            private int age;

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

            public Person build() {
                return new Person(this);
            }
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }
    }
}
