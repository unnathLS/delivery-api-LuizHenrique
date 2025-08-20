package com.deliverytech.delivery.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

// import jakarta.validation.constraints.Min;
// import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoResponseDTO {

    private Long id;
    private Long clienteId;
    private Long restauranteId;
    private String status;
    private BigDecimal valorTotal;
    private LocalDateTime dataCriacao;
    private List<ItemPedidoResponseDTO> itens;

    /**
     * Construtor customizado para ser usado pelo PedidoService.
     * 
     * @param id          O ID do pedido.
     * @param status      O status atual do pedido.
     * @param valorTotal  O valor total do pedido.
     * @param dataCriacao A data de criação do pedido.
     * @param itens       A lista de itens do pedido.
     */
    public PedidoResponseDTO(Long id, String status, BigDecimal valorTotal, LocalDateTime dataCriacao,
            List<ItemPedidoResponseDTO> itens) {
        this.id = id;
        this.status = status;
        this.valorTotal = valorTotal;
        this.dataCriacao = dataCriacao;
        this.itens = itens;
    }
}
