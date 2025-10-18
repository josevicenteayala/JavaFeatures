package com.javaevolution.optional;

import java.util.Optional;

/**
 * Demonstrates advanced usage of Optional class including map, flatMap, and filter operations.
 */
public class OptionalAdvancedExample {

    /**
     * Transforms Optional value using map.
     */
    public Optional<Integer> mapToLength(Optional<String> optional) {
        return optional.map(String::length);
    }

    /**
     * Transforms Optional value using flatMap.
     */
    public Optional<String> flatMapExample(Optional<String> optional) {
        return optional.flatMap(this::findByName);
    }

    private Optional<String> findByName(String name) {
        // Simulated database lookup
        return name.equals("John") ? Optional.of("John Doe") : Optional.empty();
    }

    /**
     * Filters Optional based on a predicate.
     */
    public Optional<String> filterExample(Optional<String> optional) {
        return optional.filter(value -> value.length() > 5);
    }

    /**
     * Chains multiple Optional operations.
     */
    public String processUser(Optional<User> userOptional) {
        return userOptional
                .filter(user -> user.getAge() >= 18)
                .map(User::getName)
                .map(String::toUpperCase)
                .orElse("UNKNOWN");
    }

    /**
     * Demonstrates ifPresent for side effects.
     */
    public void printIfPresent(Optional<String> optional) {
        optional.ifPresent(System.out::println);
    }

    /**
     * Simple User class for demonstration.
     */
    public static class User {
        private final String name;
        private final int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
