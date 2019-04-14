/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.consumidor;

import controller.Action;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Consumidor;
import persistence.ConsumidorDAO;

/**
 *
 * @author Gabriel
 */
public class PrepararEditarDadosConsumidorAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        long id = Long.parseLong(session.getAttribute("id").toString());

        Consumidor consumidor = ConsumidorDAO.getInstance().get(id);
        request.setAttribute("consumidor", consumidor);
//        request.setAttribute("txtLogin", consumidor.getConta().getLogin());
//        request.setAttribute("senha", consumidor.getConta().getSenha());
//        request.setAttribute("txtNome", consumidor.getNome());
//        request.setAttribute("txtDataNascimento", consumidor.getNascimento());
//        request.setAttribute("txtCpf", consumidor.getCpf());
//        request.setAttribute("txtDdd", consumidor.getContato().getDdd());
//        request.setAttribute("txtTelefone", consumidor.getContato().getTelefone());
//        request.setAttribute("txtTelefoneComplementar", consumidor.getContato().getTelefoneComplementar());
//        request.setAttribute("txtEmail", consumidor.getContato().getEmail());

        RequestDispatcher view = request.getRequestDispatcher("editarDados.jsp");
        view.forward(request, response);

    }

}
