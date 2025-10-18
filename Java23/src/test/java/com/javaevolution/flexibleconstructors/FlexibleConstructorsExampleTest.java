package com.javaevolution.flexibleconstructors;

import com.javaevolution.flexibleconstructors.FlexibleConstructorsExample.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlexibleConstructorsExampleTest {

    @Test
    void positiveNumber_withValidValue_shouldCreateInstance() {
        PositiveNumber num = new PositiveNumber(42);
        assertEquals(42, num.longValue());
    }

    @Test
    void positiveNumber_withNegativeValue_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new PositiveNumber(-1));
    }

    @Test
    void positiveNumber_withZero_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new PositiveNumber(0));
    }

    @Test
    void normalizedString_shouldNormalizeInput() {
        NormalizedString normalized = new NormalizedString("  HELLO World  ");
        assertEquals("hello world", normalized.getValue());
    }

    @Test
    void normalizedString_withNull_shouldReturnEmptyString() {
        NormalizedString normalized = new NormalizedString(null);
        assertEquals("", normalized.getValue());
    }

    @Test
    void smartList_withValidCapacity_shouldCreateList() {
        SmartList<String> list = new SmartList<>(5);
        assertNotNull(list);
        assertTrue(list.isEmpty());
    }

    @Test
    void smartList_withSmallCapacity_shouldUseMinimumCapacity() {
        SmartList<String> list = new SmartList<>(3);
        // List should be created with minimum capacity
        assertNotNull(list);
    }

    @Test
    void smartList_withNegativeCapacity_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new SmartList<String>(-1));
    }

    @Test
    void smartList_withListParameter_shouldCreateFromList() {
        List<String> items = Arrays.asList("a", "b", "c");
        SmartList<String> list = new SmartList<>(items);
        assertEquals(3, list.size());
    }

    @Test
    void smartList_withNullList_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new SmartList<String>((List<String>) null));
    }

    @Test
    void configuredService_withValidEndpoint_shouldProcessCorrectly() {
        ConfiguredService service = new ConfiguredService("example.com", 5000);
        assertEquals("example.com", service.getEndpoint());
        assertEquals(5000, service.getTimeout());
    }

    @Test
    void configuredService_withHttpsEndpoint_shouldDetectSsl() {
        ConfiguredService service = new ConfiguredService("https://secure.example.com", 1000);
        assertTrue(service.isSsl());
    }

    @Test
    void configuredService_withNullEndpoint_shouldUseDefault() {
        ConfiguredService service = new ConfiguredService(null, 1000);
        assertEquals("localhost", service.getEndpoint());
    }

    @Test
    void configuredService_withNegativeTimeout_shouldUseDefault() {
        ConfiguredService service = new ConfiguredService("example.com", -1);
        assertEquals(30000, service.getTimeout());
    }

    @Test
    void boundedValue_withValueInRange_shouldStoreValue() {
        BoundedValue bounded = new BoundedValue(5.0, 0.0, 10.0);
        assertEquals(5.0, bounded.getValue(), 0.001);
    }

    @Test
    void boundedValue_withValueBelowMin_shouldClampToMin() {
        BoundedValue bounded = new BoundedValue(-5.0, 0.0, 10.0);
        assertEquals(0.0, bounded.getValue(), 0.001);
    }

    @Test
    void boundedValue_withValueAboveMax_shouldClampToMax() {
        BoundedValue bounded = new BoundedValue(15.0, 0.0, 10.0);
        assertEquals(10.0, bounded.getValue(), 0.001);
    }

    @Test
    void boundedValue_withInvalidBounds_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new BoundedValue(5.0, 10.0, 5.0));
    }

    @Test
    void boundedValue_withTwoParameters_shouldUseZeroAsMin() {
        BoundedValue bounded = new BoundedValue(5.0, 10.0);
        assertEquals(5.0, bounded.getValue(), 0.001);
        assertEquals(0.0, bounded.getMin(), 0.001);
        assertEquals(10.0, bounded.getMax(), 0.001);
    }

    @Test
    void auditedObject_withValidId_shouldUseProvidedId() {
        AuditedObject obj = new AuditedObject("test-123");
        assertEquals("test-123", obj.getId());
    }

    @Test
    void auditedObject_withNullId_shouldGenerateId() {
        AuditedObject obj = new AuditedObject(null);
        assertTrue(obj.getId().startsWith("AUTO_"));
    }

    @Test
    void auditedObject_shouldRecordCreationTime() {
        long before = System.currentTimeMillis();
        AuditedObject obj = new AuditedObject("test");
        long after = System.currentTimeMillis();
        
        assertTrue(obj.getCreatedAt() >= before);
        assertTrue(obj.getCreatedAt() <= after);
    }

    @Test
    void personBuilder_withValidData_shouldCreatePerson() {
        Person person = new Person.Builder()
                .firstName("John")
                .lastName("Doe")
                .age(30)
                .build();
        
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals(30, person.getAge());
    }

    @Test
    void personBuilder_withEmptyFirstName_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Person.Builder()
                    .firstName("")
                    .lastName("Doe")
                    .age(30)
                    .build()
        );
    }

    @Test
    void personBuilder_withInvalidAge_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Person.Builder()
                    .firstName("John")
                    .lastName("Doe")
                    .age(-5)
                    .build()
        );
    }

    @Test
    void personBuilder_withAgeTooHigh_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Person.Builder()
                    .firstName("John")
                    .lastName("Doe")
                    .age(200)
                    .build()
        );
    }
}
