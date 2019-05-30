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

    public String logar(Conta conta) {
        if (listaPermissao.contains(conta.getTipoLogin())) {
            return getDescricaoConta();
        } else {
            if (contaSuperior != null) {
                return contaSuperior.logar(conta);
            }else{
                return "Invalido";
            }
        }
    }

    public void setContaSuperior(TipoConta contaSuperior) {
        this.contaSuperior = contaSuperior;
    }

}
