package com.coffeedays.coffeedays_api.mapper;

import com.coffeedays.coffeedays_api.entities.OrderEntity;
import com.coffeedays.coffeedays_api.models.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderEntity toEntity(Order order);
    List<Order> toOrder(List<OrderEntity> orderEntity);
}
