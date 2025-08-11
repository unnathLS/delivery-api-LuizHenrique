package com.deliverytech.delivery.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.deliverytech.delivery.entity.Cliente;
import com.deliverytech.delivery.entity.Pedido;
import com.deliverytech.delivery.entity.StatusPedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    /**
     * Busca todos os pedidos de um cliente específico.
     * 
     * @param cliente O objeto Cliente para buscar.
     * @return Uma lista de pedidos do cliente.
     */
    List<Pedido> findByClienteId(Long clienteId);

    /**
     * Busca pedidos com base no cliente, status e um intervalo de datas.
     * 
     * @param cliente     O cliente associado ao pedido.
     * @param status      O status do pedido (por exemplo, "Em Andamento",
     *                    "Finalizado").
     * @param dataInicial Data inicial do período de busca.
     * @param dataFinal   Data final do período de busca.
     * @return Uma lista de pedidos que correspondem aos critérios.
     */
    // Método corrigido para buscar pedidos por cliente, status e datas
    @Query("SELECT p FROM Pedido p WHERE p.cliente.id = :clienteId AND p.status = :status AND p.dataPedido BETWEEN :dataInicial AND :dataFinal")
    List<Pedido> buscarPedidosPorClienteStatusEData(
            @Param("clienteId") Long clienteId,
            @Param("status") StatusPedido status,
            @Param("dataInicial") LocalDateTime dataInicial,
            @Param("dataFinal") LocalDateTime dataFinal);

    /**
     * Encontra todos os pedidos de um cliente específico com um determinado status.
     *
     * @param clienteId O ID do cliente.
     * @param status    O status dos pedidos a serem buscados (por exemplo,
     *                  "EM_PREPARACAO").
     * @return Uma lista de pedidos que correspondem aos critérios.
     */
    List<Pedido> findByClienteIdAndStatus(Long clienteId, String status);

    /**
     * Busca todos os pedidos com um determinado status.
     *
     * @param status O status dos pedidos a serem buscados (por exemplo,
     *               "EM_PREPARACAO").
     * @return Uma lista de pedidos que correspondem ao status.
     */
    List<Pedido> findByStatus(StatusPedido status);

}
