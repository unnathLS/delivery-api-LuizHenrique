package com.deliverytech.delivery.repository;

import com.deliverytech.delivery.entity.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void quandoBuscarPorEmail_retornarCliente() {
        // Cenário (Arrange)
        Cliente cliente = new Cliente("João Silva", "joao.silva@email.com", true);
        clienteRepository.save(cliente);

        // Ação (Act)
        Cliente clienteEncontrado = clienteRepository.findByEmail("joao.silva@email.com");

        // Verificação (Assert)
        assertThat(clienteEncontrado).isNotNull();
        assertThat(clienteEncontrado.getEmail()).isEqualTo("joao.silva@email.com");
    }

    @Test
    public void quandoBuscarPorStatusAtivo_retornarListaDeClientesAtivos() {
        // Cenário (Arrange)
        Cliente clienteAtivo = new Cliente("Maria Gomes", "maria.gomes@email.com", true);
        Cliente clienteInativo = new Cliente("Pedro Souza", "pedro.souza@email.com", false);
        clienteRepository.save(clienteAtivo);
        clienteRepository.save(clienteInativo);

        // Ação (Act)
        List<Cliente> clientesAtivos = clienteRepository.findByAtivo(true);

        // Verificação (Assert)
        assertThat(clientesAtivos).hasSize(1);
        assertThat(clientesAtivos.get(0).getEmail()).isEqualTo("maria.gomes@email.com");
    }
}