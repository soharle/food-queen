/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.consumidor;

import controller.Action;
import model.categoria.Categoria;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Consumidor;
import model.Endereco;
import persistence.CategoriaDAO;
import persistence.ConsumidorDAO;
import persistence.EnderecoDAO;

/**
 *
 * @author soharle
 */
public class PrepararEditarConsumidorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        RequestDispatcher view = null;

        try {
            HttpSession session = request.getSession();
            
            long id = Long.parseLong((String) session.getAttribute("id"));
            long enderecoId = Long.parseLong((String) session.getAttribute("enderecoId"));

            Consumidor consumidor = ConsumidorDAO.getInstance().get(id);
            Endereco endereco = EnderecoDAO.getInstance().get(enderecoId);
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
