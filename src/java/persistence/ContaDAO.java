package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Contato;
import model.conta.Conta;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mathe
 */
public class ContaDAO {

    private static ContaDAO instance = new ContaDAO();

    public static ContaDAO getInstance() {
        return instance;
    }

    private ContaDAO() {

    }

    public Conta get(long id) {
        ResultSet rs = DAO.executeQuery("SELECT * FROM conta WHERE id = " + id + "");
        return create(rs);
    }

    public Conta get(String login) {
        ResultSet rs = DAO.executeQuery("SELECT * FROM conta WHERE login = '" + login + "'");
        return create(rs);

    }

    public ArrayList<Conta> getAll() {
        ResultSet rs = DAO.executeQuery("SELECT * FROM conta;");
        return createAll(rs);
    }

    public void update(Conta conta) {
        DAO.executeQuery("UPDATE conta "
                + "SET login = '" + conta.getLogin() + "', "
                + "senha = '" + conta.getSenha() + "' "
                + "WHERE id = " + conta.getId() + ";");
    }

    public void delete(long id) {
        DAO.executeQuery("DELETE FROM conta WHERE id = " + id + "");
    }

    public Conta save(Conta conta) {
        long key = -1l;
        Statement st = DAO.executeQuery("INSERT INTO conta (login, senha, tipo)" + " "
                + "VALUES ('" + conta.getLogin() + "', "
                + "'" + conta.getSenha() + "', "
                + "'" + conta.getTipo() + "');", Statement.RETURN_GENERATED_KEYS);
        try {
            if (st.getGeneratedKeys().next()) {
                key = st.getGeneratedKeys().getLong(1);
                conta.setId(key);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conta;
    }

    private ArrayList<Conta> createAll(ResultSet rs) {
        ArrayList<Conta> contas = new ArrayList<>();
        try {
            while (rs.next()) {
                contas.add(builderConta(rs));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CartaoDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return contas;
    }

    private Conta create(ResultSet rs) {
        Conta contas = null;
        try {
            rs.first();
            contas = builderConta(rs);
            return contas;

        } catch (SQLException ex) {
            Logger.getLogger(CartaoDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return contas;
    }

    private Conta builderConta(ResultSet rs) {
        Conta conta = null;
        try {
            conta = new Conta();
            conta = conta.setId(rs.getLong("conta.id")).setLogin(rs.getString("conta.login"))
                    .setSenha(rs.getString("conta.senha")).setTipo(rs.getString("conta.tipo"));

        } catch (SQLException ex) {
            Logger.getLogger(CartaoDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return conta;
    }

}
