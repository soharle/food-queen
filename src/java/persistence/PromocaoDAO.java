package persistence;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Promocao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mathe
 */
public class PromocaoDAO {
    private static PromocaoDAO instance = new PromocaoDAO();

    public static PromocaoDAO getInstance() {
        return instance;
    }

    public Promocao getPromocao(int id) throws ClassNotFoundException, SQLException {
        Promocao promocao = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from promocao where id =" + id + "");
            rs.first();
            promocao = new Promocao(rs.getInt("id"), rs.getString("nome"), rs.getString("desconto"), rs.getString("tipo"));
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return promocao;

    }

    public ArrayList<Promocao> getPromocaos() throws ClassNotFoundException, SQLException {
        ArrayList<Promocao> promocoes = new ArrayList<Promocao>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from promocao;");
            while (rs.next()) {
                Promocao promocao = new Promocao(rs.getInt("id"), rs.getString("nome"), rs.getString("desconto"), rs.getString("tipo"));
                promocoes.add(promocao);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return promocoes;

    }

    public void update(Promocao promocao) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("update promocao set nome = '" + promocao.getNome() + ", desconto = '" + promocao.getDesconto()
                    + ", tipo = '" + promocao.getTipo() + "' where id = " + promocao.getId() + ";");

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void delete(int id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.executeUpdate("delete from promocao where id =" + id + "");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Promocao promocao) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
             st.execute("update promocao set nome = '" + promocao.getNome() + ", desconto = '" + promocao.getDesconto()
                    + ", tipo = '" + promocao.getTipo() + "' where id = " + promocao.getId() + ";");

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
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

        }
    }
}
