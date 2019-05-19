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
import java.util.ArrayList;
import model.MainFactory;
import model.Combo;

/**
 *
 * @author Gabriel
 */
public class ComboDAO {
    
    private static ComboDAO instance = new ComboDAO();
    
    public static ComboDAO getInstance(){
        return instance;
    }
    
    public ComboDAO() {
    }
    
    public Combo get(long id) throws ClassNotFoundException, SQLException {
        Combo combo = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT combo.* FROM combo "
                    + "WHERE combo.id =" + id + "");
             while (rs.next()) {
                combo = new Combo().setId(rs.getInt("id")).setNome(rs.getString("nome")).setPreco(rs.getDouble("preco"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return combo;

    }

    public ArrayList<Combo> getAll() throws ClassNotFoundException, SQLException {
        ArrayList<Combo> combos = new ArrayList<Combo>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT combo.* FROM combo ");
            while (rs.next()) {
                Combo combo = new Combo().setId(rs.getInt("id")).setNome(rs.getString("nome")).setPreco(rs.getDouble("preco"));
                combos.add(combo);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return combos;

    }

    public void update(Combo combo) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE combo SET nome = '" + combo.getNome() + "', preco = " + combo.getPreco() + " WHERE id = " + combo.getId() + ";");

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void delete(long id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.executeUpdate("DELETE FROM combo WHERE id = " + id + ";");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public Combo save(Combo combo) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        long key = -1l;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO combo (nome, preco)" + " VALUES ('" + combo.getNome() + "', " + combo.getPreco() +");", Statement.RETURN_GENERATED_KEYS);
            if (st.getGeneratedKeys().next()) {
                key = st.getGeneratedKeys().getLong(1);
            }
            combo.setId(key);

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
            return combo;
        }

    }

    private void closeResources(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
