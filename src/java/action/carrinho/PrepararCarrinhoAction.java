/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.carrinho;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Carrinho;
import persistence.CarrinhoDAO;

/**
 *
 * @author mathe
 */
public class PrepararCarrinhoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            ArrayList<Carrinho> carrinhos = CarrinhoDAO.getInstance().getAll();
            request.setAttribute("carrinhos", carrinhos);
            RequestDispatcher view = request.getRequestDispatcher("pages/carrinho/listar.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(PrepararCarrinhoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
