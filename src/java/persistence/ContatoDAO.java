package persistence;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Contato;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mathe
 */
public class ContatoDAO {

    private static ContatoDAO instance = new ContatoDAO();

    public static ContatoDAO getInstance() {
        return instance;
    }

    public Contato getContato(int id) throws ClassNotFoundException, SQLException {
        Contato contato = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from contato where id =" + id + "");
            rs.first();
            contato = new Contato(rs.getInt("id"), rs.getString("telefone"), rs.getString("ddd"), rs.getString("email"), rs.getString("telefoneComplementar"));
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return contato;

    }

    public ArrayList<Contato> getContatos() throws ClassNotFoundException, SQLException {
        ArrayList<Contato> contatos = new ArrayList<Contato>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from contato;");
            while (rs.next()) {
                Contato contato = new Contato(rs.getInt("id"), rs.getString("telefone"), rs.getString("ddd"), rs.getString("email"), rs.getString("telefoneComplementar"));
                contatos.add(contato);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return contatos;

    }

    public void update(Contato contato) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("update contato set telefone = '" + contato.getTelefone() + ", ddd = '" + contato.getDdd()
                    + ", email = '" + contato.getEmail() + ", telefoneComplementar = '" + contato.getTelefoneComplementar() + "' where id = " + contato.getId() + ";");

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
            st.executeUpdate("delete from contato where id =" + id + "");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Contato contato) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into contato (telefone, ddd, email, telefone_complementar)" + " values ('" 
                    + contato.getTelefone() + "', '" + contato.getDdd() + "', '" + contato.getEmail() + "', '" + contato.getTelefoneComplementar() + "')");

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
