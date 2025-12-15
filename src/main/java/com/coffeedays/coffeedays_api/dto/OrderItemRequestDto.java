package com.coffeedays.coffeedays_api.dto;

import lombok.Data;

@Data
public class OrderItemRequestDto {

    private Integer productId;
    private Double price;
    private Integer amount;
}
