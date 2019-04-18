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
import model.Categoria;
import model.Consumidor;
import model.Pedido;
import model.Produto;
import persistence.CarrinhoDAO;
import persistence.CategoriaDAO;
import persistence.ConsumidorDAO;
import persistence.PedidoDAO;
import persistence.ProdutoDAO;

/**
 *
 * @author mathe
 */
public class AdicionarCarrinhoConsumidorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long id = Long.parseLong(request.getParameter("id"));
        Produto produto = ProdutoDAO.getInstance().get(id);
        long idConsumidor = Long.parseLong(request.getSession().getAttribute("id").toString());
        RequestDispatcher view = null;
        try {
            Consumidor consumidor = ConsumidorDAO.getInstance().get(idConsumidor);
            Carrinho carrinho = CarrinhoDAO.getInstance().getByConsumidor(idConsumidor, "NaoConcluido");

            if (carrinho == null) {
                carrinho = new Carrinho();
                carrinho.setConsumidor(consumidor);
                carrinho.setLoja(produto.getLoja());
                carrinho = CarrinhoDAO.getInstance().save(carrinho);
            }
            if (produto.getLoja().getId() == carrinho.getLoja().getId()) {
                Pedido pedido = new Pedido();
                pedido.setCarrinho(carrinho);
                pedido.setProduto(produto);
                PedidoDAO.getInstance().save(pedido);
                request.getSession().setAttribute("carrinho", carrinho);
                request.getSession().setAttribute("pedidos", PedidoDAO.getInstance().getByCarrinho(carrinho.getId()));
                view = request.getRequestDispatcher("FrontController?action=PrepararListaProdutosLojaConsumidor&id=" + produto.getLoja().getId());

            } else {
                ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
                ArrayList<Produto> produtos = ProdutoDAO.getInstance().getAll();
                request.setAttribute("produtos", produtos);
                request.setAttribute("msgErro", "Você não pode comprar produtos de lojas diferentes no mesmo carrinho");
                view = request.getRequestDispatcher("home.jsp");
            }

            view.forward(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdicionarCarrinhoConsumidorAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
