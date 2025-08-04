package com.myapp.fsd.api;

import com.myapp.fsd.domain.Product;
import com.myapp.fsd.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
