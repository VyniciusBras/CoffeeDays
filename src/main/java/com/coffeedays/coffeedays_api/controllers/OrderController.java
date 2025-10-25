package com.coffeedays.coffeedays_api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {
    @GetMapping("/busca_api")
    public String buscaApi(@RequestParam int id) {
        if (id == 1){
            return "capuccino";
        }
        if (id == 2){
            return "mocaccino";
        }
        return "Café fora de estoque!";
    }
}
