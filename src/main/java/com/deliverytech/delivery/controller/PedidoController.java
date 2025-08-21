package com.deliverytech.delivery.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.service.annotation.PatchExchange;

import com.deliverytech.delivery.dto.PedidoRequestDTO;
import com.deliverytech.delivery.dto.PedidoResponseDTO;
import com.deliverytech.delivery.entity.Pedido;
import com.deliverytech.delivery.service.PedidoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> criarPedido(@RequestBody PedidoRequestDTO pedidoDTO) {
        Pedido novoPedido = pedidoService.criarPedido(pedidoDTO);

        PedidoResponseDTO responseDTO = pedidoService.toResponseDTO(novoPedido);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<PedidoResponseDTO>> listarPedido(@PathVariable Long id) {
        List<PedidoResponseDTO> listaDePedidoDTO = pedidoService.listarPedidos();
        return new ResponseEntity<>(listaDePedidoDTO, HttpStatus.OK);
    }
    @PutMapping("/{id}/confirmar")
    public ResponseEntity<PedidoResponseDTO>confirmaPedido(@PathVariable Long id){
        Pedido pedidoConfirmado = pedidoService.confirmarPedido(id);
        PedidoResponseDTO responseDTO = pedidoService.toResponseDTO(pedidoConfirmado);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    
    @PutMapping("/{id}/preparo")
    public ResponseEntity<PedidoResponseDTO> prepararPedido(@PathVariable Long id) {
        Pedido pedidoPreparado = pedidoService.iniciarPreparo(id);
        PedidoResponseDTO responseDTO = pedidoService.toResponseDTO(pedidoPreparado);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}/enviar")
    public ResponseEntity<PedidoResponseDTO> enviarPedido(@PathVariable Long id){
        Pedido pedidoEnviado = pedidoService.enviarPedido(id);
        PedidoResponseDTO responseDTO = pedidoService.toResponseDTO(pedidoEnviado);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}/entregar")
    public ResponseEntity<PedidoResponseDTO> entregarPedido(@PathVariable Long id){
        Pedido pedidoEntregue = pedidoService.entregarPedido(id);
        PedidoResponseDTO responseDTO = pedidoService.toResponseDTO(pedidoEntregue);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<PedidoResponseDTO> cancelarPedido(@PathVariable Long id){
        Pedido pedidoCancelado = pedidoService.cancelarPedido(id);
        PedidoResponseDTO responseDTO = pedidoService.toResponseDTO(pedidoCancelado);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
