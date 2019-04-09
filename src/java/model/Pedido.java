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
    private String observacao;

    private Produto produto;
    private Carrinho carrinho;

    public Pedido() {
    }
    
    public Pedido(long id, String observacao, Produto produto, Carrinho carrinho) {
        this.id = id;
        this.observacao = observacao;
        this.produto = produto;
        this.carrinho = carrinho;
    }

    public Pedido(String observacao, Produto produto, Carrinho carrinho) {
        this.observacao = observacao;
        this.produto = produto;
        this.carrinho = carrinho;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

}
