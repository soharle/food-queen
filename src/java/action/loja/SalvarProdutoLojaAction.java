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
import persistence.LojaDAO;
import persistence.ProdutoDAO;
import persistence.PromocaoDAO;

/**
 *
 * @author mathe
 */
public class SalvarProdutoLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String nome = request.getParameter("txtNome");
        String imagem = request.getParameter("txtImagem");
        String preco = request.getParameter("txtPreco");
        String disponivel = request.getParameter("optCategoria");
        String descricao = request.getParameter("txtDescricao");
        String promocaoId = request.getParameter("optPromocao");

        try {

            Loja loja = LojaDAO.getInstance().get(Long.parseLong(request.getSession().getAttribute("id").toString()));
            Produto produto = new Produto();
            produto = produto.setDescricao(descricao).setNome(nome).setImagem(imagem).setPreco(preco)
                    .setDisponivel(disponivel).setLoja(loja);
            produto.setPromocao(PromocaoDAO.getInstance().getPromocao(Integer.parseInt(promocaoId)));
            ProdutoDAO.getInstance().save(produto);

            RequestDispatcher view = request.getRequestDispatcher("FrontController?action=PrepararProdutosLoja");

            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(PrepararLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EditarProdutoLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
