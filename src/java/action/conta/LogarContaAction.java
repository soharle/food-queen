/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.conta;

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
import javax.servlet.http.HttpSession;
import model.pedido.Pedido;
import model.categoria.Categoria;
import model.Consumidor;
import model.conta.Conta;
import model.Loja;
import model.MainFactory;
import model.Produto;
import persistence.PedidoDAO;
import persistence.CategoriaDAO;
import persistence.ConsumidorDAO;
import persistence.ContaDAO;
import persistence.LojaDAO;
import persistence.ProdutoHasPedidoDAO;
import persistence.ProdutoDAO;

/**
 *
 * @author mathe
 */
public class LogarContaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("txtLogin");
        String senha = request.getParameter("txtSenha");

        Conta conta;
        RequestDispatcher view = null;
        try {
            conta = ContaDAO.getInstance().get(login);

            if (conta != null && conta.getLogin().equals(login) && conta.getSenha().equals(senha)) {
                String tipo = conta.getTipoConta().logar(conta);
                LogarConta lc = (LogarConta) MainFactory.getObject("action.conta.LogarConta" + tipo);
                lc.logar(request, response, conta);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            view = request.getRequestDispatcher("index.jsp");
        }
    }
}
