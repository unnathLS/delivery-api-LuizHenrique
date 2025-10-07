package com.deliverytech.delivery.service;

import java.util.*;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery.dto.RestauranteRequestDTO;
import com.deliverytech.delivery.entity.Restaurante;
import com.deliverytech.delivery.exception.BusinessException;
import com.deliverytech.delivery.repository.RestauranteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestauranteService {

    private final RestauranteRepository restauranteRepository;

    public Restaurante cadastrarRestaurante(Restaurante restaurante) {
        if(restauranteRepository.existsByCnpj(restaurante.getCnpj())){
            throw new BusinessException("CNPJ já cadastrado no sistema.");
        }

    }


    public static Restaurante toEntity(RestauranteRequestDTO dto){
        Restaurante restaurante = new Restaurante();
        restaurante.setNome(dto.getNome());
        restaurante.setCnpj(dto.getCnpj());
        restaurante.setEmailContato(dto.getEmailContato());
        restaurante.setTelefone(dto.getTelefone());
        restaurante.setEndereco(dto.getEndereco());
        restaurante.setDescricao(dto.getDescricao());
        restaurante.setTaxaEntrega(dto.getTaxaEntrega());
        restaurante.setCategoria(dto.getCategoria());
        restaurante.setStatus(dto.isStatus());
        restaurante.setAvaliacao(dto.getAvaliacao());
        restaurante.setObservacao(dto.getObservacao());
        return restaurante;
    }

}
