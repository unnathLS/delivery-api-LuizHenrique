package com.deliverytech.delivery.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do restaurante é obrigatório.")
    private String nome;

    @NotBlank(message = "O email do restaurante é obrigatório.")
    @Email(message = "Email inválido.")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "O telefone do restaurante é obrigatório.")
    @Pattern(regexp = "\\(?\\d{2}\\)?\\s?9\\d{4}-?\\d{4}", message = "Número de telefone Inválido.")
    private String telefone;

    @NotBlank(message = "O endereço do restaurante é obrigatório.")
    private String endereco;

    @NotBlank(message = "O cpnj do restaurante é obrigatório.")
    @Pattern(regexp = "\\d{14}|\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}", message = "CNPJ deve ter 14 dígitos numéricos ou estar no formato 00.000.000/0000-00.")
    @Column(nullable = false, unique = true, length = 18)
    private String cnpj;

    @PositiveOrZero
    @Digits(integer = 6, fraction = 2)
    @Column(nullable = false)
    private BigDecimal taxaEntrega;

    private String descricao;

    private String comentario;

    @DecimalMin("0.0")
    @DecimalMax("5.0")

    private String avalicao;

    @NotBlank(message = "A categoria é obrigatória.")
    private String categoria;

    private boolean ativo;

    public Restaurante(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

}
