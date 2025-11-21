package com.coffeedays.coffeedays_api.controllers;

import com.coffeedays.coffeedays_api.dto.CreateProductDto;
import com.coffeedays.coffeedays_api.models.Product;
import com.coffeedays.coffeedays_api.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductDto dto) {

        Product product = new Product(
                null,
                dto.getName(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getAmount()
        );

        Product createdProduct = productService.createProduct(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }


}
