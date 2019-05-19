/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Combo {
    private long id;
    private String nome;
    private double preco;
    private ArrayList<Produto> produtos;

    public Combo() {
    }

    public long getId() {
        return id;
    }

    public Combo setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Combo setNome(String nome) {
        this.nome = nome;
        return this;
    }
    
    

    public double getPreco() {
        return preco;
    }

    public Combo setPreco(double preco) {
        this.preco = preco;
        return this;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public Combo setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
        return this;
    }
    
    
    
}
