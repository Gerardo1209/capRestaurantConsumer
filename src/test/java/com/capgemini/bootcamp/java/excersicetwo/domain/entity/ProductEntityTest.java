package com.capgemini.bootcamp.java.excersicetwo.domain.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductEntityTest {

    ProductEntity productEntity;

    @BeforeEach
    void configuration(){
        productEntity = new ProductEntity("Test", "test", 20.2, "test.png");
    }

    @Test
    void getId() {
        productEntity.setId(5);
        assertEquals(5, productEntity.getId());
    }

    @Test
    void getName() {
        productEntity.setName("Test");
        assertEquals("Test", productEntity.getName());
    }

    @Test
    void getDescription() {
        productEntity.setDescription("test");
        assertEquals("test", productEntity.getDescription());
    }


    @Test
    void getPrice() {
        productEntity.setPrice(20.2);
        assertEquals(20.2, productEntity.getPrice());
    }


    @Test
    void getImage() {
        productEntity.setImage("test.png");
        assertEquals("test.png", productEntity.getImage());
    }

}