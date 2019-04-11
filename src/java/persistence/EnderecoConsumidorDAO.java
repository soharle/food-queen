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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Consumidor;
import model.Conta;
import model.Contato;
import model.EnderecoConsumidor;

/**
 *
 * @author Gabriel
 */
public class EnderecoConsumidorDAO {

    private static EnderecoConsumidorDAO instance = new EnderecoConsumidorDAO();

    public static EnderecoConsumidorDAO getInstance() {
        return instance;
    }

    private EnderecoConsumidorDAO() {
    }
    
    

    public EnderecoConsumidor get(long id) {
        EnderecoConsumidor endereco = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT endereco_consumidor.*, consumidor.*, conta.*, contato.* "
                    + "FROM endereco_consumidor "
                    + "INNER JOIN consumidor ON cartao.consumidor_id = consumidor.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "WHERE endereco_consumidor.id = " + id + ";");
            rs.first();
            Contato contato = new Contato(rs.getLong("contato.id"), rs.getString("contato.telefone"),
                    rs.getString("contato.ddd"), rs.getString("contato.email"), rs.getString("contato.telefone_complementar"));
            Conta conta = new Conta(rs.getLong("conta.id"), rs.getString("conta.login"),
                    rs.getString("conta.senha"), rs.getString("conta.tipo"));
            Consumidor consumidor = new Consumidor(rs.getLong("consumidor.id"), rs.getString("consumidor.nome"),
                    rs.getString("consumidor.cpf"), rs.getString("consumidor.nascimento"), contato, conta);
            endereco = new EnderecoConsumidor(rs.getInt("id"), rs.getString("cep"), rs.getString("logradouro"), rs.getString("numero"), rs.getString("complemento"),
                    rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("pais"), consumidor);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CartaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return endereco;
    }

    public ArrayList<EnderecoConsumidor> getAll() {
        ArrayList<EnderecoConsumidor> enderecos = new ArrayList<EnderecoConsumidor>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT endereco_consumidor.*, consumidor.*, conta.*, contato.* "
                    + "FROM endereco_consumidor "
                    + "INNER JOIN consumidor ON cartao.consumidor_id = consumidor.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id ;");
            while (rs.next()) {
                Contato contato = new Contato(rs.getLong("contato.id"), rs.getString("contato.telefone"),
                        rs.getString("contato.ddd"), rs.getString("contato.email"), rs.getString("contato.telefone_complementar"));
                Conta conta = new Conta(rs.getLong("conta.id"), rs.getString("conta.login"),
                        rs.getString("conta.senha"), rs.getString("conta.tipo"));
                Consumidor consumidor = new Consumidor(rs.getLong("consumidor.id"), rs.getString("consumidor.nome"),
                        rs.getString("consumidor.cpf"), rs.getString("consumidor.nascimento"), contato, conta);
                EnderecoConsumidor endereco = new EnderecoConsumidor(rs.getInt("id"), rs.getString("cep"), rs.getString("logradouro"), rs.getString("numero"), rs.getString("complemento"),
                        rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("pais"), consumidor);
                enderecos.add(endereco);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CartaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enderecos;
    }
    
    public void update(EnderecoConsumidor endereco) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE  endereco_consumidor SET consumidor_id = " + endereco.getConsumidor().getId() + ", "
                    + "logradouro = '" + endereco.getLogradouro() + "', "
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
            st.executeUpdate("DELETE FROM endereco_consumidor WHERE id = " + id + "");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(EnderecoConsumidor endereco) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO endereco_consumidor (consumidor_id, cep, logradouro, numero, complemento, bairro, cidade, estado, pais)"
                    + "VALUES (" + endereco.getConsumidor().getId() + ", "
                    + "'" + endereco.getCep() + "', "
                    + "'" + endereco.getLogradouro() + "', "
                    + "'" + endereco.getNumero() + "', "
                    + "'" + endereco.getComplemento() + "', "
                    + "'" + endereco.getBairro() + "', "
                    + "'" + endereco.getCidade() + "', "
                    + "'" + endereco.getEstado() + "', "
                    + "'" + endereco.getPais() + "');");
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
