/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.consumidor;

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
import model.conta.Conta;
import model.Contato;
import model.Endereco;
import persistence.ConsumidorDAO;
import persistence.ContaDAO;
import persistence.ContatoDAO;
import persistence.EnderecoDAO;

/**
 *
 * @author Gabriel
 */
public class SalvarConsumidorAction implements Action {

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

        String cep = request.getParameter("txtCep");
        String logradouro = request.getParameter("txtLogradouro");
        String numero = request.getParameter("txtNumero");
        String complemento = request.getParameter("txtComplemento");
        String bairro = request.getParameter("txtBairro");
        String cidade = request.getParameter("txtCidade");
        String estado = request.getParameter("txtEstado");
        String pais = request.getParameter("txtPais");

        try {
            Conta conta = new Conta();
            conta.setLogin(login).setSenha(senha).setTipo("Consumidor");
            conta = ContaDAO.getInstance().save(conta);
            
            Contato contato = new Contato();
            contato.setTelefone(telefone).setDdd(ddd).setEmail(email).setTelefoneComplementar(telefoneComplementar);
            contato = ContatoDAO.getInstance().save(contato);
            
            Endereco endereco = new Endereco();
            endereco.setCep(cep).setLogradouro(logradouro).setNumero(numero).setComplemento(complemento)
                    .setBairro(bairro).setCidade(cidade).setEstado(estado).setPais(pais);
            endereco = EnderecoDAO.getInstance().save(endereco);
            
            Consumidor consumidor = new Consumidor();
            consumidor = consumidor.setNome(nome).setCpf(cpf).setNascimento(dataNascimento).setContato(contato).setConta(conta).setEndereco(endereco);
            ConsumidorDAO.getInstance().save(consumidor);

            
            HttpSession sessao = request.getSession();
            sessao.invalidate();

            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SalvarConsumidorAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(SalvarLojaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
