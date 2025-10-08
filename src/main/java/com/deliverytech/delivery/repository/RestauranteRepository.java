package com.deliverytech.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

// import java.util.*;
import com.deliverytech.delivery.entity.Restaurante;
import java.util.List;
import java.util.Optional;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    @Override
    @NonNull
    Optional<Restaurante> findById(Long id);

    @Override
    @NonNull
    List<Restaurante> findAll();

    List<Restaurante> findByNome(String nome);

    List<Restaurante> findByCategoriaContainingIgnoreCase(String categoria);

    List<Restaurante> findByStatusTrue();

    // List<Restaurante> findByAvalicao(String avalicao);

    // boolean existsByEmail(String email);

    // boolean existsByTelefone(String telefon2e);

    boolean existsByCnpj(String cpnj);

}
