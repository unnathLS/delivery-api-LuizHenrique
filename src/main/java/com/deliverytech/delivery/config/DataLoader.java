package com.deliverytech.delivery.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.deliverytech.delivery.entity.Cliente;
import com.deliverytech.delivery.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ClienteRepository clienteRepository;

    @Override
    public void run(String... args) throws Exception {
        if (clienteRepository.count() == 0) { // Só popula se estiver vazio
            Cliente c1 = new Cliente();
            c1.setNome("Luiz Delivery");
            c1.setEmail("luiz@deliverytech.com");
            c1.setTelefone("1298765-4321");
            c1.setAtivo(true);

            Cliente c2 = new Cliente();
            c2.setNome("Maria Express");
            c2.setEmail("maria@deliverytech.com");
            c2.setTelefone("1198765-4321");
            // c2.setAtivo(true);
            Cliente c3 = new Cliente();
            c3.setNome("João Rápido");
            c3.setEmail("algo@email.com");
            c3.setTelefone("1198765-4321");

            clienteRepository.saveAll(List.of(c1, c2, c3));

            System.out.println("DataLoader: Clientes iniciais inseridos no banco!");
        }
    }
}