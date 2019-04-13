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
        long id = Long.parseLong(request.getParameter("txtId"));
        String nome = request.getParameter("txtNome");
        String imagem = request.getParameter("txtImagem");
        String preco = request.getParameter("txtPreco");
        String disponivel = request.getParameter("optCategoria");

        String descricao = request.getParameter("txtDescricao");
        String idPromo = request.getParameter("txtPromocaoId");
        long idPromocao = 0;
        if (!idPromo.equals("")) {
            idPromocao = Long.parseLong(idPromo);
        }
        String promocaoNome = request.getParameter("txtPromocaoNome");
        String promocaoTipo = request.getParameter("optPromocaoTipo");
        String desconto = request.getParameter("txtPromocaoDesconto");

        RequestDispatcher view = null;

        long idLoja = Long.parseLong(request.getSession().getAttribute("id").toString());
        try {
            Loja loja = LojaDAO.getInstance().get(idLoja);
            Produto produto = ProdutoDAO.getInstance().get(id);
            produto.setDescricao(descricao).setNome(nome).setImagem(imagem).setPreco(preco).setDisponivel(disponivel);
            Promocao promocao;
            if (!idPromo.equals("")) {
                promocao = PromocaoDAO.getInstance().get(idPromocao);
                promocao.setNome(promocaoNome).setTipo(promocaoTipo).setDesconto(desconto);
                ProdutoDAO.getInstance().update(produto);

            } else {
                promocao = new Promocao();
                promocao.setNome(promocaoNome).setTipo(promocaoTipo).setDesconto(desconto);
                ProdutoDAO.getInstance().save(produto);
            }

            PromocaoDAO.getInstance().update(promocao);

            view = request.getRequestDispatcher("estabelecimento/index.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(PrepararLojaAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EditarProdutoLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
