package com.deliverytech.delivery.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.deliverytech.delivery.entity.Pedido;
import com.deliverytech.delivery.entity.Produto;
import com.deliverytech.delivery.repository.ClienteRepository;
import com.deliverytech.delivery.repository.PedidoRepository;
import com.deliverytech.delivery.repository.ProdutoRepository;

@Service
public class PedidoService {
    BigDecimal valorTotal = BigDecimal.ZERO;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Pedido criar(Pedido pedido) {
        clienteRepository.findById(pedido.getCliente().getId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));

        for (Produto produto : pedido.getProdutos()) {
            Produto produtoExistente = produtoRepository.findById(produto.getId())
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Produto com ID " + produto.getId() + " não encontrado."));
            valorTotal = valorTotal.add(produtoExistente.getPreco());
        }

        pedido.setValorTotal(valorTotal);
        pedido.setStatus("Em processamento.");

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> buscarTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido atualizarStatus(Long id, String novoStatus) {
        return pedidoRepository.findById(id)
                .map(pedidoExistente -> {
                            pedidoExistente.setStatus(novoStatus);
                            return pedidoRepository.save(pedidoExistente);
                        }) .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado."));
    }

}
