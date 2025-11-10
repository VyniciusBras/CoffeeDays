package com.coffeedays.coffeedays_api.services;

import com.coffeedays.coffeedays_api.models.Product;
import com.coffeedays.coffeedays_api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Map<String, String> validateProducts(List<Product> products) {
        Map<String, String> errors = new HashMap<>();
        
        if (products == null || products.isEmpty()) {
            errors.put("error", "A lista de produtos não pode estar vazia");
            return errors;
        }

        for (Product product : products) {
            Integer productId = product.getId();
            
            if (productId == null) {
                errors.put("product", "ID do produto é obrigatório");
                continue;
            }
            
            if (!productRepository.productExists(productId)) {
                errors.put("product_" + productId, "Produto não encontrado com ID: " + productId);
                continue;
            }

            Integer requestedAmount = product.getAmount();
            if (requestedAmount == null || requestedAmount <= 0) {
                errors.put("product_" + productId, "Quantidade solicitada inválida para o produto ID: " + productId);
                continue;
            }

            if (!productRepository.isQuantityAvailable(productId, requestedAmount)) {
                Integer availableQuantity = productRepository.getAvailableQuantity(productId);
                errors.put("product_" + productId, "Quantidade insuficiente. Disponível: "
                        + availableQuantity + ", Solicitado: " + requestedAmount);
            }
        }
        
        return errors;
    }
}

