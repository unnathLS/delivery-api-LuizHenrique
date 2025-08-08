package com.deliverytech.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery.entity.Cliente;
import com.deliverytech.delivery.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public Cliente cadastrar(Cliente cliente){
        if (clienteRepository.findByEmail(cliente.getEmail().isPresent())){
            throw new IllegalArgumentException("Email já cadastrado!");
        }
        cliente.setAtivo(true);
        return clienteRepository.save(cliente);
    }

    public List<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id){
        return clienteRepository.findById(id);
    }

    public Cliente atualizar(Long id, Cliente clienteAtualizado){
        return clienteRepository.findById(id)
            .map(clienteExistente -> {
                clienteExistente.setNome(clienteAtualizado.getNome());
                clienteExistente.setEmail(clienteAtualizado.getEmail());
                return clienteRepository.save(clienteExistente);
            }).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));
    }

    public void inativar(Long id){
        clienteRepository.finndById(id)
            .ifPresent(cliente ->{
                cliente.setAtivo(false);
                clienteRepository.save(cliente);
            });
    }



}
