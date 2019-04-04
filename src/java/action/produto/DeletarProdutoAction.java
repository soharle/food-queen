/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.produto;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import persistence.ProdutoDAO;

/**
 *
 * @author mathe
 */
public class DeletarProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));
        try {
            ProdutoDAO.getInstance().delete(id);
            response.sendRedirect("sucesso.jsp");
        } catch (IOException ex) {
            Logger.getLogger(DeletarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
