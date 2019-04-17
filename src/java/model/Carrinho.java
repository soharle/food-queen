/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Observable;
import persistence.PedidoDAO;

/**
 *
 * @author mathe
 */
public class Carrinho extends Observable {

    private long id;
    private String valor;
    private CarrinhoEstado estado;

    private Loja loja;
    private Consumidor consumidor;

    public Carrinho() {
        this.estado = new CarrinhoEstadoNaoConcluido();
    }

    public Loja getLoja() {
        return loja;
    }

    public Carrinho setLoja(Loja loja) {
        this.loja = loja;
        return this;
    }
 
    public long getId() {
        return id;
    }

    public Carrinho setId(long id) {
        this.id = id;
        return this;
    }

    public String getValor() {
        ArrayList<Pedido> pedidos = PedidoDAO.getInstance().getByCarrinho(id);
        double val = 0;
        for(Pedido pedido : pedidos){
           val += Double.parseDouble(pedido.getProduto().getPrecoDeVenda());
        }
        
        this.valor = val + "";
        return valor;
    }

    public Carrinho setValor(String valor) {
        this.valor = valor;
        return this;

    }

    public CarrinhoEstado getEstado() {
        return estado;
    }

    public Carrinho setEstado(CarrinhoEstado estado) {
        this.estado = estado;
        this.notificar();
        return this;

    }

    public Consumidor getConsumidor() {
        return consumidor;
    }

    public Carrinho setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
        return this;
    }

    public Carrinho setCarrinho(Consumidor consumidor) {
        this.consumidor = consumidor;
        return this;

    }

    public void notificar() {
        notifyObservers();
    }

}
