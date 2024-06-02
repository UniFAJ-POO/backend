package com.unifaj.restaurant.backend.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "ITENS_PEDIDO")
public class ItensPedido {
    @EmbeddedId
    private ItensPedidoId id;

    @ManyToOne
    @MapsId("idPedido")
    @JoinColumn(name = "ID_PEDIDO", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @MapsId("idProduto")
    @JoinColumn(name = "ID_PRODUTO", nullable = false)
    private Produto produto;

    @Column(name = "QUANTIDADE_PEDIDO", nullable = false)
    private Integer quantidadePedido;

    @Column(name = "VALOR_TOTAL", nullable = false)
    private BigDecimal valorTotal;

    // Constructor.

    public ItensPedido() {
    }

    public ItensPedido(Pedido pedido, Produto produto, Integer quantidadePedido, BigDecimal valorTotal) {
        this.id = new ItensPedidoId(pedido.getIdPedido(), produto.getIdProduto());
        this.pedido = pedido;
        this.produto = produto;
        this.quantidadePedido = quantidadePedido;
        this.valorTotal = valorTotal;
    }

    // Getters e Setters.

    public ItensPedidoId getId() {
        return id;
    }

    public void setId(ItensPedidoId id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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
