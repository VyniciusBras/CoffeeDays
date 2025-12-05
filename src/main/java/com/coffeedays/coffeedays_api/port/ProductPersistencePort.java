package com.coffeedays.coffeedays_api.port;

import com.coffeedays.coffeedays_api.models.Product;

import java.util.List;

public interface ProductPersistencePort {
    Product persist(Product product);
    List<Product> getAllProducts();

}
