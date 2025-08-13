package com.deliverytech.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverytech.delivery.entity.Cliente;

import java.util.*;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    Optional<Cliente> findById(Long id);
    List<Cliente> findByAtivoTrue();
    List<Cliente> findAll();
    Optional<Cliente> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByTelefone(String Telefone);
}
