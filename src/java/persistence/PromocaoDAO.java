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
import model.Endereco;
import model.Loja;
import model.Produto;
import model.Promocao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mathe
 */
public class PromocaoDAO {

    private static PromocaoDAO instance = new PromocaoDAO();

    public static PromocaoDAO getInstance() {
        return instance;
    }

    private PromocaoDAO() {
    }

    public Promocao get(long id) throws ClassNotFoundException, SQLException {
        Promocao promocao = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT promocao.*, loja.*, conta.*, contato.*, endereco_loja.*, categoria.* FROM promocao "
                    + "LEFT JOIN loja ON promocao.loja_id = loja.id "
                    + "INNER JOIN conta ON loja.conta_id = conta.id "
                    + "INNER JOIN contato ON loja.contato_id = contato.id "
                    + "INNER JOIN endereco_loja ON loja.endereco_loja_id = endereco_loja.id "
                    + "INNER JOIN categoria ON loja.categoria_id = categoria.id "
                    + "WHERE id = " + id + ";");
            rs.first();
            Conta conta = new Conta(rs.getLong("conta.id"), rs.getString("conta.login"),
                    rs.getString("conta.senha"), rs.getString("conta.tipo"));
            Contato contato = new Contato(rs.getLong("contato.id"), rs.getString("contato.telefone"),
                    rs.getString("contato.ddd"), rs.getString("contato.email"), rs.getString("contato.telefone_complementar"));
            Endereco enderecoLoja = new Endereco(rs.getLong("endereco_loja.id"), rs.getString("cep"), rs.getString("endereco_loja.logradouro"),
                    rs.getString("endereco_loja.numero"), rs.getString("endereco_loja.complemento"),
                    rs.getString("endereco_loja.bairro"), rs.getString("endereco_loja.cidade"),
                    rs.getString("endereco_loja.estado"), rs.getString("endereco_loja.pais"));
            Categoria categoria = new Categoria(rs.getInt("categoria.id"), rs.getString("categoria.nome"));
            Loja loja = new Loja(rs.getLong("loja.id"), rs.getString("loja.nome"),
                    rs.getString("loja.cnpj"), rs.getString("loja.descricao"), rs.getString("loja.imagem"),
                    enderecoLoja, conta, contato, categoria);
            promocao = new Promocao(rs.getInt("id"), rs.getString("nome"), rs.getString("desconto"), rs.getString("tipo"));
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return promocao;

    }

    public ArrayList<Promocao> getAll() throws ClassNotFoundException, SQLException {
        ArrayList<Promocao> promocoes = new ArrayList<Promocao>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT promocao.*, loja.*, conta.*, contato.*, endereco_loja.*, categoria.* FROM promocao "
                    + "INNER JOIN loja ON promocao.loja_id = loja.id "
                    + "INNER JOIN conta ON loja.conta_id = conta.id "
                    + "INNER JOIN contato ON loja.contato_id = contato.id "
                    + "INNER JOIN endereco_loja ON loja.endereco_loja_id = endereco_loja.id "
                    + "INNER JOIN categoria ON loja.categoria_id = categoria.id ;");
            while (rs.next()) {
                Conta conta = new Conta(rs.getLong("conta.id"), rs.getString("conta.login"),
                        rs.getString("conta.senha"), rs.getString("conta.tipo"));
                Contato contato = new Contato(rs.getLong("contato.id"), rs.getString("contato.telefone"),
                        rs.getString("contato.ddd"), rs.getString("contato.email"), rs.getString("contato.telefone_complementar"));
                Endereco enderecoLoja = new Endereco(rs.getLong("endereco_loja.id"), rs.getString("cep"), rs.getString("endereco_loja.logradouro"),
                        rs.getString("endereco_loja.numero"), rs.getString("endereco_loja.complemento"),
                        rs.getString("endereco_loja.bairro"), rs.getString("endereco_loja.cidade"),
                        rs.getString("endereco_loja.estado"), rs.getString("endereco_loja.pais"));
                Categoria categoria = new Categoria(rs.getInt("categoria.id"), rs.getString("categoria.nome"));
                Loja loja = new Loja(rs.getLong("loja.id"), rs.getString("loja.nome"),
                        rs.getString("loja.cnpj"), rs.getString("loja.descricao"), rs.getString("loja.imagem"),
                        enderecoLoja, conta, contato, categoria);
                Promocao promocao = new Promocao(rs.getInt("id"), rs.getString("nome"), rs.getString("desconto"), rs.getString("tipo"));
                promocoes.add(promocao);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return promocoes;

    }

    public ArrayList<Promocao> getAllByLoja(long lojaId) throws ClassNotFoundException, SQLException {
        ArrayList<Promocao> promocoes = new ArrayList<Promocao>();
        Connection conn = null;
        Statement st = null;
        String query = "SELECT promocao.*, loja.*, conta.*, contato.*, endereco_loja.*, categoria.* FROM promocao "
                + "INNER JOIN loja ON promocao.loja_id = loja.id "
                + "INNER JOIN conta ON loja.conta_id = conta.id "
                + "INNER JOIN contato ON loja.contato_id = contato.id "
                + "INNER JOIN endereco_loja ON loja.endereco_loja_id = endereco_loja.id "
                + "INNER JOIN categoria ON loja.categoria_id = categoria.id "
                + "WHERE promocao.loja_id = " + lojaId + ";";
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Conta conta = new Conta(rs.getLong("conta.id"), rs.getString("conta.login"),
                        rs.getString("conta.senha"), rs.getString("conta.tipo"));
                Contato contato = new Contato(rs.getLong("contato.id"), rs.getString("contato.telefone"),
                        rs.getString("contato.ddd"), rs.getString("contato.email"), rs.getString("contato.telefone_complementar"));
                Endereco enderecoLoja = new Endereco(rs.getLong("endereco_loja.id"), rs.getString("cep"), rs.getString("endereco_loja.logradouro"),
                        rs.getString("endereco_loja.numero"), rs.getString("endereco_loja.complemento"),
                        rs.getString("endereco_loja.bairro"), rs.getString("endereco_loja.cidade"),
                        rs.getString("endereco_loja.estado"), rs.getString("endereco_loja.pais"));
                Categoria categoria = new Categoria(rs.getInt("categoria.id"), rs.getString("categoria.nome"));
                Loja loja = new Loja(rs.getLong("loja.id"), rs.getString("loja.nome"),
                        rs.getString("loja.cnpj"), rs.getString("loja.descricao"), rs.getString("loja.imagem"),
                        enderecoLoja, conta, contato, categoria);
                Promocao promocao = new Promocao(rs.getInt("id"), rs.getString("nome"), rs.getString("desconto"), rs.getString("tipo"));
                promocoes.add(promocao);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return promocoes;

    }

    public void update(Promocao promocao) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE promocao SET nome = '" + promocao.getNome() + "', desconto = '" + promocao.getDesconto()
                    + "', tipo = '" + promocao.getTipo() + "' WHERE id = " + promocao.getId() + ";");

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
            st.executeUpdate("DELETE FROM promocao WHERE id = " + id + ";");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Promocao promocao) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO promocao (nome, desconto, tipo) "
                    + "VALUES ('" + promocao.getNome() + "', "
                    + "'" + promocao.getDesconto() + "', "
                    + "'" + promocao.getTipo() + "');");

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
