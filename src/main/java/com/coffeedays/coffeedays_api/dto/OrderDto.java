package com.coffeedays.coffeedays_api.dto;

import com.coffeedays.coffeedays_api.models.Client;
import com.coffeedays.coffeedays_api.models.Product;
import java.util.List;

public class OrderDto {
    public Client client;
    public List<Product> product;
}
