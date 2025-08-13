package com.deliverytech.delivery.controller;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery.entity.Produto;
import com.deliverytech.delivery.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/ativos")
    public List<Produto> listarProdutosAtivos() {
        return produtoService.buscarProdutosAtivo();
    }

    @GetMapping("/todos")
    public List<Produto> listarTodosProdutos() {
        return produtoService.buscarTodos();
    }


    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto){
        try {
            Produto produtoSalvo = produtoService.cadastarProduto(produto);
            return produtoSalvo;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Erro ao cadastrar produto: " + e.getMessage());
        }
    }
}
