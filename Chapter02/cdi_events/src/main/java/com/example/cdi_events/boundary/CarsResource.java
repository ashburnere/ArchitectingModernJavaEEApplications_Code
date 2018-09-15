package com.example.cdi_events.boundary;

import com.example.cdi_events.control.CreatedCarListener;
import com.example.cdi_events.entity.Car;
import com.example.cdi_events.entity.Specification;
import java.net.URI;
import java.util.Collection;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("cars")
@Produces(MediaType.APPLICATION_JSON)
public class CarsResource {

    @Inject
    CarManufacturer carManufacturer;
    
    @Context 
    UriInfo uriInfo;
    
    // GET http://localhost:8080/cdi_events/resources/cars
    @GET
    public Collection<Car> getCars() {
        System.out.println("getCars "); 
        return CreatedCarListener.getCars();
    }

    // GET http://localhost:8080/cdi_events/resources/cars/1
    @GET
    @Path("{id}")
    public Car getCar(@PathParam ("id") Integer id) {
       System.out.println("getCar: " + id); 
       return CreatedCarListener.getCar(id);
    }

    // POST http://localhost:8080/cdi_events/resources/cars/BMW
    @Path("{manufacturer}")
    @POST
    public Response createCar(@PathParam ("manufacturer") String manufacturer) {
        // TODO use specification for manufacturer 
        System.out.println("createCar " + manufacturer); 
        int id = carManufacturer.manufactureCar(new Specification()).getId();
        
        URI carUri = uriInfo.getBaseUriBuilder().path(CarsResource.class).
                path(CarsResource.class, "getCar").build(id);
        // return the URI od the created car
        return Response.created(carUri).build();
    }
}
