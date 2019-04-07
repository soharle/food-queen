/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.pedido;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pedido;
import persistence.PedidoDAO;

/**
 *
 * @author mathe
 */
public class LerPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        long id = Long.parseLong(request.getParameter("id"));

        Pedido pedido;
        
        try {
            pedido = PedidoDAO.getInstance().get(id);
            request.setAttribute("pedido", pedido);
            request.setAttribute("acao", "Editar");
            RequestDispatcher view = request.getRequestDispatcher("pages/pedido/pedido.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(LerPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}