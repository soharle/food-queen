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
import model.Categoria;
import model.Consumidor;
import model.Conta;
import model.Contato;
import model.EnderecoLoja;
import model.Favoritos;
import model.Loja;

/**
 *
 * @author Gabriel
 */
public class FavoritosDAO {

    private static FavoritosDAO instance = new FavoritosDAO();

    public static FavoritosDAO getInstance() {
        return instance;
    }

    public Favoritos get(long id) {
        Favoritos favorito = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT favoritos.*, "
                    + "loja.*, conta.*, contato.*, endereco_loja.*, categoria.*, "
                    + "consumidor.*, conta.*, contato.* "
                    + "FROM favoritos "
                    + "INNER JOIN loja ON favoritos.loja_id = loja.id "
                    + "INNER JOIN conta ON loja.conta_id = conta.id "
                    + "INNER JOIN contato ON loja.contato_id = contato.id "
                    + "INNER JOIN endereco_loja ON loja.endereco_loja_id = endereco_loja.id "
                    + "INNER JOIN categoria ON loja.categoria_id = categoria.id "
                    + "INNER JOIN consumidor ON favoritos.consumidor_id = consumidor.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "WHERE favoritos.id =" + id + ";");
            rs.first();
            Conta contaLoja = new Conta(rs.getLong("conta.id"), rs.getString("conta.login"),
                    rs.getString("conta.senha"), rs.getString("conta.tipo"));
            Contato contatoLoja = new Contato(rs.getLong("contato.id"), rs.getString("contato.telefone"),
                    rs.getString("contato.ddd"), rs.getString("contato.email"), rs.getString("contato.telefone_complementar"));
            EnderecoLoja enderecoLoja = new EnderecoLoja(rs.getLong("endereco_loja.id"), rs.getString("cep"), rs.getString("endereco_loja.logradouro"),
                    rs.getString("endereco_loja.numero"), rs.getString("endereco_loja.complemento"),
                    rs.getString("endereco_loja.bairro"), rs.getString("endereco_loja.cidade"),
                    rs.getString("endereco_loja.estado"), rs.getString("endereco_loja.pais"));
            Categoria categoria = new Categoria(rs.getInt("categoria.id"), rs.getString("categoria.nome"));
            Loja loja = new Loja(rs.getLong("loja.id"), rs.getString("loja.nome"), rs.getString("loja.cnpj"), rs.getString("loja.descricao"),
                    enderecoLoja, contaLoja, contatoLoja, categoria);
            Contato contatoConsumidor = new Contato(rs.getLong("contato.id"), rs.getString("contato.telefone"),
                    rs.getString("contato.ddd"), rs.getString("contato.email"), rs.getString("contato.telefone_complementar"));
            Conta contaConsumidor = new Conta(rs.getLong("conta.id"), rs.getString("conta.login"),
                    rs.getString("conta.senha"), rs.getString("conta.tipo"));
            Consumidor consumidor = new Consumidor(rs.getLong("consumidor.id"), rs.getString("consumidor.nome"),
                    rs.getString("consumidor.cpf"), rs.getString("consumidor.nascimento"),
                    contatoConsumidor, contaConsumidor);
            favorito = new Favoritos(rs.getLong("favoritos.id"), consumidor, loja);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FavoritosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return favorito;
    }

    public ArrayList<Favoritos> getAll() {
        ArrayList<Favoritos> favoritos = new ArrayList<Favoritos>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT favoritos.*, "
                    + "loja.*, conta.*, contato.*, endereco_loja.*, categoria.*, "
                    + "consumidor.*, conta.*, contato.* "
                    + "FROM favoritos "
                    + "INNER JOIN loja ON favoritos.loja_id = loja.id "
                    + "INNER JOIN conta ON loja.conta_id = conta.id "
                    + "INNER JOIN contato ON loja.contato_id = contato.id "
                    + "INNER JOIN endereco_loja ON loja.endereco_loja_id = endereco_loja.id "
                    + "INNER JOIN categoria ON loja.categoria_id = categoria.id "
                    + "INNER JOIN consumidor ON favoritos.consumidor_id = consumidor.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id ;");
            
            while (rs.next()) {
                Conta contaLoja = new Conta(rs.getLong("conta.id"), rs.getString("conta.login"),
                        rs.getString("conta.senha"), rs.getString("conta.tipo"));
                Contato contatoLoja = new Contato(rs.getLong("contato.id"), rs.getString("contato.telefone"),
                        rs.getString("contato.ddd"), rs.getString("contato.email"), rs.getString("contato.telefone_complementar"));
                EnderecoLoja enderecoLoja = new EnderecoLoja(rs.getLong("endereco_loja.id"), rs.getString("cep"), rs.getString("endereco_loja.logradouro"),
                        rs.getString("endereco_loja.numero"), rs.getString("endereco_loja.complemento"),
                        rs.getString("endereco_loja.bairro"), rs.getString("endereco_loja.cidade"),
                        rs.getString("endereco_loja.estado"), rs.getString("endereco_loja.pais"));
                Categoria categoria = new Categoria(rs.getInt("categoria.id"), rs.getString("categoria.nome"));
                Loja loja = new Loja(rs.getLong("loja.id"), rs.getString("loja.nome"), rs.getString("loja.cnpj"), rs.getString("loja.descricao"),
                        enderecoLoja, contaLoja, contatoLoja, categoria);
                Contato contatoConsumidor = new Contato(rs.getLong("contato.id"), rs.getString("contato.telefone"),
                        rs.getString("contato.ddd"), rs.getString("contato.email"), rs.getString("contato.telefone_complementar"));
                Conta contaConsumidor = new Conta(rs.getLong("conta.id"), rs.getString("conta.login"),
                        rs.getString("conta.senha"), rs.getString("conta.tipo"));
                Consumidor consumidor = new Consumidor(rs.getLong("consumidor.id"), rs.getString("consumidor.nome"),
                        rs.getString("consumidor.cpf"), rs.getString("consumidor.nascimento"),
                        contatoConsumidor, contaConsumidor);
                Favoritos favorito = new Favoritos(rs.getLong("favoritos.id"), consumidor, loja);
                favoritos.add(favorito);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FavoritosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return favoritos;
    }
    
    public void update(Favoritos favoritos) {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String query = "UPDATE favoritos SET consumidor_id = " + favoritos.getConsumidor().getId() + ", "
                    + "loja_id = " + favoritos.getLoja().getId() + " "
                    + "WHERE id = " + favoritos.getId() + ";";
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
            st.executeUpdate("DELETE FROM favoritos WHERE id = " + id + "");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LojaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Favoritos favorito) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO favoritos (consumidor_id, loja_id) "
                    + "VALUES (" + favorito.getConsumidor().getId() + ", "
                    + "" + favorito.getLoja().getId() + " "
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
