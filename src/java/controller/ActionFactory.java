/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.Action;

public class ActionFactory {

    public static Action create(String action) {
        Action actionObject = null;

        int index = 0;
        String actionUpper = action.toUpperCase();
        for (int i = action.length() - 1; i > 0; i--) {
            if (action.charAt(i) == action.toUpperCase().charAt(i)) {
                index = i;
                break;
            }
        }

        String pacote = action.substring(index);
        
        char c[] = pacote.toCharArray();
        c[0] += 32;  // Se for somado 32 em um código ASCII, o correspondente é a letra minuscula da mesma
                     // Exceto caracteres especiais.
        pacote = new String(c);

        String nomeClasse = "action." + pacote + "." + action + "Action";
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