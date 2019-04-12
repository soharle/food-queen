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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.PromocaoDAO;

/**
 *
 * @author Gabriel
 */
public class DeletarPromocaoLojaAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long id = Long.parseLong(request.getParameter("id"));
        try{
            PromocaoDAO.getInstance().delete(id);
            response.sendRedirect("FrontController?action=PrepararPromocoesLoja");
        }catch(IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DeletarPromocaoLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
