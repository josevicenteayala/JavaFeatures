package com.javaevolution.lambda.methodreferences;

@FunctionalInterface
public interface ConstructorReferenceFactory {

    ConstructorReference create(String message);
}
