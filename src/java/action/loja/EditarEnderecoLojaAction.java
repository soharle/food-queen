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
import model.Loja;
import persistence.EnderecoLojaDAO;
import persistence.LojaDAO;

/**
 *
 * @author soharle
 */
public class EditarEnderecoLojaAction implements Action {

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

        long idLoja = Long.parseLong(request.getSession().getAttribute("id").toString());
        try {
            Loja loja = LojaDAO.getInstance().get(idLoja);
            loja.getEnderecoLoja().setCep(cep);
            loja.getEnderecoLoja().setLogradouro(logradouro);
            loja.getEnderecoLoja().setNumero(numero);
            loja.getEnderecoLoja().setComplemento(complemento);
            loja.getEnderecoLoja().setBairro(bairro);
            loja.getEnderecoLoja().setCidade(cidade);
            loja.getEnderecoLoja().setEstado(estado);

            EnderecoLojaDAO.getInstance().update(loja.getEnderecoLoja());
            view = request.getRequestDispatcher("estabelecimento/index.jsp");

        } catch (SQLException | ClassNotFoundException ex) {
            view = request.getRequestDispatcher("erro.jsp");
        } finally {
            view.forward(request, response);
        }
    }

}
