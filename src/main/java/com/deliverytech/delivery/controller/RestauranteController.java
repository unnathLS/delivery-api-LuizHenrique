package com.deliverytech.delivery.controller;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery.entity.Restaurante;
import com.deliverytech.delivery.service.RestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
    private final RestauranteService restauranteService;

    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @GetMapping("/ativos")
    public List<Restaurante> listarRestaurantesAtivo() {
        return restauranteService.listarRestaurantesAtivo();
    }

    @GetMapping("/todos")
    public List<Restaurante> listarTodos() {
        return restauranteService.listarTodos();
    }

    @PostMapping
    public Restaurante criarRestaurante(@RequestBody Restaurante restaurante) {
        return restauranteService.salvarRestaurante(restaurante);
    }

}
