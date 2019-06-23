/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.conta;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.conta.Conta;
import persistence.ContaDAO;

/**
 *
 * @author mathe
 */
public class SalvarContaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response){
        String login = request.getParameter("txtLogin");
        String senha = request.getParameter("txtSenha");
        String tipo = request.getParameter("optTipo");

        Conta conta = new Conta();
        conta = conta.setLogin(login).setSenha(senha).setTipo(tipo);

            ContaDAO.getInstance().save(conta);
        try {
            response.sendRedirect("index.jsp");
        } catch (IOException ex) {
            Logger.getLogger(SalvarContaAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
