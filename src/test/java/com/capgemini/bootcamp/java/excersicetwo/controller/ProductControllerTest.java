package com.capgemini.bootcamp.java.excersicetwo.controller;

import com.capgemini.bootcamp.java.excersicetwo.domain.entity.ProductEntity;
import com.capgemini.bootcamp.java.excersicetwo.repository.FeingProductRepository;
import com.capgemini.bootcamp.java.excersicetwo.repository.ProductRepository;
import com.capgemini.bootcamp.java.excersicetwo.repository.RestProductRepository;
import com.capgemini.bootcamp.java.excersicetwo.service.ProductService;
import com.capgemini.bootcamp.java.excersicetwo.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    private ProductController productController;

    private ProductEntity productEntity;

    List<ProductEntity> productEntityList;

    @Mock
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private FeingProductRepository feingProductRepository;



    @BeforeEach
    void configuration(){
        productEntityList = new ArrayList<>();
        productEntity = new ProductEntity();
        productEntityList.add(productEntity);
        productRepository = new RestProductRepository(restTemplate);

        productService = new ProductServiceImpl(productRepository, feingProductRepository);
        productController = new ProductController(productService);
    }

    @Test
    void getProductObjectRest() {
        ProductEntity[] arrayProduct = new ProductEntity[productEntityList.size()];
        arrayProduct = productEntityList.toArray(arrayProduct);
        ResponseEntity<ProductEntity[]> responseEntity = ResponseEntity.ok(arrayProduct);
        when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class), eq(ProductEntity[].class))).thenReturn((responseEntity));
        var result = productController.getProductObjectRest();
        assertEquals(1, Objects.requireNonNull(result.getBody()).size());
    }

    @Test
    void getProductObjectFeing() {
        ResponseEntity<List<ProductEntity>> responseEntity = ResponseEntity.ok(productEntityList);
        when(feingProductRepository.get()).thenReturn(responseEntity);
        var result = productController.getProductObjectFeing();
        assertEquals(1, Objects.requireNonNull(result.getBody()).size());

    }
}