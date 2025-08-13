package com.deliverytech.delivery.entity;
import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoria;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private boolean ativo;

    @ManyToOne
    private Restaurante restaurante;
}
