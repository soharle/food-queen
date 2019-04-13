/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.consumidor;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.CategoriaDAO;

/**
 *
 * @author Gabriel
 */
public class CadastrarConsumidorAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            request.setAttribute("categorias", CategoriaDAO.getInstance().getAll());
            RequestDispatcher view = request.getRequestDispatcher("cadastroUsuario.jsp");

            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(CadastrarConsumidorAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CadastrarConsumidorAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
