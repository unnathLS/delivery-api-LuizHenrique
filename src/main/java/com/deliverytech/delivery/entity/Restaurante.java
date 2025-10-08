package com.deliverytech.delivery.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.math.RoundingMode;

import jakarta.persistence.*;
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

    private String nome;
    private String descricao;
    private String emailContato;
    private String telefone;
    private String endereco;
    private String cnpj;
    // private BigDecimal avaliacao;
    private BigDecimal taxaEntrega;
    private String observacao;
    private String categoria;
    private boolean status = true;

    private LocalDateTime dataCadastro = LocalDateTime.now();

    // @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL, orphanRemoval
    // = true)
    // private List<Avaliacao> avaliacoes = new ArrayList<>();

    // public void atualizarMediaAvaliacao() {
    // if (avaliacoes.isEmpty()) {
    // this.avaliacao = BigDecimal.ZERO;
    // return;
    // }
    // BigDecimal soma = avaliacoes.stream()
    // .map(Avaliacao::getNota)
    // .reduce(BigDecimal.ZERO, BigDecimal::add);
    // // no entity mantém exato
    // this.avaliacao = soma.divide(BigDecimal.valueOf(avaliacoes.size()));

    // // no DTO ou Controller
    // BigDecimal avaliacaoFormatada = restaurante.getAvaliacao().setScale(1,
    // BigDecimal.ROUND_HALF_UP);

    // }

    public Restaurante(String nome, String descricao, String emailContato, String telefone,
            String endereco, String cnpj, BigDecimal taxaEntrega, String categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.emailContato = emailContato;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.taxaEntrega = taxaEntrega;
        this.categoria = categoria;
    }
}
