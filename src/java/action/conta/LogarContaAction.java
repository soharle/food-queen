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

        try {
            conta = ContaDAO.getInstance().get(login);

            if (conta != null) {
                if (conta.getLogin().equals(login) && conta.getSenha().equals(senha)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("tipo", conta.getLogin());
                    session.setAttribute("login", conta.getLogin());
                    ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
                    ArrayList<Produto> produtos = ProdutoDAO.getInstance().getAll();
                    ArrayList<Categoria> categorias = CategoriaDAO.getInstance().getAll();
                    request.setAttribute("produtos", produtos);
                    request.setAttribute("categorias", categorias);
                    request.setAttribute("pedidos", pedidos);
                } else {
                    RequestDispatcher view = request.getRequestDispatcher("index.jsp");
                }
            } else {
                RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            }
            RequestDispatcher view = request.getRequestDispatcher("home.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException | SQLException ex) {
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        }
    }

}
