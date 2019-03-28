/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.contato;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;
import persistence.ContatoDAO;

/**
 *
 * @author mathe
 */
public class AtualizarContatoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));
        String telefone = request.getParameter("txtTelefone");
        String ddd = request.getParameter("txtDdd");
        String email = request.getParameter("txtEmail");
        String telefoneComplementar = request.getParameter("txtTelefoneComplementar");
        
        try {
            Contato contato = new Contato(id, telefone, ddd, email, telefoneComplementar);
            ContatoDAO.getInstance().update(contato);
            response.sendRedirect("sucesso.jsp");
        } catch (IOException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SalvarContatoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
