/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.loja;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Loja;
import persistence.LojaDAO;

/**
 *
 * @author soharle
 */
public class EditarContatoLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String telefone = request.getParameter("txtTelefone");
        String ddd = request.getParameter("txtDdd");
        String email = request.getParameter("txtEmail");
        String telefoneComplementar = request.getParameter("txtTelefoneComplementar");
        RequestDispatcher view = null;
        
        long idLoja = Long.parseLong((String) request.getSession().getAttribute("id"));
        try {
            Loja loja = LojaDAO.getInstance().get(idLoja);
            loja.getContato().setTelefone(telefone);
            loja.getContato().setDdd(ddd);
            loja.getContato().setEmail(email);
            loja.getContato().setTelefoneComplementar(telefoneComplementar);
            LojaDAO.getInstance().update(loja);
            view = request.getRequestDispatcher("pages/estabelecimento/index.jsp");

        } catch (SQLException | ClassNotFoundException ex) {
            view = request.getRequestDispatcher("erro.jsp");
        } finally {
            view.forward(request, response);
        }
    }

}
