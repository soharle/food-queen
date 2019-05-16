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
import model.conta.Conta;
import model.Contato;

/**
 *
 * @author Gabriel
 */
public class CartaoDAO {

    private static CartaoDAO instance = new CartaoDAO();

    public static CartaoDAO getInstance() {
        return instance;
    }

    private CartaoDAO() {
    }

    public Cartao get(long id) {
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
            Contato contato = new Contato();
            contato.setId((rs.getLong("contato.id"))).setTelefone(rs.getString("contato.telefone")).setDdd(rs.getString("contato.ddd"))
                    .setEmail((rs.getString("contato.email"))).setTelefoneComplementar(rs.getString("contato.telefone_complementar"));
            Conta conta = new Conta();
            conta.setId(rs.getLong("conta.id")).setLogin(rs.getString("conta.login"))
                    .setSenha(rs.getString("conta.senha")).setTipo(rs.getString("conta.tipo"));
            Consumidor consumidor = new Consumidor();
            consumidor.setId(rs.getLong("consumidor.id")).setNome(rs.getString("consumidor.nome"))
                    .setCpf(rs.getString("consumidor.cpf")).setNascimento(rs.getString("consumidor.nascimento")).setContato(contato).setConta(conta);
            cartao = new Cartao();
            cartao.setId(rs.getLong("cartao.id")).setNumero(rs.getString("cartao.numero")).setCod(rs.getString("cartao.cod"))
                    .setTitular(rs.getString("cartao.titular")).setValidade(rs.getString("cartao.validade")).setConsumidor(consumidor);
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
            Contato contato = new Contato();
            contato.setId((rs.getLong("contato.id"))).setTelefone(rs.getString("contato.telefone")).setDdd(rs.getString("contato.ddd"))
                    .setEmail((rs.getString("contato.email"))).setTelefoneComplementar(rs.getString("contato.telefone_complementar"));
            Conta conta = new Conta();
            conta.setId(rs.getLong("conta.id")).setLogin(rs.getString("conta.login"))
                    .setSenha(rs.getString("conta.senha")).setTipo(rs.getString("conta.tipo"));
            Consumidor consumidor = new Consumidor();
            consumidor.setId(rs.getLong("consumidor.id")).setNome(rs.getString("consumidor.nome"))
                    .setCpf(rs.getString("consumidor.cpf")).setNascimento(rs.getString("consumidor.nascimento")).setContato(contato).setConta(conta);
            Cartao cartao = new Cartao();
            cartao.setId(rs.getLong("cartao.id")).setNumero(rs.getString("cartao.numero")).setCod(rs.getString("cartao.cod"))
                    .setTitular(rs.getString("cartao.titular")).setValidade(rs.getString("cartao.validade")).setConsumidor(consumidor);
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

    public ArrayList<Cartao> getAllByConsumidor(long id) {
        ArrayList<Cartao> cartoes = new ArrayList<Cartao>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String query = "SELECT cartao.*, consumidor.*, conta.*, contato.* "
                    + "FROM cartao "
                    + "INNER JOIN consumidor ON cartao.consumidor_id = consumidor.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "WHERE cartao.consumidor_id = " + id + ";";
            ResultSet rs = st.executeQuery(query);
            rs.first();
            Contato contato = new Contato();
            contato.setId((rs.getLong("contato.id"))).setTelefone(rs.getString("contato.telefone")).setDdd(rs.getString("contato.ddd"))
                    .setEmail((rs.getString("contato.email"))).setTelefoneComplementar(rs.getString("contato.telefone_complementar"));
            Conta conta = new Conta();
            conta.setId(rs.getLong("conta.id")).setLogin(rs.getString("conta.login"))
                    .setSenha(rs.getString("conta.senha")).setTipo(rs.getString("conta.tipo"));
            Consumidor consumidor = new Consumidor();
            consumidor.setId(rs.getLong("consumidor.id")).setNome(rs.getString("consumidor.nome"))
                    .setCpf(rs.getString("consumidor.cpf")).setNascimento(rs.getString("consumidor.nascimento")).setContato(contato).setConta(conta);
            Cartao cartao = new Cartao();
            cartao.setId(rs.getLong("cartao.id")).setNumero(rs.getString("cartao.numero")).setCod(rs.getString("cartao.cod"))
                    .setTitular(rs.getString("cartao.titular")).setValidade(rs.getString("cartao.validade")).setConsumidor(consumidor);
            cartoes.add(cartao);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CartaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cartoes;
    }

}
