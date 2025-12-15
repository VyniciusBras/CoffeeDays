package com.coffeedays.coffeedays_api.adapter;

import com.coffeedays.coffeedays_api.entities.ProductEntity;
import com.coffeedays.coffeedays_api.mapper.ProductMapper;
import com.coffeedays.coffeedays_api.models.Product;
import com.coffeedays.coffeedays_api.port.ProductPersistencePort;
import com.coffeedays.coffeedays_api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductPersistencePort {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    public Product persist(Product product) {
        ProductEntity productEntity = productMapper.toEntity(product);
        productRepository.save(productEntity);
        return product;
    }
    public List<Product> getAllProducts() {
        List<ProductEntity> products = StreamSupport.stream(productRepository.findAll().spliterator(), false).toList();
        return productMapper.toProduct(products);
    }
}
