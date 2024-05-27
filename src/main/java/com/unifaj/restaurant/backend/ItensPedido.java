package com.unifaj.restaurant.backend;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "ITENS_PEDIDO")
public class ItensPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PEDIDO")
    private Integer idPedido;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO", nullable = false)
    private Produto produto;

    @Column(name = "QUANTIDADE_PEDIDO", nullable = false)
    private Integer quantidadePedido;

    @Column(name = "VALOR_TOTAL", nullable = false)
    private BigDecimal valorTotal;

    // Constructor.

    public ItensPedido() {
    }

    public ItensPedido(Integer idPedido, Produto produto, Integer quantidadePedido, BigDecimal valorTotal) {
        this.idPedido = idPedido;
        this.produto = produto;
        this.quantidadePedido = quantidadePedido;
        this.valorTotal = valorTotal;
    }

    // Getters e Setters.

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidadePedido() {
        return quantidadePedido;
    }

    public void setQuantidadePedido(Integer quantidadePedido) {
        this.quantidadePedido = quantidadePedido;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
