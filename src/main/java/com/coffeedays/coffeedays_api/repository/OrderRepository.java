package com.coffeedays.coffeedays_api.repository;

import com.coffeedays.coffeedays_api.models.Order;
import java.util.ArrayList;
import java.util.List;
//
public class OrderRepository {
    private List<Order> order;
    public List<Order> getOrder() {
        return order;
    }
    public OrderRepository() {
        this.order = new ArrayList<Order>();
    }
    public void addOrder(Order order) {
        this.order.add(order);
    }
}
