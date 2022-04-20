package ru.geekbrains.lesson3.assignment.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.lesson3.assignment.models.Product;

import java.util.List;

@Component
public class CartRepository {

    @Autowired
    private List<Product> productsInCart;

}
