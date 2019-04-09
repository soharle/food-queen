package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Conta;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mathe
 */
public class ContaDAO {

    private static ContaDAO instance = new ContaDAO();

    public static ContaDAO getInstance() {
        return instance;
    }

    public Conta get(long id) throws ClassNotFoundException, SQLException {
        Conta conta = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM conta WHERE id = " + id + "");
            rs.first();
            conta = new Conta(rs.getInt("id"), rs.getString("login"), rs.getString("senha"), rs.getString("tipo"));
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return conta;

    }
    
    public Conta get(String login) throws ClassNotFoundException, SQLException {
        Conta conta = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM conta WHERE login = '" + login + "'");
            rs.first();
            conta = new Conta(rs.getInt("id"), rs.getString("login"), rs.getString("senha"), rs.getString("tipo"));
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return conta;

    }

    public ArrayList<Conta> getAll() throws ClassNotFoundException, SQLException {
        ArrayList<Conta> contas = new ArrayList<Conta>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM conta;");
            while (rs.next()) {
                Conta conta = new Conta(rs.getInt("id"), rs.getString("login"), rs.getString("senha"), rs.getString("tipo"));
                contas.add(conta);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return contas;

    }

    public void update(Conta conta) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE conta "
                    + "SET login = '" + conta.getLogin() + "', "
                    + "senha = '" + conta.getSenha() + "' "
                    + "WHERE id = " + conta.getId() + ";");

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
            st.executeUpdate("DELETE FROM conta WHERE id = " + id + "");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Conta conta) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO conta (login, senha, tipo)" + " "
                    + "VALUES ('" + conta.getLogin() + "', "
                    + "'" + conta.getSenha() + "', "
                    + "'" + conta.getTipo() + "');");

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
            System.out.println(e);
        }
    }
}
