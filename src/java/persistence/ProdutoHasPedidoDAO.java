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
import model.pedido.Pedido;
import model.pedido.PedidoEstado;
import model.Consumidor;
import model.conta.Conta;
import model.Contato;
import model.Loja;
import model.ProdutoHasPedido;
import model.Produto;
import model.MainFactory;

/**
 *
 * @author Gabriel
 */
public class ProdutoHasPedidoDAO {

    private static ProdutoHasPedidoDAO instance = new ProdutoHasPedidoDAO();

    public static ProdutoHasPedidoDAO getInstance() {
        return instance;
    }

    private ProdutoHasPedidoDAO() {
    }

    public ProdutoHasPedido get(long id) {
        ProdutoHasPedido produtoHasPedido = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT produto_has_pedido.*, pedido.*, produto.*, consumidor.*, contato.*, conta.*  "
                    + "FROM produto_has_pedido "
                    + "INNER JOIN pedido ON produto_has_pedido.pedido_id = pedido.id "
                    + "INNER JOIN produto ON produto_has_pedido.produto_id = produto.id "
                    + "INNER JOIN consumidor ON pedido.consumidor_id = consumidor.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                    + "WHERE id = " + id + ";");
            rs.first();
            Contato contato = new Contato();
            contato.setId((rs.getLong("contato.id"))).setTelefone(rs.getString("contato.telefone")).setDdd(rs.getString("contato.ddd"))
                    .setEmail((rs.getString("contato.email"))).setTelefoneComplementar(rs.getString("contato.telefone_complementar"));
            Conta conta = new Conta();
            conta.setId(rs.getLong("conta.id")).setLogin(rs.getString("conta.login"))
                    .setSenha(rs.getString("conta.senha")).setTipo(rs.getString("conta.tipo"));
            Consumidor consumidor = new Consumidor();
            consumidor.setId(rs.getLong("consumidor.id")).setNome(rs.getString("consumidor.nome"))
                    .setCpf(rs.getString("consumidor.cpf")).setNascimento(rs.getString("consumidor.nascimento")).setContato(contato).setConta(conta);
            Loja loja = LojaDAO.getInstance().get(rs.getLong("produto.loja_id"));

            Produto produto = new Produto();
            produto.setId((rs.getLong("produto.id"))).setNome(rs.getString("produto.nome"))
                    .setPreco(rs.getString("produto.preco")).setDisponivel(rs.getString("produto.disponivel"))
                    .setDescricao(rs.getString("produto.descricao")).setImagem(rs.getString("produto.imagem")).setLoja(loja);
            Pedido pedido = new Pedido();
            pedido.setId((rs.getLong("pedido.id"))).setValor(rs.getString("pedido.valor"))
                    .setEstado((PedidoEstado) MainFactory.getObject(PedidoEstado.class.getName() + rs.getString("pedido.estado"))).setConsumidor(consumidor);
            produtoHasPedido = new ProdutoHasPedido();
            produtoHasPedido.setId(rs.getLong("produto_has_pedido.id")).setProduto(produto).setCarrinho(pedido);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProdutoHasPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtoHasPedido;
    }

    public ArrayList<ProdutoHasPedido> getAll() {
        ArrayList<ProdutoHasPedido> produtoHasPedidos = new ArrayList();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT produto_has_pedido.*, pedido.*, produto.*, consumidor.*, contato.*, conta.*  "
                    + "FROM produto_has_pedido "
                    + "INNER JOIN pedido ON produto_has_pedido.pedido_id = pedido.id "
                    + "INNER JOIN produto ON produto_has_pedido.produto_id = produto.id "
                    + "INNER JOIN consumidor ON pedido.consumidor_id = consumidor.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id;");
            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId((rs.getLong("contato.id"))).setTelefone(rs.getString("contato.telefone")).setDdd(rs.getString("contato.ddd"))
                        .setEmail((rs.getString("contato.email"))).setTelefoneComplementar(rs.getString("contato.telefone_complementar"));
                Conta conta = new Conta();
                conta.setId(rs.getLong("conta.id")).setLogin(rs.getString("conta.login"))
                        .setSenha(rs.getString("conta.senha")).setTipo(rs.getString("conta.tipo"));
                Consumidor consumidor = new Consumidor();
                consumidor.setId(rs.getLong("consumidor.id")).setNome(rs.getString("consumidor.nome"))
                        .setCpf(rs.getString("consumidor.cpf")).setNascimento(rs.getString("consumidor.nascimento")).setContato(contato).setConta(conta);
                Loja loja = LojaDAO.getInstance().get(rs.getLong("produto.loja_id"));

                Produto produto = new Produto();
                produto.setId((rs.getLong("produto.id"))).setNome(rs.getString("produto.nome"))
                        .setPreco(rs.getString("produto.preco")).setDisponivel(rs.getString("produto.disponivel"))
                        .setDescricao(rs.getString("produto.descricao")).setImagem(rs.getString("produto.imagem")).setLoja(loja);
                Pedido pedido = new Pedido();
                pedido.setId((rs.getLong("pedido.id"))).setValor(rs.getString("pedido.valor"))
                        .setEstado((PedidoEstado) MainFactory.getObject(PedidoEstado.class.getName() + rs.getString("pedido.estado"))).setConsumidor(consumidor);
                ProdutoHasPedido produtoHasPedido = new ProdutoHasPedido();
                produtoHasPedido.setId(rs.getLong("produto_has_pedido.id")).setProduto(produto).setCarrinho(pedido);
                produtoHasPedidos.add(produtoHasPedido);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProdutoHasPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtoHasPedidos;
    }

    public void update(ProdutoHasPedido produtoHasPedido) {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE produto SET produto_id = " + produtoHasPedido.getProduto().getId() + ", "
                    + "pedido_id = " + produtoHasPedido.getCarrinho().getId() + ""
                    + "WHERE id = " + produtoHasPedido.getId() + ";");

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
            st.executeUpdate("DELETE FROM produto_has_pedido WHERE id = " + id + "");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LojaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(ProdutoHasPedido produtoHasPedido) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO produto_has_pedido (produto_id, pedido_id) "
                    + "VALUES (" + produtoHasPedido.getProduto().getId() + ", "
                    + "" + produtoHasPedido.getCarrinho().getId() + ""
                    + ");");
        } catch (SQLException e) {
            System.out.println(e);;
        } finally {
            closeResources(conn, st);
        }

    }

    public ArrayList<ProdutoHasPedido> getByCarrinho(long id) {
        ProdutoHasPedido produtoHasPedido = null;
        Connection conn = null;
        Statement st = null;
        ArrayList<ProdutoHasPedido> produtoHasPedidos = new ArrayList<>();

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT produto_has_pedido.*, pedido.*, produto.*, consumidor.*, contato.*, conta.*, promocao.* "
                    + "FROM produto_has_pedido "
                    + "INNER JOIN pedido ON produto_has_pedido.pedido_id = pedido.id "
                    + "INNER JOIN produto ON produto_has_pedido.produto_id = produto.id "
                    + "INNER JOIN consumidor ON pedido.consumidor_id = consumidor.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                    + "INNER JOIN promocao ON produto.promocao_id = promocao.id "
                    + "WHERE produto_has_pedido.pedido_id = " + id + ";");
            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId((rs.getLong("contato.id"))).setTelefone(rs.getString("contato.telefone")).setDdd(rs.getString("contato.ddd"))
                        .setEmail((rs.getString("contato.email"))).setTelefoneComplementar(rs.getString("contato.telefone_complementar"));
                Conta conta = new Conta();
                conta.setId(rs.getLong("conta.id")).setLogin(rs.getString("conta.login"))
                        .setSenha(rs.getString("conta.senha")).setTipo(rs.getString("conta.tipo"));
                Consumidor consumidor = new Consumidor();
                consumidor.setId(rs.getLong("consumidor.id")).setNome(rs.getString("consumidor.nome"))
                        .setCpf(rs.getString("consumidor.cpf")).setNascimento(rs.getString("consumidor.nascimento")).setContato(contato).setConta(conta);
                Loja loja = LojaDAO.getInstance().get(rs.getLong("produto.loja_id"));
                Produto produto = new Produto();
                produto.setId((rs.getLong("produto.id"))).setNome(rs.getString("produto.nome"))
                        .setPreco(rs.getString("produto.preco")).setDisponivel(rs.getString("produto.disponivel"))
                        .setDescricao(rs.getString("produto.descricao")).setImagem(rs.getString("produto.imagem")).setLoja(loja)
                        .setPromocao(PromocaoDAO.getInstance().getPromocao(Integer.parseInt(rs.getString("promocao.id"))));
                Pedido pedido = new Pedido();
                pedido.setId((rs.getLong("pedido.id"))).setValor(rs.getString("pedido.valor"))
                        .setEstado((PedidoEstado) MainFactory.getObject(PedidoEstado.class.getName() + rs.getString("pedido.estado"))).setConsumidor(consumidor);
                produtoHasPedido = new ProdutoHasPedido();
                produtoHasPedido.setId(rs.getLong("produto_has_pedido.id")).setProduto(produto).setCarrinho(pedido);
                produtoHasPedidos.add(produtoHasPedido);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProdutoHasPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtoHasPedidos;
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
