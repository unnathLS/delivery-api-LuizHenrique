package com.deliverytech.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.*;
import com.deliverytech.delivery.entity.Restaurante;
import java.util.List;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    List<Restaurante> findByAtivoTrue();

    // List<Restaurante> findAll();

}
