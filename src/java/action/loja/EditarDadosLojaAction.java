/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.loja;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.categoria.Categoria;
import model.Loja;
import persistence.CategoriaDAO;
import persistence.LojaDAO;

/**
 *
 * @author soharle
 */
public class EditarDadosLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nome = request.getParameter("txtNome");
        String cnpj = request.getParameter("txtCnpj");
        String descricao = request.getParameter("txtDescricao");
        String imagem = request.getParameter("txtImagem");
        Long idCategoria = Long.parseLong(request.getParameter("optCategoria"));
        
        HttpSession session = request.getSession();
        
        long id = Long.parseLong(session.getAttribute("id").toString());

        RequestDispatcher view = null;
        
        try {
            Loja loja = LojaDAO.getInstance().get(id);
            loja.setNome(nome).setCnpj(cnpj).setDescricao(descricao).setImagem(imagem);
            Categoria categoria = CategoriaDAO.getInstance().get(idCategoria);
            loja.setCategoria(categoria);

            LojaDAO.getInstance().update(loja);
            view = request.getRequestDispatcher("estabelecimento/index.jsp");

        } catch (SQLException | ClassNotFoundException ex) {
            view = request.getRequestDispatcher("erro.jsp");
        }finally{
            view.forward(request, response);
        }

    }

}
