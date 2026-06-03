package com.petshop.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.math.BigDecimal;

/**
 * @author Felipe Araújo Lemos
 */
@Data
@Entity
@Table(name = "tb_itens_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @Positive(message = "A quantidade deve ser maior que zero")
    private Integer quantidade;

    private BigDecimal precoUnitario;
}