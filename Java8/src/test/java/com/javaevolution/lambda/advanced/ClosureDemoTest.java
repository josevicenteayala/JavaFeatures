package com.javaevolution.lambda.advanced;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClosureDemoTest {

    @ParameterizedTest
    @CsvSource({
            "'', 'Hello '",
            "'World', 'Hello World'",
            "' ', 'Hello  '"
    })
    void appendText_withVariousInputs_appendsHelloAndInput(String input, String expected) {
        ClosureDemo demo = new ClosureDemo();
        String result = demo.appendText(input);
        assertEquals(expected, result);
    }
}