package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.EnderecoLoja;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mathe
 */
public class EnderecoLojaDAO {

    private static EnderecoLojaDAO instance = new EnderecoLojaDAO();

    public static EnderecoLojaDAO getInstance() {
        return instance;
    }

    private EnderecoLojaDAO() {
    }
    
    

    public EnderecoLoja get(long id) throws ClassNotFoundException, SQLException {
        EnderecoLoja endereco = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM endereco_loja WHERE id =" + id + "");
            rs.first();
            endereco = new EnderecoLoja(rs.getInt("id"), rs.getString("cep"), rs.getString("logradouro"), rs.getString("numero"), rs.getString("complemento"),
                    rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("pais"));
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return endereco;

    }

    public ArrayList<EnderecoLoja> getAll() throws ClassNotFoundException, SQLException {
        ArrayList<EnderecoLoja> enderecos = new ArrayList<EnderecoLoja>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM endereco_loja;");
            while (rs.next()) {
                EnderecoLoja endereco = new EnderecoLoja(rs.getInt("id"), rs.getString("cep"), rs.getString("logradouro"), rs.getString("numero"), rs.getString("complemento"),
                        rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("pais"));
                enderecos.add(endereco);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return enderecos;

    }

    public void update(EnderecoLoja endereco) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE  endereco_loja SET logradouro = '" + endereco.getLogradouro() + "', "
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
            st.executeUpdate("DELETE FROM endereco_loja WHERE id = " + id + "");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public EnderecoLoja save(EnderecoLoja endereco) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        long key = -1;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO endereco_loja (cep, logradouro, numero, complemento, bairro, cidade, estado, pais)"
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
