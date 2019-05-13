/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.conta;

/**
 *
 * @author mathe
 */
public class Login {

    private TipoLogin tipoLogin;

    public Login(TipoLogin tipoLogin) {
        this.tipoLogin = tipoLogin;
    }

    public TipoLogin getTipoConta() {
        return tipoLogin;
    }

    public void setTipoConta(TipoLogin tipoLogin) {
        this.tipoLogin = tipoLogin;
    }

}
