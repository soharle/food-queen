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
import model.Combo;
import model.Loja;
import model.Produto;
import model.promocao.Promocao;

/**
 *
 * @author Gabriel
 */
public class ComboHasProdutoDAO {
    private static ComboHasProdutoDAO instance = new ComboHasProdutoDAO();
    
    public static ComboHasProdutoDAO getInstance(){
        return instance;
    }
    
    public ComboHasProdutoDAO() {
    }
    
    public Combo getComboByProduto(long produtoId) throws ClassNotFoundException, SQLException {
        Combo combo = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT combo.* FROM combo_has_produto "
                    + "INNER JOIN combo ON combo_has_produto.combo_id = combo.id"
                    + "WHERE combo_has_produto.produto_id =" + produtoId + "");
             while (rs.next()) {
                combo = new Combo().setId(rs.getInt("id")).setNome(rs.getString("nome")).setPreco(rs.getDouble("preco"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return combo;

    }
    
    public ArrayList<Produto> getProdutosByCombo(long comboId) throws ClassNotFoundException, SQLException {
        ArrayList<Produto> produtos = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT produto.* FROM combo_has_produto "
                    + "INNER JOIN produto ON combo_has_produto.produto_id = produto.id"
                    + "WHERE combo_has_produto.combo_id =" + comboId + "");
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
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return produtos;

    }

    public void update(Combo combo) throws ClassNotFoundException, SQLException {

        //não faz sentido
    }

    public void delete(long comboId, long produtoId) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.executeUpdate("DELETE FROM combo_has_produto WHERE combo_id = " + comboId + " AND produto_id = " + produtoId + ";");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public Combo save(Combo combo) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        long key = -1l;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String query = "INSERT INTO combo_has_produto (combo_id, produto_id)" + " VALUES ";
            for(Produto produto : combo.getProdutos()){
                query = " ('" + combo.getNome() + "', " + combo.getPreco() +"),";
            }
            query += "*";
            query.replace(",*", ";");
            
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
            if (st.getGeneratedKeys().next()) {
                key = st.getGeneratedKeys().getLong(1);
            }
            combo.setId(key);

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
            return combo;
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
