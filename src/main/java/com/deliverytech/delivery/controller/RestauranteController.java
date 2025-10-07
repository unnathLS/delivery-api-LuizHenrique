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

}
