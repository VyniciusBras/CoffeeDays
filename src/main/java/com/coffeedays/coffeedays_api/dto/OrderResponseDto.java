package com.coffeedays.coffeedays_api.dto;

import lombok.Data;

@Data
public class OrderResponseDto {
    private String name;
    private Integer orderId;
    private String orderStatus;
    private Double totalPrice;
}
