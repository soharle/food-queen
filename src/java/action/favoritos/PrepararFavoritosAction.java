/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.favoritos;

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
import model.Favoritos;
import persistence.FavoritosDAO;

/**
 *
 * @author mathe
 */
public class PrepararFavoritosAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            ArrayList<Favoritos> listaFavoritos = FavoritosDAO.getInstance().getAll();
            request.setAttribute("listaFavoritos", listaFavoritos);
            RequestDispatcher view = request.getRequestDispatcher("pages/favoritos/listar.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(PrepararFavoritosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
