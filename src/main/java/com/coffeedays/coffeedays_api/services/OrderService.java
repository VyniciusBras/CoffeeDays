package com.coffeedays.coffeedays_api.services;

import com.coffeedays.coffeedays_api.models.Order;
import com.coffeedays.coffeedays_api.models.Product;
import com.coffeedays.coffeedays_api.port.OrderPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderPersistencePort orderPersistencePort;

    public List<Order> getAllOrders(){
        return orderPersistencePort.getAllOrder();
    }

    public Order createOrder(Order order) {
        return orderPersistencePort.persist(order);
    }
}
