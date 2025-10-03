package com.deliverytech.delivery.controller;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery.entity.Restaurante;
import com.deliverytech.delivery.service.RestauranteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/restaurantes")
@RequiredArgsConstructor
public class RestauranteController {
    // TODO: Implementar o controller do restaurante
    private final RestauranteService restauranteService;

    @PostMapping
    public ResponseEntity<Restaurante> criarRestaurante(@RequestBody Restaurante restaurante) {
        Restaurante novoRestaurante = restauranteService.cadastroRestaurante(restaurante);
        return new ResponseEntity<>(novoRestaurante, HttpStatus.CREATED);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Restaurante>> listaRestaurantes() {
        List<Restaurante> restaurantes = restauranteService.listarRestaurantes();
        return new ResponseEntity<>(restaurantes, HttpStatus.OK);
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<Restaurante>> listarRestaurantesAtivos() {
        List<Restaurante> restaurantesAtivos = restauranteService.listarRestaurantes();
        return new ResponseEntity<>(restaurantesAtivos, HttpStatus.OK);
    }

    @PatchMapping("/ativar/{id}")
    public ResponseEntity<Restaurante> ativar(@PathVariable Long id) {
        restauranteService.ativarRestaurante(id);
        return ResponseEntity.ok().build();

    }

    @PatchMapping("/desativar/{id}")
    public ResponseEntity<Restaurante> desativar(@PathVariable Long id) {
        restauranteService.desativarRestaurante(id);
        return ResponseEntity.ok().build();
    }

}
