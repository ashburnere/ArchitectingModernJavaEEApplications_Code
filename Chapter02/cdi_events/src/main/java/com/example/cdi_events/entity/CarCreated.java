package com.example.cdi_events.entity;

public class CarCreated {

    private final Car car;

    public CarCreated(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}
