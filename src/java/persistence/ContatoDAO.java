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

    private ContatoDAO() {
    }

    public Contato get(long id) throws ClassNotFoundException, SQLException {
        Contato contato = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM contato WHERE id = " + id + "");
            rs.first();
            contato = new Contato();
            contato.setId((rs.getLong("contato.id"))).setTelefone(rs.getString("contato.telefone")).setDdd(rs.getString("contato.ddd"))
                    .setEmail((rs.getString("contato.email"))).setTelefoneComplementar(rs.getString("contato.telefone_complementar"));
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return contato;

    }

    public ArrayList<Contato> getAll() throws ClassNotFoundException, SQLException {
        ArrayList<Contato> contatos = new ArrayList<Contato>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM contato;");
            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId((rs.getLong("contato.id"))).setTelefone(rs.getString("contato.telefone")).setDdd(rs.getString("contato.ddd"))
                        .setEmail((rs.getString("contato.email"))).setTelefoneComplementar(rs.getString("contato.telefone_complementar"));
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
            st.execute("UPDATE contato SET "
                    + "telefone = '" + contato.getTelefone() + "', "
                    + "ddd = '" + contato.getDdd() + "', "
                    + "email = '" + contato.getEmail() + "', "
                    + "telefone_complementar = '" + contato.getTelefoneComplementar() + "' "
                    + "WHERE id = " + contato.getId() + ";");

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
            st.executeUpdate("DELETE FROM contato WHERE id =" + id + "");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public Contato save(Contato contato) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        long key = -1l;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO contato (telefone, ddd, email, telefone_complementar)" + " "
                    + "VALUES ('" + contato.getTelefone() + "', "
                    + "'" + contato.getDdd() + "', "
                    + "'" + contato.getEmail() + "', "
                    + "'" + contato.getTelefoneComplementar() + "');", Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            if (rs != null && rs.next()) {
                key = rs.getLong(1);
            }
            contato.setId(key);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
            return contato;
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
