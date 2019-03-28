/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel
 */
public class AtualizarLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        long lojaId = Long.parseLong(request.getParameter("lojaId"));
        long contaId = Long.parseLong(request.getParameter("contaID"));
        long contatoId = Long.parseLong(request.getParameter("contatoId"));
        long categoriaId = Long.parseLong(request.getParameter("categoriaId"));
        
        String nome = request.getParameter("txtNome");
        String cnpj = request.getParameter("textCnpj");
        String descricao = request.getParameter("textDescricao");
        
        String login = request.getParameter("textLogin");
        String senha = request.getParameter("textSenha");
        
        String telefone = request.getParameter("textTelefone");
        String ddd = request.getParameter("textDDD");
        String email = request.getParameter("textEmail");
        String telefone2 = request.getParameter("textTelefoneComplementar");
        
        
    }

}
