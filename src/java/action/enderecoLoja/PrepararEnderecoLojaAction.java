/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.enderecoLoja;

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
import model.EnderecoLoja;
import persistence.EnderecoLojaDAO;

/**
 *
 * @author mathe
 */
public class PrepararEnderecoLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            ArrayList<EnderecoLoja> enderecosLoja = EnderecoLojaDAO.getInstance().getAll();
            request.setAttribute("enderecosLoja", enderecosLoja);
            RequestDispatcher view = request.getRequestDispatcher("pages/enderecoLoja/listar.jsp");
            view.forward(request, response);
        } catch (ClassNotFoundException | SQLException | ServletException | IOException ex) {
            Logger.getLogger(PrepararEnderecoLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
