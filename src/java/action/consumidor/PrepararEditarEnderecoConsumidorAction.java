/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.consumidor;

import controller.Action;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Consumidor;
import persistence.ConsumidorDAO;

/**
 *
 * @author Gabriel
 */
public class PrepararEditarEnderecoConsumidorAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        long id = Long.parseLong(session.getAttribute("id").toString());

        Consumidor consumidor = ConsumidorDAO.getInstance().get(id);
        request.setAttribute("consumidor", consumidor);
        
        RequestDispatcher view = request.getRequestDispatcher("editarEndereco.jsp");
        view.forward(request, response);
    }
    
}
