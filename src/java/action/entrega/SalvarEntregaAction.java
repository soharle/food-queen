/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.entrega;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Carrinho;
import model.Entrega;
import model.EntregaEstado;
import model.Loja;
import model.Entrega;
import model.StateFactory;
import persistence.CarrinhoDAO;
import persistence.LojaDAO;
import persistence.EntregaDAO;

/**
 *
 * @author mathe
 */
public class SalvarEntregaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String estadoTxt = request.getParameter("optEstado");
        long idLoja = Long.parseLong(request.getParameter("optLoja"));
        long idCarrinho = Long.parseLong(request.getParameter("optCarrinho"));

        Loja loja = null;
        Carrinho carrinho = null;
        EntregaEstado estado = StateFactory.createEntregaEstado(estadoTxt);

        try {
            loja = LojaDAO.getInstance().get(idLoja);
            carrinho = CarrinhoDAO.getInstance().get(idCarrinho);
            Entrega entrega = new Entrega(estado, loja, carrinho);
            EntregaDAO.getInstance().save(entrega);
            response.sendRedirect("sucesso.jsp");
        } catch (IOException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SalvarEntregaAction.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}

