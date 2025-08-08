package com.deliverytech.delivery.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data;
    private String status;

    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Restaurante restaurante;
    
    public Pedido(){

    }

    public Pedido(Date data,  String status, Long id, Cliente cliente, Restaurante restaurante){
        this.data = data;
        this.status = status; 
        this.cliente = cliente;
        this.restaurante = restaurante;
    }
}
