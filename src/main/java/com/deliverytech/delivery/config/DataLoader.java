package com.deliverytech.delivery.config;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.deliverytech.delivery.entity.Cliente;
import com.deliverytech.delivery.entity.Produto;
import com.deliverytech.delivery.entity.Restaurante;
import com.deliverytech.delivery.repository.ClienteRepository;
import com.deliverytech.delivery.repository.ProdutoRepository;
import com.deliverytech.delivery.repository.RestauranteRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ProdutoRepository produtoRepository;

    private final RestauranteRepository restauranteRepository;

    private final ClienteRepository clienteRepository;

    @Override
    public void run(String... args) throws Exception {
        Restaurante r1 = new Restaurante();
        Produto p1 = new Produto();
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();
        Cliente c3 = new Cliente();

        if (clienteRepository.count() == 0) { // Só popula se estiver vazio
            c1.setNome("Luiz Delivery");
            c1.setEmail("luiz@deliverytech.com");
            c1.setTelefone("1298905-4321");
            c1.setAtivo(true);

            c2.setNome("Maria Express");
            c2.setEmail("maria@deliverytech.com");
            c2.setTelefone("1198865-4321");
            // c2.setAtivo(true);
            c3.setNome("João Rápido");
            c3.setEmail("algo@email.com");
            c3.setTelefone("1198765-4541");

            clienteRepository.saveAll(List.of(c1, c2, c3));

            System.out.println("DataLoader: Clientes iniciais inseridos no banco!");

        }
        if (restauranteRepository.count() == 0) {
            r1.setNome("Cantinho da terra");
            r1.setEmail("cantinho@email.com");
            r1.setTelefone("12982241865");
            r1.setEndereco("Rua Rebouca de Carvalho");
            r1.setCnpj("25963258000118");
            r1.setCategoria("Comida brasileira");
            r1.setTaxaEntrega(BigDecimal.valueOf(5.0));

            restauranteRepository.saveAll(List.of(r1));
        }
        if (produtoRepository.count() == 0) {
            p1.setNome("Café Pingado");
            p1.setDescricao("50 ml de café preto.");
            p1.setCategoria("Café");
            p1.setDisponibilidade(true);
            p1.setPreco(BigDecimal.valueOf(2.50));
            p1.setRestaurante(r1);
            produtoRepository.save(p1);
        }
    }
}