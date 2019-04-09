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
import model.Categoria;
import model.Conta;
import model.Pedido;
import model.Produto;
import persistence.CategoriaDAO;
import persistence.ContaDAO;
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
                    session.setAttribute("tipo", conta.getTipo());
                    session.setAttribute("login", conta.getLogin());

                    if (conta.getTipo() == "Loja") {
                        view = request.getRequestDispatcher("estabelecimento/index.jsp");
                    } else {
                        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
                        ArrayList<Produto> produtos = ProdutoDAO.getInstance().getAll();
                        ArrayList<Categoria> categorias = CategoriaDAO.getInstance().getAll();
                        request.setAttribute("produtos", produtos);
                        request.setAttribute("categorias", categorias);
                        request.setAttribute("pedidos", pedidos);
                        view = request.getRequestDispatcher("home.jsp");

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
