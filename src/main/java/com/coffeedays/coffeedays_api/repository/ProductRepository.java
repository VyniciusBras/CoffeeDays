package com.coffeedays.coffeedays_api.repository;

import com.coffeedays.coffeedays_api.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product>  products;
    public ProductRepository() {
        products = new ArrayList<>();
        Product capuccino = new Product("Capuccino","O Cappuccino é uma bebida italiana clássica e cremosa, feita à base de café espresso,",8.0,30);
        Product mocaccino = new Product("Mocaccino","O Mocaccino é uma bebida quente feita com café espresso, leite e chocolate, sendo uma variação do cappuccino,",7.0,25);
        products.add(capuccino);
        products.add(mocaccino);
    }
}
