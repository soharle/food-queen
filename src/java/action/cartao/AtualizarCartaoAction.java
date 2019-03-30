/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.cartao;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cartao;
import model.Consumidor;
import persistence.CartaoDAO;

/**
 *
 * @author mathe
 */
public class AtualizarCartaoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));
        String numero = request.getParameter("txtNumero");
        String cod = request.getParameter("txtCod");
        String titular = request.getParameter("txtTitutlar");
        String validade = request.getParameter("txtValidade");
        long idConsumidor = Long.parseLong(request.getParameter("optConsumidor"));
       
        Consumidor consumidor = null;

        try {
            
            //consumidor = ConsumidorDAO.getInstance().get(idConsumidor);
            Cartao cartao = new Cartao(id, numero, cod, titular, validade, consumidor);
            CartaoDAO.getInstance().update(cartao);
            response.sendRedirect("sucesso.jsp");
        } catch (IOException ex) {
            Logger.getLogger(AtualizarCartaoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
