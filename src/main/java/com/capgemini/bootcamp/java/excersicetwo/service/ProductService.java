package com.capgemini.bootcamp.java.excersicetwo.service;

import com.capgemini.bootcamp.java.excersicetwo.domain.object.ProductObject;

import java.util.List;

public interface ProductService {
    public List<ProductObject> getProductsRest();
    public List<ProductObject> getProductsFeing();
}
