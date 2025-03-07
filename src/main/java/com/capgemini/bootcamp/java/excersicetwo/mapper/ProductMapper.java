package com.capgemini.bootcamp.java.excersicetwo.mapper;

import com.capgemini.bootcamp.java.excersicetwo.domain.entity.ProductEntity;
import com.capgemini.bootcamp.java.excersicetwo.domain.object.ProductObject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    //Transform entity to object
    @Mapping(target = "retrieved", ignore = true)
    ProductObject productEntityToProductObject(ProductEntity productEntity);

    //Transform object to entity
    ProductEntity productObjectToProductEntity(ProductObject productObject);

}
