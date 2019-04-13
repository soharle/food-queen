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
public class Entrega {

    private long id;
    private EntregaEstado estado;
    private Loja loja;
    private Carrinho carrinho;

    public long getId() {
        return id;
    }

    public Entrega setId(long id) {
        this.id = id;
        return this;
    }

    public EntregaEstado getEstado() {
        return estado;
    }

    public Entrega setEstado(EntregaEstado estado) {
        this.estado = estado;
        return this;

    }

    public Loja getLoja() {
        return loja;
    }

    public Entrega setLoja(Loja loja) {
        this.loja = loja;
        return this;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public Entrega setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
        return this;
    }

}
