package com.example.cdi_events.control;

import com.example.cdi_events.entity.Car;
import com.example.cdi_events.entity.Specification;
import java.util.concurrent.atomic.AtomicInteger;

public class CarFactory {

    private static final AtomicInteger carCount = new AtomicInteger();
    
    public Car createCar(Specification spec) {
        // ...
        return new Car(carCount.incrementAndGet(), spec);
    }

}
