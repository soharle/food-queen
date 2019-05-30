/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.conta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.conta.Conta;

/**
 *
 * @author mathe
 */
public interface LogarConta {

    public void logar(HttpServletRequest request, HttpServletResponse response, Conta conta);
}
