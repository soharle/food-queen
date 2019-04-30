/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.consumidor;

import action.loja.EditarProdutoLojaAction;
import action.loja.PrepararLojaAction;
import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cartao;
import model.Consumidor;
import persistence.CartaoDAO;
import persistence.ConsumidorDAO;


/**
 *
 * @author mathe
 */
public class SalvarCartaoConsumidorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String nome = request.getParameter("txtNome");
        String numero = request.getParameter("txtNumero");
        String mes = request.getParameter("optMes");
        String ano = request.getParameter("optAno");
        String cod = request.getParameter("txtCod");

        try {
            Cartao cartao = new Cartao();
            cartao.setCod(cod).setNumero(numero).setTitular(nome).setValidade(mes + "/" + ano);
            Consumidor consumidor = ConsumidorDAO.getInstance().get(Long.parseLong(request.getSession().getAttribute("id").toString()));
            cartao.setConsumidor(consumidor);
            
            CartaoDAO.getInstance().save(cartao);
            
            RequestDispatcher view = request.getRequestDispatcher("home.jsp");

            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(PrepararLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EditarProdutoLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
