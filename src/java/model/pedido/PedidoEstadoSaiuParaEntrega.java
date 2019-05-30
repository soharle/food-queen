/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pedido;

import model.MainFactory;

/**
 *
 * @author mathe
 */
public class PedidoEstadoSaiuParaEntrega extends PedidoEstado {

    public PedidoEstadoSaiuParaEntrega() {
        this.estadoNome = "SaiuParaEntrega";
        this.estadoMsg = "Pedido saiu para entrega";
        this.nome = "saiu para entrega";

    }

    public boolean entregar(Pedido pedido) {
        pedido.setEstado((PedidoEstado) MainFactory.getObject(PedidoEstado.class.getName() + "Entregue"));
        return true;
    }

}
