package com.javaevolution.lambda.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Logger;

/**
 * Handling exceptions within lambda expressions can be tricky because lambda expressions are expected to be functional interfaces, which typically do not allow checked exceptions to be thrown.
 * However, you can write wrapper methods that handle these exceptions within the lambda expression
 */
public class ExceptionHandlingInLambdaDemo {

    private static final Logger LOGGER = Logger.getLogger(ExceptionHandlingInLambdaDemo.class.getName());

    @FunctionalInterface
    public interface ThrowingConsumer<T, E extends Exception> {
        void accept(T t) throws E;

        static <T, E extends Exception> Consumer<T> unchecked(ThrowingConsumer<T, E> consumer) {
            return t -> {
                try {
                    consumer.accept(t);
                } catch (Exception ex) {
                    throw new LambdaRuntimeException(ex.getMessage());
                }
            };
        }
    }

    public static void printListElements() {
        // This lambda expression throws an IOException
        ThrowingConsumer<String, Exception> consumer = LOGGER::info;
        Consumer<String> consumer2 = ThrowingConsumer.unchecked(consumer);
        consumer2.accept("Hello, World!");
    }

    public static void printArrayContent(Integer [] array) {
        List<Integer> integers = Arrays.asList(array);
        integers.forEach(ThrowingConsumer.unchecked(n -> {
            if (n > 8) throw new LambdaRuntimeException("Value too high");
            LOGGER.info(n + "");
        }));
    }

}
