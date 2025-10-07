package com.deliverytech.delivery.dto;

import java.math.BigDecimal;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestauranteRequestDTO {

    @NotBlank(message = "O nome do restaurante é obrigatório.")
    private String nome;

    private String descricao;

    @NotBlank(message = "O email do restaurante é obrigatório.")
    @Email(message = "Email inválido.")
    private String emailContato;

    @NotBlank(message = "O telefone do restaurante é obrigatório.")
    @Pattern(regexp = "\\(?\\d{2}\\)?\\s?9\\d{4}-?\\d{4}", message = "Número de telefone inválido.")
    private String telefone;

    @NotBlank(message = "O endereço do restaurante é obrigatório.")
    private String endereco;

    @NotBlank(message = "O CNPJ é obrigatório.")
    @Pattern(regexp = "\\d{14}|\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}", message = "CNPJ inválido.")
    private String cnpj;

    @PositiveOrZero(message = "A taxa de entrega deve ser positiva.")
    private BigDecimal taxaEntrega;

    private String observacao;

    @NotBlank(message = "A categoria é obrigatória.")
    private String categoria;

    private boolean status = true;
}
