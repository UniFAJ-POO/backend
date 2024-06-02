package com.unifaj.restaurant.backend.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "PEDIDO")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PEDIDO")
    private Integer idPedido;

    @Column(name = "TOTAL_PEDIDO", nullable = false)
    private BigDecimal totalPedido;

    @Column(name = "STATUS_PAGO", nullable = false)
    private Boolean statusPago;

    @Column(name = "DATA_PEDIDO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataPedido;

    @ManyToOne
    @JoinColumn(name = "NUM_MESA")
    private Mesa mesa;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente cliente;

    // Constructor.

    public Pedido() {
    }

    public Pedido(Integer idPedido, BigDecimal totalPedido, Boolean statusPago, Date dataPedido, Mesa mesa, Cliente cliente) {
        this.idPedido = idPedido;
        this.totalPedido = totalPedido;
        this.statusPago = statusPago;
        this.dataPedido = dataPedido;
        this.mesa = mesa;
        this.cliente = cliente;
    }

    // Getters e Setters.

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public BigDecimal getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(BigDecimal totalPedido) {
        this.totalPedido = totalPedido;
    }

    public Boolean getStatusPago() {
        return statusPago;
    }

    public void setStatusPago(Boolean statusPago) {
        this.statusPago = statusPago;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
