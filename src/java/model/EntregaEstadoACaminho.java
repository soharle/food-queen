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
public class EntregaEstadoACaminho extends EntregaEstado {

    public EntregaEstadoACaminho() {
        this.estadoNome = "ACaminho";
        this.estadoMsg = "A Caminho";
    }

    @Override
    public boolean acidentou(Entrega entrega) {
        entrega.setEstado(new EntregaEstadoAcidente());
        return true;
    }

    @Override
    public boolean naoEncontrado(Entrega entrega) {
        entrega.setEstado(new EntregaEstadoNaoEncontrado());
        return true;
    }

    @Override
    public boolean entregue(Entrega entrega) {
        entrega.setEstado(new EntregaEstadoEntregue());
        return true;
    }

    @Override
    public boolean roubado(Entrega entrega) {
        entrega.setEstado(new EntregaEstadoRoubado());
        return true;
    }

}
