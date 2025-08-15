package com.deliverytech.delivery.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome produto é obrigatório.")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "A descrição do produto é obrigatório.")
    private String descricao;

    @NotBlank(message = "A categoria do produto é obrigatório.")
    private String categoria;

    @NotNull
    private boolean disponibilidade;

    @NotNull(message = "O preço do produto é obrigatório.")
    @Positive
    @DecimalMin("0.01")
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "restaurante_id", nullable = false)
    // @NotNull(message = "O restaurate do produto é obrigatório.")
    private Restaurante restaurante;
}
