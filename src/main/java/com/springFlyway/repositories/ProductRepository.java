package com.springFlyway.repositories;

import com.springFlyway.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, UUID> {
    Optional<ProductModel> findByNomeProduto(String nomeProduto);
    Optional<ProductModel> findByDescricaoProduto(String descricaoProduto);
    Optional<ProductModel> findByEan(String ean);
    Optional<ProductModel> findByCategoriaProduto(String categoriaProduto);
}
