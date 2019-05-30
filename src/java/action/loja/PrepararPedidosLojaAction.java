/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.loja;

import controller.Action;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.pedido.Pedido;
import persistence.PedidoDAO;

/**
 *
 * @author Gabriel
 */
public class PrepararPedidosLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        long id = Long.parseLong(session.getAttribute("id").toString());

        ArrayList<Pedido> pedidos = (ArrayList<Pedido>) session.getAttribute("pedidos");
        
        if (pedidos == null) {
            pedidos = PedidoDAO.getInstance().getAllByLoja(id, "NaoConcluido");
        }
        request.setAttribute("pedidos", pedidos);

        RequestDispatcher view = request.getRequestDispatcher("estabelecimento/pedidos.jsp");
        try {
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(PrepararLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
