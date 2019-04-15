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
import model.Produto;
import persistence.ProdutoDAO;
import persistence.PromocaoDAO;

/**
 *
 * @author mathe
 */
public class LerProdutoLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long id = Long.parseLong(request.getParameter("id"));

        try {
            Produto produto = ProdutoDAO.getInstance().get(id);
            request.setAttribute("produto", produto);
            request.setAttribute("promocoes", PromocaoDAO.getInstance().getPromocoes());

            request.setAttribute("acao", "editar");
            RequestDispatcher view = request.getRequestDispatcher("estabelecimento/manterProduto.jsp");
            view.forward(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LerProdutoLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
