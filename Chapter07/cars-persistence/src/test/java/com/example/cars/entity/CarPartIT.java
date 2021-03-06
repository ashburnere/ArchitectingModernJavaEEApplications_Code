package com.example.cars.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CarPartIT {

    private EntityManager entityManager;
    private EntityTransaction transaction;

    @Before
    public void setUp() {
        entityManager = Persistence.createEntityManagerFactory("it").createEntityManager();
        transaction = entityManager.getTransaction();
    }

    @Test
    public void test() {
        transaction.begin();

        CarPart part = new CarPart();
        part.setOrder("123");
        part.setType(PartType.CHASSIS);
        part = entityManager.merge(part);

        transaction.commit();
        
        
        CarPart partUpdate = entityManager.find(CarPart.class, part.getId());
        Assert.assertEquals("123", partUpdate.getOrder());
        
        transaction.begin();
        partUpdate.setOrder("1234");
        entityManager.merge(partUpdate);
        transaction.commit();

        partUpdate = entityManager.find(CarPart.class, part.getId());
        Assert.assertEquals("1234", partUpdate.getOrder());
    }

}