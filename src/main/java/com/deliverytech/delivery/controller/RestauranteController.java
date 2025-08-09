package com.deliverytech.delivery.controller;

import com.deliverytech.delivery.entity.Restaurante;
import com.deliverytech.delivery.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping
    public ResponseEntity<Restaurante> cadastrar(@RequestBody Restaurante restaurante){
        Restaurante novoRestaurante = restauranteService.cadastrar(restaurante);
        return new ResponseEntity<>(novoRestaurante, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Restaurante>> buscarTodos(){
        List<Restaurante> restaurantes = restauranteService.buscarTodos();
        return new ResponseEntity<>(restaurantes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> buscarPorId(@PathVariable Long id){
        return restauranteService.buscarPorId(id)
            .map(restaurante -> new ResponseEntity<>(restaurante, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> atualizar(@PathVariable Long id, @RequestBody Restaurante restauranteAtualizado){
        try{
            Restaurante restaurante = restauranteService.atualizar(id, restauranteAtualizado);
            return new ResponseEntity<>(restaurante, HttpStatus.OK);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PatchMapping("/{id}/ativar")
    public ResponseEntity<Restaurante> ativar(@PathVariable Long id ){
        try{
            restauranteService.ativar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}/inativar")
    public ResponseEntity<Restaurante> inativar(@PathVariable Long id ){
        try{
            restauranteService.inativar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
