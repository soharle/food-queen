/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.loja;

import controller.Action;
import model.Categoria;
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

        try {
            ArrayList<Categoria> categorias = CategoriaDAO.getInstance().getAll();
            HttpSession session = request.getSession();
            long id = Long.parseLong((String) session.getAttribute("lojaId"));
            Loja loja = LojaDAO.getInstance().get(id);
            request.setAttribute("loja", loja);
            request.setAttribute("categorias", categorias);
            RequestDispatcher view = request.getRequestDispatcher("pages/estabelecimento/editarDados.jsp");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PrepararEditarLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}