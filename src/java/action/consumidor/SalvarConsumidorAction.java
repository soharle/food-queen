/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.consumidor;

import action.categoria.SalvarCategoriaAction;
import action.loja.SalvarLojaAction;
import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Consumidor;
import model.Conta;
import model.Contato;
import model.EnderecoConsumidor;
import persistence.ConsumidorDAO;
import persistence.ContaDAO;
import persistence.ContatoDAO;

/**
 *
 * @author Gabriel
 */
public class SalvarConsumidorAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("txtLogin");
        String senha = request.getParameter("txtSenha");

        String nome = request.getParameter("txtNome");
        String dataNascimento = request.getParameter("txtNascimento");
        String cpf = request.getParameter("txtCpf");

        String telefone = request.getParameter("txtTelefone");
        String ddd = request.getParameter("txtDdd");
        String email = request.getParameter("txtEmail");
        String telefoneComplementar = request.getParameter("txtTelefone2");

        try {
            Conta conta = new Conta(login, senha, "Consumidor");
            conta = ContaDAO.getInstance().save(conta);
            Contato contato = new Contato(telefone, ddd, email, telefoneComplementar);
            contato = ContatoDAO.getInstance().save(contato);
            Consumidor consumidor = new Consumidor(nome, cpf, dataNascimento, contato, conta);
            ConsumidorDAO.getInstance().save(consumidor);
            
            HttpSession sessao = request.getSession();
            sessao.invalidate();

            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SalvarCategoriaAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(SalvarLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
