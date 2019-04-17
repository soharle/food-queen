/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.consumidor;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
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
public class EditarContatoConsumidorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String telefone = request.getParameter("txtTelefone");
        String ddd = request.getParameter("txtDdd");
        String email = request.getParameter("txtEmail");
        String telefoneComplementar = request.getParameter("txtTelefoneComplementar");
        RequestDispatcher view = null;
        
        long id = Long.parseLong((String) request.getSession().getAttribute("id"));
        try {
            Consumidor consumidor = ConsumidorDAO.getInstance().get(id);
            consumidor.getContato().setTelefone(telefone);
            consumidor.getContato().setDdd(ddd);
            consumidor.getContato().setEmail(email);
            consumidor.getContato().setTelefoneComplementar(telefoneComplementar);
            ConsumidorDAO.getInstance().update(consumidor);
            view = request.getRequestDispatcher("home.jsp");

        } catch (SQLException | ClassNotFoundException ex) {
            view = request.getRequestDispatcher("erro.jsp");
        } finally {
            view.forward(request, response);
        }
    }

}
