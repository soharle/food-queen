/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.favoritos;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Consumidor;
import model.Favoritos;
import model.Loja;
import persistence.FavoritosDAO;
import persistence.LojaDAO;

/**
 *
 * @author mathe
 */
public class AtualizarFavoritosAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));
        long idConsumidor = Long.parseLong(request.getParameter("optConsumidor"));
        long idLoja = Long.parseLong(request.getParameter("optLoja"));
        
        Consumidor consumidor = null;
        Loja loja = null;
        
        try {
            //consumidor = ConsumidorDAO.getInstance().get(idConsumidor);
            loja = LojaDAO.getInstance().get(idLoja);
            Favoritos favoritos = new Favoritos(id, consumidor, loja);
            FavoritosDAO.getInstance().update(favoritos);
            response.sendRedirect("sucesso.jsp");
        } catch (IOException ex) {
            Logger.getLogger(AtualizarFavoritosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
