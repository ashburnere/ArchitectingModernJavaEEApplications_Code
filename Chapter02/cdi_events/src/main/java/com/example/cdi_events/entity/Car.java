package com.example.cdi_events.entity;

public class Car {

    private Specification specification;
    private int id;

    private Car() {
    }

    public Car(int id, Specification specification) {
        this.id = id;
        this.specification = specification;
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }
    
    public int getId() {
        return id;
    }
    
    

}
