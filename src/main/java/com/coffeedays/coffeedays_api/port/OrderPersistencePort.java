package com.coffeedays.coffeedays_api.port;

import com.coffeedays.coffeedays_api.models.Order;
import com.coffeedays.coffeedays_api.models.Product;

import java.util.List;

public interface OrderPersistencePort {
    Order persist(Order order);
    List<Order> getAllOrder();
}
