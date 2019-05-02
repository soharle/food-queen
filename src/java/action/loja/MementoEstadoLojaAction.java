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
import model.MainFactory;
import model.pedido.MementoManager;
import model.pedido.Pedido;
import persistence.PedidoDAO;

/**
 *
 * @author mathe
 */
public class MementoEstadoLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        long id = Long.parseLong(request.getParameter("id"));
        ArrayList<Pedido> pedidos = (ArrayList<Pedido>) session.getAttribute("pedidos");

        if (pedidos == null) {
            long idLoja = Long.parseLong(session.getAttribute("id").toString());
            pedidos = PedidoDAO.getInstance().getAllByLoja(idLoja, "NaoConcluido");
        }

        int pedidoIndex = 0;
        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).getId() == id) {
                pedidoIndex = i;
                break;
            }
        }

        RequestDispatcher view = null;
        MementoManager mm = (MementoManager) session.getAttribute("mementoManager" + id);
        if (mm != null) {
            String metodo = request.getParameter("memento");
            if (!metodo.equals("salvar")) {
                MainFactory.invocarMemento(mm, metodo);
                pedidos.get(pedidoIndex).setEstado(mm.atual());

            } else {
                pedidos.get(pedidoIndex).notificar();
                mm.esquecerProximos();
                PedidoDAO.getInstance().update(pedidos.get(pedidoIndex));
            }

            session.setAttribute("mementoManager" + id, mm);
            request.setAttribute("pedidos", pedidos);
            session.setAttribute("pedidos", pedidos);

            view = request.getRequestDispatcher("estabelecimento/pedidos.jsp");
            PedidoDAO.getInstance().update(pedidos.get(pedidoIndex));

        } else {
            String msg = "O pedido não tem histórico, mude seu estado antes!";
            request.setAttribute("msg", msg);
            view = request.getRequestDispatcher("FrontController?action=PrepararPedidosLoja");
        }

        view.forward(request, response);

    }
}
