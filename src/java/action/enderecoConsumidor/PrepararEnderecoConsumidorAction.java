/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.enderecoConsumidor;

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
import model.EnderecoConsumidor;
import persistence.EnderecoConsumidorDAO;

/**
 *
 * @author mathe
 */
public class PrepararEnderecoConsumidorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            ArrayList<EnderecoConsumidor> enderecoConsumidores = EnderecoConsumidorDAO.getInstance().getAll();
            request.setAttribute("enderecoConsumidores", enderecoConsumidores);
            RequestDispatcher view = request.getRequestDispatcher("pages/enderecoConsumidor/listar.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(PrepararEnderecoConsumidorAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
