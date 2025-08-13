package com.deliverytech.delivery.entity;

// import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")  // FK para Pedido
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id") // FK para Produto
    private Produto produto;

    private int quantidade;
}
