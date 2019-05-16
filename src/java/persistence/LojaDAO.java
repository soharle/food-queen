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
import model.categoria.Categoria;
import model.conta.Conta;
import model.Contato;
import model.Endereco;
import model.Loja;
import model.MainFactory;

/**
 *
 * @author Gabriel
 */
public class LojaDAO {

    private static LojaDAO instance = new LojaDAO();

    public static LojaDAO getInstance() {
        return instance;
    }

    private LojaDAO() {
    }

    public Loja get(long id) throws SQLException, ClassNotFoundException {
        Loja loja = null;
        Connection conn = null;
        Statement st = null;

        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT loja.*, conta.*, contato.*, endereco.*, categoria.* "
                    + "FROM loja "
                    + "LEFT JOIN conta ON loja.conta_id = conta.id "
                    + "LEFT JOIN contato ON loja.contato_id = contato.id "
                    + "LEFT JOIN endereco ON loja.endereco_id = endereco.id "
                    + "LEFT JOIN categoria ON loja.categoria_id = categoria.id "
                    + "WHERE loja.id =" + id + "");
            rs.first();
            Contato contatoLoja = new Contato();
            contatoLoja.setId((rs.getLong("contato.id"))).setTelefone(rs.getString("contato.telefone")).setDdd(rs.getString("contato.ddd"))
                    .setEmail((rs.getString("contato.email"))).setTelefoneComplementar(rs.getString("contato.telefone_complementar"));
            Conta contaLoja = new Conta();
            contaLoja.setId(rs.getLong("conta.id")).setLogin(rs.getString("conta.login"))
                    .setSenha(rs.getString("conta.senha")).setTipo(rs.getString("conta.tipo"));
            Endereco enderecoLoja = new Endereco();
            enderecoLoja.setId(rs.getInt("endereco.id")).setCep(rs.getString("endereco.cep")).setLogradouro(rs.getString("endereco.logradouro")).setNumero(rs.getString("endereco.numero"))
                    .setComplemento(rs.getString("endereco.complemento")).setBairro(rs.getString("endereco.bairro")).setCidade(rs.getString("endereco.cidade"))
                    .setEstado(rs.getString("endereco.estado")).setPais(rs.getString("endereco.pais"));
            Categoria categoria = (Categoria) MainFactory.getObject(Categoria.class.getName() + rs.getString("categoria.nome"));
            categoria.setId(rs.getInt("categoria.id"));
            loja = new Loja();
            loja = loja.setId(rs.getLong("loja.id")).setNome(rs.getString("loja.nome")).setCnpj(rs.getString("loja.cnpj"))
                    .setDescricao(rs.getString("loja.descricao")).setImagem(rs.getString("loja.imagem"))
                    .setEndereco(enderecoLoja).setConta(contaLoja).setContato(contatoLoja).setCategoria(categoria);

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
            String query = "SELECT loja.*, conta.*, contato.*, endereco.*, categoria.* "
                    + "FROM loja "
                    + "LEFT JOIN conta ON loja.conta_id = conta.id "
                    + "LEFT JOIN contato ON loja.contato_id = contato.id "
                    + "LEFT JOIN endereco ON loja.endereco_id = endereco.id "
                    + "LEFT JOIN categoria ON loja.categoria_id = categoria.id "
                    + "WHERE loja.conta_id =" + contaId + "";
            ResultSet rs = st.executeQuery(query);
            rs.first();
            Contato contatoLoja = new Contato();
            contatoLoja.setId((rs.getLong("contato.id"))).setTelefone(rs.getString("contato.telefone")).setDdd(rs.getString("contato.ddd"))
                    .setEmail((rs.getString("contato.email"))).setTelefoneComplementar(rs.getString("contato.telefone_complementar"));
            Conta contaLoja = new Conta();
            contaLoja.setId(rs.getLong("conta.id")).setLogin(rs.getString("conta.login"))
                    .setSenha(rs.getString("conta.senha")).setTipo(rs.getString("conta.tipo"));
            Endereco enderecoLoja = new Endereco();
            enderecoLoja.setId(rs.getInt("endereco.id")).setCep(rs.getString("endereco.cep")).setLogradouro(rs.getString("endereco.logradouro")).setNumero(rs.getString("endereco.numero"))
                    .setComplemento(rs.getString("endereco.complemento")).setBairro(rs.getString("endereco.bairro")).setCidade(rs.getString("endereco.cidade"))
                    .setEstado(rs.getString("endereco.estado")).setPais(rs.getString("endereco.pais"));
            Categoria categoria = (Categoria) MainFactory.getObject(Categoria.class.getName() + rs.getString("categoria.nome"));
            categoria.setId(rs.getInt("categoria.id"));
            loja = new Loja();
            loja = loja.setId(rs.getLong("loja.id")).setNome(rs.getString("loja.nome")).setCnpj(rs.getString("loja.cnpj"))
                    .setDescricao(rs.getString("loja.descricao")).setImagem(rs.getString("loja.imagem"))
                    .setEndereco(enderecoLoja).setConta(contaLoja).setContato(contatoLoja).setCategoria(categoria);
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
            ResultSet rs = st.executeQuery("SELECT loja.*, conta.*, contato.*, endereco.*, categoria.* "
                    + "FROM loja "
                    + "INNER JOIN conta ON loja.conta_id = conta.id "
                    + "INNER JOIN contato ON loja.contato_id = contato.id "
                    + "INNER JOIN endereco ON loja.endereco_id = endereco.id "
                    + "INNER JOIN categoria ON loja.categoria_id = categoria.id;");
            while (rs.next()) {
                Contato contatoLoja = new Contato();
                contatoLoja.setId((rs.getLong("contato.id"))).setTelefone(rs.getString("contato.telefone")).setDdd(rs.getString("contato.ddd"))
                        .setEmail((rs.getString("contato.email"))).setTelefoneComplementar(rs.getString("contato.telefone_complementar"));
                Conta contaLoja = new Conta();
                contaLoja.setId(rs.getLong("conta.id")).setLogin(rs.getString("conta.login"))
                        .setSenha(rs.getString("conta.senha")).setTipo(rs.getString("conta.tipo"));
                Endereco enderecoLoja = new Endereco();
                enderecoLoja.setId(rs.getInt("endereco.id")).setCep(rs.getString("endereco.cep")).setLogradouro(rs.getString("endereco.logradouro")).setNumero(rs.getString("endereco.numero"))
                        .setComplemento(rs.getString("endereco.complemento")).setBairro(rs.getString("endereco.bairro")).setCidade(rs.getString("endereco.cidade"))
                        .setEstado(rs.getString("endereco.estado")).setPais(rs.getString("endereco.pais"));
                Categoria categoria = (Categoria) MainFactory.getObject(Categoria.class.getName() + rs.getString("categoria.nome"));
                categoria.setId(rs.getInt("categoria.id"));
                Loja loja = new Loja();
                loja = loja.setId(rs.getLong("loja.id")).setNome(rs.getString("loja.nome")).setCnpj(rs.getString("loja.cnpj"))
                        .setDescricao(rs.getString("loja.descricao")).setImagem(rs.getString("loja.imagem"))
                        .setEndereco(enderecoLoja).setConta(contaLoja).setContato(contatoLoja).setCategoria(categoria);
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
            String query = "UPDATE loja SET endereco_id = " + loja.getEndereco().getId() + ", "
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

    public Loja save(Loja loja) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        long key = -1l;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO loja (endereco_id, conta_id, nome, cnpj, descricao, imagem, contato_id, categoria_id) "
                    + "VALUES (" + loja.getEndereco().getId() + ", "
                    + "" + loja.getConta().getId() + ", "
                    + "'" + loja.getNome() + "', "
                    + "'" + loja.getCnpj() + "', "
                    + "'" + loja.getDescricao() + "', "
                    + "'" + loja.getImagem() + "', "
                    + "" + loja.getContato().getId() + ", "
                    + "" + loja.getCategoria().getId() + ""
                    + ");", Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            if (rs != null && rs.next()) {
                key = rs.getLong(1);
            }
            loja.setId(key);
        } catch (SQLException e) {
            System.out.println(e);;
        } finally {
            closeResources(conn, st);
            return loja;
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
