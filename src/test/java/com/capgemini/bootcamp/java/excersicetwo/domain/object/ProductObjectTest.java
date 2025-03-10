package com.capgemini.bootcamp.java.excersicetwo.domain.object;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class ProductObjectTest {

    ProductObject productObject;

    @BeforeEach
    void configuration(){
        productObject = new ProductObject(5, "Test", "test", 20.2, "test.png");
    }

    @Test
    void getId() {
        productObject.setId(5);
        assertEquals(5, productObject.getId());
    }

    @Test
    void getName() {
        productObject.setName("Test");
        assertEquals("Test", productObject.getName());
    }

    @Test
    void getDescription() {
        productObject.setDescription("test");
        assertEquals("test", productObject.getDescription());
    }

    @Test
    void getPrice() {
        productObject.setPrice(20.2);
        assertEquals(20.2, productObject.getPrice());
    }

    @Test
    void getImage() {
        productObject.setImage("test.png");
        assertEquals("test.png", productObject.getImage());
    }

    @Test
    void getRetrieved() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        productObject.setRetrieved(timestamp);
        assertEquals(timestamp, productObject.getRetrieved());
    }
}