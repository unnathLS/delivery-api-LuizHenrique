package com.deliverytech.delivery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import com.deliverytech.delivery.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByCategoria(String categoria);

    List<Produto> findByDisponibilidade(boolean disponibilidade);

    @Override
    @NonNull
    List<Produto> findAll();
}
