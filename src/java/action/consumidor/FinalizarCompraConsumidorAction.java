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
 * @author mathe
 */
public class FinalizarCompraConsumidorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long id = Long.parseLong(request.getSession().getAttribute("id").toString());

        Pedido carrinho = PedidoDAO.getInstance().getByConsumidor(id, "NaoConcluido");
        carrinho.getEstado().aguardar(carrinho);
        ArrayList<ProdutoHasPedido> pedidos = ProdutoHasPedidoDAO.getInstance().getByCarrinho(carrinho.getId());
        Double valor = 0d;
        
        for (ProdutoHasPedido pedido : pedidos) {
            valor += Double.parseDouble(pedido.getProduto().getPrecoDeVenda());
        }
        
        carrinho.setValor(valor.toString());
        carrinho.getEstado().aguardar(carrinho);
        PedidoDAO.getInstance().update(carrinho);
        
        ArrayList<Pedido> carrinhos = PedidoDAO.getInstance().getAllByConsumidor(id);
        request.setAttribute("carrinhos", carrinhos);
        
        request.getSession().removeAttribute("carrinho");
        request.getSession().removeAttribute("pedidos");

        RequestDispatcher view = request.getRequestDispatcher("meusPedidos.jsp");
        view.forward(request, response);
    }

}
