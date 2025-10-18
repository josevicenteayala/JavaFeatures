package com.javaevolution.immutable;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ImmutableCollectionsExampleTest {

    private final ImmutableCollectionsExample example = new ImmutableCollectionsExample();

    @Test
    void createImmutableList_shouldContainElements() {
        List<String> list = example.createImmutableList();
        assertEquals(3, list.size());
        assertTrue(list.contains("apple"));
        assertTrue(list.contains("banana"));
        assertTrue(list.contains("cherry"));
    }

    @Test
    void createImmutableList_shouldBeUnmodifiable() {
        List<String> list = example.createImmutableList();
        assertThrows(UnsupportedOperationException.class, () -> list.add("orange"));
        assertThrows(UnsupportedOperationException.class, () -> list.remove(0));
        assertThrows(UnsupportedOperationException.class, () -> list.set(0, "pear"));
    }

    @Test
    void createImmutableSet_shouldContainElements() {
        Set<Integer> set = example.createImmutableSet();
        assertEquals(5, set.size());
        assertTrue(set.contains(1));
        assertTrue(set.contains(5));
    }

    @Test
    void createImmutableSet_shouldBeUnmodifiable() {
        Set<Integer> set = example.createImmutableSet();
        assertThrows(UnsupportedOperationException.class, () -> set.add(6));
        assertThrows(UnsupportedOperationException.class, () -> set.remove(1));
    }

    @Test
    void createImmutableMap_shouldContainEntries() {
        Map<String, Integer> map = example.createImmutableMap();
        assertEquals(3, map.size());
        assertEquals(1, map.get("one"));
        assertEquals(2, map.get("two"));
        assertEquals(3, map.get("three"));
    }

    @Test
    void createImmutableMap_shouldBeUnmodifiable() {
        Map<String, Integer> map = example.createImmutableMap();
        assertThrows(UnsupportedOperationException.class, () -> map.put("four", 4));
        assertThrows(UnsupportedOperationException.class, () -> map.remove("one"));
    }

    @Test
    void createLargeImmutableMap_shouldContainAllEntries() {
        Map<String, String> map = example.createLargeImmutableMap();
        assertEquals(11, map.size());
        assertEquals("value1", map.get("key1"));
        assertEquals("value11", map.get("key11"));
    }

    @Test
    void createEmptyImmutableList_shouldBeEmpty() {
        List<String> list = example.createEmptyImmutableList();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void createEmptyImmutableSet_shouldBeEmpty() {
        Set<String> set = example.createEmptyImmutableSet();
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
    }

    @Test
    void createEmptyImmutableMap_shouldBeEmpty() {
        Map<String, String> map = example.createEmptyImmutableMap();
        assertTrue(map.isEmpty());
        assertEquals(0, map.size());
    }

    @Test
    void listOf_withNull_shouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> List.of("a", null, "c"));
    }

    @Test
    void setOf_withDuplicates_shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Set.of(1, 2, 2, 3));
    }
}
