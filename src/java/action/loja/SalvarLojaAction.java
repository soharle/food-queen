/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.loja;

import action.categoria.SalvarCategoriaAction;
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
import model.Categoria;
import model.Conta;
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
public class SalvarLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("txtLogin");
        String senha = request.getParameter("txtSenha");

        String nome = request.getParameter("txtNome");
        String cnpj = request.getParameter("txtCnpj");
        String descricao = request.getParameter("txtDescricao");
        String imagem = request.getParameter("txtImagem");

        String optCategoria = request.getParameter("optCategoria");

        String cep = request.getParameter("txtCep");
        String logradouro = request.getParameter("txtLogradouro");
        String numero = request.getParameter("txtNumero");
        String complemento = request.getParameter("txtComplemento");
        String bairro = request.getParameter("txtBairro");
        String cidade = request.getParameter("txtCidade");
        String estado = request.getParameter("txtEstado");
        String pais = request.getParameter("txtPais");

        String telefone = request.getParameter("txtTelefone");
        String ddd = request.getParameter("txtDdd");
        String email = request.getParameter("txtEmail");
        String telefoneComplementar = request.getParameter("txtTelefoneComplementar");

        try {
            Conta conta = new Conta(login, senha, "Loja");
            conta = ContaDAO.getInstance().save(conta);
            Categoria categoria = CategoriaDAO.getInstance().get(Long.parseLong(optCategoria));
            Endereco endereco = new Endereco(cep, logradouro, numero, complemento, bairro, cidade, estado, pais);
            endereco = EnderecoDAO.getInstance().save(endereco);
            Contato contato = new Contato(telefone, ddd, email, telefoneComplementar);
            contato = ContatoDAO.getInstance().save(contato);
            Loja loja = new Loja(nome, cnpj, descricao, imagem, endereco, conta, contato, categoria);
            LojaDAO.getInstance().save(loja);

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
