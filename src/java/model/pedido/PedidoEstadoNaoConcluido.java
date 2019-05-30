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
public class PedidoEstadoNaoConcluido extends PedidoEstado {

    public PedidoEstadoNaoConcluido() {
        this.estadoNome = "NaoConcluido";
        this.estadoMsg = "Não concluido";
        this.nome = "não esta concluido";

    }

    public boolean aguardar(Pedido pedido) {
        pedido.setEstado((PedidoEstado) MainFactory.getObject(PedidoEstado.class.getName() + "Aguardando"));
        return true;
    }
}
