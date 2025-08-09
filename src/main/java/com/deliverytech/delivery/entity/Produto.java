package com.deliverytech.delivery.entity;

import java.math.BigDecimal;

// import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String categoria;
    private String descricao;
    private boolean disponibilidade;
    private BigDecimal preco;

    @ManyToOne
    private Restaurante restaurante;

    public Produto() {

    }

    public Produto(String nome, String categoria, boolean disponibilidade, Restaurante restaurante, BigDecimal preco,
            String descricao) {
        this.nome = nome;
        this.categoria = categoria;
        this.disponibilidade = disponibilidade;
        this.restaurante = restaurante;
        this.preco = preco;
        this.descricao = descricao;
    }

}
