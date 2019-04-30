/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pedido;

import java.util.ArrayList;

/**
 *
 * @author mathe
 */
public class MementoManager {

    private ArrayList<PedidoMemento> mementos;

    public MementoManager() {
        mementos = new ArrayList<PedidoMemento>();
    }

    public void adicionarMemento(PedidoMemento memento) {
        mementos.add(memento);
    }

    public PedidoMemento retornarUm(PedidoMemento memento) {
        if (!this.mementos.contains(memento)) {
            return memento;
        }

        return mementos.get(mementos.indexOf(memento) - 1);
    }

    public PedidoMemento avancaUm(PedidoMemento memento) {
        if (!this.mementos.contains(memento)) {
            if (mementos.size() > mementos.indexOf(memento)) {
                return mementos.get(mementos.indexOf(memento) + 1);
            }
        }

        return memento;
    }

    public void esquecerFuturo(PedidoMemento memento) {
        if (this.mementos.contains(memento)) 
            for (int i = mementos.size(); i > 0; i--) {
                if(mementos.get(i).equals(memento))
                    break;
                this.mementos.remove(i);
            }
    }
}
