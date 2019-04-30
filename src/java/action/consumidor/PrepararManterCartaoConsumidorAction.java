/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.consumidor;

import controller.Action;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cartao;
import persistence.CartaoDAO;


/**
 *
 * @author Gabriel
 */
public class PrepararManterCartaoConsumidorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        long id = Long.parseLong(session.getAttribute("id").toString());
        ArrayList<Cartao> cartoes = CartaoDAO.getInstance().getAllByConsumidor(id);
        request.setAttribute("cartoes", cartoes);

        RequestDispatcher view = request.getRequestDispatcher("manterCartao.jsp");
        view.forward(request, response);
    }

}
