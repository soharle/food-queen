/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.enderecoLoja;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EnderecoLoja;
import persistence.EnderecoLojaDAO;

/**
 *
 * @author mathe
 */
public class AtualizarEnderecoLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        long id = Long.parseLong(request.getParameter("id"));
        String cep = request.getParameter("txtCep");
        String logradouro = request.getParameter("txtLogradouro");
        String numero = request.getParameter("txtNumero");
        String complemento = request.getParameter("txtComplemento");
        String bairro = request.getParameter("txtBairro");
        String cidade = request.getParameter("txtCidade");
        String estado = request.getParameter("txtEstado");
        String pais = request.getParameter("txtPais");

        try {
            EnderecoLoja enderecoLoja = new EnderecoLoja(id, cep, logradouro, numero, complemento, bairro, cidade, estado, pais);
            EnderecoLojaDAO.getInstance().update(enderecoLoja);
            response.sendRedirect("sucesso.jsp");
        } catch (IOException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SalvarEnderecoLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
