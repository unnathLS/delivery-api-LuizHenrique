package com.deliverytech.delivery.config;

import com.deliverytech.delivery.entity.*;
import com.deliverytech.delivery.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private RestauranteRepository restauranteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void run(String... args) throws Exception {
        // 1. Inserir clientes
        Cliente c1 = new Cliente("Ana", "ana@email.com", true);
        Cliente c2 = new Cliente("Bruno", "bruno@email.com", true);
        Cliente c3 = new Cliente("Carla", "carla@email.com", false);
        clienteRepository.saveAll(Arrays.asList(c1, c2, c3));

        // 2. Inserir restaurantes
        Restaurante r2 = new Restaurante("Sushi House", "Japonesa", true, BigDecimal.valueOf(7.0), BigDecimal.valueOf(4.8));
        Restaurante r1 = new Restaurante("Pizza Place", "Italiana", true, BigDecimal.valueOf(5.0), BigDecimal.valueOf(4.5));
        restauranteRepository.saveAll(Arrays.asList(r1, r2));

        // 3. Inserir produtos
        Produto p1 = new Produto("Pizza Margherita", "Pizza", true, r1, BigDecimal.valueOf(30.0), "Clássica italiana");
        Produto p2 = new Produto("Pizza Calabresa", "Pizza", true, r1, BigDecimal.valueOf(32.0), "Com calabresa");
        Produto p3 = new Produto("Sushi Salmão", "Sushi", true, r2, BigDecimal.valueOf(25.0), "Salmão fresco");
        Produto p4 = new Produto("Temaki", "Sushi", true, r2, BigDecimal.valueOf(20.0), "Cone de alga");
        Produto p5 = new Produto("Pizza Portuguesa", "Pizza", false, r1, BigDecimal.valueOf(35.0),
                "Com ovos e ervilha");
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        // 4. Inserir pedidos
        Pedido pedido1 = new Pedido();
        pedido1.setCliente(c1);
        pedido1.setProdutos(Arrays.asList(p3, p4));
        pedido1.setValorTotal(p3.getPreco().add(p4.getPreco()).add(r1.getTaxaEntrega()));
        pedido1.setStatus("Em processamento.");
        pedidoRepository.save(pedido1);

        Pedido pedido2 = new Pedido();
        pedido2.setCliente(c2);
        pedido2.setProdutos(Arrays.asList(p3, p2));
        pedido2.setValorTotal(p3.getPreco().add(p2.getPreco()).add(r2.getTaxaEntrega()));
        pedido2.setStatus("Em processamento.");
        pedidoRepository.save(pedido2);

        // 5. Validação das consultas
        System.out.println("Clientes ativos: " + clienteRepository.findByAtivoTrue());
        System.out.println("Restaurantes italianos: " + restauranteRepository.findByCategoria("Italiana"));
        System.out.println("Produtos disponíveis: " + produtoRepository.findByDisponivelTrue());
        System.out.println("Pedidos do cliente Ana: " + pedidoRepository.findByClienteId(c1.getId()));
        System.out.println("Top 5 restaurantes: " + restauranteRepository.findTop5ByOrderByNomeAsc());
    }
}
