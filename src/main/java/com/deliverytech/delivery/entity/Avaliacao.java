package com.deliverytech.delivery.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente usuario; // quem fez a avaliação

    @ManyToOne
    @JoinColumn(nullable = false)
    private Restaurante restaurante; // restaurante avaliado

    @DecimalMin("0.0")
    @DecimalMax("5.0")
    private BigDecimal nota;

    private String comentario;

    private LocalDateTime dataCriacao = LocalDateTime.now();
}
