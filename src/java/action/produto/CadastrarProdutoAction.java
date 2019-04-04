/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.produto;

import controller.Action;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mathe
 */
public class CadastrarProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("acao", "Cadastrar");
        RequestDispatcher view = request.getRequestDispatcher("pages/produto/produto.jsp");
        try {
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(CadastrarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
