package com.deliverytech.delivery.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery.entity.Cliente;
import com.deliverytech.delivery.service.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.cadastroCliente(cliente);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarCliente();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<Cliente>> clienteAtivos() {
        List<Cliente> clienteAtivos = clienteService.listarClientesAtivos();
        return new ResponseEntity<>(clienteAtivos, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Cliente> buscarClienteID(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarClientePorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
}
