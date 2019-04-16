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
import model.StateFactory;
import persistence.CarrinhoDAO;
import persistence.PedidoDAO;

/**
 *
 * @author mathe
 */
public class FinalizarCompraConsumidorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long id = Long.parseLong(request.getSession().getAttribute("id").toString());
        Carrinho carrinho = CarrinhoDAO.getInstance().getByConsumidor(id);
        carrinho.setEstado(StateFactory.createCarrinhoEstado("Aguardando"));
        ArrayList<Pedido> pedidos = PedidoDAO.getInstance().getByCarrinho(carrinho.getId());
        
        request.setAttribute("carrinho", carrinho);
        request.setAttribute("pedidos", pedidos);
        
        RequestDispatcher view = request.getRequestDispatcher("home.jsp");
        view.forward(request, response);
    }
    
}
