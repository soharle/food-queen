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

    @Override
    public boolean acidentou(Entrega entrega) {
        entrega.getEstado().setEstadoTxt("Ocorreu um acidente");
        return true;
    }

    @Override
    public boolean naoEncontrado(Entrega entrega) {
        entrega.getEstado().setEstadoTxt("Endereço não encontrado");
        return true;
    }

    @Override
    public boolean entregue(Entrega entrega) {
        entrega.getEstado().setEstadoTxt("Entrega feita");
        return true;
    }

    @Override
    public boolean roubado(Entrega entrega) {
        entrega.getEstado().setEstadoTxt("Entrega roubada");
        return true;
    }

}
