/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
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
public class LerCategoriaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        long id = Long.parseLong(request.getParameter("txtId"));

        Categoria categoria;
        
        try {
            categoria = CategoriaDAO.getInstance().getCategoria(id);
            request.setAttribute("categoria", categoria);
            RequestDispatcher view = request.getRequestDispatcher("categoriaPages/exibitCategoria.jsp");
            view.forward(request, response);
        } catch (SQLException | ClassNotFoundException | ServletException | IOException ex) {
            Logger.getLogger(LerCategoriaAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
