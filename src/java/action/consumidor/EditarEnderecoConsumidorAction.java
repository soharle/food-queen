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
import model.Consumidor;
import model.EnderecoConsumidor;
import model.Loja;
import persistence.ConsumidorDAO;
import persistence.EnderecoConsumidorDAO;
import persistence.LojaDAO;

/**
 *
 * @author soharle
 */
public class EditarEnderecoConsumidorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String cep = request.getParameter("txtCep");
        String logradouro = request.getParameter("txtLogradouro");
        String numero = request.getParameter("txtNumero");
        String complemento = request.getParameter("txtComplemento");
        String bairro = request.getParameter("txtBairro");
        String cidade = request.getParameter("txtCidade");
        String estado = request.getParameter("txtEstado");

        RequestDispatcher view = null;
        HttpSession session = request.getSession();

        long id = Long.parseLong((String) session.getAttribute("id"));
        long enderecoId = Long.parseLong((String) session.getAttribute("enderecoId"));
        try {
            
            EnderecoConsumidor endereco = EnderecoConsumidorDAO.getInstance().get(enderecoId);

            endereco.setCep(cep);
            endereco.setLogradouro(logradouro);
            endereco.setNumero(numero);
            endereco.setComplemento(complemento);
            endereco.setBairro(bairro);
            endereco.setCidade(cidade);
            endereco.setEstado(estado);

            EnderecoConsumidorDAO.getInstance().update(endereco);
            view = request.getRequestDispatcher("home.jsp");

        } catch (SQLException | ClassNotFoundException ex) {
            view = request.getRequestDispatcher("erro.jsp");
        } finally {
            view.forward(request, response);
        }
    }

}
