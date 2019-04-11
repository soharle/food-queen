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
public class Promocao {

    private long id;
    private String nome;
    private String desconto;
    private String tipo;
    private Loja loja;

    public Promocao(long id, String nome, String desconto, String tipo, Loja loja) {
        this.id = id;
        this.nome = nome;
        this.desconto = desconto;
        this.tipo = tipo;
        this.loja = loja;
    }

    public Promocao(String nome, String desconto, String tipo, Loja loja) {
        this.nome = nome;
        this.desconto = desconto;
        this.tipo = tipo;
        this.loja = loja;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
