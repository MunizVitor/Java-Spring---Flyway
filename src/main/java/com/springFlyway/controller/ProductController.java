package com.springFlyway.controller;

import com.springFlyway.model.ProductModel;
import com.springFlyway.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("flyway")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @PostMapping("/save")
    public ResponseEntity createProduct(@Validated @RequestBody ProductModel product) {
        var productExistente = repository.findByNomeProduto(product.getNomeProduto());
        if(productExistente.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Produto já existe");
        }
        repository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto criado com sucesso, código do produto: " + product.getEan());
    }

    @GetMapping("products")
    public ResponseEntity getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @GetMapping("products/{codigoProduto}")
    public ResponseEntity getCodigoProducts(@PathVariable String codigoProduto) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findByEan(codigoProduto)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado pelo código: " + codigoProduto)));
    }

    @GetMapping("products/{descricaoProduto}")
    public ResponseEntity getDescricaoProducts(@PathVariable String descricaoProduto) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findByDescricaoProduto(descricaoProduto)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado pela descrição: " + descricaoProduto)));
    }

    @GetMapping(value = "products", params = "nomeProduto")
    public ResponseEntity<?> getNomeProducts(@RequestParam String nomeProduto) {
        return repository.findByNomeProduto(nomeProduto)
                .map(product -> ResponseEntity.ok(product))
                .orElseGet(() -> (ResponseEntity<ProductModel>) ResponseEntity.status(HttpStatus.NOT_FOUND));
    }

}
