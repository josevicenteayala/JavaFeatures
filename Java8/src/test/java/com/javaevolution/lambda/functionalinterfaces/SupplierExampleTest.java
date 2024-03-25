package com.javaevolution.lambda.functionalinterfaces;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class SupplierExampleTest {

    @RepeatedTest(1000)
    void generateRandomNumber_shouldReturnANumber() {
        int number = SupplierExample.generateRandomNumber();
        assertTrue(number >= 0 && number <=100);
    }

    @Test
    void generateInstanceObject_shouldReturnNonNullExampleObject() {
        SupplierExample.ExampleObject exampleObject = SupplierExample.generateInstanceObject();

        assertAll(
                () -> assertNotNull(exampleObject),
                () -> assertEquals("ExampleObject instance", exampleObject.toString())
        );
    }

    @Test
    void provideDefaultValue_givenANullValue_shouldReturnDefaultValue() {
        String defaultValue = SupplierExample.provideDefaultValue(null);

        assertEquals("Default String", defaultValue);
    }
}