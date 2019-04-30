/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.consumidor;

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
import persistence.ConsumidorDAO;
import persistence.ContatoDAO;

/**
 *
 * @author mathe
 */
public class EditarDadosConsumidorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        long id = Long.parseLong(session.getAttribute("id").toString());

        Consumidor consumidor = ConsumidorDAO.getInstance().get(id);
        String login = request.getParameter("txtLogin");
        String senha = request.getParameter("txtSenha");
        String nome = request.getParameter("txtNome");
        String nascimento = request.getParameter("txtNascimento");
        String cpf = request.getParameter("txtCpf");
        String ddd = request.getParameter("txtDdd");
        String telefone = request.getParameter("txtTelefone");
        String complementar = request.getParameter("txtComplementar");
        consumidor.setNascimento(nascimento).setNome(nome).setCpf(cpf).getContato().setDdd(ddd).setTelefone(telefone).setTelefoneComplementar(complementar);
        consumidor.getConta().setLogin(login).setSenha(senha);
        try {
            ConsumidorDAO.getInstance().update(consumidor);
            ContatoDAO.getInstance().update(consumidor.getContato());
            RequestDispatcher view = request.getRequestDispatcher("home.jsp");
            view.forward(request, response);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EditarDadosConsumidorAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
