package com.coffeedays.coffeedays_api.controllers;

import com.coffeedays.coffeedays_api.dto.OrderRequestDto;
import com.coffeedays.coffeedays_api.dto.OrderResponseDto;
import com.coffeedays.coffeedays_api.models.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class OrderController {

    @PostMapping("/order")
    public ResponseEntity<OrderResponseDto> order(@RequestBody OrderRequestDto orderRequestDto) {
        Order order = new Order();

        order.setClient(orderRequestDto.client);
        order.setProduct(orderRequestDto.product);
        order.setDateOrder(LocalDateTime.now());
        
        // Mapear de Order para OrderResponseDto
        OrderResponseDto orderResponseDto = mapOrderToOrderResponseDto(order);

        //Criar a classe ProductRepository, utilizando ela para criar uma metodo e verificar a quantidade disponivel

        //Adicionar um ID nos Produtos para fazer a comparação, verificando se o produto existe ou não
        return ResponseEntity.ok().body(orderResponseDto);
    }

    private OrderResponseDto mapOrderToOrderResponseDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        
        if (order.getClient() != null) {
            responseDto.setName(order.getClient().getName());
        }
        responseDto.setOrderId(order.getOrderId());
        responseDto.setOrderStatus(order.getOrderStatus());
        responseDto.setTotalPrice(order.getTotalPrice());
        
        return responseDto;
    }
}
