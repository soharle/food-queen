/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.loja;

import controller.Action;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import persistence.ProdutoDAO;

/**
 *
 * @author Gabriel
 */
public class PrepararProdutosLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long id = Long.parseLong(request.getSession().getAttribute("id").toString());
        ArrayList<Produto> produtos = ProdutoDAO.getInstance().getAllByLoja(id);
        request.setAttribute("produtos", produtos);
        RequestDispatcher view = request.getRequestDispatcher("estabelecimento/produtos.jsp");

        try {
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(PrepararLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
