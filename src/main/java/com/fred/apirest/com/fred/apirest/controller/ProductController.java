package com.fred.apirest.com.fred.apirest.controller;

import com.fred.apirest.com.fred.apirest.entity.Product;
import com.fred.apirest.com.fred.apirest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
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

    //Consider using a Service layer

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No founded product with ID: " + id));

    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productUpdating) {
        Product productExisting = productRepository.findById(id).orElseThrow(() -> new RuntimeException("No founded product with id: " + id));

        productExisting.setName(productUpdating.getName());
        productExisting.setPrice(productUpdating.getPrice());
        return productRepository.save(productExisting);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No founded product with ID: " + id));

        productRepository.delete(product);
        return "The product with ID: " + id + " was deleted correctly";
    }

}
