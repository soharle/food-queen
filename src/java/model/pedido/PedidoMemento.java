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
public class PedidoMemento {
    private PedidoEstado estado;

    public PedidoMemento(PedidoEstado estado) {
        this.estado = estado;
    }
    
    public PedidoEstado getEstado(){
        return this.estado;
    }
    
    public String toString(){
        return this.estado.getEstadoNome();
    }
}
