package com.deliverytech.delivery.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery.entity.Pedido;
import com.deliverytech.delivery.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/todos")
    public List<Pedido> listarTodosPedidos() {
        return pedidoService.buscarPedidos();
    }

    @PostMapping
    public ResponseEntity<Pedido> pedidoFeito(@RequestBody Pedido pedido) {
        Pedido pedidoCriado = pedidoService.criarPedido(pedido);
        return ResponseEntity.ok(pedidoCriado);
    }

}
