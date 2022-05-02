package ru.geekbrains.lesson3.assignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.lesson3.assignment.models.Product;
import ru.geekbrains.lesson3.assignment.services.CartService;
import ru.geekbrains.lesson3.assignment.services.ProductService;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProductList();
    }

    @DeleteMapping("/products/remove")
    public void removeFromList(@RequestParam Long productId) {
        productService.removeFromList(productId);
    }

    @PostMapping("/products/add")
    public void addToCart(@RequestParam Long productId) {
        cartService.addProductToCart(productId);
    }

    @GetMapping("/cart")
    public List<Product> getCart() {
        return cartService.getProductsInCart();
    }

}
