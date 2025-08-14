package com.deliverytech.delivery.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
// import jakarta.validation.constraints.Size;
// import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Table(name = "cliente", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
})
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email inválido")
    @Column(nullable = false, unique = true)
    private String email;

    // @NotBlank(message = "O CPF é obrigatório")
    // @Pattern(regexp = "\\d{11}", message = "CPF deve conter exatamente 11 dígitos
    // númericos")
    // @Column(nullable = false , unique = true, length = 11)
    // private String cpf;

    @NotBlank(message = "O telefone é obrigatório")
    @Pattern(regexp = "\\(?\\d{2}\\)?\\s?9\\d{4}-?\\d{4}", message = "Número de telefone Inválido.")
    @Column(nullable = false, unique = true)
    private String telefone;
    private boolean ativo;

}
