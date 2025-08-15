package com.deliverytech.delivery.service;

import java.math.BigDecimal;
import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery.entity.Produto;
import com.deliverytech.delivery.entity.Restaurante;
import com.deliverytech.delivery.repository.ProdutoRepository;
import com.deliverytech.delivery.repository.RestauranteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final RestauranteRepository restauranteRepository;

    public Produto criarProduto(Produto produto, Long id) {
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado"));
        produto.setRestaurante(restaurante);
        produto.setDisponibilidade(true);
        return produtoRepository.save(produto);
    }

    public List<Produto> listaDeProdutos() {
        return produtoRepository.findAll();
    }

}
