package com.coffeedays.coffeedays_api.models;
import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Client client;
    private List<Product> product;
    private LocalDateTime dateOrder;
    private Integer orderId;
    private String orderStatus;
    private Double totalPrice;

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
    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public String getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public Double getTotalPrice() {
        return product.stream().map(prod -> prod.getPrice() * prod.getAmount()).reduce(0.0, Double::sum);
    }

}
