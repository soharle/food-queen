/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mathe
 */
public class Conta {

    private long id;
    private String login;
    private String senha;
    private String tipo;

    public long getId() {
        return id;
    }

    public Conta setId(long id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public Conta setLogin(String login) {
        this.login = login;
        return this;

    }

    public String getSenha() {
        return senha;
    }

    public Conta setSenha(String senha) {
        this.senha = senha;
        return this;

    }

    public String getTipo() {
        return tipo;
    }

    public Conta setTipo(String tipo) {
        this.tipo = tipo;
        return this;

    }

}
