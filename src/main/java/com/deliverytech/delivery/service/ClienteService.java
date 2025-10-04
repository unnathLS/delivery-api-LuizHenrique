package com.deliverytech.delivery.service;

import java.util.List;
// import java.util.Optional;
// import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.deliverytech.delivery.dto.ClienteRequestDTO;
import com.deliverytech.delivery.dto.ClienteResponseDTO;
import com.deliverytech.delivery.entity.Cliente;
import com.deliverytech.delivery.repository.ClienteRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteResponseDTO cadastroCliente(ClienteRequestDTO requestDTO) {
        Cliente clienteCadastro = mapToEntity(requestDTO);

        if (clienteRepository.existsByEmail(requestDTO.getEmail())) {
            throw new IllegalArgumentException("E-mail já cadastro!");
        }

        Cliente clienteCadastrado = clienteRepository.save(clienteCadastro);

        return mapToResponseDTO(clienteCadastrado);
    }

    public List<ClienteResponseDTO> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes.stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());

    }

    public List<ClienteResponseDTO> listarClientesAtivos() {

        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .filter(cliente -> cliente.isAtivo())
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());

    }

    public ClienteResponseDTO busarClientePorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        return new ClienteResponseDTO(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(),
                cliente.isAtivo());
    }

    public ClienteResponseDTO buscarClientePorEmail(String email) {
        Cliente cliente = clienteRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Email não encontrado"));

        return new ClienteResponseDTO(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(),
                cliente.isAtivo());
    }

    public ClienteResponseDTO atualizarCliente(Long id, ClienteRequestDTO dto) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        clienteExistente.setNome(dto.getNome());
        clienteExistente.setEmail(dto.getEmail());
        clienteExistente.setTelefone(dto.getTelefone());

        Cliente clienteAtualizado = clienteRepository.save(clienteExistente);

        return mapToResponseDTO(clienteAtualizado);
    }

    public ClienteResponseDTO desativarCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        cliente.setAtivo(!cliente.isAtivo());
        Cliente clienteAtualizado = clienteRepository.save(cliente);

        return mapToResponseDTO(clienteAtualizado);
    }

    // public void ativarCLiente(Long id) {
    // Cliente cliente = clienteRepository.findById(id)
    // .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
    // cliente.setAtivo(true);
    // clienteRepository.save(cliente);
    // }

    private Cliente mapToEntity(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();

        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());
        cliente.setAtivo(true);
        return cliente;
    }

    private ClienteResponseDTO mapToResponseDTO(Cliente entity) {
        return new ClienteResponseDTO(
                entity.getId(),
                entity.getNome(),
                entity.getTelefone(),
                entity.getEmail(),
                entity.isAtivo());
    }

}
