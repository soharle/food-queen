/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.conta;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Loja;
import model.conta.Conta;
import persistence.LojaDAO;

/**
 *
 * @author mathe
 */
public class LogarContaLoja implements LogarConta {

    @Override
    public void logar(HttpServletRequest request, HttpServletResponse response, Conta conta) {
        Loja loja = LojaDAO.getInstance().getByConta(conta.getId());
        HttpSession session = request.getSession();

        session.setAttribute("id", loja.getId());
        session.setAttribute("tipo", conta.getTipo());
        session.setAttribute("login", conta.getLogin());
        try {
            request.getRequestDispatcher("estabelecimento/index.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(LogarContaLoja.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
