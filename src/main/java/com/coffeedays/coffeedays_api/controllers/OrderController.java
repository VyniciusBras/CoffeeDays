package com.coffeedays.coffeedays_api.controllers;

import com.coffeedays.coffeedays_api.dto.OrderItemRequestDto;
import com.coffeedays.coffeedays_api.dto.OrderRequestDto;
import com.coffeedays.coffeedays_api.dto.OrderResponseDto;
import com.coffeedays.coffeedays_api.models.Order;
import com.coffeedays.coffeedays_api.models.OrderItem;
import com.coffeedays.coffeedays_api.services.OrderService;
import com.coffeedays.coffeedays_api.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final ProductService productService;
    private final OrderService orderService;

    @PostMapping()
    public ResponseEntity<?> order(@RequestBody OrderRequestDto orderRequestDto) {
//            Map<String, String> errors = productService.validateProducts(orderRequestDto.order);
//
//            if (!errors.isEmpty()) {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
//            }

            Order order = new Order();
            order.setClient(orderRequestDto.client);
            order.setOrderItem(mapOrderItemRequestDtoToOrderItem(orderRequestDto.items));
            order.setOrderDate(LocalDateTime.now());
            order.setOrderStatus("CONFIRMADO");
            orderService.createOrder(order);

            OrderResponseDto orderResponseDto = mapOrderToOrderResponseDto(order);
        return ResponseEntity.ok().body(orderResponseDto);
    }

    @GetMapping
    public ResponseEntity<?> getOrders() {

        return ResponseEntity.ok().body(List.of());
    }

    private List<OrderItem> mapOrderItemRequestDtoToOrderItem(List<OrderItemRequestDto> orderItemRequestDto) {
        List<OrderItem> orderItems = new ArrayList<>();
        orderItemRequestDto.forEach(orderItemRequest -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setAmount(orderItemRequest.getAmount());
            orderItem.setPrice(orderItemRequest.getPrice());
            orderItems.add(orderItem);
        });
        return orderItems;
    }

    private OrderResponseDto mapOrderToOrderResponseDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();

        if (order.getClient() != null && order.getClient().getName() != null) {
            responseDto.setName(order.getClient().getName());
        }

        responseDto.setOrderId(order.getOrderId());
        responseDto.setOrderStatus(order.getOrderStatus());
        //responseDto.setTotalPrice(order.getTotalPrice());

        return responseDto;
    }
}
