package com.coffeedays.coffeedays_api.mapper;

import com.coffeedays.coffeedays_api.entities.ProductEntity;
import com.coffeedays.coffeedays_api.models.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductEntity toEntity(Product product);
    List<Product> toProduct(List<ProductEntity> productEntity);
    Product toProduct(ProductEntity productEntity);
}