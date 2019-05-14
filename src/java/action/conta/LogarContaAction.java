/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.conta;

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
import javax.servlet.http.HttpSession;
import model.pedido.Pedido;
import model.categoria.Categoria;
import model.Consumidor;
import model.conta.Conta;
import model.Loja;
import model.Produto;
import persistence.PedidoDAO;
import persistence.CategoriaDAO;
import persistence.ConsumidorDAO;
import persistence.ContaDAO;
import persistence.LojaDAO;
import persistence.ProdutoHasPedidoDAO;
import persistence.ProdutoDAO;

/**
 *
 * @author mathe
 */
public class LogarContaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("txtLogin");
        String senha = request.getParameter("txtSenha");

        Conta conta;
        RequestDispatcher view = null;
        try {
            conta = ContaDAO.getInstance().get(login);

            if (conta != null) {
                if (conta.getLogin().equals(login) && conta.getSenha().equals(senha)) {
                    HttpSession session = request.getSession();
                    long id = 0;
                    if (conta.getTipoConta().logar(conta)) {
                        if (conta.getTipo().equals("Loja")) {
                            Loja loja = LojaDAO.getInstance().getByConta(conta.getId());
                            id = loja.getId();
                            view = request.getRequestDispatcher("estabelecimento/index.jsp");
                        } else {
                            Consumidor consumidor = ConsumidorDAO.getInstance().getByConta(conta.getId());
                            id = consumidor.getId();
                            ArrayList<Produto> produtos = null;
                            try {
                                produtos = ProdutoDAO.getInstance().getAll();
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            ArrayList<Categoria> categorias = CategoriaDAO.getInstance().getAll();
                            request.setAttribute("produtos", produtos);
                            request.setAttribute("categorias", categorias);
                            Pedido carrinho = PedidoDAO.getInstance().getByConsumidor(id, "NaoConcluido");
                            if (carrinho != null) {
                                request.getSession().setAttribute("pedidos", ProdutoHasPedidoDAO.getInstance().getByCarrinho(carrinho.getId()));
                            }
                            view = request.getRequestDispatcher("home.jsp");

                            session.setAttribute("id", id);
                            session.setAttribute("tipo", conta.getTipo());
                            session.setAttribute("login", conta.getLogin());

                        }
                    } else {
                        view = request.getRequestDispatcher("erro.jsp");
                    }
                }
            } else {
                view = request.getRequestDispatcher("index.jsp");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            view = request.getRequestDispatcher("index.jsp");
        } finally {
            try {
                view.forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(LogarContaAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
