package com.example.cars.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Car")
public class Car implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5101952716407740569L;
	private Specification specification;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    
    public Car() {
    	
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return specification != null ? specification.equals(car.specification) : car.specification == null;
    }

    @Override
    public int hashCode() {
        return specification != null ? specification.hashCode() : 0;
    }

}
