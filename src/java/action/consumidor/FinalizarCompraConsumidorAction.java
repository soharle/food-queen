/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.consumidor;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Carrinho;
import model.Entrega;
import model.Pedido;
import model.StateFactory;
import persistence.CarrinhoDAO;
import persistence.EntregaDAO;
import persistence.PedidoDAO;

/**
 *
 * @author mathe
 */
public class FinalizarCompraConsumidorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long id = Long.parseLong(request.getSession().getAttribute("id").toString());

        try {
            Carrinho carrinho = CarrinhoDAO.getInstance().getByConsumidor(id);
            carrinho.getEstado().aguardar(carrinho);
            ArrayList<Pedido> pedidos = PedidoDAO.getInstance().getByCarrinho(carrinho.getId());
            Double valor = 0d;
            for(Pedido pedido : pedidos){
                valor += Double.parseDouble(pedido.getProduto().getPrecoDeVenda());
            }
            carrinho.setValor(valor.toString());
            CarrinhoDAO.getInstance().save(carrinho);

            Entrega entrega = new Entrega();
            entrega.setCarrinho(carrinho);
            entrega.setLoja(pedidos.get(0).getProduto().getLoja());
            EntregaDAO.getInstance().save(entrega);
            request.setAttribute("carrinho", carrinho);
            request.setAttribute("pedidos", pedidos);
            request.getSession().removeAttribute("carrinho");
            request.getSession().removeAttribute("pedidos");

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FinalizarCompraConsumidorAction.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher view = request.getRequestDispatcher("meusPedidos.jsp");
        view.forward(request, response);
    }

}
