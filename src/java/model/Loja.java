/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.conta.Conta;
import model.categoria.Categoria;

/**
 *
 * @author mathe
 */
public class Loja {

    private long id;
    private String nome;
    private String cnpj;
    private String descricao;
    private String imagem;

    private Endereco endereco;
    private Conta conta;
    private Contato contato;
    private Categoria categoria;

    public long getId() {
        return id;
    }

    public Loja setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Loja setNome(String nome) {
        this.nome = nome;
        return this;

    }

    public String getCnpj() {
        return cnpj;
    }

    public Loja setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Loja setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String getImagem() {
        return imagem;
    }

    public Loja setImagem(String imagem) {
        this.imagem = imagem;
        return this;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Loja setEndereco(Endereco endereco) {
        this.endereco = endereco;
        return this;

    }

    public Conta getConta() {
        return conta;
    }

    public Loja setConta(Conta conta) {
        this.conta = conta;
        return this;

    }

    public Contato getContato() {
        return contato;
    }

    public Loja setContato(Contato contato) {
        this.contato = contato;
        return this;

    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Loja setCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }

}
