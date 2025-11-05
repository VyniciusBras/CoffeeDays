package com.coffeedays.coffeedays_api.models;

public class Client {
    private String name;
    private String document;
    private String email;

    public String getNome() {
        return name;
    }
    public void setNome(String nome) {
        this.name = name;
    }
    public String getDocument() {
        return document;
    }
    public void setDocument(String document) {
        this.document = document;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
}
