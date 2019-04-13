/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import persistence.PromocaoDAO;

/**
 *
 * @author mathe
 */
public class Promocao {

    private long id;
    private String nome;
    private String desconto;
    private String tipo;

    public Promocao(long id, String nome, String desconto, String tipo) {
        this.id = id;
        this.nome = nome;
        this.desconto = desconto;
        this.tipo = tipo;
    }

    public Promocao(String nome, String desconto, String tipo) {
        this.nome = nome;
        this.desconto = desconto;
        this.tipo = tipo;
    }

    public Promocao() {
        this.id = 0;
        this.nome = "";
        this.desconto = "";
        this.tipo = "";

    }

    public long getId() {
        return id;
    }

    public Promocao setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Promocao setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getDesconto() {
        return desconto;
    }

    public Promocao setDesconto(String desconto) {
        this.desconto = desconto;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public Promocao setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public void save() throws SQLException, ClassNotFoundException {
        PromocaoDAO.getInstance().save(this);
    }
}
