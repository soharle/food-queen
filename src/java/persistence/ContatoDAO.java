package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public Contato get(long id) {
        ResultSet rs = DAO.executeQuery("SELECT * FROM contato WHERE id = " + id + "");
        return create(rs);
    }

    public ArrayList<Contato> getAll() {
        ResultSet rs = DAO.executeQuery("SELECT * FROM contato;");
        return createAll(rs);
    }

    public void update(Contato contato) {
        DAO.executeQuery("UPDATE contato SET "
                + "telefone = '" + contato.getTelefone() + "', "
                + "ddd = '" + contato.getDdd() + "', "
                + "email = '" + contato.getEmail() + "', "
                + "telefone_complementar = '" + contato.getTelefoneComplementar() + "' "
                + "WHERE id = " + contato.getId() + ";");
    }

    public void delete(long id) {
        DAO.executeQuery("DELETE FROM contato WHERE id =" + id + "");
    }

    public Contato save(Contato contato) {
        long key = -1l;
        Statement st = DAO.executeQuery("INSERT INTO contato (telefone, ddd, email, telefone_complementar)" + " "
                + "VALUES ('" + contato.getTelefone() + "', "
                + "'" + contato.getDdd() + "', "
                + "'" + contato.getEmail() + "', "
                + "'" + contato.getTelefoneComplementar() + "');", Statement.RETURN_GENERATED_KEYS);
        try {
            if (st.getGeneratedKeys().next()) {
                key = st.getGeneratedKeys().getLong(1);
                contato.setId(key);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contato;
    }

    private ArrayList<Contato> createAll(ResultSet rs) {
        ArrayList<Contato> contatos = new ArrayList<>();
        try {
            while (rs.next()) {
                contatos.add(builderContato(rs));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CartaoDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return contatos;
    }

    private Contato create(ResultSet rs) {
        Contato contato = null;
        try {
            rs.first();
            contato = builderContato(rs);
            return contato;

        } catch (SQLException ex) {
            Logger.getLogger(CartaoDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return contato;
    }

    private Contato builderContato(ResultSet rs) {
        Contato contato = null;
        try {
            contato = new Contato();
            contato.setId((rs.getLong("contato.id"))).setTelefone(rs.getString("contato.telefone")).setDdd(rs.getString("contato.ddd"))
                    .setEmail((rs.getString("contato.email"))).setTelefoneComplementar(rs.getString("contato.telefone_complementar"));

        } catch (SQLException ex) {
            Logger.getLogger(CartaoDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return contato;
    }
}
