package com.javaevolution.defaultmethods;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void startEngineShouldPrintMessage() {
        Car car = new Car();
        String expectedMessage = "Engine started.";

        car.startEngine();

        assertEquals(expectedMessage, car.startEngine());
    }

    @Test
    void startEngineShouldNotPrintDifferentMessage() {
        Car car = new Car();
        String unexpectedMessage = "Engine not started.";

        car.startEngine();

        assertNotEquals(unexpectedMessage, car.startEngine());
    }
}