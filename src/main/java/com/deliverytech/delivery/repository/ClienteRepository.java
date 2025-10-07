package com.deliverytech.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import com.deliverytech.delivery.entity.Cliente;

import java.util.*;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Override    
    Optional<Cliente> findById(@NonNull Long id);

    List<Cliente> findByStatusTrue();

    Optional<Cliente> findByEmail(String email);



    boolean existsByEmail(String email);

    boolean existsByTelefone(String Telefone);
}
