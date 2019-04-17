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
public class CarrinhoEstadoNaoAprovado extends CarrinhoEstado{

    public CarrinhoEstadoNaoAprovado(){
        this.estadoNome = "NaoAprovado";
        this.estadoMsg = "Carrinho não aprovado";
    }
   
}
