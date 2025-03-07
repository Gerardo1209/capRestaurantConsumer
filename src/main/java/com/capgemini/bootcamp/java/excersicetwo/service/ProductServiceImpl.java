package com.capgemini.bootcamp.java.excersicetwo.service;


import com.capgemini.bootcamp.java.excersicetwo.domain.entity.ProductEntity;
import com.capgemini.bootcamp.java.excersicetwo.domain.object.ProductObject;
import com.capgemini.bootcamp.java.excersicetwo.mapper.ProductMapper;
import com.capgemini.bootcamp.java.excersicetwo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    ProductRepository restProductRepository;
    ProductRepository feignProductRepository;

    @Autowired
    public ProductServiceImpl(
            @Qualifier("rest")
            ProductRepository restProductRepository,
            @Qualifier("feing")
            ProductRepository feignProductRepository
    ){
        this.restProductRepository = restProductRepository;
        this.feignProductRepository = feignProductRepository;
    }

    @Override
    public List<ProductObject> getProductsRest() {
        List<ProductEntity> productEntitys = this.restProductRepository.get();
        List<ProductObject> productObjects = new ArrayList<>();
        for(ProductEntity productEntity:productEntitys){
            ProductObject productObject = ProductMapper.INSTANCE.productEntityToProductObject(productEntity);
            productObjects.add(productObject);
        }
        return productObjects;
    }

    @Override
    public List<ProductObject> getProductsFeing() {
        return null;
    }
}
