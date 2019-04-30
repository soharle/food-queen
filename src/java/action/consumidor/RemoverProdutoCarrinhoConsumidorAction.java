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
import model.pedido.Pedido;
import model.ProdutoHasPedido;
import persistence.PedidoDAO;
import persistence.ProdutoHasPedidoDAO;

/**
 *
 * @author Gabriel
 */
public class RemoverProdutoCarrinhoConsumidorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long id = Long.parseLong(request.getParameter("id"));
        ProdutoHasPedidoDAO.getInstance().delete(id);
        long idConsumidor = Long.parseLong(request.getSession().getAttribute("id").toString());
        Pedido carrinho = PedidoDAO.getInstance().getByConsumidor(idConsumidor, "NaoConcluido");
        ArrayList<ProdutoHasPedido> pedidos = ProdutoHasPedidoDAO.getInstance().getByCarrinho(carrinho.getId());
        request.getSession().setAttribute("pedidos", pedidos);
        if (pedidos.size() == 0) {
            PedidoDAO.getInstance().delete(carrinho.getId());
            request.getSession().removeAttribute("pedidos");
            request.getSession().removeAttribute("carrinho");
        }

        RequestDispatcher view = request.getRequestDispatcher("home.jsp");
        view.forward(request, response);
    }

}
