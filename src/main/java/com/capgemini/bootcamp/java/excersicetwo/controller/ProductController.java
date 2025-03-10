package com.capgemini.bootcamp.java.excersicetwo.controller;

import com.capgemini.bootcamp.java.excersicetwo.domain.object.ProductObject;
import com.capgemini.bootcamp.java.excersicetwo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/rest")
    public ResponseEntity<List<ProductObject>> getProductObjectRest(){
        return ResponseEntity.ok(this.productService.getProductsRest());
    }

    @GetMapping("/feing")
    public ResponseEntity<List<ProductObject>> getProductObjectFeing(){
        return ResponseEntity.ok(this.productService.getProductsFeing());
    }

}
