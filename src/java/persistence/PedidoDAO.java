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
import model.Carrinho;
import model.Consumidor;
import model.Conta;
import model.Contato;
import model.Loja;
import model.Pedido;
import model.Produto;
import model.Promocao;
import model.StateFactory;

/**
 *
 * @author Gabriel
 */
public class PedidoDAO {

    private static PedidoDAO instance = new PedidoDAO();

    public static PedidoDAO getInstance() {
        return instance;
    }

    private PedidoDAO() {
    }

    public Pedido get(long id) {
        Pedido pedido = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT pedido.*, carrinho.*, produto.*, consumidor.*, contato.*, conta.*  "
                    + "FROM pedido "
                    + "INNER JOIN carrinho ON pedido.carrinho_id = carrinho.id "
                    + "INNER JOIN produto ON pedido.produto_id = produto.id "
                    + "INNER JOIN consumidor ON carrinho.consumidor_id = consumidor.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                    + "WHERE id = " + id + ";");
            rs.first();
            Contato contato = new Contato(rs.getLong("contato.id"), rs.getString("contato.telefone"),
                    rs.getString("contato.ddd"), rs.getString("contato.email"), rs.getString("contato.telefone_complementar"));
            Conta conta = new Conta(rs.getLong("conta.id"), rs.getString("conta.login"),
                    rs.getString("conta.senha"), rs.getString("conta.tipo"));
            Consumidor consumidor = new Consumidor(rs.getLong("consumidor.id"), rs.getString("consumidor.nome"),
                    rs.getString("consumidor.cpf"), rs.getString("consumidor.nascimento"), contato, conta);
            Loja loja = LojaDAO.getInstance().get(rs.getLong("produto.loja_id"));
            Promocao promocao = new Promocao(rs.getLong("promocao.id"), rs.getString("promocao.nome"),
                    rs.getString("promocao.desconto"), rs.getString("promocao.tipo"), loja);
            Produto produto = new Produto(rs.getLong("produto.id"), rs.getString("produto.nome"),
                    rs.getString("produto.preco"), rs.getString("produto.disponivel"),
                    rs.getString("produto.descricao"), rs.getString("produto.imagem"), loja, promocao);
            Carrinho carrinho = new Carrinho(rs.getLong("carrinho.id"), rs.getString("carrinho.valor"),
                    rs.getString("carrinho.data"), rs.getString("carrinho.hora"), rs.getString("carrinho.pagamento"),
                    StateFactory.createCarrinhoEstado(rs.getString("carrinho.estado")), consumidor);
            pedido = new Pedido(rs.getLong("pedido.id"), rs.getString("pedido.observacao"), produto, carrinho);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedido;
    }
    

    public ArrayList<Pedido> getAll() {
        ArrayList<Pedido> pedidos = new ArrayList();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT pedido.*, carrinho.*, produto.*, consumidor.*, contato.*, conta.*  "
                    + "FROM pedido "
                    + "INNER JOIN carrinho ON pedido.carrinho_id = carrinho.id "
                    + "INNER JOIN produto ON pedido.produto_id = produto.id "
                    + "INNER JOIN consumidor ON carrinho.consumidor_id = consumidor.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id;");
            while (rs.next()) {
                Contato contato = new Contato(rs.getLong("contato.id"), rs.getString("contato.telefone"),
                        rs.getString("contato.ddd"), rs.getString("contato.email"), rs.getString("contato.telefone_complementar"));
                Conta conta = new Conta(rs.getLong("conta.id"), rs.getString("conta.login"),
                        rs.getString("conta.senha"), rs.getString("conta.tipo"));
                Consumidor consumidor = new Consumidor(rs.getLong("consumidor.id"), rs.getString("consumidor.nome"),
                        rs.getString("consumidor.cpf"), rs.getString("consumidor.nascimento"), contato, conta);
                Loja loja = LojaDAO.getInstance().get(rs.getLong("produto.loja_id"));
                Promocao promocao = new Promocao(rs.getLong("promocao.id"), rs.getString("promocao.nome"),
                        rs.getString("promocao.desconto"), rs.getString("promocao.tipo"), loja);
                Produto produto = new Produto(rs.getLong("produto.id"), rs.getString("produto.nome"),
                        rs.getString("produto.preco"), rs.getString("produto.disponivel"),
                        rs.getString("produto.descricao"), rs.getString("produto.imagem"), loja, promocao);
                Carrinho carrinho = new Carrinho(rs.getLong("carrinho.id"), rs.getString("carrinho.valor"),
                        rs.getString("carrinho.data"), rs.getString("carrinho.hora"), rs.getString("carrinho.pagamento"),
                        StateFactory.createCarrinhoEstado(rs.getString("carrinho.estado")), consumidor);
                Pedido pedido = new Pedido(rs.getLong("pedido.id"), rs.getString("pedido.observacao"), produto, carrinho);
                pedidos.add(pedido);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedidos;
    }

    public void update(Pedido pedido) {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE produto SET produto_id = " + pedido.getProduto().getId() + ", "
                    + "carrinho_id = " + pedido.getCarrinho().getId() + ", "
                    + "observacao = '" + pedido.getObservacao() + "' "
                    + "WHERE id = " + pedido.getId() + ";");

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
            st.executeUpdate("DELETE FROM pedido WHERE id = " + id + "");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LojaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Pedido pedido) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO pedido (produto_id, carrinho_id, observacao) "
                    + "VALUES (" + pedido.getProduto().getId() + ", "
                    + "" + pedido.getCarrinho().getId() + ", "
                    + "'" + pedido.getObservacao() + "'"
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
