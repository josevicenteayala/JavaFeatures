package com.javaevolution.lambda.advanced;

import java.util.function.UnaryOperator;

/**
 * A closure is a lambda expression that references variables from outside its body.
 * The lambda expression can access final variables, effectively making them final.
 * The lambda expression can also access instance variables and static variables.
 */
public class ClosureDemo {

    public String appendText(String text) {
        UnaryOperator<String> appendFunction = suffix -> suffix + text;
        return appendFunction.apply("Hello ");
    }

}
