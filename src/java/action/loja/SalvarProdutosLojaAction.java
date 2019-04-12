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
public class SalvarProdutosLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long idLoja = Long.parseLong(request.getSession().getAttribute("id").toString());
        String nome = request.getParameter("txtNome");
        String valor = request.getParameter("txtPreco");
        String descricao = request.getParameter("txtDescricao");
        String imagem = request.getParameter("txtImagem");
        String disponibilidade = request.getParameter("optCategoria");
        long idPromocao = Long.parseLong(request.getParameter("optPromocao"));
        
        Promocao promo;
        Loja loja;
        Produto produto;
        try {
            loja = LojaDAO.getInstance().get(idLoja);
            if(idPromocao == 0){
                promo = new Promocao();
            }else{
                promo = PromocaoDAO.getInstance().get(idPromocao);
            }
            produto = new Produto(nome, valor, disponibilidade, descricao, loja, promo);
            ProdutoDAO.getInstance().save(produto);
            RequestDispatcher view = request.getRequestDispatcher("FrontController?action=PrepararProdutosLoja");
            view.forward(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SalvarProdutosLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
