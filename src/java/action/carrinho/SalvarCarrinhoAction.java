/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.carrinho;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Carrinho;
import model.CarrinhoEstado;
import model.Consumidor;
import model.StateFactory;
import persistence.CarrinhoDAO;

/**
 *
 * @author mathe
 */
public class SalvarCarrinhoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String valor = request.getParameter("txtValor");
        String data = request.getParameter("txtData");
        String hora = request.getParameter("txtHora");
        String pagamento = request.getParameter("txtPagamento");
        String estadoTxt = request.getParameter("optEstado");
        long idConsumidor = Long.parseLong(request.getParameter("optConsumidor"));
        
        CarrinhoEstado estado = StateFactory.createCarrinhoEstado(estadoTxt);

        Consumidor consumidor = null;

        try {
            
            //consumidor = ConsumidorDAO.getInstance().get(idConsumidor);
            Carrinho carrinho = new Carrinho(valor, data, hora, pagamento, estado, consumidor);
            CarrinhoDAO.getInstance().save(carrinho);
            response.sendRedirect("sucesso.jsp");
        } catch (IOException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SalvarCarrinhoAction.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}

