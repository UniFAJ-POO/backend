package com.unifaj.restaurant.backend;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cadeiras;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    @OneToMany(mappedBy = "mesa")
    private List<Pedido> pedidos;

    public enum Situacao {
        OCUPADA,
        LIVRE,
        RESERVADA
    }

    // Constructor.

    public Mesa() {
    }

    public Mesa(int id, int cadeiras, Situacao situacao, List<Pedido> pedidos) {
        this.id = id;
        this.cadeiras = cadeiras;
        this.situacao = situacao;
        this.pedidos = pedidos;
    }

    // Getters e Setters.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCadeiras() {
        return cadeiras;
    }

    public void setCadeiras(int cadeiras) {
        this.cadeiras = cadeiras;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
