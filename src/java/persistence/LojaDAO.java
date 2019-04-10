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
import model.Conta;
import model.Contato;
import model.EnderecoLoja;
import model.Loja;

/**
 *
 * @author Gabriel
 */
public class LojaDAO {

    private static LojaDAO instance = new LojaDAO();

    public static LojaDAO getInstance() {
        return instance;
    }

    public Loja get(long id) throws SQLException, ClassNotFoundException {
        Loja loja = null;
        Connection conn = null;
        Statement st = null;

        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT loja.*, conta.*, contato.*, endereco_loja.*, categoria.* "
                    + "FROM loja "
                    + "INNER JOIN conta ON loja.conta_id = conta.id "
                    + "INNER JOIN contato ON loja.contato_id = contato.id "
                    + "INNER JOIN endereco_loja ON loja.endereco_loja_id = endereco_loja.id "
                    + "INNER JOIN categoria ON loja.categoria_id = categoria.id "
                    + "WHERE loja.id =" + id + "");
            rs.first();
            Conta conta = new Conta(rs.getLong("conta.id"), rs.getString("conta.login"),
                    rs.getString("conta.senha"), rs.getString("conta.tipo"));
            Contato contato = new Contato(rs.getLong("contato.id"), rs.getString("contato.telefone"),
                    rs.getString("contato.ddd"), rs.getString("contato.email"), rs.getString("contato.telefone_complementar"));
            EnderecoLoja enderecoLoja = new EnderecoLoja(rs.getLong("endereco_loja.id"), rs.getString("cep"), rs.getString("endereco_loja.logradouro"),
                    rs.getString("endereco_loja.numero"), rs.getString("endereco_loja.complemento"),
                    rs.getString("endereco_loja.bairro"), rs.getString("endereco_loja.cidade"),
                    rs.getString("endereco_loja.estado"), rs.getString("endereco_loja.pais"));
            Categoria categoria = new Categoria(rs.getInt("categoria.id"), rs.getString("categoria.nome"));
            loja = new Loja(rs.getLong("loja.id"), rs.getString("loja.nome"),
                    rs.getString("loja.cnpj"), rs.getString("loja.descricao"), rs.getString("loja.imagem"),
                    enderecoLoja, conta, contato, categoria);
        } finally {
            closeResources(conn, st);
        }
        return loja;
    }
    
    public Loja getByConta(long contaId) throws SQLException, ClassNotFoundException {
        Loja loja = null;
        Connection conn = null;
        Statement st = null;

        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String query = "SELECT loja.*, conta.*, contato.*, endereco_loja.*, categoria.* "
                    + "FROM loja "
                    + "INNER JOIN conta ON loja.conta_id = conta.id "
                    + "INNER JOIN contato ON loja.contato_id = contato.id "
                    + "INNER JOIN endereco_loja ON loja.endereco_loja_id = endereco_loja.id "
                    + "INNER JOIN categoria ON loja.categoria_id = categoria.id "
                    + "WHERE loja.conta_id =" + contaId + "";
            ResultSet rs = st.executeQuery(query);
            rs.first();
            Conta conta = new Conta(rs.getLong("conta.id"), rs.getString("conta.login"),
                    rs.getString("conta.senha"), rs.getString("conta.tipo"));
            Contato contato = new Contato(rs.getLong("contato.id"), rs.getString("contato.telefone"),
                    rs.getString("contato.ddd"), rs.getString("contato.email"), rs.getString("contato.telefone_complementar"));
            EnderecoLoja enderecoLoja = new EnderecoLoja(rs.getLong("endereco_loja.id"), rs.getString("cep"), rs.getString("endereco_loja.logradouro"),
                    rs.getString("endereco_loja.numero"), rs.getString("endereco_loja.complemento"),
                    rs.getString("endereco_loja.bairro"), rs.getString("endereco_loja.cidade"),
                    rs.getString("endereco_loja.estado"), rs.getString("endereco_loja.pais"));
            Categoria categoria = new Categoria(rs.getInt("categoria.id"), rs.getString("categoria.nome"));
            loja = new Loja(rs.getLong("loja.id"), rs.getString("loja.nome"),
                    rs.getString("loja.cnpj"), rs.getString("loja.descricao"), rs.getString("loja.imagem"),
                    enderecoLoja, conta, contato, categoria);
        } finally {
            closeResources(conn, st);
        }
        return loja;
    }

    public ArrayList<Loja> getAll() {
        ArrayList<Loja> lojas = new ArrayList();
        Connection conn = null;
        Statement st = null;

        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT loja.*, conta.*, contato.*, endereco_loja.*, categoria.* "
                    + "FROM loja "
                    + "INNER JOIN conta ON loja.conta_id = conta.id "
                    + "INNER JOIN contato ON loja.contato_id = contato.id "
                    + "INNER JOIN endereco_loja ON loja.endereco_loja_id = endereco_loja.id "
                    + "INNER JOIN categoria ON loja.categoria_id = categoria.id;");
            while (rs.next()) {
                Conta conta = new Conta(rs.getLong("conta.id"), rs.getString("conta.login"),
                        rs.getString("conta.senha"), rs.getString("conta.tipo"));
                Contato contato = new Contato(rs.getLong("contato.id"), rs.getString("contato.telefone"),
                        rs.getString("contato.ddd"), rs.getString("contato.email"), rs.getString("contato.telefone_complementar"));
                EnderecoLoja enderecoLoja = new EnderecoLoja(rs.getLong("endereco_loja.id"), rs.getString("cep"), rs.getString("endereco_loja.logradouro"),
                        rs.getString("endereco_loja.numero"), rs.getString("endereco_loja.complemento"),
                        rs.getString("endereco_loja.bairro"), rs.getString("endereco_loja.cidade"),
                        rs.getString("endereco_loja.estado"), rs.getString("endereco_loja.pais"));
                Categoria categoria = new Categoria(rs.getInt("categoria.id"), rs.getString("categoria.nome"));
                Loja loja = new Loja(rs.getLong("loja.id"), rs.getString("loja.nome"),
                        rs.getString("loja.cnpj"), rs.getString("loja.descricao"), rs.getString("loja.imagem"),
                        enderecoLoja, conta, contato, categoria);
                lojas.add(loja);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LojaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st);
        }
        return lojas;
    }

    public void update(Loja loja) {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String query = "UPDATE loja SET endereco_loja_id = " + loja.getEnderecoLoja().getId() + ", "
                    + "conta_id = " + loja.getConta().getId() + ", "
                    + "nome = '" + loja.getNome() + "', "
                    + "cnpj = '" + loja.getCnpj() + "', "
                    + "descricao = '" + loja.getDescricao() + "', "
                    + "imagem = '" + loja.getImagem() + "', "
                    + "contato_id = " + loja.getContato().getId() + ", "
                    + "categoria_id = " + loja.getCategoria().getId() + " "
                    + "WHERE id = " + loja.getId() + ";";
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
            st.executeUpdate("DELETE FROM loja WHERE id = " + id + "");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LojaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Loja loja) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO loja (endereco_loja_id, conta_id, nome, cnpj, descricao, imagem, contato_id, categoria_id) "
                    + "VALUES (" + loja.getEnderecoLoja().getId() + ", "
                    + "" + loja.getConta().getId() + ", "
                    + "'" + loja.getNome() + "', "
                    + "'" + loja.getCnpj() + "', "
                    + "'" + loja.getDescricao() + "', "
                    + "'" + loja.getImagem() + "', "
                    + "" + loja.getContato().getId() + ", "
                    + "" + loja.getCategoria().getId() + ""
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
