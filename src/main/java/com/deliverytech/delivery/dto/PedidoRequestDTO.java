package com.deliverytech.delivery.dto;

import java.util.List;

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
public class PedidoRequestDTO {

    @NotNull
    private Long clienteId;

    @NotNull
    private Long restauranteId;

    @NotNull
    @Min(1)
    private List<ItemPedidoRequestDTO> produtos;

    
    public PedidoRequestDTO(Long clienteId, List<ItemPedidoRequestDTO> produtos) {
        this.clienteId = clienteId;
        this.produtos = produtos;
    }

}
