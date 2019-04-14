/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.consumidor;

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
import model.Endereco;
import persistence.ConsumidorDAO;
import persistence.EnderecoDAO;

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
        try {
            long id = Long.parseLong(session.getAttribute("id").toString());
            Consumidor consumidor = ConsumidorDAO.getInstance().get(id);
            
            Endereco endereco = consumidor.getEndereco();

            endereco.setCep(cep);
            endereco.setLogradouro(logradouro);
            endereco.setNumero(numero);
            endereco.setComplemento(complemento);
            endereco.setBairro(bairro);
            endereco.setCidade(cidade);
            endereco.setEstado(estado);
            EnderecoDAO.getInstance().update(endereco);
            view = request.getRequestDispatcher("home.jsp");
            view.forward(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EditarEnderecoConsumidorAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
