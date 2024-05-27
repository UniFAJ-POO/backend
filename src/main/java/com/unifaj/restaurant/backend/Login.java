package com.unifaj.restaurant.backend;

import jakarta.persistence.*;

@Entity
@Table(name = "LOGIN")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FUNCIONARIO")
    private Integer idFuncionario;

    @Column(name = "USERNAME", nullable = false, length = 50, unique = true)
    private String username;

    @Column(name = "SENHA", nullable = false, length = 30)
    private String senha;

    // Constructor.

    public Login() {
    }

    public Login(Integer idFuncionario, String username, String senha) {
        this.idFuncionario = idFuncionario;
        this.username = username;
        this.senha = senha;
    }

    // Getters e Setters.

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
