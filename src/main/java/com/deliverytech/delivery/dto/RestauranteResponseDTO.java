package com.deliverytech.delivery.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestauranteResponseDTO {
    
    private Long id;
    private String nome;
    private String descricao;
    private String emailContato;
    private String telefone;
    private String endereco;
    private String cnpj;
    private BigDecimal taxaEntrega;
    private BigDecimal avaliacao;
    private String observacao;
    private String categoria;
    private boolean status;
    private LocalDateTime dataCadastro = LocalDateTime.now();
}
