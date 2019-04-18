/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathe
 */
public class StateFactory {

    public static CarrinhoEstado createCarrinhoEstado(String state) {
        CarrinhoEstado actionObject = null;
        String nomeClasse = "model.CarrinhoEstado" + state;
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            return null;
        }
        if (!(objeto instanceof CarrinhoEstado)) {
            return null;
        }
        actionObject = (CarrinhoEstado) objeto;
        return actionObject;
    }

    public static Boolean invocarMetodoFactory(Carrinho carrinho, String nomeMetodo) {
        Boolean mudou = false;
        try {
            Method metodo = CarrinhoEstado.class.getMethod(nomeMetodo, Carrinho.class);
            mudou = (Boolean) metodo.invoke(carrinho.getEstado(), carrinho);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(StateFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mudou;
    }

}
