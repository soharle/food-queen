/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.produto;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Loja;
import model.Produto;
import model.Promocao;
import persistence.LojaDAO;
import persistence.ProdutoDAO;
import persistence.PromocaoDAO;

/**
 *
 * @author mathe
 */
public class AtualizarProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));
        String nome = request.getParameter("txtNome");
        String preco = request.getParameter("txtPreco");
        String disponivel = request.getParameter("txtDisponivel");
        String descricao = request.getParameter("txtDescricao");
        long idLoja = Long.parseLong(request.getParameter("optLoja"));
        long idPromocao = Long.parseLong(request.getParameter("optPromocao"));

        Loja loja = null;
        Promocao promocao = null;

        try {
            loja = LojaDAO.getInstance().get(idLoja);
            promocao = PromocaoDAO.getInstance().get(idPromocao);
            Produto produto = new Produto(id, nome, preco, disponivel, descricao, loja, promocao);
            ProdutoDAO.getInstance().update(produto);
            response.sendRedirect("sucesso.jsp");
        } catch (IOException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AtualizarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
