package com.coffeedays.coffeedays_api.models;

public class Product {
    private String name;
    private String description;
    private Double price;
    private Integer amount;

    public String getName() {
        return name;
    }
    public void setNome(String nome) {
        this.name = nome;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price){
        this.price = price;
    }
    public Integer getAmount(){
        return amount;
    }
    public void setAmount(Integer amount){
        this.amount = amount;
    }
}
