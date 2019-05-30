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
import model.conta.Conta;
import model.Contato;
import model.Endereco;

/**
 *
 * @author raiss
 */
public class ConsumidorDAO {

    private static ConsumidorDAO instance = new ConsumidorDAO();

    public static ConsumidorDAO getInstance() {
        return instance;
    }

    private ConsumidorDAO() {
    }

    public Consumidor get(long id) {
        Consumidor consumidor = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT consumidor.*, contato.*, conta.*, endereco.* "
                    + "FROM consumidor "
                    + "INNER JOIN contato ON contato.id = consumidor.contato_id "
                    + "INNER JOIN conta ON conta.id = consumidor.conta_id "
                    + "INNER JOIN endereco ON endereco.id = consumidor.endereco_id "
                    + "WHERE consumidor.id = " + id + ";");

            rs.first();

            Contato contato = new Contato();
            contato.setId((rs.getLong("contato.id"))).setTelefone(rs.getString("contato.telefone")).setDdd(rs.getString("contato.ddd"))
                    .setEmail((rs.getString("contato.email"))).setTelefoneComplementar(rs.getString("contato.telefone_complementar"));
            Conta conta = new Conta();
            conta.setId(rs.getLong("conta.id")).setLogin(rs.getString("conta.login"))
                    .setSenha(rs.getString("conta.senha")).setTipo(rs.getString("conta.tipo"));
            Endereco endereco = new Endereco();
            endereco.setId(rs.getLong("endereco.id")).setBairro(rs.getString("endereco.bairro")).setCep(rs.getString("endereco.cep"))
                    .setCidade(rs.getString("endereco.cidade")).setComplemento(rs.getString("endereco.complemento")).setEstado(rs.getString("endereco.estado"))
                    .setLogradouro(rs.getString("endereco.logradouro")).setNumero(rs.getString("endereco.numero")).setPais(rs.getString("endereco.pais"));
            consumidor = new Consumidor();
            consumidor.setId(rs.getLong("consumidor.id")).setNome(rs.getString("consumidor.nome"))
                    .setCpf(rs.getString("consumidor.cpf")).setNascimento(rs.getString("consumidor.nascimento")).setContato(contato).setConta(conta).setEndereco(endereco);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return consumidor;
    }

    public Consumidor getByConta(long id) {
        Consumidor consumidor = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT consumidor.*, contato.*, conta.* "
                    + "FROM consumidor "
                    + "INNER JOIN contato ON contato.id = consumidor.contato_id "
                    + "INNER JOIN conta ON conta.id = consumidor.conta_id "
                    + "WHERE consumidor.conta_id = " + id + ";");
            rs.first();
            Contato contato = new Contato();
            contato.setId((rs.getLong("contato.id"))).setTelefone(rs.getString("contato.telefone")).setDdd(rs.getString("contato.ddd"))
                    .setEmail((rs.getString("contato.email"))).setTelefoneComplementar(rs.getString("contato.telefone_complementar"));
            Conta conta = new Conta();
            conta.setId(rs.getLong("conta.id")).setLogin(rs.getString("conta.login"))
                    .setSenha(rs.getString("conta.senha")).setTipo(rs.getString("conta.tipo"));
            consumidor = new Consumidor();
            consumidor.setId(rs.getLong("consumidor.id")).setNome(rs.getString("consumidor.nome"))
                    .setCpf(rs.getString("consumidor.cpf")).setNascimento(rs.getString("consumidor.nascimento")).setContato(contato).setConta(conta);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return consumidor;
    }

    public ArrayList<Consumidor> getAll() {
        ArrayList<Consumidor> consumidores = new ArrayList<Consumidor>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT consumidor.*, contato.*, conta.* "
                    + "FROM consumidor "
                    + "INNER JOIN contato ON contato.id = consumidor.contato_id"
                    + "INNER JOIN conta ON conta.id = consumidor.conta_id ");

            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId((rs.getLong("contato.id"))).setTelefone(rs.getString("contato.telefone")).setDdd(rs.getString("contato.ddd"))
                        .setEmail((rs.getString("contato.email"))).setTelefoneComplementar(rs.getString("contato.telefone_complementar"));
                Conta conta = new Conta();
                conta.setId(rs.getLong("conta.id")).setLogin(rs.getString("conta.login"))
                        .setSenha(rs.getString("conta.senha")).setTipo(rs.getString("conta.tipo"));
                Consumidor consumidor = new Consumidor();
                consumidor.setId(rs.getLong("consumidor.id")).setNome(rs.getString("consumidor.nome"))
                        .setCpf(rs.getString("consumidor.cpf")).setNascimento(rs.getString("consumidor.nascimento")).setContato(contato).setConta(conta);
                consumidores.add(consumidor);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return consumidores;
    }

    public void update(Consumidor consumidor) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        conn = DatabaseLocator.getInstance().getConnection();
        st = conn.createStatement();
        st.execute("UPDATE consumidor SET nome = '" + consumidor.getNome() + "', "
                + "cpf = '" + consumidor.getCpf() + "', "
                + "nascimento = '" + consumidor.getNascimento() + "', "
                + "conta_id = " + consumidor.getConta().getId() + ", "
                + "contato_id = " + consumidor.getContato().getId() + " "
                + "WHERE id = " + consumidor.getId() + ";");

        closeResources(conn, st);

    }

    public void delete(long id) {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.executeUpdate("DELETE FROM consumidor WHERE id = " + id + "");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LojaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Consumidor consumidor) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO consumidor ( nome, cpf, nascimento, conta_id, contato_id, endereco_id) "
                    + "VALUES ('" + consumidor.getNome() + "', "
                    + "'" + consumidor.getCpf() + "', "
                    + "'" + consumidor.getNascimento() + "', "
                    + "" + consumidor.getConta().getId() + ", "
                    + "" + consumidor.getContato().getId() + ", "
                    + "" + consumidor.getEndereco().getId() + ");");
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
