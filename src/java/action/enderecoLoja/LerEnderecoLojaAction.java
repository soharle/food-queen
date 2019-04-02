/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.enderecoLoja;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EnderecoLoja;
import persistence.EnderecoLojaDAO;

/**
 *
 * @author mathe
 */
public class LerEnderecoLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        long id = Long.parseLong(request.getParameter("id"));

        EnderecoLoja enderecoLoja;
        
        try {
            enderecoLoja = EnderecoLojaDAO.getInstance().get(id);
            request.setAttribute("enderecoLoja", enderecoLoja);
            request.setAttribute("acao", "Editar");
            RequestDispatcher view = request.getRequestDispatcher("pages/enderecoLoja/enderecoLoja.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LerEnderecoLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
