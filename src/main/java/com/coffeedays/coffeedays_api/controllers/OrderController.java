package com.coffeedays.coffeedays_api.controllers;

import com.coffeedays.coffeedays_api.dto.OrderDto;
import com.coffeedays.coffeedays_api.models.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class OrderController {

    @PostMapping("/order")
    public void sale(@RequestBody OrderDto orderDto) {
        Order order = new Order();

        order.setClient(orderDto.client);
        order.setProduct(orderDto.product);
        order.setDateOrder(LocalDateTime.now());

        System.out.println("Pedido criado: " + order);
    }
}
