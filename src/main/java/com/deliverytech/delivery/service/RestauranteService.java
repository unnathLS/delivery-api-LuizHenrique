package com.deliverytech.delivery.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery.dto.RestauranteRequestDTO;
import com.deliverytech.delivery.dto.RestauranteResponseDTO;
import com.deliverytech.delivery.entity.Restaurante;
import com.deliverytech.delivery.exception.BusinessException;
import com.deliverytech.delivery.exception.EntityNotFoundException;
import com.deliverytech.delivery.repository.RestauranteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestauranteService {

    private final RestauranteRepository restauranteRepository;
    private final ModelMapper modelMapper;

    public RestauranteResponseDTO cadastroRestaurante(RestauranteRequestDTO dto) {
        if (restauranteRepository.existsByCnpj(dto.getCnpj())) {
            throw new BusinessException("CNPJ já cadastrado no sistema.");
        }

        Restaurante restaurante = modelMapper.map(dto, Restaurante.class);
        restaurante.setStatus(true); 

        Restaurante restauranteSalvo = restauranteRepository.save(restaurante);

        return modelMapper.map(restauranteSalvo, RestauranteResponseDTO.class);

    }

    public RestauranteResponseDTO buscarRestaurantePorId(Long id) {

        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Restaurante não encontado"));

        return modelMapper.map(restaurante, RestauranteResponseDTO.class);
    }

    public List<RestauranteResponseDTO> buscarRestaurantesPorCategoria(String categoria) {
        List<Restaurante> restaurantes = restauranteRepository.findByCategoriaContainingIgnoreCase(categoria);

        return restaurantes.stream()
                .map(restaurante -> modelMapper.map(restaurante, RestauranteResponseDTO.class))
                .collect(Collectors.toList());
    }

    public List<RestauranteResponseDTO> buscarRestaurantesDisponiveis() {
        List<Restaurante> restaurantes = restauranteRepository.findByStatusTrue();

        return restaurantes.stream()
                .map(restaurante -> modelMapper.map(restaurante, RestauranteResponseDTO.class))
                .collect(Collectors.toList());
    }

    public RestauranteResponseDTO atualizarRestaurante(Long id, RestauranteRequestDTO dto) {
        Restaurante restauranteExistente = restauranteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Restaurante não encontrado"));
        modelMapper.map(dto, restauranteExistente);

        Restaurante restauranteAtualizado = restauranteRepository.save(restauranteExistente);

        return modelMapper.map(restauranteAtualizado, RestauranteResponseDTO.class);
    }

    public BigDecimal calcularTaxaEntrega(Long restauranteId, String cep) {
        Restaurante restaurante = restauranteRepository.findById(restauranteId)
                .orElseThrow(() -> new EntityNotFoundException("Restaurante não encontrado"));

        // BigDecimal taxaAdicionalPorDistancia = simularCalculoTaxaPorDistancia(cep);

        BigDecimal taxaBase = restaurante.getTaxaEntrega();
        // BigDecimal taxaFinal = taxaBase.add(taxaAdicionalPorDistancia);
        BigDecimal taxaFinal = taxaBase.add(simuladorCalculoDistancia(cep)); // Sem cálculo adicional por enquanto
        return taxaFinal.setScale(2, RoundingMode.HALF_UP);

    }

    private BigDecimal simuladorCalculoDistancia(String cep) {
        String cepNumerico = cep.replaceAll("[0-9]", "");

        if (cepNumerico.length() != 8) {
            throw new BusinessException("CEP inválido. Deve conter exatamente 8 dígitos numéricos.");
        }

        char primeiroDigito = cep.charAt(0);

        switch (primeiroDigito) {
            case '0':
            case '1':
            case '2':
            case '3':
                // CEPs de regiões "próximas"
                return new BigDecimal("2.00"); // Taxa adicional de R$ 2,00
            case '4':
            case '5':
            case '6':
                // CEPs de regiões "médias"
                return new BigDecimal("5.00"); // Taxa adicional de R$ 5,00
            case '7':
            case '8':
            case '9':
                // CEPs de regiões "distantes"
                return new BigDecimal("10.00"); // Taxa adicional de R$ 10,00
            default:
                // Caso o CEP seja inválido (não deveria acontecer após a validação)
                return new BigDecimal("15.00");
        }
    }

}
