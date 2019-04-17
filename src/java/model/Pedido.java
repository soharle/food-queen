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
public class Pedido {

    private long id;
    private Produto produto;
    private Carrinho carrinho;

 
    public long getId() {
        return id;
    }

    public Pedido setId(long id) {
        this.id = id;
        return this;
    }

    public Produto getProduto() {
        return produto;
    }

    public Pedido setProduto(Produto produto) {
        this.produto = produto;
        return this;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public Pedido setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
        return this;
    }

}
