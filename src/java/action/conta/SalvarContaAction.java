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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("txtLogin");
        String senha = request.getParameter("txtSenha");
        String tipo = request.getParameter("optTipo");

        Conta conta = new Conta();
        conta = conta.setLogin(login).setSenha(senha).setTipo(tipo);

        try {
            ContaDAO.getInstance().save(conta);
        } catch (SQLException | ClassNotFoundException ex) {
            response.sendRedirect("erro.jsp");
        }
        response.sendRedirect("index.jsp");

    }
}
