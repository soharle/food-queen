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
public class PedidoEstadoNaoAprovado extends PedidoEstado {

    public PedidoEstadoNaoAprovado() {
        this.estadoNome = "NaoAprovado";
        this.estadoMsg = "Pedido não aprovado";
        this.nome = "não aprovado";

    }

}
