package com.deliverytech.delivery.repository;

import com.deliverytech.delivery.entity.Produto;
import com.deliverytech.delivery.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    /**
     * Busca todos os produtos de um restaurante específico.
     * 
     * @param restaurante O objeto Restaurante para buscar.
     * @return Uma lista de produtos que pertencem ao resturante.
     */
    List<Produto> findByRestaurante(Restaurante restaurante);

    /**
     * Busca todos os produtos que pertencem a uma categoria.
     * 
     * @param categoria A categoria do produto.
     * @return Uma lista de produtos da categoria.
     */
    List<Produto> findByCategoria(String categoria);

    /**
     * Busca todos os produtos que estão disponíveis.
     * 
     * @return Uma lista de produtos disponíveis
     */
    List<Produto> findByDisponibilidadeTrue();
}