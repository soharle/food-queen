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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.LojaDAO;

/**
 *
 * @author Gabriel
 */
public class DeletarLojaAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));
        
        try{
            LojaDAO.getInstance().delete(id);
            response.sendRedirect("sucesso.jsp");
        }catch(IOException ex) {
            Logger.getLogger(DeletarLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
