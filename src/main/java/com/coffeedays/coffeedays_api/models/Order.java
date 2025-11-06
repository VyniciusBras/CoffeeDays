package com.coffeedays.coffeedays_api.models;
import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Client client;
    private List<Product> product;
    private LocalDateTime dateOrder;

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public List<Product> getProduct() {
        return product;
    }
    public void setProduct(List<Product> product) {
    this.product = product;
    }
    public LocalDateTime getDateOrder() {
    return dateOrder;
    }
    public void setDateOrder(LocalDateTime dateOrder) {
    this.dateOrder = dateOrder;
    }
}
