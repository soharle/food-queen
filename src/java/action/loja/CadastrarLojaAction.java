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
import model.EnderecoLoja;
import persistence.CategoriaDAO;
import persistence.ContaDAO;
import persistence.ContatoDAO;
import persistence.EnderecoLojaDAO;
import persistence.LojaDAO;

/**
 *
 * @author Gabriel
 */
public class CadastrarLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("acao", "Cadastrar");

        ArrayList<Categoria> categorias;
        ArrayList<Conta> contas;
        ArrayList<Contato> contatos;
        ArrayList<EnderecoLoja> enderecosLoja;

        try {
            categorias = CategoriaDAO.getInstance().getAll();
            contas = ContaDAO.getInstance().getAll();
            contatos = ContatoDAO.getInstance().getAll();
            enderecosLoja = EnderecoLojaDAO.getInstance().getAll();

            request.setAttribute("categorias", categorias);
            request.setAttribute("contas", contas);
            request.setAttribute("contatos", contatos);
            request.setAttribute("enderecosLoja", enderecosLoja);

            RequestDispatcher view = request.getRequestDispatcher("pages/loja/loja.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(CadastrarCategoriaAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CadastrarLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
