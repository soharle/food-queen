/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author mathe
 */
public class Consumidor implements Observer {

    private long id;
    private String nome;
    private String cpf;
    private String nascimento;

    private Contato contato;
    private Conta conta;
    private Endereco endereco;

    public long getId() {
        return id;
    }

    public Consumidor setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Consumidor setNome(String nome) {
        this.nome = nome;
        return this;

    }

    public String getCpf() {
        return cpf;
    }

    public Consumidor setCpf(String cpf) {
        this.cpf = cpf;
        return this;

    }

    public String getNascimento() {
        return nascimento;
    }

    public Consumidor setNascimento(String nascimento) {
        this.nascimento = nascimento;
        return this;

    }

    public Contato getContato() {
        return contato;
    }

    public Consumidor setContato(Contato contato) {
        this.contato = contato;
        return this;
    }

    public Conta getConta() {
        return conta;
    }

    public Consumidor setConta(Conta conta) {
        this.conta = conta;
        return this;

    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Consumidor setEndereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    public void update(Observable o, Object arg) {
        if (o instanceof Carrinho) {
            Carrinho carrinho = (Carrinho) o;
            System.out.println("Atenção " + this.getNome()
                    + ", o seu Carrinho mudou de estado para "
                    + carrinho.getEstado().getEstadoNome());
        }

    }
}
