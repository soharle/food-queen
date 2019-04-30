/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.loja;

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
import model.promocao.Promocao;
import persistence.PromocaoDAO;

/**
 *
 * @author Gabriel
 */
public class CadastrarProdutoLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            ArrayList<Promocao> promocoes = PromocaoDAO.getInstance().getPromocoes();
            request.setAttribute("acao", "criar");
            request.setAttribute("promocoes", promocoes);
            RequestDispatcher view = request.getRequestDispatcher("estabelecimento/manterProduto.jsp");
            view.forward(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastrarProdutoLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
