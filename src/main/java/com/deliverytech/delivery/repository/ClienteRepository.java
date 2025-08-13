package com.deliverytech.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverytech.delivery.entity.Cliente;

import java.util.*;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    List<Cliente> findByAtivoTrue();
}
