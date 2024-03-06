package com.javaevolution.lambda.basics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SimpleLambdaExampleTest {

    @Test
    void greeting_receivingLambdaFunction_shouldPrintGreetings() {
        SimpleLambdaExample.Greeting greeting = (String name) -> "Hello, " + name;
        assertEquals("Hello, Java", greeting.sayHello("Java"));
    }

}