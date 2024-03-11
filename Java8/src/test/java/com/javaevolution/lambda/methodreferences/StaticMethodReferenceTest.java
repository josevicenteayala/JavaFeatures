package com.javaevolution.lambda.methodreferences;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class StaticMethodReferenceTest {

    @Test
    void reverseOrderOfElementsInList_givenNonEmptyStringList_shouldReturnListWithElementsInReverseOrder() {
        List<String> stringList = List.of("super","panic","vincent");
        List<String> expectedList = List.of("repus","cinap","tnecniv");

        assertIterableEquals(expectedList,StaticMethodReference.reverseOrderOfElementsInList(stringList));
    }
}