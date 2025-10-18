package com.javaevolution.unnamedpatterns;

import com.javaevolution.unnamedpatterns.UnnamedPatternsExample.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UnnamedPatternsExampleTest {

    private final UnnamedPatternsExample example = new UnnamedPatternsExample();

    @Test
    void processPoint_withPoint_shouldReturnXCoordinate() {
        Point point = new Point(5, 10);
        String result = example.processPoint(point);
        assertTrue(result.contains("5"));
        assertTrue(result.contains("X coordinate"));
    }

    @Test
    void processPoint_withNull_shouldReturnNullMessage() {
        String result = example.processPoint(null);
        assertEquals("Null object", result);
    }

    @Test
    void processPoint_withNonPoint_shouldReturnNotAPoint() {
        String result = example.processPoint("not a point");
        assertEquals("Not a Point", result);
    }

    @Test
    void extractName_withPerson_shouldReturnName() {
        Person person = new Person("Alice", 30, "123 Main St");
        String name = example.extractName(person);
        assertEquals("Alice", name);
    }

    @Test
    void extractName_withNonPerson_shouldReturnUnknown() {
        String name = example.extractName("not a person");
        assertEquals("Unknown", name);
    }

    @Test
    void generateDefaultList_shouldCreateListWithCorrectSize() {
        List<String> list = example.generateDefaultList(5);
        assertEquals(5, list.size());
        assertTrue(list.stream().allMatch(s -> s.equals("default")));
    }

    @Test
    void countElements_shouldReturnCorrectCount() {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        int count = example.countElements(list);
        assertEquals(4, count);
    }

    @Test
    void countElements_withEmptyList_shouldReturnZero() {
        List<String> list = List.of();
        int count = example.countElements(list);
        assertEquals(0, count);
    }

    @Test
    void processComplexPattern_withPositiveY_shouldReturnPositiveY() {
        Point point = new Point(3, 5);
        String result = example.processComplexPattern(point);
        assertEquals("Positive Y", result);
    }

    @Test
    void processComplexPattern_withNegativeY_shouldReturnNegativeY() {
        Point point = new Point(3, -5);
        String result = example.processComplexPattern(point);
        assertEquals("Negative Y", result);
    }

    @Test
    void processComplexPattern_withZeroY_shouldReturnYIsZero() {
        Point point = new Point(3, 0);
        String result = example.processComplexPattern(point);
        assertEquals("Y is zero", result);
    }

    @Test
    void safeOperation_withSuccessfulOperation_shouldReturnTrue() {
        boolean result = example.safeOperation(() -> {
            // Do nothing - successful operation
        });
        assertTrue(result);
    }

    @Test
    void safeOperation_withFailingOperation_shouldReturnFalse() {
        boolean result = example.safeOperation(() -> {
            throw new RuntimeException("Test exception");
        });
        assertFalse(result);
    }

    @Test
    void extractNameOldWay_withPerson_shouldReturnName() {
        Person person = new Person("Bob", 25, "456 Oak Ave");
        String name = example.extractNameOldWay(person);
        assertEquals("Bob", name);
    }

    @Test
    void processContainer_withContainer_shouldReturnXCoordinate() {
        Container container = new Container(new Point(7, 9), "test");
        String result = example.processContainer(container);
        assertTrue(result.contains("7"));
        assertTrue(result.contains("X coordinate in container"));
    }

    @Test
    void processContainer_withNonContainer_shouldReturnNotAContainer() {
        String result = example.processContainer("not a container");
        assertEquals("Not a Container", result);
    }

    @Test
    void countLines_shouldReturnNonNegative() {
        int count = example.countLines("test.txt");
        assertTrue(count >= 0);
    }
}
