package com.capgemini.bootcamp.java.excersicetwo.repository;

import com.capgemini.bootcamp.java.excersicetwo.domain.entity.ProductEntity;

import java.util.List;

public interface ProductRepository {
    List<ProductEntity> get();
}
