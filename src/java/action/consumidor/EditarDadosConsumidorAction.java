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
import model.Categoria;
import model.Consumidor;
import model.Loja;
import persistence.CategoriaDAO;
import persistence.ConsumidorDAO;
import persistence.LojaDAO;

/**
 *
 * @author soharle
 */
public class EditarDadosConsumidorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nome = request.getParameter("txtNome");
        String cpf = request.getParameter("txtCnpj");
        String nascimento = request.getParameter("txtDescricao");

        HttpSession session = request.getSession();

        long id = Long.parseLong((String) session.getAttribute("id"));

        RequestDispatcher view = null;

        try {
            Consumidor consumidor = ConsumidorDAO.getInstance().get(id);
            consumidor.setNome(nome);
            consumidor.setCpf(cpf);
            consumidor.setNascimento(nascimento);

            ConsumidorDAO.getInstance().update(consumidor);
            view = request.getRequestDispatcher("home.jsp");

        } catch (SQLException | ClassNotFoundException ex) {
            view = request.getRequestDispatcher("erro.jsp");
        } finally {
            view.forward(request, response);
        }

    }

}
