package com.coffeedays.coffeedays_api.models;
import java.time.LocalDateTime;
import java.util.List;

public class Sale {
    private Client client;
    private List<Product> product;
    private LocalDateTime dateSale;

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
    public LocalDateTime getDateSale() {
    return dateSale;
    }
    public void setDateSale(LocalDateTime dateSale) {
    this.dateSale = dateSale;
    }
}
