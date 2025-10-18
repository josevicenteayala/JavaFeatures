package com.javaevolution.optional;

import com.javaevolution.optional.OptionalAdvancedExample.User;
import org.junit.jupiter.api.Test;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OptionalAdvancedExampleTest {

    private final OptionalAdvancedExample example = new OptionalAdvancedExample();

    @Test
    void mapToLength_givenOptionalWithValue_shouldReturnLength() {
        Optional<String> optional = Optional.of("Hello");
        Optional<Integer> result = example.mapToLength(optional);
        assertTrue(result.isPresent());
        assertEquals(5, result.get());
    }

    @Test
    void mapToLength_givenEmptyOptional_shouldReturnEmpty() {
        Optional<String> optional = Optional.empty();
        Optional<Integer> result = example.mapToLength(optional);
        assertFalse(result.isPresent());
    }

    @Test
    void flatMapExample_givenJohn_shouldReturnFullName() {
        Optional<String> optional = Optional.of("John");
        Optional<String> result = example.flatMapExample(optional);
        assertTrue(result.isPresent());
        assertEquals("John Doe", result.get());
    }

    @Test
    void flatMapExample_givenOtherName_shouldReturnEmpty() {
        Optional<String> optional = Optional.of("Jane");
        Optional<String> result = example.flatMapExample(optional);
        assertFalse(result.isPresent());
    }

    @Test
    void filterExample_givenLongString_shouldReturnValue() {
        Optional<String> optional = Optional.of("LongString");
        Optional<String> result = example.filterExample(optional);
        assertTrue(result.isPresent());
        assertEquals("LongString", result.get());
    }

    @Test
    void filterExample_givenShortString_shouldReturnEmpty() {
        Optional<String> optional = Optional.of("Short");
        Optional<String> result = example.filterExample(optional);
        assertFalse(result.isPresent());
    }

    @Test
    void processUser_givenAdultUser_shouldReturnUppercaseName() {
        User user = new User("Alice", 25);
        String result = example.processUser(Optional.of(user));
        assertEquals("ALICE", result);
    }

    @Test
    void processUser_givenMinorUser_shouldReturnUnknown() {
        User user = new User("Bob", 15);
        String result = example.processUser(Optional.of(user));
        assertEquals("UNKNOWN", result);
    }

    @Test
    void processUser_givenEmptyOptional_shouldReturnUnknown() {
        String result = example.processUser(Optional.empty());
        assertEquals("UNKNOWN", result);
    }

    @Test
    void printIfPresent_givenOptionalWithValue_shouldNotThrowException() {
        Optional<String> optional = Optional.of("Test");
        assertDoesNotThrow(() -> example.printIfPresent(optional));
    }

    @Test
    void printIfPresent_givenEmptyOptional_shouldNotThrowException() {
        Optional<String> optional = Optional.empty();
        assertDoesNotThrow(() -> example.printIfPresent(optional));
    }
}
