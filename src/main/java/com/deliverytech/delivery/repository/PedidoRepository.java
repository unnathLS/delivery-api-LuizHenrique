package com.deliverytech.delivery.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.deliverytech.delivery.entity.Cliente;
import com.deliverytech.delivery.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    /**
     * Busca todos os pedidos de um cliente específico.
     * 
     * @param cliente O objeto Cliente para buscar.
     * @return Uma lista de pedidos do cliente.
     */
    List<Pedido> findByCliente(Cliente cliente);

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
    @Query("SELECT p FROM Pedido p WHERE p.cliente = :cliente AND p.status = :status AND p.data BETWEEN :dataInicial AND :dataFinal")
    List<Pedido> buscarPedidosPorClienteStatusEData(
            @Param("cliente") Cliente cliente,
            @Param("status") String status,
            @Param("dataInicial") Date dataInicial,
            @Param("dataFinal") Date dataFinal);

}
