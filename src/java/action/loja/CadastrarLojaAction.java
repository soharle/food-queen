/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.loja;

import action.categoria.CadastrarCategoriaAction;
import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;
import model.Conta;
import model.Contato;
import model.Endereco;
import persistence.CategoriaDAO;
import persistence.ContaDAO;
import persistence.ContatoDAO;
import persistence.EnderecoDAO;
import persistence.LojaDAO;

/**
 *
 * @author Gabriel
 */
public class CadastrarLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("categorias", CategoriaDAO.getInstance().getAll());
            RequestDispatcher view = request.getRequestDispatcher("cadastroLoja.jsp");

            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(CadastrarCategoriaAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CadastrarLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
