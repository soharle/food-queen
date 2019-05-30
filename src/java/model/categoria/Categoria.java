/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.categoria;

/**
 *
 * @author mathe
 */
public abstract class Categoria {

    private long id;
    private String nome;

    public abstract String getDescricao();

    public long getId() {
        return id;
    }

    public Categoria setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Categoria setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String categoriaDescricao() {
        return "A categoria " + this.getNome() + " " + this.getDescricao();
    }
}
