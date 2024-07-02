package com.javaevolution.defaultmethods;

public class ElectricCar implements Vehicle {
    @Override
    public String startEngine() {
        return "Electric engine started.";
    }

    @Override
    public String stopEngine() {
        return "Electric car engine stopped.";
    }
}
