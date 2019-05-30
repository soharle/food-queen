/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pedido;

/**
 *
 * @author mathe
 */
public abstract class PedidoEstado {
    
    protected String estadoNome;
    protected String estadoMsg;
    protected String nome;
    
    public boolean aprovar(Pedido pedido){
        return false;
    }
    
    public boolean naoAprovar(Pedido pedido){
        return false;
    }

    public boolean aguardar(Pedido pedido){
        return false;
    }
    
    public boolean sairParaEntrega(Pedido pedido){
        return false;
    }
    
    public boolean entregar(Pedido pedido){
        return false;
    }
   
    public String getEstadoNome() {
        return estadoNome;
    }

    public String getEstadoMsg() {
        return estadoMsg;
    }
    
    public String getNome(){
        return nome;
    }
    
}
