package com.deliverytech.delivery.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.deliverytech.delivery.dto.PedidoResponseDTO;
import com.deliverytech.delivery.dto.ItemPedidoResponseDTO;
import com.deliverytech.delivery.dto.PedidoRequestDTO;
import com.deliverytech.delivery.entity.ItemPedido;
import com.deliverytech.delivery.entity.Produto;
import com.deliverytech.delivery.entity.Pedido;
import com.deliverytech.delivery.enums.StatusPedido;
import com.deliverytech.delivery.repository.ClienteRepository;
import com.deliverytech.delivery.repository.PedidoRepository;
import com.deliverytech.delivery.repository.ProdutoRepository;
// import com.deliverytech.delivery.repository.RestauranteRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {
   private final ClienteRepository clienteRepository;
   private final PedidoRepository pedidoRepository;
   private final ProdutoRepository produtoRepository;
   // private final RestauranteRepository restauranteRepository;

   @Transactional
   public Pedido criarPedido(PedidoRequestDTO pedidoDTO) {
      Pedido pedido = new Pedido();
      pedido.setCliente(clienteRepository.findById(pedidoDTO.getClienteId())
            .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado")));

      List<ItemPedido> itens = pedidoDTO.getProdutos().stream().map(itemDTO -> {
         Produto produto = produtoRepository.findById(itemDTO.getProdutoId())
               .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado: " + itemDTO.getProdutoId()));

         ItemPedido item = new ItemPedido();
         item.setPedido(pedido); // Associa o item ao pedido que está a ser criado
         item.setProduto(produto);
         item.setQuantidade(itemDTO.getQuantidade());
         item.setPrecoUnitario(produto.getPreco());
         return item;
      }).toList();

      pedido.setItens(itens);
      pedido.setValorTotal(this.calcularValorTotal(itens)); // Usa o método privado
      pedido.setStatus(StatusPedido.PENDENTE);
      // dataCriacao é gerada automaticamente pela anotação @CreationTimestamp na
      // entidade Pedido

      return pedidoRepository.save(pedido);
   }

   private BigDecimal calcularValorTotal(List<ItemPedido> itens) {
      return itens.stream()
            .map(item -> item.getPrecoUnitario().multiply(BigDecimal.valueOf(item.getQuantidade())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
   }

   public List<PedidoResponseDTO> listarPedidos() {
      List<Pedido> pedidos = pedidoRepository.findAll();
      return pedidos.stream()
            .map(this::toResponseDTO)
            .toList();
   }

   @Transactional
   public Pedido confirmarPedido(Long pedidoId) {
      Pedido pedido = findByIdOrThrow(pedidoId);
      if (pedido.getStatus() != StatusPedido.PENDENTE) {
         throw new IllegalStateException("Apenas pedidos pendentes podem ser confirmados.");
      }
      pedido.setStatus(StatusPedido.CONFIRMADO);
      pedido.setDataAtualizacao(LocalDateTime.now());
      return pedidoRepository.save(pedido);
   }

   @Transactional
   public Pedido cancelarPedido(Long pedidoId) {
      Pedido pedido = findByIdOrThrow(pedidoId);
      if (pedido.getStatus() == StatusPedido.ENTREGUE || pedido.getStatus() == StatusPedido.CANCELADO) {
         throw new IllegalStateException("Pedidos entregues ou já cancelados não podem ser cancelados.");
      }
      pedido.setStatus(StatusPedido.CANCELADO);
      pedido.setDataAtualizacao(LocalDateTime.now());
      return pedidoRepository.save(pedido);
   }

   @Transactional
   public Pedido iniciarPreparo(Long pedidoId) {
      Pedido pedido = findByIdOrThrow(pedidoId);
      if (pedido.getStatus() != StatusPedido.CONFIRMADO) {
         throw new IllegalStateException("Apenas pedidos confirmados podem iniciar o preparo.");
      }
      pedido.setStatus(StatusPedido.EM_PREPARO);
      pedido.setDataAtualizacao(LocalDateTime.now());
      return pedidoRepository.save(pedido);
   }

   @Transactional
   public Pedido enviarPedido(Long pedidoId) {
      Pedido pedido = findByIdOrThrow(pedidoId);
      if (pedido.getStatus() != StatusPedido.EM_PREPARO) {
         throw new IllegalStateException("Apenas pedidos EM PREPARO podem ser enviados.");
      }
      pedido.setStatus(StatusPedido.ENVIADO);
      return pedidoRepository.save(pedido);
   }

   @Transactional
   public Pedido entregarPedido(Long pedidoId) {
      Pedido pedido = findByIdOrThrow(pedidoId);
      if (pedido.getStatus() != StatusPedido.ENVIADO) {
         throw new IllegalStateException("Apenas pedidos enviados podem ser entregues.");
      }
      pedido.setStatus(StatusPedido.ENTREGUE);
      pedido.setDataAtualizacao(LocalDateTime.now());
      return pedidoRepository.save(pedido);
   }

   public PedidoResponseDTO toResponseDTO(Pedido pedido) {
      return new PedidoResponseDTO(
            pedido.getId(),
            pedido.getStatus().name(),
            pedido.getValorTotal(),
            pedido.getDataCriacao(),
            pedido.getItens().stream().map(item -> new ItemPedidoResponseDTO(
                  item.getProduto().getId(),
                  item.getProduto().getNome(),
                  item.getQuantidade(),
                  item.getPrecoUnitario() // <-- CORREÇÃO APLICADA AQUI
            )).toList());
   }

   public Pedido findByIdOrThrow(Long pedidoId) {
      return pedidoRepository.findById(pedidoId)
            .orElseThrow(() -> new IllegalArgumentException("Pedido com ID " + pedidoId + " não encontrado."));
   }
}