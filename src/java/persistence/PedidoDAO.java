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
            Carrinho carrinho = new Carrinho();
            carrinho.setId((rs.getLong("carrinho.id"))).setValor(rs.getString("carrinho.valor")).setData(rs.getString("carrinho.data"))
                    .setHora(rs.getString("carrinho.hora")).setPagamento(rs.getString("carrinho.pagamento"))
                    .setEstado(StateFactory.createCarrinhoEstado(rs.getString("carrinho.estado"))).setConsumidor(consumidor);
            pedido = new Pedido();
            pedido.setId(rs.getLong("pedido.id")).setObservacao(rs.getString("pedido.observacao")).setProduto(produto).setCarrinho(carrinho);
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
                Carrinho carrinho = new Carrinho();
                carrinho.setId((rs.getLong("carrinho.id"))).setValor(rs.getString("carrinho.valor")).setData(rs.getString("carrinho.data"))
                        .setHora(rs.getString("carrinho.hora")).setPagamento(rs.getString("carrinho.pagamento"))
                        .setEstado(StateFactory.createCarrinhoEstado(rs.getString("carrinho.estado"))).setConsumidor(consumidor);
                Pedido pedido = new Pedido();
                pedido.setId(rs.getLong("pedido.id")).setObservacao(rs.getString("pedido.observacao")).setProduto(produto).setCarrinho(carrinho);
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

    public ArrayList<Pedido> getByCarrinho(long id) {
        Pedido pedido = null;
        Connection conn = null;
        Statement st = null;
        ArrayList<Pedido> pedidos = new ArrayList<>();

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT pedido.*, carrinho.*, produto.*, consumidor.*, contato.*, conta.*, promocao.* "
                    + "FROM pedido "
                    + "INNER JOIN carrinho ON pedido.carrinho_id = carrinho.id "
                    + "INNER JOIN produto ON pedido.produto_id = produto.id "
                    + "INNER JOIN consumidor ON carrinho.consumidor_id = consumidor.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                    + "INNER JOIN promocao ON produto.promocao_id = promocao.id "
                    + "WHERE pedido.carrinho_id = " + id + ";");
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
                Carrinho carrinho = new Carrinho();
                carrinho.setId((rs.getLong("carrinho.id"))).setValor(rs.getString("carrinho.valor")).setData(rs.getString("carrinho.data"))
                        .setHora(rs.getString("carrinho.hora")).setPagamento(rs.getString("carrinho.pagamento"))
                        .setEstado(StateFactory.createCarrinhoEstado(rs.getString("carrinho.estado"))).setConsumidor(consumidor);
                pedido = new Pedido();
                pedido.setId(rs.getLong("pedido.id")).setObservacao(rs.getString("pedido.observacao")).setProduto(produto).setCarrinho(carrinho);
                pedidos.add(pedido);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedidos;
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
