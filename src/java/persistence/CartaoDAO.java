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
import model.Cartao;
import model.Consumidor;
import model.Conta;
import model.Contato;

/**
 *
 * @author Gabriel
 */
public class CartaoDAO {

    private static CartaoDAO instance = new CartaoDAO();

    public CartaoDAO getInstance() {
        return instance;
    }

    public Cartao get(int id) {
        Cartao cartao = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT cartao.*, consumidor.*, conta.*, contato.* "
                    + "FROM cartao "
                    + "INNER JOIN consumidor ON cartao.consumidor_id = consumidor.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "WHERE cartao.id = " + id + ";");
            rs.first();
            Contato contato = new Contato(rs.getLong("contato.id"), rs.getString("contato.telefone"),
                    rs.getString("contato.ddd"), rs.getString("contato.email"), rs.getString("contato.telefone_complementar"));
            Conta conta = new Conta(rs.getLong("conta.id"), rs.getString("conta.login"),
                    rs.getString("conta.senha"), rs.getString("conta.tipo"));
            Consumidor consumidor = new Consumidor(rs.getLong("consumidor.id"), rs.getString("consumidor.nome"),
                    rs.getString("consumidor.cpf"), rs.getString("consumidor.nascimento"), contato, conta);
            cartao = new Cartao(rs.getLong("cartao.id"), rs.getString("cartao.numero"), rs.getString("cartao.cod"),
                    rs.getString("cartao.titular"), rs.getString("cartao.validade"), consumidor);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CartaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cartao;
    }

    public ArrayList<Cartao> getAll() {
        ArrayList<Cartao> cartoes = new ArrayList<Cartao>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT cartao.*, consumidor.*, conta.*, contato.* "
                    + "FROM cartao "
                    + "INNER JOIN consumidor ON cartao.consumidor_id = consumidor.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id ;");
            rs.first();
            Contato contato = new Contato(rs.getLong("contato.id"), rs.getString("contato.telefone"),
                    rs.getString("contato.ddd"), rs.getString("contato.email"), rs.getString("contato.telefone_complementar"));
            Conta conta = new Conta(rs.getLong("conta.id"), rs.getString("conta.login"),
                    rs.getString("conta.senha"), rs.getString("conta.tipo"));
            Consumidor consumidor = new Consumidor(rs.getLong("consumidor.id"), rs.getString("consumidor.nome"),
                    rs.getString("consumidor.cpf"), rs.getString("consumidor.nascimento"), contato, conta);
            Cartao cartao = new Cartao(rs.getLong("cartao.id"), rs.getString("cartao.numero"), rs.getString("cartao.cod"),
                    rs.getString("cartao.titular"), rs.getString("cartao.validade"), consumidor);
            cartoes.add(cartao);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CartaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cartoes;
    }

    public void update(Cartao cartao) {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String query = "UPDATE cartao SET numero = '" + cartao.getNumero() + "', "
                    + "cod = '" + cartao.getCod() + "', "
                    + "titular = '" + cartao.getTitular() + "', "
                    + "validade = '" + cartao.getValidade() + "', "
                    + "consumidor_id = " + cartao.getConsumidor().getId() + " "
                    + "WHERE id = " + cartao.getId() + ";";
            st.execute(query);

        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LojaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st);
        }
    }

    public void delete(long id) {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.executeUpdate("DELETE FROM cartao WHERE id = " + id + "");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LojaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Cartao cartao) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO cartao (numero, cod, titular, validade, consumidor_id) "
                    + "VALUES ('" + cartao.getNumero() + "', "
                    + "'" + cartao.getCod() + "', "
                    + "'" + cartao.getTitular() + "', "
                    + "'" + cartao.getValidade() + "', "
                    + "" + cartao.getConsumidor().getId() + ""
                    + ");");
        } catch (SQLException e) {
            System.out.println(e);;
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
