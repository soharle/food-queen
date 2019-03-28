/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.categoria;
import action.categoria.SalvarCategoriaAction;
import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;
import persistence.CategoriaDAO;

/**
 *
 * @author mathe
 */
public class AtualizaCategoriaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));
        String nome = request.getParameter("txtNome");

        try {
            Categoria categoria = new Categoria(id, nome);
            CategoriaDAO.getInstance().update(categoria);
            response.sendRedirect("sucesso.jsp");
        } catch (IOException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SalvarCategoriaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}