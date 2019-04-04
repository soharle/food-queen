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
import javax.servlet.http.HttpSession;
import model.Conta;
import persistence.ContaDAO;

/**
 *
 * @author mathe
 */
public class SalvarContaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("txtLogin");
        String senha = request.getParameter("txtSenha");
        String tipo = request.getParameter("optTipo");
        
        try {
            Conta conta = new Conta(login, senha, tipo);
            ContaDAO.getInstance().save(conta);
            HttpSession session = request.getSession();
            session.setAttribute("tipo", tipo);
            session.setAttribute("login", login);
            response.sendRedirect("index.jsp");
        } catch (IOException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SalvarContaAction.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}

