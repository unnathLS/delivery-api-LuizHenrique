package com.deliverytech.delivery.service;

import java.util.*;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery.entity.Restaurante;
import com.deliverytech.delivery.repository.RestauranteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestauranteService {
    private final RestauranteRepository restauranteRepository;

    public Restaurante cadastroRestaurante(Restaurante restaurante) {
        if (restauranteRepository.existsByEmail(restaurante.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado.");
        }
        if (restauranteRepository.existsByTelefone(restaurante.getTelefone())) {
            throw new IllegalArgumentException("Telefone já cadastrado.");
        }
        // TODO: Padronizar o cpnj antes de salvar no banco de dados
        if (restauranteRepository.existsByCnpj(restaurante.getCnpj())) {
            throw new IllegalArgumentException("CNPJ já cadastrado.");
        }
        restaurante.setAtivo(true);
        return restauranteRepository.save(restaurante);
    }

    public List<Restaurante> listarRestaurantes() {
        return restauranteRepository.findAll();
    }

    public List<Restaurante> listaRestaurantesAtivos() {
        return restauranteRepository.findByAtivoTrue();
    }

    public Optional<Restaurante> buscarResutarantesPorId(Long id) {
        return restauranteRepository.findById(id);
    }
    // TODO: Implementar atualização de cadastro para restaurantes mais para frente

    public void desativarRestaurante(Long id) {
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado com o ID: " + id));
        restaurante.setAtivo(false);
        restauranteRepository.save(restaurante);
    }

    public void ativarRestaurante(Long id) {
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado."));
        restaurante.setAtivo(true);
        restauranteRepository.save(restaurante);
    }

}
