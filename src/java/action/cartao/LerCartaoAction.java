/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.cartao;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cartao;
import persistence.CartaoDAO;

/**
 *
 * @author mathe
 */
public class LerCartaoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        long id = Long.parseLong(request.getParameter("id"));

        Cartao cartao;
        
        try {
            cartao = CartaoDAO.getInstance().get(id);
            request.setAttribute("cartao", cartao);
            request.setAttribute("acao", "Editar");
            RequestDispatcher view = request.getRequestDispatcher("pages/cartao/cartao.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException  ex) {
            Logger.getLogger(LerCartaoAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
