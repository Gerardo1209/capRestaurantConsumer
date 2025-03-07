package com.capgemini.bootcamp.java.excersicetwo.repository;

import com.capgemini.bootcamp.java.excersicetwo.domain.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("feing")
public class FeignProductRepository implements ProductRepository {
    @Override
    public List<ProductEntity> get() {
        return null;
    }
}
