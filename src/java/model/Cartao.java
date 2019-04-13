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
public class Cartao {

    private long id;
    private String numero;
    private String cod;
    private String titular;
    private String validade;

    Consumidor consumidor;

    public long getId() {
        return id;
    }

    public Cartao setId(long id) {
        this.id = id;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Cartao setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String getCod() {
        return cod;
    }

    public Cartao setCod(String cod) {
        this.cod = cod;
        return this;
    }

    public String getTitular() {
        return titular;
    }

    public Cartao setTitular(String titular) {
        this.titular = titular;
        return this;

    }

    public String getValidade() {
        return validade;
    }

    public Cartao setValidade(String validade) {
        this.validade = validade;
        return this;

    }

    public Consumidor getConsumidor() {
        return consumidor;
    }

    public Cartao setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
        return this;
    }

}
