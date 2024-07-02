package com.javaevolution.defaultmethods;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class ElectricCarTest {
    @Test
    void startEngineShouldReturnExpectedMessage() {
        ElectricCar electricCar = new ElectricCar();
        String expectedMessage = "Electric engine started.";

        assertEquals(expectedMessage, electricCar.startEngine());
    }

    @Test
    void stopEngineShouldReturnExpectedMessage() {
        ElectricCar electricCar = new ElectricCar();
        String expectedMessage = "Electric car engine stopped.";

        assertEquals(expectedMessage, electricCar.stopEngine());
    }

    @Test
    void startEngineShouldNotReturnDifferentMessage() {
        ElectricCar electricCar = new ElectricCar();
        String unexpectedMessage = "Engine not started.";

        assertNotEquals(unexpectedMessage, electricCar.startEngine());
    }

    @Test
    void stopEngineShouldNotReturnDifferentMessage() {
        ElectricCar electricCar = new ElectricCar();
        String unexpectedMessage = "Engine not stopped.";

        assertNotEquals(unexpectedMessage, electricCar.stopEngine());
    }
}