/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Entrega;

/**
 *
 * @author Gabriel
 */
public class EntregaDAO {

    private static EntregaDAO instance = new EntregaDAO();

    public EntregaDAO getInstance() {
        return instance;
    }

    public Entrega get(long id) {
        Entrega entrega = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT entrega.*, "
                    + "loja.*, conta.*, contato.*, endereco_loja.*, categoria.*, "
                    + "carrinho.*, consumidor.*, contato.*, conta.* "
                    + "FROM entrega"
                    + "INNER JOIN loja ON entrega.loja_id = loja.id");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EntregaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return entrega;
    }
}
