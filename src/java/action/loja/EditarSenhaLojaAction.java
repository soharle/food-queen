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
import model.conta.Conta;
import model.Loja;
import persistence.ContaDAO;
import persistence.LojaDAO;

/**
 *
 * @author soharle
 */
public class EditarSenhaLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String senha = request.getParameter("txtNovaSenha");
       
        RequestDispatcher view = null;
        
        long idLoja = Long.parseLong(request.getSession().getAttribute("id").toString());
        try {
            Loja loja = LojaDAO.getInstance().get(idLoja);
            Conta conta = new Conta();
            conta.setSenha(senha).setLogin(loja.getConta().getLogin()).setId(loja.getConta().getId());
            loja.setConta(conta);
            ContaDAO.getInstance().update(loja.getConta());
            view = request.getRequestDispatcher("estabelecimento/index.jsp");

        } catch (SQLException | ClassNotFoundException ex) {
            view = request.getRequestDispatcher("erro.jsp");
        } finally {
            view.forward(request, response);
        }
    }

}
