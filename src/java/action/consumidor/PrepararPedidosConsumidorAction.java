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
import model.Carrinho;
import model.Pedido;
import persistence.CarrinhoDAO;
import persistence.PedidoDAO;

/**
 *
 * @author Gabriel
 */
public class PrepararPedidosConsumidorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long id = Long.parseLong(request.getSession().getAttribute("id").toString());
        ArrayList<Carrinho> carrinhos = CarrinhoDAO.getInstance().getAllByConsumidor(id);
        request.setAttribute("carrinhos", carrinhos);

        RequestDispatcher view = request.getRequestDispatcher("meusPedidos.jsp");
        view.forward(request, response);
    }

}
