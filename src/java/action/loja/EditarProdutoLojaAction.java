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
import model.Produto;
import model.Promocao;
import persistence.LojaDAO;
import persistence.ProdutoDAO;
import persistence.PromocaoDAO;

/**
 *
 * @author Gabriel
 */
public class EditarProdutoLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String nome = request.getParameter("txtNome");
        String imagem = request.getParameter("txtImagem");
        String preco = request.getParameter("txtPreco");
        String disponivel = request.getParameter("optCategoria");
        String descricao = request.getParameter("txtDescricao");
        String teste = request.getParameter("txtId");
        try {
            
            if (!request.getParameter("txtId").equals("")) {
                long id = Long.parseLong(request.getParameter("txtId"));
                Produto produto = ProdutoDAO.getInstance().get(id);
                produto = produto.setDescricao(descricao).setNome(nome).setImagem(imagem).setPreco(preco).setDisponivel(disponivel);
                ProdutoDAO.getInstance().update(produto);
            } else {
                Loja loja = LojaDAO.getInstance().get(Long.parseLong(request.getSession().getAttribute("id").toString()));
                Produto produto = new Produto();
                produto = produto.setDescricao(descricao).setNome(nome).setImagem(imagem).setPreco(preco).setDisponivel(disponivel).setLoja(loja);
                ProdutoDAO.getInstance().save(produto);
            }

            RequestDispatcher view = request.getRequestDispatcher("estabelecimento/index.jsp");

            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(PrepararLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EditarProdutoLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
