package com.deliverytech.delivery.repository;

import com.deliverytech.delivery.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    /**
     * Busca um cliente pelo seu email.
     * 
     * @param email O email do cliente a ser buscado
     * @return O cliente entrado, ou null se não houver
     */

    Optional<Cliente> findByEmail(String email);

    /**
     * Busca todos os clientes com o status ativo
     * 
     * @param ativo O status ativo do cliente
     * @return Uma lista de clientes ativos
     */
    List<Cliente> findByAtivoTrue();

    /**
     * Busca todos os clientes cujo nome contém a string de busca, ignorando a diferença entre
     * letras maiúsculas e minúsculas.
     * @param nome A string de busca para o nome do cliente.
     * @return Uma lista de clientes que correspondem à busca.
     */
    List<Cliente> findByNomeContainingIgnoreCase(String nome);

    /**
     * Verifica se um cliente com o e-mail fornecido já existe no banco de dados.
     * Este é o método mais otimizado para a checagem de existência.
     * @param email O e-mail a ser verificado.
     * @return true se um cliente com o e-mail existir, false caso contrário.
     */
    boolean existsByEmail(String email);
}
