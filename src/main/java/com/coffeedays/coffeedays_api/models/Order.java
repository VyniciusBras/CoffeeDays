package com.coffeedays.coffeedays_api.models;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Order {
    private Client client;
    private List<Product> product;
    private LocalDateTime dateOrder;
    private Integer orderId;
    private String orderStatus;
    private Double totalPrice;

    public Double getTotalPrice() {
        return product.stream().map(prod -> prod.getPrice() * prod.getAmount()).reduce(0.0, Double::sum);
    }

}
