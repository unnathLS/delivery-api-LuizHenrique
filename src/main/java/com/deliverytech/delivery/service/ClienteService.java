package com.deliverytech.delivery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.deliverytech.delivery.entity.Cliente;
import com.deliverytech.delivery.repository.ClienteRepository;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }
    public List<Cliente> listarClientesAtivos(){
        return clienteRepository.findByAtivoTrue();
    }
    public Cliente salvarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }
}
