package com.deliverytech.delivery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery.exception.EntityNotFoundException;
import com.deliverytech.delivery.dto.ClienteRequestDTO;
import com.deliverytech.delivery.dto.ClienteResponseDTO;
import com.deliverytech.delivery.entity.Cliente;
import com.deliverytech.delivery.exception.BusinessException;
import com.deliverytech.delivery.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ModelMapper modelMapper;

    public ClienteResponseDTO cadastroCliente(ClienteRequestDTO requestDTO) {
        if (clienteRepository.existsByEmail(requestDTO.getEmail())) {
            throw new BusinessException("E-mail já cadastrado!");
        }

        // Mapear DTO para entidade automaticamente
        Cliente clienteCadastro = modelMapper.map(requestDTO, Cliente.class);
        clienteCadastro.setStatus(true); // garantir que cliente novo esteja ativo

        Cliente clienteCadastrado = clienteRepository.save(clienteCadastro);

        // Mapear entidade para DTO de response
        return modelMapper.map(clienteCadastrado, ClienteResponseDTO.class);
    }

    public List<ClienteResponseDTO> listarClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(cliente -> modelMapper.map(cliente, ClienteResponseDTO.class))
                .collect(Collectors.toList());
    }

    public List<ClienteResponseDTO> listarClientesAtivos() {
        return clienteRepository.findAll()
                .stream()
                .filter(Cliente::isStatus)
                .map(cliente -> modelMapper.map(cliente, ClienteResponseDTO.class))
                .collect(Collectors.toList());
    }

    public ClienteResponseDTO buscarClientePorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        return modelMapper.map(cliente, ClienteResponseDTO.class);
    }

    public ClienteResponseDTO buscarClientePorEmail(String email) {
        Cliente cliente = clienteRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Email não encontrado"));

        return modelMapper.map(cliente, ClienteResponseDTO.class);
    }

    public ClienteResponseDTO atualizarCliente(Long id, ClienteRequestDTO dto) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        // Atualizar campos do DTO para a entidade existente
        modelMapper.map(dto, clienteExistente);

        Cliente clienteAtualizado = clienteRepository.save(clienteExistente);

        return modelMapper.map(clienteAtualizado, ClienteResponseDTO.class);
    }

    public ClienteResponseDTO statusCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        cliente.setStatus(!cliente.isStatus());
        Cliente clienteAtualizado = clienteRepository.save(cliente);

        return modelMapper.map(clienteAtualizado, ClienteResponseDTO.class);
    }
}
