package com.capgemini.bootcamp.java.excersicetwo.repository;

import com.capgemini.bootcamp.java.excersicetwo.domain.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Qualifier("feing")
@FeignClient(value = "instantwebtools-api", url = "http://localhost:8081/api/product")
public interface FeingProductRepository{

    @RequestMapping(method = RequestMethod.GET, value = "")
    ResponseEntity<List<ProductEntity>> get();


}
