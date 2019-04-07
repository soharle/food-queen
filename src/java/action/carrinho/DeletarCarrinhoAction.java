/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.carrinho;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Carrinho;
import persistence.CarrinhoDAO;

/**
 *
 * @author mathe
 */
public class DeletarCarrinhoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));
        try {
            CarrinhoDAO.getInstance().delete(id);
            response.sendRedirect("sucesso.jsp");
        } catch (IOException ex) {
            Logger.getLogger(SalvarCarrinhoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}