package ru.geekbrains.lesson3.assignment.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.lesson3.assignment.models.Product;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> productList;

    public List<Product> findAll() {
        return Collections.unmodifiableList(productList);
    }

    public Product findById(Long id) {
        return productList.stream().filter(p -> p.getId()
                .equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }


    @PostConstruct
    public void init() {
        productList = Arrays.asList(
                new Product(1L, "Chocolate bar", 99),
                new Product(2L, "Bacon-flavored crisps", 107),
                new Product(3L, "Sparkling water", 75),
                new Product(4L, "Canned tuna", 201),
                new Product(5L, "Instant coffee", 412)
        );
    }
}
