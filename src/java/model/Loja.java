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
public class Loja {
    private long id;
    private String nome;
    private String cnpj;
    private String descricao;
    
    private EnderecoLoja enderecoLoja;
    private Conta conta;
    private Contato contato;
    private Categoria categoria;

    public Loja(String nome, String cnpj, String descricao, EnderecoLoja enderecoLoja, Conta conta, Contato contato, Categoria categoria) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.enderecoLoja = enderecoLoja;
        this.conta = conta;
        this.contato = contato;
        this.categoria = categoria;
    }
    
    
    
    public Loja(long id, String nome, String cnpj, String descricao, EnderecoLoja enderecoLoja, Conta conta, Contato contato, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.enderecoLoja = enderecoLoja;
        this.conta = conta;
        this.contato = contato;
        this.categoria = categoria;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public EnderecoLoja getEnderecoLoja() {
        return enderecoLoja;
    }

    public void setEnderecoLoja(EnderecoLoja enderecoLoja) {
        this.enderecoLoja = enderecoLoja;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
}
