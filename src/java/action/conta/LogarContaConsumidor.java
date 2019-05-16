/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.conta;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Consumidor;
import model.Produto;
import model.categoria.Categoria;
import model.conta.Conta;
import model.pedido.Pedido;
import persistence.CategoriaDAO;
import persistence.ConsumidorDAO;
import persistence.PedidoDAO;
import persistence.ProdutoDAO;
import persistence.ProdutoHasPedidoDAO;

/**
 *
 * @author mathe
 */
public class LogarContaConsumidor implements LogarConta {

    @Override
    public void logar(HttpServletRequest request, HttpServletResponse response, Conta conta) {
        Consumidor consumidor = ConsumidorDAO.getInstance().getByConta(conta.getId());
        HttpSession session = request.getSession();
        ArrayList<Produto> produtos = null;
        try {
            produtos = ProdutoDAO.getInstance().getAll();
            ArrayList<Categoria> categorias = CategoriaDAO.getInstance().getAll();
            request.setAttribute("produtos", produtos);
            request.setAttribute("categorias", categorias);
            Pedido carrinho = PedidoDAO.getInstance().getByConsumidor(consumidor.getId(), "NaoConcluido");
            session.setAttribute("id", consumidor.getId());
            session.setAttribute("tipo", conta.getTipo());
            session.setAttribute("login", conta.getLogin());
            if (carrinho != null) {
                request.getSession().setAttribute("pedidos", ProdutoHasPedidoDAO.getInstance().getByCarrinho(carrinho.getId()));
            }
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException | ServletException | IOException ex) {
            System.out.println(ex);
        }
    }

}
