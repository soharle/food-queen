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
public class CarrinhoEstadoAprovado extends CarrinhoEstado {

    public CarrinhoEstadoAprovado() {
        this.estadoNome = "Aprovado";
        this.estadoMsg = "Carrinho aprovado";
        this.nome = "aprovado";

    }

    @Override
    public boolean sairParaEntrega(Carrinho carrinho) {
        carrinho.setEstado((CarrinhoEstado) StateFactory.getObject(CarrinhoEstado.class.getName() + "SaiuParaEntrega"));
        return true;
    }

}
