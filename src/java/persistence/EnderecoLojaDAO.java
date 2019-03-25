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

    public EnderecoLoja getEnderecoLoja(long id) throws ClassNotFoundException, SQLException {
        EnderecoLoja endereco = null;
        Connection conn = null;
        Statement st = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from endereco_loja where id =" + id + "");
            rs.first();
            endereco = new EnderecoLoja(rs.getInt("id"), rs.getString("logradouro"), rs.getString("numero"), rs.getString("complemento"),
            rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("pais"));
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return endereco;

    }

    public ArrayList<EnderecoLoja> getEnderecoLojas() throws ClassNotFoundException, SQLException {
        ArrayList<EnderecoLoja> enderecos = new ArrayList<EnderecoLoja>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from endereco_loja;");
            while (rs.next()) {
                EnderecoLoja endereco = new EnderecoLoja(rs.getInt("id"), rs.getString("logradouro"), rs.getString("numero"), rs.getString("complemento"),
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
            st.execute("update endereco_loja set logradouro = '" + endereco.getLogradouro() + ", numero = '" + endereco.getNumero() + ", complemento = '" +
                    endereco.getComplemento() + ", bairro = '" + endereco.getBairro() + ", cidade = '" + endereco.getCidade() + ", estado = '" + endereco.getEstado() +
                    ", pais = '" + endereco.getPais() + "' where id = " + endereco.getId() + ";");

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
            st.executeUpdate("delete from endereco_loja where id =" + id + "");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(EnderecoLoja endereco) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into endereco_loja set logradouro = '" + endereco.getLogradouro() + ", numero = '" + endereco.getNumero() + ", complemento = '" +
                    endereco.getComplemento() + ", bairro = '" + endereco.getBairro() + ", cidade = '" + endereco.getCidade() + ", estado = '" + endereco.getEstado() +
                    ", pais = '" + endereco.getPais() + "' where id = " + endereco.getId() + ";");
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
