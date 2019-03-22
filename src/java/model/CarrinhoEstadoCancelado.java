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
public class CarrinhoEstadoCancelado implements CarrinhoEstado {

    @Override
    public boolean aprovar(Carrinho carrinho) {
        return false;
    }

    @Override
    public boolean naoAprovar(Carrinho carrinho) {
        return false;
    }

    @Override
    public boolean cancelar(Carrinho carrinho) {
        return false;
    }

    @Override
    public boolean aguardar(Carrinho carrinho) {
        return false;
    }
    
}
