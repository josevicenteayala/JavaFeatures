package com.javaevolution.lambda.methodreferences;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class InstanceMethodReferenceTest {

    @Test
    void cleanNonAlphabeticCharacters_givenNonEmptyStringList_shouldReturnAlphabeticListsOnly() {
        List<String> texts = List.of("@Hello67#","M4i%c0h!a-e'l","!@#$%^&*()_+=-[]{};':?><");
        List<String> extectedList = List.of("Hello","Michael","");

        InstanceMethodReference instanceMethodReference = new InstanceMethodReference();

        assertIterableEquals(extectedList,instanceMethodReference.cleanNonAlphabeticCharacters(texts));
    }
}