/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.promocao;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Promocao;
import persistence.PromocaoDAO;

/**
 *
 * @author mathe
 */
public class SalvarPromocaoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String nome = request.getParameter("txtNome");
        String desconto = request.getParameter("txtDesconto");
        String tipo = request.getParameter("txtTipo");
        
        try {
            Promocao promocao = new Promocao(nome, desconto, tipo);
            PromocaoDAO.getInstance().save(promocao);
            response.sendRedirect("sucesso.jsp");
        } catch (IOException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SalvarPromocaoAction.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}

