/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.ProdutoDAO;

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

    public Produto(long id, String nome, String preco, String disponivel, String descricao, String imagem, Loja loja) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.disponivel = disponivel;
        this.descricao = descricao;
        this.imagem = imagem;
        this.loja = loja;
    }

    public Produto() {
        this.promocao = new Promocao();
    }

    public long getId() {
        return id;
    }

    public Produto setId(long id) {
        this.id = id;
        return this;

    }

    public String getNome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getPreco() {
        return preco;
    }

    public Produto setPreco(String preco) {
        this.preco = preco;
        return this;

    }

    public String getDisponivel() {
        return disponivel;
    }

    public Produto setDisponivel(String disponivel) {
        this.disponivel = disponivel;
        return this;

    }

    public String getDescricao() {
        return descricao;
    }

    public Produto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;

    }

    public String getImagem() {
        return imagem;
    }

    public Produto setImagem(String imagem) {
        this.imagem = imagem;
        return this;

    }

    public Loja getLoja() {
        return loja;
    }

    public Produto setLoja(Loja loja) {
        this.loja = loja;
        return this;

    }

    public Promocao getPromocao() {
        return promocao;
    }

    public Produto setPromocao(Promocao promocao) {
        this.promocao = promocao;
        return this;

    }

    public void save() throws SQLException, ClassNotFoundException {
        ProdutoDAO.getInstance().save(this);
    }

    public void update() {
         ProdutoDAO.getInstance().update(this);
    }

}
