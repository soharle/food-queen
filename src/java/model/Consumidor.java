/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.ArrayList;
import model.conta.Conta;
import model.pedido.Pedido;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.ConsumidorDAO;

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

    public void update(Observable o, Object arg) {
        if (o instanceof Pedido) {
            Pedido carrinho = (Pedido) o;
            System.out.println("Atenção " + this.getNome()
                    + ", o seu Carrinho mudou de estado para "
                    + carrinho.getEstado().getEstadoNome());
        }

    }

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
    
    public void update(){
        try {
            ConsumidorDAO.getInstance().update(this);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delete(){
        ConsumidorDAO.getInstance().delete(id);
    }
    
    public void save(){
        try {
            ConsumidorDAO.getInstance().save(this);
        } catch (SQLException ex) {
            Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Consumidor get(){
        return ConsumidorDAO.getInstance().get(id);
    }
    
    public static ArrayList<Consumidor> getAll(){
        return ConsumidorDAO.getInstance().getAll();
    }
}
