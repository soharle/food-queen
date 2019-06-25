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
import model.Cartao;
import model.Consumidor;
import model.Contato;
import model.conta.Conta;

/**
 *
 * @author mathe
 */
public class DAO {

    public static ResultSet executeQuery(String query) {
        try {
            Connection conn = DatabaseLocator.getInstance().getConnection();
            Statement st = conn.createStatement();
            boolean result = st.execute(query);
            if(result){
                return st.getResultSet();
            }
            conn.close();
            st.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CartaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public static Statement executeQuery(String query, int statement) {
        try {
            Connection conn = DatabaseLocator.getInstance().getConnection();
            Statement st = conn.createStatement();
            boolean result = st.execute(query, statement);
            if(result){
                return st;
            }
            conn.close();
            st.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CartaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
