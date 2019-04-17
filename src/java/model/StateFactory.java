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

}
