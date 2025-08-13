package com.deliverytech.delivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverytech.delivery.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // List<Pedido> findAll();

    List<Pedido> findByClienteId(Long clienteId);

    List<Pedido> findByRestauranteId(Long restauranteId);
}
