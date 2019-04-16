/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.consumidor;

import controller.Action;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ProdutoDAO;

/**
 *
 * @author Gabriel
 */
public class PrepararListarProdutosFiltroConsumidorAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("produtos", ProdutoDAO.getInstance().getAll());
        RequestDispatcher view = request.getRequestDispatcher("listaProdutos.jsp");
        view.forward(request, response);
    }
    
}
