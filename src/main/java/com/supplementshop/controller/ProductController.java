package com.supplementshop.controller;

import com.supplementshop.model.Product;
import com.supplementshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}/stock")
    public Product updateStock(@PathVariable Integer id, @RequestBody Map<String, Integer> stockUpdate) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setStock(stockUpdate.get("stock"));
        return productRepository.save(product);
    }
}