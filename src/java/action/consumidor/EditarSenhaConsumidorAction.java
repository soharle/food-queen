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
import model.Consumidor;
import persistence.ConsumidorDAO;

/**
 *
 * @author soharle
 */
public class EditarSenhaConsumidorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String senha = request.getParameter("txtSenha");

        RequestDispatcher view = null;

        long id = Long.parseLong((String) request.getSession().getAttribute("id"));
        try {
            Consumidor consumidor = ConsumidorDAO.getInstance().get(id);
            consumidor.getConta().setSenha(senha);
            ConsumidorDAO.getInstance().update(consumidor);
            view = request.getRequestDispatcher("home.jsp");

        } catch (ClassNotFoundException ex) {
            view = request.getRequestDispatcher("erro.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(EditarSenhaConsumidorAction.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            view.forward(request, response);
        }
    }

}
