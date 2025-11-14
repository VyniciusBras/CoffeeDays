package com.coffeedays.coffeedays_api.controllers;

import com.coffeedays.coffeedays_api.dto.OrderRequestDto;
import com.coffeedays.coffeedays_api.dto.OrderResponseDto;
import com.coffeedays.coffeedays_api.models.Order;
import com.coffeedays.coffeedays_api.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")   // <-- Agora todos endpoints começam com /orders
public class OrderController {

    private final ProductService productService;

    @PostMapping()
    public ResponseEntity<?> order(@RequestBody OrderRequestDto orderRequestDto) {
            Map<String, String> errors = productService.validateProducts(orderRequestDto.product);

            if (!errors.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
            }

            Order order = new Order();
            order.setClient(orderRequestDto.client);
            order.setProduct(orderRequestDto.product);
            order.setDateOrder(LocalDateTime.now());
            order.setOrderId((int)(Math.random() * 100000));
            order.setOrderStatus("CONFIRMED");
            //Criar um OrderRepository com uma lista de Orders e salvar essa order criada na lista de Orders
            OrderResponseDto orderResponseDto = mapOrderToOrderResponseDto(order);
        return ResponseEntity.ok().body(orderResponseDto);
    }

    @GetMapping
    public ResponseEntity<?> getOrders() {
        // Como ainda não existe armazenamento real, retorna vazio
        return ResponseEntity.ok().body(List.of());
    }

    private OrderResponseDto mapOrderToOrderResponseDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();

        if (order.getClient() != null && order.getClient().getName() != null) {
            responseDto.setName(order.getClient().getName());
        }

        responseDto.setOrderId(order.getOrderId());
        responseDto.setOrderStatus(order.getOrderStatus());
        responseDto.setTotalPrice(order.getTotalPrice());

        return responseDto;
    }
}
