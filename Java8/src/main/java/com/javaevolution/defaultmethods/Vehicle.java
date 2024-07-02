package com.javaevolution.defaultmethods;

public interface Vehicle {
    String startEngine();

    default String stopEngine() {
        return "Engine stopped.";
    }
}
