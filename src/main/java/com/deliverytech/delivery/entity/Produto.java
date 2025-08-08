package com.deliverytech.delivery.entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String categoria;
    private boolean disponibilidade;

    @ManyToOne
    private Restaurante restaurante;

    public Produto(){

    }
    public Produto(String nome, String categoria, boolean disponibilidade, Restaurante restaurante){
        this.nome = nome;
        this.categoria = categoria;
        this.disponibilidade = disponibilidade;
        this.restaurante = restaurante;
    }

}
