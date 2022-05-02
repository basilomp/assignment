package ru.geekbrains.lesson3.assignment.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.lesson3.assignment.models.Product;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class ProductRepository {

    private List<Product> products;

    private LinkedList<Product> productList;

    public LinkedList<Product> findAll() {
        return productList;

    }

    public Product findById(Long id) {
        return productList.stream().filter(p -> p.getId()
                .equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void removeFromList(Long productId) {
        productList.removeIf(product -> product.getId().equals(productId));
    }


    @PostConstruct
    public void init() {
        products = Arrays.asList(
                new Product(1L, "Chocolate bar", 99),
                new Product(2L, "Bacon-flavored crisps", 107),
                new Product(3L, "Sparkling water", 75),
                new Product(4L, "Canned tuna", 201),
                new Product(5L, "Instant coffee", 412)
        );
        productList = new LinkedList<>();
        productList.addAll(products);

    }
}
