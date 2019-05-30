/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.conta;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathe
 */
public class Conta {

    private long id;
    private String login;
    private String senha;
    private TipoConta tipo;
    private TipoLogin tipoLogin;

    public long getId() {
        return id;
    }

    public Conta setId(long id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public Conta setLogin(String login) {
        this.login = login;
        return this;

    }

    public String getSenha() {
        return senha;
    }

    public Conta setSenha(String senha) {
        this.senha = senha;
        return this;

    }

    public String getTipo() {
        return tipo.getDescricaoConta();
    }

    public Conta setTipo(String tipo) {
        try {
            Class c = Class.forName("model.conta.TipoConta" + tipo);
            this.tipo = (TipoConta) c.newInstance();
            Class c2 = Class.forName("model.conta.TipoLogin" + tipo);
            this.tipoLogin = (TipoLogin) c2.getDeclaredMethod("getTipoLogin" + tipo).invoke(c2.newInstance());
        } catch (IllegalAccessException | ClassNotFoundException | IllegalArgumentException | SecurityException ex) {
            System.out.println(ex);
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException ex) {
            Logger.getLogger(Conta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }

    public TipoConta getTipoConta() {
        return tipo;
    }

    public TipoLogin getTipoLogin() {
        return tipoLogin;
    }

}
