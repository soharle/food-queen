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

    public Entrega(long id, EntregaEstado estado, Loja loja, Carrinho carrinho) {
        this.id = id;
        this.estado = estado;
        this.loja = loja;
        this.carrinho = carrinho;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EntregaEstado getEstado() {
        return estado;
    }

    public void setEstado(EntregaEstado estado) {
        this.estado = estado;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }
    
    
}
