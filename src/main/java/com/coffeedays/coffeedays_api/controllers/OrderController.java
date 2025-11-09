package com.coffeedays.coffeedays_api.controllers;

import com.coffeedays.coffeedays_api.dto.OrderRequestDto;
import com.coffeedays.coffeedays_api.dto.OrderResponseDto;
import com.coffeedays.coffeedays_api.models.Order;
import com.coffeedays.coffeedays_api.models.Product;
import com.coffeedays.coffeedays_api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final ProductRepository productRepository;

    @PostMapping("/order")
    public ResponseEntity<?> order(@RequestBody OrderRequestDto orderRequestDto) {
        // Verificar se os produtos existem e se há quantidade disponível
        Map<String, String> errors = validateProducts(orderRequestDto.product);
        
        if (!errors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        Order order = new Order();
        order.setClient(orderRequestDto.client);
        order.setProduct(orderRequestDto.product);
        order.setDateOrder(LocalDateTime.now());
        
        // Mapear de Order para OrderResponseDto
        OrderResponseDto orderResponseDto = mapOrderToOrderResponseDto(order);

        return ResponseEntity.ok().body(orderResponseDto);
    }

    private Map<String, String> validateProducts(java.util.List<Product> products) {
        Map<String, String> errors = new HashMap<>();
        
        if (products == null || products.isEmpty()) {
            errors.put("error", "A lista de produtos não pode estar vazia");
            return errors;
        }

        for (Product product : products) {
            Integer productId = product.getId();
            
            if (productId == null) {
                errors.put("product", "ID do produto é obrigatório");
                continue;
            }
            
            if (!productRepository.productExists(productId)) {
                errors.put("product_" + productId, "Produto não encontrado com ID: " + productId);
                continue;
            }

            Integer requestedAmount = product.getAmount();
            if (requestedAmount == null || requestedAmount <= 0) {
                errors.put("product_" + productId, "Quantidade solicitada inválida para o produto ID: " + productId);
                continue;
            }

            if (!productRepository.isQuantityAvailable(productId, requestedAmount)) {
                Integer availableQuantity = productRepository.getAvailableQuantity(productId);
                errors.put("product_" + productId, "Quantidade insuficiente. Disponível: "
                        + availableQuantity + ", Solicitado: " + requestedAmount);
            }
        }
        
        return errors;
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
