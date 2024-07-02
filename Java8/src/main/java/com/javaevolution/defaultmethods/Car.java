package com.javaevolution.defaultmethods;

public class Car implements Vehicle {
    @Override
    public String startEngine() {
        return "Engine started.";
    }
}
