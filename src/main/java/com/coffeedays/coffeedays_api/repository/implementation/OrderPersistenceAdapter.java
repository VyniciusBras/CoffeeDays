package com.coffeedays.coffeedays_api.repository.implementation;

import com.coffeedays.coffeedays_api.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderPersistenceAdapter {
    private List<Order> order;
    public List<Order> getOrder() {
        return order;
    }
    public OrderPersistenceAdapter() {
        this.order = new ArrayList<Order>();
    }
    public void addOrder(Order order) {
        this.order.add(order);
    }
}
