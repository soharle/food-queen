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
public class CarrinhoEstadoSaiuParaEntrega extends CarrinhoEstado {

    public CarrinhoEstadoSaiuParaEntrega() {
        this.estadoNome = "SaiuParaEntrega";
        this.estadoMsg = "Carrinho saiu para entrega";
        this.nome = "saiu para entrega";

    }

    public boolean entregar(Carrinho carrinho) {
        carrinho.setEstado(StateFactory.createCarrinhoEstado("Entregue"));
        return true;
    }

}
