/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import action.categoria.PreparaCategoriaAction;
import controller.Action;

public class ActionFactory {

    public static Action create(String action) {
        Action actionObject = null;

        int index = 0;
        String actionUpper = action.toUpperCase();
        for (int i = 1; i < action.length(); i++) {
            if (action.charAt(i) == action.toUpperCase().charAt(i)) {
                index = i;
                break;
            }
        }

        String pacote = action.substring(index);

        String nomeClasse = "action." + pacote.toLowerCase() + "." + action + "Action";
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            return null;
        }
        if (!(objeto instanceof Action)) {
            return null;
        }
        actionObject = (Action) objeto;
        return actionObject;
    }
}
