package com.deliverytech.delivery.repository;

import com.deliverytech.delivery.entity.Produto;
import com.deliverytech.delivery.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.math.BigDecimal;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    /**
     * Busca todos os produtos de um restaurante específico pelo ID do restaurante.
     * 
     * @param restauranteId O ID do restaurante para buscar os produtos.
     * @return Uma lista de produtos que pertencem ao restaurante com o ID
     *         fornecido.
     */
    List<Produto> findByRestauranteId(Long restauranteId);

    // /**
    // * Busca todos os produtos de um restaurante específico.
    // *
    // * @param restaurante O objeto Restaurante para buscar.
    // * @return Uma lista de produtos que pertencem ao resturante.
    // */
    // List<Produto> findByRestaurante(Restaurante restaurante);

    /**
     * Busca todos os produtos que estão disponíveis.
     * 
     * @return Uma lista de produtos disponíveis
     */
    List<Produto> findByDisponivelTrue();

    /**
     * Busca todos os produtos que pertencem a uma categoria.
     * 
     * @param categoria A categoria do produto.
     * @return Uma lista de produtos da categoria.
     */
    List<Produto> findByCategoria(String categoria);

    /**
     * Busca todos os produtos que possuem um preço menor ou igual ao valor
     * especificado.
     * 
     * @param preco O preço máximo dos produtos a serem buscados.
     * @return Uma lista de produtos com preço menor ou igual ao especificado.
     */
    List<Produto> findByPrecoLessThanEqual(BigDecimal preco);

}