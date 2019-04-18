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
import model.Cartao;
import model.Consumidor;
import model.Pedido;
import persistence.CarrinhoDAO;
import persistence.CartaoDAO;
import persistence.ConsumidorDAO;
import persistence.PedidoDAO;

/**
 *
 * @author Gabriel
 */
public class PrepararFinalizarCompraConsumidorAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        long id = Long.parseLong(request.getSession().getAttribute("id").toString());
        Consumidor consumidor = ConsumidorDAO.getInstance().get(id);
        Carrinho carrinho = CarrinhoDAO.getInstance().getByConsumidor(id);
        ArrayList<Cartao> cartoes = CartaoDAO.getInstance().getAllByConsumidor(id);
        ArrayList<Pedido> pedidos = PedidoDAO.getInstance().getByCarrinho(carrinho.getId());
        request.setAttribute("cartoes", cartoes);
        request.setAttribute("pedidos", pedidos);
        request.setAttribute("consumidor", consumidor);
        
        RequestDispatcher view = request.getRequestDispatcher("finalizarCompra.jsp");
        view.forward(request, response);
    }
    
}
