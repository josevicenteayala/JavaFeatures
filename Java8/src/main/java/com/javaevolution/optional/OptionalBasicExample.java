package com.javaevolution.optional;

import java.util.Optional;

/**
 * Demonstrates the basic usage of Optional class in Java 8.
 * Optional is a container object used to contain not-null objects and helps avoid NullPointerExceptions.
 */
public class OptionalBasicExample {

    /**
     * Creates an Optional with a value.
     */
    public Optional<String> createOptionalWithValue(String value) {
        return Optional.of(value);
    }

    /**
     * Creates an Optional that may or may not have a value.
     */
    public Optional<String> createOptionalNullable(String value) {
        return Optional.ofNullable(value);
    }

    /**
     * Creates an empty Optional.
     */
    public Optional<String> createEmptyOptional() {
        return Optional.empty();
    }

    /**
     * Checks if Optional has a value.
     */
    public boolean isPresent(Optional<String> optional) {
        return optional.isPresent();
    }

    /**
     * Gets the value from Optional or throws exception if empty.
     */
    public String getValue(Optional<String> optional) {
        return optional.get();
    }

    /**
     * Gets the value from Optional or returns a default value if empty.
     */
    public String getOrDefault(Optional<String> optional, String defaultValue) {
        return optional.orElse(defaultValue);
    }

    /**
     * Gets the value from Optional or returns a value from supplier if empty.
     */
    public String getOrElseGet(Optional<String> optional) {
        return optional.orElseGet(() -> "Default from supplier");
    }

    /**
     * Gets the value from Optional or throws custom exception if empty.
     */
    public String getOrElseThrow(Optional<String> optional) {
        return optional.orElseThrow(() -> new IllegalStateException("Value not present"));
    }
}
