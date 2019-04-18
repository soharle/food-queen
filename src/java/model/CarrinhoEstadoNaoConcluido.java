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
public class CarrinhoEstadoNaoConcluido extends CarrinhoEstado {

    public CarrinhoEstadoNaoConcluido() {
        this.estadoNome = "NaoConcluido";
        this.estadoMsg = "Não concluido";
    }

    public boolean aguardar(Carrinho carrinho) {
        carrinho.setEstado(new CarrinhoEstadoAguardando());
        return true;
    }
}
