package com.deliverytech.delivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverytech.delivery.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    List<Produto> findByAtivoTrue();
    List<Produto> findByRestauranteId(Long restauranteId);    
    // List<Produto> findAll();
} 
