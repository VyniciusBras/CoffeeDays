package com.coffeedays.coffeedays_api.models;

import lombok.Data;

@Data
public class OrderItem {

    private Integer orderId;
    private Integer Id;

    private Product product;
    private Double price;
    private Integer amount;


}
