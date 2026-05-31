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

    @PostMapping("products/save")
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

    @GetMapping("products/codigo/{codigoProduto}")
    public ResponseEntity<?> getCodigoProducts(@PathVariable String codigoProduto) {
        return ResponseEntity.ok(repository.findByEan(codigoProduto)
                        .orElseThrow(() -> new RuntimeException("Produto não encontrado pelo código: " + codigoProduto))
        );
    }

    @GetMapping("products/descricao/{descricaoProduto}")
    public ResponseEntity<?> getDescricaoProducts(@PathVariable String descricaoProduto) {
        return ResponseEntity.ok(repository.findByDescricaoProduto(descricaoProduto)
                        .orElseThrow(() -> new RuntimeException("Produto não encontrado pela descrição: " + descricaoProduto))
        );
    }

    @GetMapping("products/nome/{nomeProduto}")
    public ResponseEntity<?> getNomeProducts(@PathVariable String nomeProduto) {
        return ResponseEntity.ok(repository.findByNomeProduto(nomeProduto)
                        .orElseThrow(() -> new RuntimeException("Produto não encontrado pelo nome: " + nomeProduto))
        );
    }

    @GetMapping("products/categoria/{categoriaProduto}")
    public ResponseEntity<?> getCategoriaProducts(@PathVariable String categoriaProduto) {
        return ResponseEntity.ok(repository.findByCategoriaProduto(categoriaProduto)
                        .orElseThrow(() -> new RuntimeException("Produto não encontrado pela categoria: " + categoriaProduto))
        );
    }

}
