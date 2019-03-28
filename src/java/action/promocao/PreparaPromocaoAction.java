/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.promocao;

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
import model.Promocao;
import persistence.PromocaoDAO;

/**
 *
 * @author mathe
 */
public class PreparaPromocaoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            ArrayList<Promocao> promocoes = PromocaoDAO.getInstance().getAll();
            request.setAttribute("promocoes", promocoes);
            RequestDispatcher view = request.getRequestDispatcher("pages/promocao/listar.jsp");
            view.forward(request, response);
        } catch (ClassNotFoundException | SQLException | ServletException | IOException ex) {
            Logger.getLogger(PreparaPromocaoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
