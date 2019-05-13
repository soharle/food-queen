/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.loja;

import controller.Action;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.categoria.Categoria;
import model.conta.Conta;
import model.Contato;
import model.Endereco;
import persistence.CategoriaDAO;
import persistence.ContaDAO;
import persistence.ContatoDAO;
import persistence.EnderecoDAO;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)

public class AtualizarLojaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try (PrintWriter out1 = response.getWriter()) {
            HttpSession session = request.getSession();
            Part filePart = request.getPart("file");
            long id = Long.parseLong(request.getParameter("id"));
            String nome = request.getParameter("txtNome");
            String cnpj = request.getParameter("txtCnpj");
            String descricao = request.getParameter("txtDescricao");
            long contaId = Long.parseLong(request.getParameter("optConta"));
            long contatoId = Long.parseLong(request.getParameter("optContato"));
            long categoriaId = Long.parseLong(request.getParameter("optCategoria"));
            long enderecoLojaId = Long.parseLong(request.getParameter("optEnderecoLoja"));

            String photo = "";
            String path = "/web/assets/images";

            File file = new File(path);
            file.mkdir();
            String fileName = getFileName(filePart);
            OutputStream out = null;

            InputStream filecontent = null;

            PrintWriter writer = response.getWriter();
            out = new FileOutputStream(new File(path + File.separator
                    + fileName));

            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);

                photo = path + "/" + fileName;

            }

            try {
                Conta conta = ContaDAO.getInstance().get(contaId);
                Contato contato = ContatoDAO.getInstance().get(contatoId);
                Categoria categoria = CategoriaDAO.getInstance().get(categoriaId);
                Endereco enderecoLoja = EnderecoDAO.getInstance().get(enderecoLojaId);

                //Loja loja = new Loja(id, nome, cnpj, descricao, enderecoLoja, conta, contato, categoria);
                //LojaDAO.getInstance().update(loja);
                response.sendRedirect("sucesso.jsp");
            } catch (IOException ex) {
                Logger.getLogger(AtualizarLojaAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AtualizarLojaAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AtualizarLojaAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");

        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
