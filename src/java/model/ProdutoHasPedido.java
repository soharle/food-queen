/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.pedido.Pedido;

/**
 *
 * @author mathe
 */
public class ProdutoHasPedido {

    private long id;
    private Produto produto;
    private Pedido carrinho;

 
    public long getId() {
        return id;
    }

    public ProdutoHasPedido setId(long id) {
        this.id = id;
        return this;
    }

    public Produto getProduto() {
        return produto;
    }

    public ProdutoHasPedido setProduto(Produto produto) {
        this.produto = produto;
        return this;
    }

    public Pedido getCarrinho() {
        return carrinho;
    }

    public ProdutoHasPedido setCarrinho(Pedido carrinho) {
        this.carrinho = carrinho;
        return this;
    }

    @Override
    public String toString() {
        return this.produto.toString();
    }
    
    
}
