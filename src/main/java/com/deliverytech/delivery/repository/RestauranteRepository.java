package com.deliverytech.delivery.repository;

import com.deliverytech.delivery.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    /**
     * Busca um restaurante pelo nome.
     * 
     * @param nome O nome do restaurante.
     * @return O restaura encontrado.
     */
    Restaurante findByNome(String nome);

    /**
     * Busca todos os restaurantes que pertencem a uma categoria.
     * 
     * @param categoria A categoria a ser buscada.
     * @return Uma lista de restaurantes da categoria.
     */
    List<Restaurante> findByCategoria(String categoria);

    /**
     * Busca todos os restaurantes ativos.
     * 
     * @returnUm lista de restaurantes ativos.
     */
    List<Restaurante> findByAtivoTrue();

    /**
     * Busca todos os restaurantes com taxa de entrega menor ou igual ao valor especificado.
     * 
     * @param taxaEntrega O valor máximo da taxa de entrega.
     * @return Uma lista de restaurantes com taxa de entrega menor ou igual ao valor especificado.
     */
    
    List<Restaurante> findByTaxaEntregaLessThanEqual(BigDecimal taxaEntrega);
   
    /**
     * Busca os 5 primeiros restaurantes ordenados pelo nome em ordem ascendente.
     * 
     * @return Uma lista de até 5 restaurantes ordenados pelo nome.
     */
    List<Restaurante> findTop5ByOrderByNomeAsc();

}
