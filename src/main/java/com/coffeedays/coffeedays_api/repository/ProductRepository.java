package com.coffeedays.coffeedays_api.repository;

import com.coffeedays.coffeedays_api.models.Product;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private List<Product> products;
    
    public ProductRepository() {
        products = new ArrayList<>();
        Product capuccino = new Product(1, "Capuccino","O Cappuccino é uma bebida italiana clássica e cremosa, feita à base de café espresso.",8.0,30);
        Product mocaccino = new Product(2, "Mocaccino","O Mocaccino é uma bebida quente feita com café espresso, leite e chocolate, sendo uma variação do cappuccino.",7.0,25);
        Product macchiato_caramelo = new Product(3, "Macchiato de Caramelo","O Macchiato de Caramelo é uma popular bebida de café em camadas que combina café expresso, leite vaporizado ou frio, xarope de baunilha e uma finalização com calda de caramelo.",10.0,20);
        Product cafe_mocha = new Product(4, "Café Mocha","O café mocha é uma bebida de café que combina expresso, leite vaporizado e chocolate.",9.0,17);
        Product cafe_expresso = new Product(5, "Café Expresso","O Café expreso é uma bebida concentrada feita pela passagem de água quente sob alta pressão através de café moído e compactado.",9.0,17);
        products.add(capuccino);
        products.add(mocaccino);
        products.add(macchiato_caramelo);
        products.add(cafe_mocha);
        products.add(cafe_expresso);
    }

    public Optional<Product> findById(Integer id) {
        return products.stream()
                .filter(product -> product.getId() != null && product.getId().equals(id))
                .findFirst();
    }

    public Optional<Product> findByName(String name) {
        return products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public boolean isQuantityAvailable(Integer productId, Integer requestedAmount) {
        Optional<Product> product = findById(productId);
        if (product.isPresent()) {
            return product.get().getAmount() >= requestedAmount;
        }
        return false;
    }

    public Integer getAvailableQuantity(Integer productId) {
        Optional<Product> product = findById(productId);
        return product.map(Product::getAmount).orElse(0);
    }

    public boolean productExists(Integer productId) {
        return findById(productId).isPresent();
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
}
