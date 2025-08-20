package com.deliverytech.delivery.dto;

import java.math.BigDecimal;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoResponseDTO {

    // INÍCIO DA CORREÇÃO 1: Adicionar o campo para o ID do produto
    @NotNull
    private Long produtoId;
    // FIM DA CORREÇÃO 1

    @NotNull
    private String nomeProduto;

    @NotNull
    private BigDecimal precoUnitario;

    @NotNull
    @Min(1)
    private Integer quantidade;

    // INÍCIO DA CORREÇÃO 2: Adicionar o construtor customizado
    /**
     * Construtor para ser usado pelo PedidoService.
     * @param produtoId O ID do produto.
     * @param nomeProduto O nome do produto.
     * @param quantidade A quantidade de itens.
     * @param precoUnitario O preço de uma unidade do produto.
     */
    public ItemPedidoResponseDTO(Long produtoId, String nomeProduto, Integer quantidade, BigDecimal precoUnitario) {
        this.produtoId = produtoId;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }
    // FIM DA CORREÇÃO 2
}