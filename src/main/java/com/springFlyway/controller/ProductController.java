package com.springFlyway.controller;

import com.springFlyway.model.ProductModel;
import com.springFlyway.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flyway")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @PostMapping("/save")
    public ResponseEntity createProduct(@Validated @RequestBody ProductModel product) {
        ProductModel productExistente = repository.findBy(product.getNomeProduto());

    }
}
