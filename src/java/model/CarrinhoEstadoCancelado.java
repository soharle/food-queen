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
public class CarrinhoEstadoCancelado extends CarrinhoEstado {

    
    public CarrinhoEstadoCancelado(){
        this.estadoNome = "Cancelado";
        this.estadoMsg = "Carrinho cancelado";
    }
    
}