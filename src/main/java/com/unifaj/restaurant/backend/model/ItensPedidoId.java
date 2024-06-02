package com.unifaj.restaurant.backend.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ItensPedidoId implements Serializable {
    private Integer idPedido;
    private Integer idProduto;

    // Constructor.

    public ItensPedidoId() {
    }

    public ItensPedidoId(Integer idPedido, Integer idProduto) {
        this.idPedido = idPedido;
        this.idProduto = idProduto;
    }

    // Getters e Setters.

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }
}
