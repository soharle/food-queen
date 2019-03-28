/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.contato;

import action.contato.SalvarContatoAction;
import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ContatoDAO;

/**
 *
 * @author mathe
 */
public class DeletarContatoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));
        try {
            ContatoDAO.getInstance().delete(id);
            response.sendRedirect("sucesso.jsp");
        } catch (IOException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SalvarContatoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}