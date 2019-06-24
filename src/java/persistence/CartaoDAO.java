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

        ResultSet rs = DAO.executeQuery("SELECT cartao.*, consumidor.*, conta.*, contato.* "
                + "FROM cartao "
                + "INNER JOIN consumidor ON cartao.consumidor_id = consumidor.id "
                + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                + "WHERE cartao.id = " + id + ";");

        cartao = create(rs);

        return cartao;
    }

    public ArrayList<Cartao> getAll() {
        ArrayList<Cartao> cartoes = new ArrayList<Cartao>();
        ResultSet rs = DAO.executeQuery("SELECT cartao.*, consumidor.*, conta.*, contato.* "
                + "FROM cartao "
                + "INNER JOIN consumidor ON cartao.consumidor_id = consumidor.id "
                + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                + "INNER JOIN contato ON consumidor.contato_id = contato.id ;");
        cartoes = createAll(rs);
        return cartoes;
    }

    public ArrayList<Cartao> getAllByConsumidor(long id) {
        ArrayList<Cartao> cartoes = new ArrayList<Cartao>();
        ResultSet rs = DAO.executeQuery("SELECT cartao.*, consumidor.*, conta.*, contato.* "
                + "FROM cartao "
                + "INNER JOIN consumidor ON cartao.consumidor_id = consumidor.id "
                + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                + "WHERE cartao.consumidor_id = " + id + ";");
        cartoes = createAll(rs);

        return cartoes;
    }

    public void update(Cartao cartao) {
        DAO.executeQuery("UPDATE cartao SET numero = '" + cartao.getNumero() + "', "
                + "cod = '" + cartao.getCod() + "', "
                + "titular = '" + cartao.getTitular() + "', "
                + "validade = '" + cartao.getValidade() + "', "
                + "consumidor_id = " + cartao.getConsumidor().getId() + " "
                + "WHERE id = " + cartao.getId() + ";");
    }

    public void delete(long id) {
        DAO.executeQuery("DELETE FROM cartao WHERE id = " + id + "");
    }

    public void save(Cartao cartao) {
        ResultSet st = DAO.executeQuery("INSERT INTO cartao (numero, cod, titular, validade, consumidor_id) "
                + "VALUES ('" + cartao.getNumero() + "', "
                + "'" + cartao.getCod() + "', "
                + "'" + cartao.getTitular() + "', "
                + "'" + cartao.getValidade() + "', "
                + "" + cartao.getConsumidor().getId() + ""
                + ");");

    }

    private Cartao create(ResultSet rs) {
        Cartao cartao = null;
        try {
            rs.first();
            cartao = builderCartao(rs);
            return cartao;
        } catch (SQLException ex) {
            Logger.getLogger(CartaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cartao;
    }

    private ArrayList<Cartao> createAll(ResultSet rs) {
        ArrayList<Cartao> listaCartao = new ArrayList<>();
        try {
            while (rs.next()) {
                listaCartao.add(builderCartao(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaCartao;
    }

    private Cartao builderCartao(ResultSet rs) {
        Cartao cartao = null;
        Contato contato = new Contato();
        try {
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
        } catch (SQLException ex) {
            Logger.getLogger(CartaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cartao;
    }

}
