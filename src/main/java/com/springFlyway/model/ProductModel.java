package com.springFlyway.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true, length = 13)
    private String ean;

    private String nomeProduto;
    private String descricaoProduto;
    private BigDecimal precoProduto;

    @PrePersist
    public void gerarEan() {
        if (ean == null) {
            ean = gerarCodigoEan();
        }
    }

    private String gerarCodigoEan() {
        return String.valueOf(
                (long)(Math.random() * 9000000000000L)
                        + 1000000000000L
        );
    }

}
