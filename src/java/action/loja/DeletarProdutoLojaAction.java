/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.loja;

import controller.Action;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ProdutoDAO;

/**
 *
 * @author mathe
 */
public class DeletarProdutoLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long id = Long.parseLong(request.getParameter("id"));
        ProdutoDAO.getInstance().delete(id);
        response.sendRedirect("FrontController?action=PrepararProdutosLoja");

    }

}
