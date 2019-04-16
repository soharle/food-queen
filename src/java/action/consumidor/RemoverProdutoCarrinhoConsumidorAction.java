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
import model.Carrinho;
import model.Consumidor;
import persistence.CarrinhoDAO;
import persistence.ConsumidorDAO;
import persistence.PedidoDAO;

/**
 *
 * @author Gabriel
 */
public class RemoverProdutoCarrinhoConsumidorAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long id = Long.parseLong(request.getParameter("id"));
        PedidoDAO.getInstance().delete(id);
        long idConsumidor = Long.parseLong(request.getSession().getAttribute("id").toString());
        Carrinho carrinho = CarrinhoDAO.getInstance().getByConsumidor(idConsumidor);
        request.getSession().setAttribute("pedidos", PedidoDAO.getInstance().getByCarrinho(carrinho.getId()));
        RequestDispatcher view = request.getRequestDispatcher("home.jsp");
            view.forward(request, response);
    }
    
}
