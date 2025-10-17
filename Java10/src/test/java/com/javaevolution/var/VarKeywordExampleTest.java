package com.javaevolution.var;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class VarKeywordExampleTest {

    private final VarKeywordExample example = new VarKeywordExample();

    @Test
    void basicVarUsage_shouldCompile() {
        assertDoesNotThrow(() -> example.basicVarUsage());
    }

    @Test
    void varWithCollections_shouldReturnList() {
        List<String> result = example.varWithCollections();
        assertNotNull(result);
        assertEquals(3, result.size());
        assertTrue(result.contains("Alice"));
        assertTrue(result.contains("Bob"));
        assertTrue(result.contains("Charlie"));
    }

    @Test
    void varWithStreams_shouldFilterAndTransform() {
        List<String> input = Arrays.asList("hi", "hello", "world", "java");
        List<String> result = example.varWithStreams(input);
        assertEquals(3, result.size());
        assertTrue(result.contains("HELLO"));
        assertTrue(result.contains("WORLD"));
        assertTrue(result.contains("JAVA"));
        assertFalse(result.contains("HI"));
    }

    @Test
    void varInForLoops_shouldCalculateSum() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int result = example.varInForLoops(numbers);
        // Sum is calculated twice in the method: once in enhanced for, once in traditional for
        assertEquals(30, result); // (1+2+3+4+5) * 2 = 30
    }

    @Test
    void varWithGenerics_shouldCreateMapWithLists() {
        Map<String, List<Integer>> result = example.varWithGenerics();
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.containsKey("scores"));
        assertTrue(result.containsKey("ages"));
        assertEquals(Arrays.asList(85, 90, 95), result.get("scores"));
        assertEquals(Arrays.asList(20, 25, 30), result.get("ages"));
    }

    @Test
    void limitationsOfVar_shouldCompile() {
        assertDoesNotThrow(() -> example.limitationsOfVar());
    }

    @Test
    void varBestPractices_shouldCompile() {
        assertDoesNotThrow(() -> example.varBestPractices());
    }

    @Test
    void varWithTryWithResources_shouldCompile() {
        assertDoesNotThrow(() -> example.varWithTryWithResources());
    }

    @Test
    void varInference_shouldInferCorrectTypes() {
        var stringVar = "test";
        assertTrue(stringVar instanceof String);

        var intVar = 42;
        assertTrue(intVar instanceof Integer);

        var listVar = new ArrayList<String>();
        assertTrue(listVar instanceof List);
        assertTrue(listVar instanceof ArrayList);

        var mapVar = new HashMap<String, Integer>();
        assertTrue(mapVar instanceof Map);
        assertTrue(mapVar instanceof HashMap);
    }
}
