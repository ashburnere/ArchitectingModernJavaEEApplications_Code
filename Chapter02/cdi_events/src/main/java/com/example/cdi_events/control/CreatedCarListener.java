package com.example.cdi_events.control;

import com.example.cdi_events.entity.Car;
import com.example.cdi_events.entity.CarCreated;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.event.Observes;

public class CreatedCarListener {

    private static final Map<Integer, Car> carDB = new ConcurrentHashMap<>();
    private static final AtomicInteger carCount = new AtomicInteger();

    /**
     * Handles the CDI event for objects of type CarCreated
     * @param event 
     */
    public void onCarCreated(@Observes CarCreated event) {
        Car car = event.getCar();
        // handle event
        int id = carCount.incrementAndGet();
        System.out.println(System.currentTimeMillis() +  " Car created with id: " + id);
             
        carDB.put(id, car);
    }
    
    public static Collection<Car> getCars() {
        return carDB.values();
    }
    
     public static Car getCar(int id) {
        return carDB.get(id);
    }

}
