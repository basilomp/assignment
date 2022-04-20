package ru.geekbrains.lesson3.assignment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.geekbrains.lesson3.assignment.models.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CartService {

    @Autowired
    private ProductService productService;

    private List<Product> productsInCart = new ArrayList<>();

    public void addProductToCart(Long id) {
        productsInCart.add(productService.getProduct(id));
    }

    private void removeProductFromCart(Long id) {
        productsInCart.remove(productService.getProduct(id));
    }

    public List<Product> getProductsInCart() {
        return productsInCart;
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(productsInCart);
    }
}
