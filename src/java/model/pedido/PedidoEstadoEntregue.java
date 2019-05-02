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
public class PedidoEstadoEntregue extends PedidoEstado {

    public PedidoEstadoEntregue() {
        this.estadoNome = "Entregue";
        this.estadoMsg = "Pedido entregue";
        this.nome = "entregue";

    }

}
