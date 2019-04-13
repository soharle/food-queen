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
public class Consumidor {

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

}
