package com.javaevolution.lambda.basics;

import static com.javaevolution.lambda.Printer.printLogger;

import java.util.logging.Logger;

public class SimpleLambdaExample {

    private static final Logger LOGGER = Logger.getLogger(SimpleLambdaExample.class.getName());

    interface Greeting {
        String sayHello(String name);
    }

    public static void main(String[] args) {
        printGreetingForJava();
    }

    private static void printGreetingForJava() {
        Greeting greeting = (String name) -> "Hello, " + name;
        printLogger(LOGGER,greeting.sayHello("Java"));
    }
}
