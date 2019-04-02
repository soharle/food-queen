/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.loja;

import action.categoria.SalvarCategoriaAction;
import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;
import model.Conta;
import model.Contato;
import model.EnderecoLoja;
import model.Loja;
import persistence.CategoriaDAO;
import persistence.ContaDAO;
import persistence.ContatoDAO;
import persistence.EnderecoLojaDAO;
import persistence.LojaDAO;

/**
 *
 * @author Gabriel
 */
public class SalvarLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String nome = request.getParameter("txtNome");
        String cnpj = request.getParameter("txtCnpj");
        String descricao = request.getParameter("txtDescricao");
        long contaId = Long.parseLong(request.getParameter("optConta"));
        long contatoId = Long.parseLong(request.getParameter("optContato"));
        long categoriaId = Long.parseLong(request.getParameter("optCategoria"));
        long enderecoLojaId = Long.parseLong(request.getParameter("optEnderecoLoja"));

        try {
            Conta conta = ContaDAO.getInstance().get(contaId);
            Contato contato = ContatoDAO.getInstance().get(contatoId);
            Categoria categoria = CategoriaDAO.getInstance().get(categoriaId);
            EnderecoLoja enderecoLoja = EnderecoLojaDAO.getInstance().get(enderecoLojaId);

            Loja loja = new Loja(nome, cnpj, descricao, enderecoLoja, conta, contato, categoria);
            LojaDAO.getInstance().save(loja);
            response.sendRedirect("sucesso.jsp");
        } catch (IOException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SalvarCategoriaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
