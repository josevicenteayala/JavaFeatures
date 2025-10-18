package com.javaevolution.optional;

import org.junit.jupiter.api.Test;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OptionalBasicExampleTest {

    private final OptionalBasicExample example = new OptionalBasicExample();

    @Test
    void createOptionalWithValue_shouldContainValue() {
        Optional<String> optional = example.createOptionalWithValue("Hello");
        assertTrue(optional.isPresent());
        assertEquals("Hello", optional.get());
    }

    @Test
    void createOptionalWithValue_givenNull_shouldThrowException() {
        assertThrows(NullPointerException.class, () -> example.createOptionalWithValue(null));
    }

    @Test
    void createOptionalNullable_givenNull_shouldBeEmpty() {
        Optional<String> optional = example.createOptionalNullable(null);
        assertFalse(optional.isPresent());
    }

    @Test
    void createOptionalNullable_givenValue_shouldContainValue() {
        Optional<String> optional = example.createOptionalNullable("Hello");
        assertTrue(optional.isPresent());
        assertEquals("Hello", optional.get());
    }

    @Test
    void createEmptyOptional_shouldBeEmpty() {
        Optional<String> optional = example.createEmptyOptional();
        assertFalse(optional.isPresent());
    }

    @Test
    void isPresent_givenEmptyOptional_shouldReturnFalse() {
        Optional<String> optional = Optional.empty();
        assertFalse(example.isPresent(optional));
    }

    @Test
    void isPresent_givenOptionalWithValue_shouldReturnTrue() {
        Optional<String> optional = Optional.of("value");
        assertTrue(example.isPresent(optional));
    }

    @Test
    void getValue_givenEmptyOptional_shouldThrowException() {
        Optional<String> optional = Optional.empty();
        assertThrows(java.util.NoSuchElementException.class, () -> example.getValue(optional));
    }

    @Test
    void getValue_givenOptionalWithValue_shouldReturnValue() {
        Optional<String> optional = Optional.of("test");
        assertEquals("test", example.getValue(optional));
    }

    @Test
    void getOrDefault_givenEmptyOptional_shouldReturnDefaultValue() {
        Optional<String> optional = Optional.empty();
        assertEquals("default", example.getOrDefault(optional, "default"));
    }

    @Test
    void getOrDefault_givenOptionalWithValue_shouldReturnValue() {
        Optional<String> optional = Optional.of("value");
        assertEquals("value", example.getOrDefault(optional, "default"));
    }

    @Test
    void getOrElseGet_givenEmptyOptional_shouldReturnSupplierValue() {
        Optional<String> optional = Optional.empty();
        assertEquals("Default from supplier", example.getOrElseGet(optional));
    }

    @Test
    void getOrElseThrow_givenEmptyOptional_shouldThrowCustomException() {
        Optional<String> optional = Optional.empty();
        assertThrows(IllegalStateException.class, () -> example.getOrElseThrow(optional));
    }

    @Test
    void getOrElseThrow_givenOptionalWithValue_shouldReturnValue() {
        Optional<String> optional = Optional.of("value");
        assertEquals("value", example.getOrElseThrow(optional));
    }
}
