/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pedido;

import java.util.ArrayList;
import java.util.Observable;
import model.Consumidor;
import model.Loja;
import model.Produto;
import model.ProdutoHasPedido;
import persistence.ProdutoHasPedidoDAO;

/**
 *
 * @author mathe
 */
public class Pedido extends Observable {

    private long id;
    private String valor;
    private PedidoEstado estado;
    private ArrayList<ProdutoHasPedido> produtosDoPedido;

    private Loja loja;
    private Consumidor consumidor;

    public Pedido() {
        this.estado = new PedidoEstadoNaoConcluido();
    }

    public Loja getLoja() {
        return loja;
    }

    public Pedido setLoja(Loja loja) {
        this.loja = loja;
        return this;
    }

    public long getId() {
        return id;
    }

    public Pedido setId(long id) {
        this.id = id;
        return this;
    }

    public String getValor() {
        ArrayList<ProdutoHasPedido> pedidos = ProdutoHasPedidoDAO.getInstance().getByCarrinho(id);
        double val = 0;
        for (ProdutoHasPedido pedido : pedidos) {
            val += Double.parseDouble(pedido.getProduto().getPrecoDeVenda());
        }

        this.valor = val + "";
        return valor;
    }

    public Pedido setValor(String valor) {
        this.valor = valor;
        return this;

    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public Pedido setEstado(PedidoEstado estado) {
        this.estado = estado;
        return this;

    }

    public Consumidor getConsumidor() {

        return consumidor;
    }

    public Pedido setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
        this.addObserver(this.consumidor);
        return this;
    }

    public Pedido setCarrinho(Consumidor consumidor) {
        this.consumidor = consumidor;
        return this;

    }

    public ArrayList<ProdutoHasPedido> getProdutosDoPedido() {
        return produtosDoPedido;
    }

    public void setProdutosDoPedido(ArrayList<ProdutoHasPedido> produtosDoPedido) {
        this.produtosDoPedido = produtosDoPedido;
    }


    public void notificar() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        String produtosString = "Pedido " + this.id + '\n' +
                "Para: " + this.consumidor.getNome() + '\n';
        
        for(ProdutoHasPedido p : produtosDoPedido){
            produtosString += p.toString() + '\n';
        }
        
        return produtosString;
    }

    
}
