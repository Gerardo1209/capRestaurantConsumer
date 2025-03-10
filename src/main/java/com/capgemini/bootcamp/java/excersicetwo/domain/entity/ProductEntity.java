package com.capgemini.bootcamp.java.excersicetwo.domain.entity;

import org.springframework.stereotype.Component;

@Component
public class ProductEntity {

    private long id;

    private String name;

    private String description;

    private double price;

    private String image;

    public ProductEntity(){}

    public ProductEntity(String name, String description, double price, String image) {
        this();
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /*@Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }*/
}
