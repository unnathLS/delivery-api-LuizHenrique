package com.deliverytech.delivery.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private boolean ativo;
    private String cpf;
    private String telefone;

    /**
     * Construtor para criar um cliente com os campos obrigatórios.
     *
     * @param nome O nome do cliente.
     * @param email O email do cliente.
     * @param ativo Indica se o cliente está ativo.
     * @param cpf O CPF do cliente.
     * @param telefone O telefone do cliente.
     */
    public Cliente(String nome, String email, boolean ativo, String spf, String telefone){
        this.nome = nome;
        this.email = email;
        this.ativo = ativo;
        this.cpf = spf;
        this.telefone = telefone;
    }
}
