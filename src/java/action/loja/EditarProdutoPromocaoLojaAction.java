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
import model.Promocao;
import persistence.ProdutoDAO;
import persistence.PromocaoDAO;

/**
 *
 * @author mathe
 */
public class EditarProdutoPromocaoLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long idProduto = Long.parseLong(request.getParameter("txtId"));
        
        
        String checkbox = request.getParameter("cbPromocao");
        String nome = request.getParameter("txtPromocaoNome");
        String desconto = request.getParameter("txtPromocaoDesconto");
        String tipo = request.getParameter("optPromocaoTipo");
        String idPromo = request.getParameter("txtPromocaoId");
        
        try {
            if (checkbox != null) {
                Promocao promocao;
                if (idPromo.equals("")) {
                    promocao = new Promocao();
                    promocao.setNome(nome).setTipo(tipo).setDesconto(desconto);
                    ProdutoDAO.getInstance().get(idProduto).setPromocao(promocao).update();
                } else {
                    long id = Long.parseLong(idPromo);

                    promocao = PromocaoDAO.getInstance().get(id);
                    promocao.setNome(nome).setTipo(tipo).setDesconto(desconto);
                    PromocaoDAO.getInstance().update(promocao);
                }

            } else {
                if (idPromo.equals("")) {
                    long id = Long.parseLong(idPromo);
                    PromocaoDAO.getInstance().get(id).save();
                    ProdutoDAO.getInstance().get(idProduto).setPromocao(null).update();
                }
            }
            RequestDispatcher view = request.getRequestDispatcher("estabelecimento/index.jsp");
            view.forward(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EditarProdutoPromocaoLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
