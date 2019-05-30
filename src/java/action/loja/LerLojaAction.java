/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.loja;

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
import model.categoria.Categoria;
import model.conta.Conta;
import model.Contato;
import model.Endereco;
import model.Loja;
import persistence.CategoriaDAO;
import persistence.ContaDAO;
import persistence.ContatoDAO;
import persistence.EnderecoDAO;
import persistence.LojaDAO;

/**
 *
 * @author Gabriel
 */
public class LerLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        long id = Long.parseLong(request.getParameter("id"));
        
        Loja loja = null;
        ArrayList<Categoria> categorias;
        ArrayList<Conta> contas;
        ArrayList<Contato> contatos;
        ArrayList<Endereco> enderecosLoja;

        try {
            categorias = CategoriaDAO.getInstance().getAll();
            contas = ContaDAO.getInstance().getAll();
            contatos = ContatoDAO.getInstance().getAll();
            enderecosLoja = EnderecoDAO.getInstance().getAll();
            loja= LojaDAO.getInstance().get(id);
            
            request.setAttribute("categorias", categorias);
            request.setAttribute("contas", contas);
            request.setAttribute("contatos", contatos);
            request.setAttribute("enderecosLoja", enderecosLoja);
            request.setAttribute("loja", loja);
            
            request.setAttribute("acao", "Editar");
            
            RequestDispatcher view = request.getRequestDispatcher("pages/loja/loja.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LerLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
