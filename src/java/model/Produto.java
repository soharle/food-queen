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
public class Produto {
    private long id;
    private String nome;
    private String preco;
    private String disponivel;
    private String descricao;
    private String imagem;
    
    private Loja loja;
    private Promocao promocao;

    public Produto(long id, String nome, String preco, String disponivel, String descricao, String imagem, Loja loja, Promocao promocao) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.disponivel = disponivel;
        this.descricao = descricao;
        this.imagem = imagem;
        this.loja = loja;
        this.promocao = promocao;
    }

    public Produto(String nome, String preco, String disponivel, String descricao, Loja loja, Promocao promocao) {
        this.nome = nome;
        this.preco = preco;
        this.disponivel = disponivel;
        this.descricao = descricao;
        this.loja = loja;
        this.promocao = promocao;
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

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(String disponivel) {
        this.disponivel = disponivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Promocao getPromocao() {
        return promocao;
    }

    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }
    
    
}
