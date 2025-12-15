package com.coffeedays.coffeedays_api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Product {
    private Integer id;
    private String name;
    private String description;
    private Double price;

}
