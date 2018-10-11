package com.example.cars.boundary;

import java.util.Arrays;
import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.cars.entity.Car;
import com.example.cars.entity.Color;
import com.example.cars.entity.EngineType;
import com.example.cars.entity.Specification;

@Path("cars")
@Produces(MediaType.APPLICATION_JSON)
public class CarsResource {

    @Inject
    CarManufacturer carManufacturer;
    
    // GET http://localhost:9080/car-manufacture-cdi-unit/resources/cars
    @GET
    public Collection<Car> manufactureCar() {
        System.out.println("manufactureCar "); 
        Specification spec = new Specification();
        spec.setColor(Color.BLACK);
        spec.setEngine(EngineType.DIESEL);
        Car car = this.carManufacturer.manufactureCar(spec);
        return Arrays.asList(car);
    }
    
//    @POST
//    public Collection<Car> manufactureCar() {
//        System.out.println("manufactureCar "); 
//        Specification spec = new Specification();
//        spec.setColor(Color.BLACK);
//        spec.setEngine(EngineType.DIESEL);
//        Car car = this.carManufacturer.manufactureCar(spec);
//        return Arrays.asList(car);
//    }
//    
    
    
    
}

