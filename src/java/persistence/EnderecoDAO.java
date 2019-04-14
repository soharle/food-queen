package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Endereco;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mathe
 */
public class EnderecoDAO {

    private static EnderecoDAO instance = new EnderecoDAO();

    public static EnderecoDAO getInstance() {
        return instance;
    }

    private EnderecoDAO() {
    }

    public Endereco get(long id) throws ClassNotFoundException, SQLException {
        Endereco endereco = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM endereco WHERE id =" + id + "");
            rs.first();
            endereco = new Endereco();
            endereco.setId(rs.getInt("id")).setCep(rs.getString("cep")).setLogradouro(rs.getString("logradouro")).setNumero(rs.getString("numero"))
                    .setComplemento(rs.getString("complemento")).setBairro(rs.getString("bairro")).setCidade(rs.getString("cidade"))
                    .setEstado(rs.getString("estado")).setPais(rs.getString("pais"));
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return endereco;

    }

    public ArrayList<Endereco> getAll() throws ClassNotFoundException, SQLException {
        ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM endereco;");
            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt("id")).setCep(rs.getString("cep")).setLogradouro(rs.getString("logradouro")).setNumero(rs.getString("numero"))
                        .setComplemento(rs.getString("complemento")).setBairro(rs.getString("bairro")).setCidade(rs.getString("cidade"))
                        .setEstado(rs.getString("estado")).setPais(rs.getString("pais"));
                enderecos.add(endereco);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return enderecos;

    }

    public void update(Endereco endereco) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE  endereco SET logradouro = '" + endereco.getLogradouro() + "', "
                    + "cep = '" + endereco.getCep() + "', "
                    + "numero = '" + endereco.getNumero() + "', "
                    + "complemento = '" + endereco.getComplemento() + "', "
                    + "bairro = '" + endereco.getBairro() + "', "
                    + "cidade = '" + endereco.getCidade() + "', "
                    + "estado = '" + endereco.getEstado() + "', "
                    + "pais = '" + endereco.getPais() + "' "
                    + "WHERE id = " + endereco.getId() + ";");

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
            st.executeUpdate("DELETE FROM endereco WHERE id = " + id + "");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public Endereco save(Endereco endereco) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        long key = -1;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO endereco (cep, logradouro, numero, complemento, bairro, cidade, estado, pais)"
                    + "VALUES ('" + endereco.getCep() + "', "
                    + "'" + endereco.getLogradouro() + "', "
                    + "'" + endereco.getNumero() + "', "
                    + "'" + endereco.getComplemento() + "', "
                    + "'" + endereco.getBairro() + "', "
                    + "'" + endereco.getCidade() + "', "
                    + "'" + endereco.getEstado() + "', "
                    + "'" + endereco.getPais() + "');", Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            if (rs != null && rs.next()) {
                key = rs.getLong(1);
            }
            endereco.setId(key);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
            return endereco;
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
