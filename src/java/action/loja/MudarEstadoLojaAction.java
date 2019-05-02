/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.loja;

import controller.Action;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.pedido.Pedido;
import model.MainFactory;
import model.pedido.MementoManager;
import persistence.PedidoDAO;

public class MudarEstadoLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String metodo = request.getParameter("estado");
        long id = Long.parseLong(request.getParameter("id"));

        HttpSession session = request.getSession();
        long idLoja = Long.parseLong(session.getAttribute("id").toString());

        ArrayList<Pedido> pedidos = (ArrayList<Pedido>) session.getAttribute("pedidos");

        if (pedidos == null) {
            pedidos = PedidoDAO.getInstance().getAllByLoja(idLoja, "NaoConcluido");
        }

        int pedidoIndex = 0;
        Pedido pedido = null;

        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).getId() == id) {
                pedidoIndex = i;
                pedido = pedidos.get(i);
                break;
            }
        }

        MementoManager mm = (MementoManager) session.getAttribute("mementoManager" + id);

        if (mm == null) {
            mm = new MementoManager(pedido.getEstado());
        }

        boolean mudou = MainFactory.invocarMetodoFactory(pedido, metodo);
        String msg;
        if (mudou) {
            msg = "O carrinho mudou para " + pedido.getEstado().getNome();

            mm.adicionarMemento(pedido.getEstado());
            session.setAttribute("mementoManager" + id, mm);
        } else {
            msg = "Estado do carrinho " + pedido.getEstado().getNome() + " não pode ser trocado!";
        }
        PedidoDAO.getInstance().update(pedido);
        request.setAttribute("msg", msg);

        session.setAttribute("pedidos", pedidos);
        request.setAttribute("pedidos", pedidos);

        RequestDispatcher view = request.getRequestDispatcher("estabelecimento/pedidos.jsp");
        view.forward(request, response);
    }

}
