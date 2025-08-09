package com.deliverytech.delivery.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data;
    private String status;
    private BigDecimal valorTotal;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Restaurante restaurante;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Produto> produtos;

    public Pedido() {
    }

    public Pedido(Date data, String status, Long id, Cliente cliente, Restaurante restaurante, BigDecimal valorTotal) {
        this.data = data;
        this.status = status;
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.valorTotal = valorTotal;
    }
}
