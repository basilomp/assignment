package ru.geekbrains.lesson3.assignment.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.lesson3.assignment.models.Product;
import ru.geekbrains.lesson3.assignment.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProduct(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    public void removeFromList(Long id) {
        productRepository.removeFromList(id);
    }

}
