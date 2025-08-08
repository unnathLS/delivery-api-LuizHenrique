package com.deliverytech.delivery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private boolean ativo;

    public Cliente() {
    }

    public Cliente(String email, String nome, boolean ativo) {
        this.email = email;
        this.nome = nome;
        this.ativo = ativo;
    }

}