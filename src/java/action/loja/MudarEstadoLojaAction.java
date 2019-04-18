/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.loja;

import controller.Action;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Carrinho;
import model.StateFactory;
import persistence.CarrinhoDAO;

public class MudarEstadoLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String metodo = request.getParameter("estado");
        long id = Long.parseLong(request.getParameter("id"));
        Carrinho carrinho = CarrinhoDAO.getInstance().get(id);
        boolean mudou = StateFactory.invocarMetodoFactory(carrinho, metodo);
        CarrinhoDAO.getInstance().update(carrinho);

        String msg;
        if (mudou) {
            msg = "O carrinho mudou para " + carrinho.getEstado().getNome();
            carrinho.notificar();
        } else {
            msg = "Estado do carrinho " + carrinho.getEstado().getNome() + " não pode ser trocado!";
        }

        request.setAttribute("msg", msg);
        RequestDispatcher view = request.getRequestDispatcher("FrontController?action=PrepararPedidosLoja");
        view.forward(request, response);
    }

}
