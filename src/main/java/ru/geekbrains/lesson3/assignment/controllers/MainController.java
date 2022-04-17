package ru.geekbrains.lesson3.assignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.lesson3.assignment.services.CartService;
import ru.geekbrains.lesson3.assignment.services.ProductService;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @GetMapping("")
    public String test(Model model) {
        model.addAttribute("items", productService.getProductList());
            model.addAttribute("inCart", cartService);
        return "products";
    }

    @GetMapping("/cart")
    public String getCart(Model model) {
        model.addAttribute("cart", cartService);
        return "cart";
    }

}
