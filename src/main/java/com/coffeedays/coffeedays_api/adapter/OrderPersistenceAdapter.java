package com.coffeedays.coffeedays_api.adapter;

import com.coffeedays.coffeedays_api.entities.OrderEntity;
import com.coffeedays.coffeedays_api.entities.OrderItemEntity;
import com.coffeedays.coffeedays_api.entities.ProductEntity;
import com.coffeedays.coffeedays_api.mapper.OrderMapper;
import com.coffeedays.coffeedays_api.models.Order;
import com.coffeedays.coffeedays_api.models.OrderItem;
import com.coffeedays.coffeedays_api.port.OrderPersistencePort;
import com.coffeedays.coffeedays_api.repository.OrderRepository;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements OrderPersistencePort {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    @Override
    public Order persist(Order order) {
        OrderEntity orderEntity = orderMapper.toEntity(order);
        order.getOrderItem().forEach(orderItem -> {
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            orderItemEntity.setId(orderItem.getId());
            orderItemEntity.setPrice(orderItem.getPrice());
            orderEntity.addOrderItem(orderItemEntity);
        });
        orderRepository.save(orderEntity);
        return order;
    }
    @Override
    public List<Order> getAllOrder() {
        List<OrderEntity> order = StreamSupport.stream(orderRepository.findAll().spliterator(),false).toList();
        return orderMapper.toOrder(order);
    }

}
