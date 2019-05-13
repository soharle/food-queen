/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.conta;

import java.util.ArrayList;
public abstract class TipoConta {
    
    protected ArrayList listaPermissao = new ArrayList();
    private TipoConta contaSuperior;
    
    public abstract String getDescricaoConta();

    public boolean logar(Conta conta) {
        if (listaPermissao.contains(conta.getTipo())) {
            return true;
        } else {
            if (contaSuperior != null) {
                return contaSuperior.logar(conta);

            } else {
                return false;
            }
        }
    }

    public void setContaSuperior(TipoConta contaSuperior) {
        this.contaSuperior = contaSuperior;
    }

}
