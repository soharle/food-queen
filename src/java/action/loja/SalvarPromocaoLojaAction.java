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
import javax.servlet.http.HttpSession;
import model.Loja;
import model.Promocao;
import persistence.LojaDAO;
import persistence.PromocaoDAO;

/**
 *
 * @author Gabriel
 */
public class SalvarPromocaoLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long idLoja = Long.parseLong(request.getSession().getAttribute("id").toString());
        String nome = request.getParameter("txtNome");
        String desconto = request.getParameter("txtDesconto");
        String tipo = request.getParameter("optTipo");

        try {
            Loja loja = LojaDAO.getInstance().get(idLoja);
            Promocao promo = new Promocao(nome, desconto, tipo, loja);
            PromocaoDAO.getInstance().save(promo);
            RequestDispatcher view = request.getRequestDispatcher("FrontController?action=PrepararPromocoesLoja");
            view.forward(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SalvarPromocaoLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
