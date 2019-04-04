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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Carrinho;
import model.Pedido;
import model.Produto;
import persistence.CarrinhoDAO;
import persistence.PedidoDAO;
import persistence.ProdutoDAO;

/**
 *
 * @author mathe
 */
public class AtualizarPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));
        String observacao = request.getParameter("txtObservacao");
        long idProduto = Long.parseLong(request.getParameter("optProduto"));
        long idCarrinho = Long.parseLong(request.getParameter("optCarrinho"));
        
        Produto produto = null;
        Carrinho carrinho = null;
        
        try {
            produto = ProdutoDAO.getInstance().get(idProduto);
            carrinho = CarrinhoDAO.getInstance().get(idCarrinho);
            Pedido pedido = new Pedido(id, observacao, produto, carrinho);
            PedidoDAO.getInstance().update(pedido);
            response.sendRedirect("sucesso.jsp");
        } catch (IOException ex) {
            Logger.getLogger(AtualizarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
