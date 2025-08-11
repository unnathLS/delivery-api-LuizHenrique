package com.deliverytech.delivery.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.deliverytech.delivery.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByClienteId(Long clienteId);

    @Query("SELECT p FROM Pedido p WHERE p.cliente.id = :clienteId AND p.status = :status AND p.pedidoData BETWEEN :dataInicial AND :dataFinal")
    List<Pedido> findByClienteIdAndStatusAndPedidoDataBetween(
        @Param("clienteId") Long clienteId,
        @Param("status") String status,
        @Param("dataInicial") LocalDateTime dataInicial,
        @Param("dataFinal") LocalDateTime dataFinal);

    List<Pedido> findByClienteIdAndStatus(Long clienteId, String status);

    List<Pedido> findByStatus(String status);

}
