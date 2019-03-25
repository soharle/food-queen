/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

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
import model.Categoria;
import persistence.CategoriaDAO;

/**
 *
 * @author mathe
 */
public class PreparaCategoriaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            ArrayList<Categoria> categorias = CategoriaDAO.getInstance().getCategorias();
            request.setAttribute("categorias", categorias);
            RequestDispatcher view = request.getRequestDispatcher("carroPages/carro.jsp");
            view.forward(request, response);
        } catch (ClassNotFoundException | SQLException | ServletException | IOException ex) {
            Logger.getLogger(PreparaCategoriaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
