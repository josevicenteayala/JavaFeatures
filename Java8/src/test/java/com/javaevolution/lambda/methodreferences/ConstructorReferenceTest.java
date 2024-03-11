package com.javaevolution.lambda.methodreferences;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructorReferenceTest {

    @Test
    void createObject_givenNonEmptyMessage_shouldReturnObjectReferenceToGetTheMessage(){
        ConstructorReferenceFactory constructorReferenceFactory = ConstructorReference::new;

        ConstructorReference constructorReference = constructorReferenceFactory.create("This is the message");

        assertEquals("This is the message", constructorReference.getMessage());
    }

}