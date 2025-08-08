package com.deliverytech.delivery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String categoria;
    private boolean ativo;
    private Double avaliacao;

    public Restaurante(){

    }
    public Restaurante(String nome, String categoria, boolean ativo, Double avaliacao ){
        this.nome = nome;
        this.categoria = categoria;
        this.ativo = ativo;
        this.avaliacao = avaliacao;
    }
}
