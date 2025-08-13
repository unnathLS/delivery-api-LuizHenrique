package com.deliverytech.delivery.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery.entity.Produto;
import com.deliverytech.delivery.repository.ProdutoRepository;
import com.deliverytech.delivery.repository.RestauranteRepository;

@Service
public class ProdutoService {
    @Autowired
    private  ProdutoRepository produtoRepository;
    @Autowired
    private  RestauranteRepository restauranteRepository;

    public Produto cadastarProduto(Produto produto){
        if (produto.getPreco().compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("O preço do produto não pode ser negativo.");
        }
        restauranteRepository.findById(produto.getRestaurante().getId()).orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado."));
        return produtoRepository.save(produto);
    }
    
    public List<Produto> buscarTodos(){
        return produtoRepository.findAll();
    }
    
    public List<Produto> buscarProdutosAtivo(){
        return produtoRepository.findByAtivoTrue();
    }


}
