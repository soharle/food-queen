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
    private String data;
    private String hora;
    private String pagamento;
    private CarrinhoEstado estado;

    Consumidor consumidor;

    public Carrinho() {
        this.estado = new CarrinhoEstadoNaoConcluido();
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

    public String getData() {
        return data;
    }

    public Carrinho setData(String data) {
        this.data = data;
        return this;

    }

    public String getHora() {
        return hora;
    }

    public Carrinho setHora(String hora) {
        this.hora = hora;
        return this;

    }

    public String getPagamento() {
        return pagamento;
    }

    public Carrinho setPagamento(String pagamento) {
        this.pagamento = pagamento;
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
