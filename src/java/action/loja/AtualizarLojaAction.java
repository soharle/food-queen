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
public class AtualizarLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        long lojaId = Long.parseLong(request.getParameter("lojaId"));
        long contaId = Long.parseLong(request.getParameter("contaID"));
        long contatoId = Long.parseLong(request.getParameter("contatoId"));
        long categoriaId = Long.parseLong(request.getParameter("categoriaId"));
        long enderecoLojaId = Long.parseLong(request.getParameter("enderecoLojaId"));
        
        String nome = request.getParameter("txtNome");
        String cnpj = request.getParameter("textCnpj");
        String descricao = request.getParameter("textDescricao");
        
        try {
            Conta conta = ContaDAO.getInstance().get(contaId);
            Contato contato = ContatoDAO.getInstance().get(contatoId);
            Categoria categoria = CategoriaDAO.getInstance().get(categoriaId);
            EnderecoLoja endereco = EnderecoLojaDAO.getInstance().get(enderecoLojaId);
            Loja loja = new Loja(nome, cnpj, descricao, endereco, conta, contato, categoria);
            LojaDAO.getInstance().update(loja);
            response.sendRedirect("sucesso.jsp");
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(AtualizarLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}
