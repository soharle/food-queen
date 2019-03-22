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
public class Carrinho {
    
    private long id;
    private String valor;
    private String data;
    private String hora;
    private String pagamento;
    private CarrinhoEstado estado;
    
    Consumidor consumidor;

    public Carrinho(long id, String valor, String data, String hora, String pagamento, CarrinhoEstado estado, Consumidor consumidor) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.hora = hora;
        this.pagamento = pagamento;
        this.estado = estado;
        this.consumidor = consumidor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    protected CarrinhoEstado getEstado() {
        return estado;
    }

    protected void setEstado(CarrinhoEstado estado) {
        this.estado = estado;
    }

    public Consumidor getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
    }
    
}
