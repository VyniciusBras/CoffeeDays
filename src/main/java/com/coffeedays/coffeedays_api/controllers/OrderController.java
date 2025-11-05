package com.coffeedays.coffeedays_api.controllers;

import com.coffeedays.coffeedays_api.dto.SaleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {
    @PostMapping("/sale")
    public void sale(@RequestBody SaleDto saleDto) {

    }
}
