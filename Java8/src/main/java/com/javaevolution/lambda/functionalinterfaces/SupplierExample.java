package com.javaevolution.lambda.functionalinterfaces;

import java.util.Objects;
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierExample {

    private static final Random random = new Random();
    private static final IntSupplier randomNumberSupplier = () -> random.nextInt(100);
    private static final Supplier<ExampleObject> exampleObjectSupplier = ExampleObject::new;
    private static final Supplier<String> defaultStringSupplier = () -> "Default String";

    private SupplierExample() {
        throw new IllegalStateException("This is a util class");
    }

    public static int generateRandomNumber() {
        return randomNumberSupplier.getAsInt();
    }


    public static class ExampleObject {
        @Override
        public String toString() {
            return "ExampleObject instance";
        }
    }

    public static ExampleObject generateInstanceObject() {
        return exampleObjectSupplier.get();
    }

    public static String provideDefaultValue(String nullValue) {
        return Objects.isNull(nullValue) ? defaultStringSupplier.get():nullValue;
    }
}
