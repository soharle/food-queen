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
import javax.servlet.http.HttpSession;
import model.Carrinho;
import model.Categoria;
import model.Pedido;
import model.Produto;
import persistence.CategoriaDAO;
import persistence.ProdutoDAO;

/**
 *
 * @author Gabriel
 */
public class PrepararHomeAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if (session.getAttribute("tipo") == "Consumidor") {
            try {
                ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
                ArrayList<Produto> produtos = ProdutoDAO.getInstance().getAll();
                ArrayList<Categoria> categorias = CategoriaDAO.getInstance().getAll();
                request.setAttribute("produtos", produtos);
                request.setAttribute("categorias", categorias);
                request.setAttribute("pedidos", pedidos);
                RequestDispatcher view = request.getRequestDispatcher("home.jsp");
                view.forward(request, response);

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(PrepararHomeAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            response.sendRedirect("");
        }
    }

}
