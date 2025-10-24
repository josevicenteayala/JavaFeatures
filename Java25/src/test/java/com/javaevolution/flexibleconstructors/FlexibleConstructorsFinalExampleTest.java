package com.javaevolution.flexibleconstructors;

import com.javaevolution.flexibleconstructors.FlexibleConstructorsFinalExample.*;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FlexibleConstructorsFinalExampleTest {

    @Test
    void positiveNumber_withValidValue_shouldCreate() {
        PositiveNumber num = new PositiveNumber(42);
        assertEquals(42, num.getValue());
    }

    @Test
    void positiveNumber_withZero_shouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> new PositiveNumber(0));
    }

    @Test
    void positiveNumber_withNegative_shouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> new PositiveNumber(-1));
    }

    @Test
    void normalizedString_shouldNormalizeInput() {
        NormalizedString str = new NormalizedString("  HELLO  ");
        assertEquals("hello", str.getValue());
    }

    @Test
    void normalizedString_withNull_shouldReturnEmpty() {
        NormalizedString str = new NormalizedString(null);
        assertEquals("", str.getValue());
    }

    @Test
    void rectangle_withValidDimensions_shouldCreate() {
        Rectangle rect = new Rectangle(10, 20);
        assertEquals(200, rect.area());
    }

    @Test
    void rectangle_withZero_shouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(0, 10));
    }

    @Test
    void rectangle_withTooLarge_shouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(20000, 10));
    }

    @Test
    void smartList_withCapacity_shouldCreateWithMinimum() {
        SmartList<String> list = new SmartList<>(5);
        assertTrue(list.isEmpty());
    }

    @Test
    void smartList_withNegativeCapacity_shouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> new SmartList<String>(-1));
    }

    @Test
    void smartList_withList_shouldCopy() {
        List<String> original = List.of("a", "b", "c");
        SmartList<String> list = new SmartList<>(original);
        assertEquals(3, list.size());
    }

    @Test
    void boundedInteger_withinRange_shouldCreate() {
        BoundedInteger num = new BoundedInteger(50, 0, 100);
        assertEquals(50, num.getValue());
    }

    @Test
    void boundedInteger_outsideRange_shouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> new BoundedInteger(150, 0, 100));
    }

    @Test
    void boundedInteger_withInvalidRange_shouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> new BoundedInteger(50, 100, 0));
    }

    @Test
    void person_withValidData_shouldCreate() {
        Person person = new Person.Builder()
            .firstName("John")
            .lastName("Doe")
            .age(30)
            .email("john@example.com")
            .build();
        
        assertEquals("John Doe", person.getFullName());
        assertEquals(30, person.getAge());
    }

    @Test
    void person_withMissingFirstName_shouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Person.Builder().lastName("Doe").age(30).build()
        );
    }

    @Test
    void person_withInvalidAge_shouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Person.Builder().firstName("John").lastName("Doe").age(-1).build()
        );
    }

    @Test
    void securePassword_withStrongPassword_shouldCreate() {
        SecurePassword pwd = new SecurePassword("Password123");
        assertTrue(pwd.verify("Password123"));
    }

    @Test
    void securePassword_withWeakPassword_shouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> new SecurePassword("weak"));
    }

    @Test
    void securePassword_clear_shouldClearPassword() {
        SecurePassword pwd = new SecurePassword("Password123");
        pwd.clear();
        // Password should be cleared (filled with nulls)
    }

    @Test
    void immutableConfiguration_withValidProps_shouldCreate() {
        Map<String, String> props = Map.of("key1", "value1", "key2", "value2");
        ImmutableConfiguration config = new ImmutableConfiguration(props);
        
        assertEquals("value1", config.getProperty("key1"));
        assertEquals("value1", config.getProperty("KEY1")); // Case-insensitive
    }

    @Test
    void immutableConfiguration_withEmptyProps_shouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> 
            new ImmutableConfiguration(Map.of())
        );
    }
}
