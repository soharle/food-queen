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
public class CarrinhoEstadoAguardando extends CarrinhoEstado {

    public CarrinhoEstadoAguardando() {
        this.estadoNome = "Aguardando";
        this.estadoMsg = "Aguardando aprovação";
        this.nome = "aguardando";
    }

    @Override
    public boolean aprovar(Carrinho carrinho) {
        carrinho.setEstado((CarrinhoEstado) StateFactory.getObject(CarrinhoEstado.class.getName() + "Aprovado"));
        return true;
    }

    @Override
    public boolean naoAprovar(Carrinho carrinho) {
        carrinho.setEstado((CarrinhoEstado) StateFactory.getObject(CarrinhoEstado.class.getName() + "NaoAprovado"));
        return true;
    }

}
