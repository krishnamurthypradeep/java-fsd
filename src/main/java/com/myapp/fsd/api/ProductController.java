package com.myapp.fsd.api;

import com.myapp.fsd.domain.Product;
import com.myapp.fsd.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    private ProductRepository repository;
    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(repository.findAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer   id) {
        return ResponseEntity.ok(repository.findById(id).get());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Integer id,
            @RequestBody Product updatedProduct
    ) {
        return repository.findById(id)
                .map(existingProduct -> {
                    // Update fields
                    existingProduct.setName(updatedProduct.getName());
                    existingProduct.setPrice(updatedProduct.getPrice());
                    existingProduct.setDescription(updatedProduct.getDescription());
                    existingProduct.setProductAvailable(updatedProduct.isProductAvailable());
                    existingProduct.setStarRating(updatedProduct.getStarRating());
                    existingProduct.setImageUrl(updatedProduct.getImageUrl());
                    repository.save(existingProduct);
                    return ResponseEntity.ok(existingProduct);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

// CI CD
// Version Control (Git and Github)
// Testing (Junit)
// CI Server (Github Actions)
// Docker (Containerization) Dev|QA|Prod

// Devops
// CI CD
// IAC (Terraform)
// Monitoring (Splunk, Grafana)
