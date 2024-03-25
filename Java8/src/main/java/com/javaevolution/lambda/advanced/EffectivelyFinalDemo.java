package com.javaevolution.lambda.advanced;

import java.util.function.IntUnaryOperator;
import java.util.logging.Logger;

/**
 * Lambda expressions can capture and use local variables from their enclosing scope. However, these variables must be effectively final or actually final.
 * An effectively final variable is one that is not modified after initialization in the local scope.
 * If a lambda expression tries to modify a local variable, the compiler will throw an error.
 */
public class EffectivelyFinalDemo {
    private static final Logger LOGGER = Logger.getLogger(EffectivelyFinalDemo.class.getName());
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        // x = 30; // This will throw an error
        // y = 40; // This will throw an error
        // The following lambda expression will not throw an error because x is effectively final
        Runnable r = () -> LOGGER.info(() -> x + y + "");
        r.run();
    }

    public int multiplyByFive(int factor) {
        IntUnaryOperator multiplier = (int x) -> x * factor;
        return multiplier.applyAsInt(5);
    }
}
