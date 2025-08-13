package com.deliverytech.delivery.service;

import java.util.*;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery.entity.Restaurante;
import com.deliverytech.delivery.repository.RestauranteRepository;

@Service
public class RestauranteService {
    private final RestauranteRepository restauranteRepository;

    public RestauranteService(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public List<Restaurante> listarRestaurantesAtivo() {
        return restauranteRepository.findByAtivoTrue();
    }
    public List<Restaurante> listarTodos() {
        return restauranteRepository.findAll();
    }

    public Restaurante buscarRestaurantePorId(Long id) {
        return restauranteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado."));
    }
    
    public Restaurante salvarRestaurante(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

}
