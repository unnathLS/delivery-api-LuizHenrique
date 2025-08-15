package com.deliverytech.delivery.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery.entity.Produto;

import com.deliverytech.delivery.service.ProdutoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;

    @PostMapping("/cadastrar-produto/{restauranteId}")
    public ResponseEntity<Produto> cadastroProduto(
            @Valid @RequestBody Produto produto,
            @PathVariable Long restauranteId) { // Corrigido para restauranteId
        Produto produtoSalvo = produtoService.criarProduto(produto, restauranteId);
        return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Produto>> listarProdutos() {
        List<Produto> listar = produtoService.listaDeProdutos();
        return new ResponseEntity<>(listar, HttpStatus.OK);
    }
}
