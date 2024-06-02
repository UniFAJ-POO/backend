package com.unifaj.restaurant.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "MESA")
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUM_MESA")
    private Integer numMesa;

    @Column(name = "QTD_CADEIRA", nullable = false)
    private Integer qtdCadeira;

    @Column(name = "STATUS_MESA", nullable = false)
    private Boolean statusMesa;

    // Constructor.

    public Mesa() {
    }

    public Mesa(Integer numMesa, Integer qtdCadeira, Boolean statusMesa) {
        this.numMesa = numMesa;
        this.qtdCadeira = qtdCadeira;
        this.statusMesa = statusMesa;
    }

    // Getters e Setters.

    public Integer getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(Integer numMesa) {
        this.numMesa = numMesa;
    }

    public Integer getQtdCadeira() {
        return qtdCadeira;
    }

    public void setQtdCadeira(Integer qtdCadeira) {
        this.qtdCadeira = qtdCadeira;
    }

    public Boolean getStatusMesa() {
        return statusMesa;
    }

    public void setStatusMesa(Boolean statusMesa) {
        this.statusMesa = statusMesa;
    }
}
