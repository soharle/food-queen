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
public interface CarrinhoEstado {
    public boolean aprovar(Carrinho carrinho);
    public boolean naoAprovar(Carrinho carrinho);
    public boolean cancelar(Carrinho carrinho);
    public boolean aguardar(Carrinho carrinho);
}
