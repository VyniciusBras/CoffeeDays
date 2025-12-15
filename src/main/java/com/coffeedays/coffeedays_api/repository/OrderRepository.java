package com.coffeedays.coffeedays_api.repository;

import com.coffeedays.coffeedays_api.entities.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {

}
