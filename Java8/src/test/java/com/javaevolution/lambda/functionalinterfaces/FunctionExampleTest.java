package com.javaevolution.lambda.functionalinterfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FunctionExampleTest {

    @Test
    void getStringLength_givenAText_shouldReturnTheLength() {
        assertEquals(3,FunctionExample.getStringLength("One"));
    }

    @Test
    void getStringLengthImprovement_givenAText_shouldReturnTheLength() {
        assertEquals(3,FunctionExample.getStringLengthImprovement("One"));
    }
}