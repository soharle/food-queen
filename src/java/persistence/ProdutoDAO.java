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
import model.Loja;
import model.Produto;
import model.promocao.Promocao;
import model.MainFactory;

/**
 *
 * @author Gabriel
 */
public class ProdutoDAO {

    private static ProdutoDAO instance = new ProdutoDAO();

    public static ProdutoDAO getInstance() {
        return instance;
    }

    private ProdutoDAO() {
    }

    public Produto get(long id) {
        Produto produto = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from produto "
                    + "WHERE produto.id = " + id + ";");
            rs.first();
            Loja loja = LojaDAO.getInstance().get(rs.getLong("produto.loja_id"));
            Promocao promocao = PromocaoDAO.getInstance().getPromocao(rs.getInt("produto.promocao_id"));
            produto = new Produto();
            produto.setId((rs.getLong("produto.id"))).setNome(rs.getString("produto.nome"))
                    .setPreco(rs.getString("produto.preco")).setDisponivel(rs.getString("produto.disponivel"))
                    .setDescricao(rs.getString("produto.descricao")).setImagem(rs.getString("produto.imagem")).setLoja(loja);
            produto.setPromocao((Promocao) MainFactory.getObject( Promocao.class.getName() + promocao.getNome()));
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return produto;
    }

    public ArrayList<Produto> getAll() {
        ArrayList<Produto> produtos = new ArrayList();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from produto;");
            while (rs.next()) {
                Loja loja = LojaDAO.getInstance().get(rs.getLong("produto.loja_id"));
                Promocao promocao = PromocaoDAO.getInstance().getPromocao(rs.getInt("produto.promocao_id"));

                Produto produto = new Produto();
                produto.setId((rs.getLong("produto.id"))).setNome(rs.getString("produto.nome"))
                        .setPreco(rs.getString("produto.preco")).setDisponivel(rs.getString("produto.disponivel"))
                        .setDescricao(rs.getString("produto.descricao")).setImagem(rs.getString("produto.imagem")).setLoja(loja);
                produto.setPromocao(promocao);
                produtos.add(produto);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return produtos;
    }

    public ArrayList<Produto> getAllByLoja(long idLoja) {
        ArrayList<Produto> produtos = new ArrayList();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT produto.*, loja.* "
                    + "FROM produto "
                    + "INNER JOIN loja ON produto.loja_id = loja.id "
                    + "WHERE produto.loja_id = '" + idLoja + "';");
            while (rs.next()) {
                Loja loja = LojaDAO.getInstance().get(rs.getLong("produto.loja_id"));
                Promocao promocao = PromocaoDAO.getInstance().getPromocao(rs.getInt("produto.promocao_id"));

                Produto produto = new Produto();
                produto.setId((rs.getLong("produto.id"))).setNome(rs.getString("produto.nome"))
                        .setPreco(rs.getString("produto.preco")).setDisponivel(rs.getString("produto.disponivel"))
                        .setDescricao(rs.getString("produto.descricao")).setImagem(rs.getString("produto.imagem")).setLoja(loja);
                produto.setPromocao(promocao);
                produtos.add(produto);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return produtos;
    }

    public void update(Produto produto) {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE produto SET loja_id = " + produto.getLoja().getId() + ", "
                    + "nome = '" + produto.getNome() + "', "
                    + "preco = '" + produto.getPreco() + "', "
                    + "disponivel = '" + produto.getDisponivel() + "', "
                    + "descricao = '" + produto.getDescricao() + "', "
                    + "imagem = '" + produto.getImagem() + "', "
                    + "promocao_id = " + produto.getPromocao().getId() + " "
                    + "WHERE id = " + produto.getId() + ";");

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
            st.executeUpdate("DELETE FROM produto WHERE id = " + id + "");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LojaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Produto produto) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String query = "INSERT INTO produto (loja_id, nome, preco, disponivel, descricao, imagem, promocao_id) "
                    + "VALUES (" + produto.getLoja().getId() + ", "
                    + "'" + produto.getNome() + "', "
                    + "'" + produto.getPreco() + "', "
                    + "'" + produto.getDisponivel() + "', "
                    + "'" + produto.getDescricao() + "', "
                    + "'" + produto.getImagem() + "', "
                    + "" + produto.getPromocao().getId() + " "
                    + ");";
            st.execute(query);
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
