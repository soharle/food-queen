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
public abstract class CarrinhoEstado {
    
    protected String estadoNome;
    protected String estadoMsg;
    
    public boolean aprovar(Carrinho carrinho){
        return false;
    };
    public boolean naoAprovar(Carrinho carrinho){
        return false;
    };
    public boolean cancelar(Carrinho carrinho){
        return false;
    };
    public boolean aguardar(Carrinho carrinho){
        return false;
    };

    public String getEstadoNome() {
        return estadoNome;
    }

    public String getEstadoMsg() {
        return estadoMsg;
    }
    
    
}
