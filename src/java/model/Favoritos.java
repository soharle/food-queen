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
public class Favoritos {

    private long id;

    private Consumidor consumidor;
    private Loja loja;

    public Favoritos() {
    }

    public long getId() {
        return id;
    }

    public Favoritos setId(long id) {
        this.id = id;
        return this;
    }

    public Consumidor getConsumidor() {
        return consumidor;
    }

    public Favoritos setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
        return this;

    }

    public Loja getLoja() {
        return loja;
    }

    public Favoritos setLoja(Loja loja) {
        this.loja = loja;
        return this;
    }

}
