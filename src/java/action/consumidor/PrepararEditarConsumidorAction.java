/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.consumidor;

import controller.Action;
import model.Categoria;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Consumidor;
import model.EnderecoConsumidor;
import model.Loja;
import persistence.CategoriaDAO;
import persistence.ConsumidorDAO;
import persistence.EnderecoConsumidorDAO;
import persistence.LojaDAO;

/**
 *
 * @author soharle
 */
public class PrepararEditarConsumidorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        RequestDispatcher view = null;

        try {
            ArrayList<Categoria> categorias = CategoriaDAO.getInstance().getAll();
            HttpSession session = request.getSession();
            
            long id = Long.parseLong((String) session.getAttribute("id"));
            long enderecoId = Long.parseLong((String) session.getAttribute("enderecoId"));

            Consumidor consumidor = ConsumidorDAO.getInstance().get(id);
            EnderecoConsumidor endereco = EnderecoConsumidorDAO.getInstance().get(enderecoId);
            request.setAttribute("consumidor", consumidor);
            request.setAttribute("endereco", endereco);
            view = request.getRequestDispatcher("editarDados.jsp");

        } catch (ClassNotFoundException | SQLException ex) {
            view = request.getRequestDispatcher("erro.jsp");

        } finally {
            view.forward(request, response);
        }
    }

}
