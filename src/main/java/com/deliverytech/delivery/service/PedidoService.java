package com.deliverytech.delivery.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery.entity.ItemPedido;
import com.deliverytech.delivery.entity.Pedido;
import com.deliverytech.delivery.entity.Produto;
import com.deliverytech.delivery.entity.Restaurante;
import com.deliverytech.delivery.repository.PedidoRepository;
import com.deliverytech.delivery.repository.ProdutoRepository;
import com.deliverytech.delivery.repository.RestauranteRepository;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private RestauranteRepository restauranteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;


    public Pedido criarPedido(Pedido pedido) {
        Restaurante restaurante = restauranteRepository.findById(pedido.getRestaurante().getId())
                .orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado."));

        BigDecimal valorTotal = CalcularValorTotal(pedido.getItens());

        valorTotal = valorTotal.add(restaurante.getTaxaEntrega());
        // pedido.setValorTotal(valorTotal);
        pedido.setRestaurante(restaurante);

        return pedidoRepository.save(pedido);
    }

    private BigDecimal CalcularValorTotal(List<ItemPedido> itens) {
        BigDecimal total = BigDecimal.ZERO;

        for (ItemPedido item : itens) {
            Produto produto = produtoRepository.findById(item.getProduto().getId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + item.getProduto().getId()));
            item.setProduto(produto); // garante que o produto está completo com preço
        }
        return total;
    }

    public List<Pedido> buscarPedidos() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> buscarPedidosProCliente(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }

    // public List<Pedido> buscarPedidosPorRestaurante(long restauranteId) {
    // return restauranteRepository.findByRestauranteId(restauranteId);
    // }
}