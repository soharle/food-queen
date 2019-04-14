/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.consumidor;

import controller.Action;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Consumidor;
import persistence.CartaoDAO;
import persistence.ConsumidorDAO;

/**
 *
 * @author Gabriel
 */
public class PrepararManterCartaoConsumidorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        long id = Long.parseLong(session.getAttribute("id").toString());

        request.setAttribute("cartoes", CartaoDAO.getInstance().getAllByConsumidor(id));

        RequestDispatcher view = request.getRequestDispatcher("manterCartao.jsp");
        view.forward(request, response);
    }

}
