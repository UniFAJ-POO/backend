package com.unifaj.restaurant.backend;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Mesa mesa;

    @OneToMany(mappedBy = "pedido")
    private List<Item> itens;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    // Constructor.

    public Pedido() {
    }

    public Pedido(int id, Cliente cliente, Mesa mesa, List<Item> itens, Date data) {
        this.id = id;
        this.cliente = cliente;
        this.mesa = mesa;
        this.itens = itens;
        this.data = data;
    }

    // Getters e Setters.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
