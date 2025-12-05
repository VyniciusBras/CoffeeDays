package com.coffeedays.coffeedays_api.repository.interfaces;

import com.coffeedays.coffeedays_api.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity,Integer> {

}
