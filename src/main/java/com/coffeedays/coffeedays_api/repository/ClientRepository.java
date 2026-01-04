package com.coffeedays.coffeedays_api.repository;

import com.coffeedays.coffeedays_api.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ProductEntity,Integer> {

}
