/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.loja;

import controller.Action;
import model.categoria.Categoria;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Loja;
import persistence.CategoriaDAO;
import persistence.LojaDAO;

/**
 *
 * @author soharle
 */
public class PrepararEditarLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        RequestDispatcher view = null;
        
        try {
            ArrayList<Categoria> categorias = CategoriaDAO.getInstance().getAll();
            HttpSession session = request.getSession();

            long id = Long.parseLong(session.getAttribute("id").toString());
            Loja loja = LojaDAO.getInstance().get(id);
            request.setAttribute("loja", loja);
            request.setAttribute("categorias", categorias);
            view = request.getRequestDispatcher("estabelecimento/editarDados.jsp");

        } catch (ClassNotFoundException | SQLException ex) {
            view = request.getRequestDispatcher("erro.jsp");

        }finally{
            view.forward(request, response);
        }
    }

}
