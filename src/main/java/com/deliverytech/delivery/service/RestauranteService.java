package com.deliverytech.delivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery.entity.Restaurante;
import com.deliverytech.delivery.repository.RestauranteRepository;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public Restaurante cadastrar(Restaurante restaurante) {
        restaurante.setAtivo(true);
        return restauranteRepository.save(restaurante);
    }

    public List<Restaurante> buscarTodos() {
        return restauranteRepository.findAll();
    }

    public Optional<Restaurante> buscarPorId(Long id) {
        return restauranteRepository.findById(id);
    }

    public Restaurante atualizar(Long id, Restaurante restauranteAtualizado) {
        return restauranteRepository.findById(id).map(
                restauranteExistente -> {
                    restauranteExistente.setNome(restauranteAtualizado.getNome());
                    restauranteExistente.setCategoria(restauranteAtualizado.getCategoria());
                    return restauranteRepository.save(restauranteExistente);
                }).orElseThrow(() -> new IllegalArgumentException("Resturante não encontrado!"));
    }

    public void ativar(Long id) {
        restauranteRepository.findById(id).ifPresent(
                restaurante -> {
                    restaurante.setAtivo(true);
                    restauranteRepository.save(restaurante);
                });
    }

    public void inativar(Long id) {
        restauranteRepository.findById(id).ifPresent(
                restaurante -> {
                    restaurante.setAtivo(false);
                    restauranteRepository.save(restaurante);
                });
    }

}
