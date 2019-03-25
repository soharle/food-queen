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
public abstract class EntregaEstado {
    
    protected String estadoNome;
    protected String estadoMsg;
    
    public boolean encaminhar(Entrega entrega){
        return false;
    };
    public boolean acidentou(Entrega entrega){
        return false;
    };
    public boolean naoEncontrado(Entrega entrega){
        return false;
    };
    public boolean entregue(Entrega entrega){
        return false;
    };
    public boolean roubado(Entrega entrega){
        return false;
    };
    
    public String getEstadoNome(){
        return this.estadoNome;
    }
    
    public String getEstadoMsg(){
        return this.estadoMsg;
    }
}