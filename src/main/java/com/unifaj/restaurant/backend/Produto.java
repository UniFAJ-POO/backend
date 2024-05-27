package com.unifaj.restaurant.backend;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "PRODUTO")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUTO")
    private Integer idProduto;

    @Column(name = "NOME_PRODUTO", nullable = false, length = 50)
    private String nomeProduto;

    @Column(name = "VALOR_PRODUTO", nullable = false)
    private BigDecimal valorProduto;

    @Column(name = "QTD_PRODUTO", nullable = false)
    private Integer qtdProduto;

    // Constructor.

    public Produto() {
    }

    public Produto(Integer idProduto, String nomeProduto, BigDecimal valorProduto, Integer qtdProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.qtdProduto = qtdProduto;
    }

    // Getters e Setters.

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public BigDecimal getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(BigDecimal valorProduto) {
        this.valorProduto = valorProduto;
    }

    public Integer getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(Integer qtdProduto) {
        this.qtdProduto = qtdProduto;
    }
}
