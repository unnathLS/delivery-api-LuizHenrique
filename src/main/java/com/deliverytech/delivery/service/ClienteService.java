package com.deliverytech.delivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.deliverytech.delivery.entity.Cliente;
import com.deliverytech.delivery.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public Cliente cadastroCliente(Cliente cliente) {
        if (cliente.getEmail() == null || cliente.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email é obrigatório");
        }
        if (clienteRepository.existsByEmail(cliente.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado");
        }
        if (cliente.getTelefone() == null || cliente.getTelefone().isEmpty()) {
            throw new IllegalArgumentException("Telefone é obrigatório");
        }
        if (clienteRepository.existsByTelefone(cliente.getTelefone())) {
            throw new IllegalArgumentException("Telefone já cadastrado");
        }
        cliente.setAtivo(true);
        return clienteRepository.save(cliente);
    }
    
    public List<Cliente> listarCliente(){
        return clienteRepository.findAll();
    }

    public List<Cliente> listarClientesAtivos() {
        return clienteRepository.findByAtivoTrue();
    }

    public Optional<Cliente> buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }
}
