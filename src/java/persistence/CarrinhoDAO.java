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
import model.Entrega;
import model.Loja;
import model.StateFactory;

/**
 *
 * @author Gabriel
 */
public class CarrinhoDAO {

    private static CarrinhoDAO instance = new CarrinhoDAO();

    public static CarrinhoDAO getInstance() {
        return instance;
    }

    private CarrinhoDAO() {
    }

    public Carrinho get(long id) {
        Carrinho carrinho = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT carrinho.*, consumidor.*, contato.*, conta.* "
                    + "FROM carrinho "
                    + "INNER JOIN consumidor ON carrinho.consumidor_id = consumidor.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                    + "WHERE carrinho.id = " + id + ";");
            rs.first();
            Contato contato = new Contato();
            contato = contato.setId((rs.getLong("contato.id"))).setTelefone(rs.getString("contato.telefone")).setDdd(rs.getString("contato.ddd"))
                    .setEmail((rs.getString("contato.email"))).setTelefoneComplementar(rs.getString("contato.telefone_complementar"));
            Conta conta = new Conta();
            conta = conta.setId(rs.getLong("conta.id")).setLogin(rs.getString("conta.login"))
                    .setSenha(rs.getString("conta.senha")).setTipo(rs.getString("conta.tipo"));
            Consumidor consumidor = new Consumidor();
            consumidor = consumidor.setId(rs.getLong("consumidor.id")).setNome(rs.getString("consumidor.nome"))
                    .setCpf(rs.getString("consumidor.cpf")).setNascimento(rs.getString("consumidor.nascimento")).setContato(contato).setConta(conta);
            carrinho = new Carrinho();
            carrinho = carrinho.setId((rs.getLong("carrinho.id"))).setValor(rs.getString("carrinho.valor")).setData(rs.getString("carrinho.data"))
                    .setHora(rs.getString("carrinho.hora")).setPagamento(rs.getString("carrinho.pagamento"))
                    .setEstado(StateFactory.createCarrinhoEstado(rs.getString("carrinho.estado"))).setConsumidor(consumidor);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CarrinhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return carrinho;
    }

    public ArrayList<Carrinho> getAll() {
        ArrayList<Carrinho> carrinhos = new ArrayList<Carrinho>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT carrinho.*, consumidor.*, contato.*, conta.* "
                    + "FROM carrinho "
                    + "INNER JOIN consumidor ON carrinho.consumidor_id = consumidor.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id;");
            while (rs.next()) {
                Contato contato = new Contato();
                contato = contato.setId((rs.getLong("contato.id"))).setTelefone(rs.getString("contato.telefone")).setDdd(rs.getString("contato.ddd"))
                        .setEmail((rs.getString("contato.email"))).setTelefoneComplementar(rs.getString("contato.telefone_complementar"));
                Conta conta = new Conta();
                conta = conta.setId(rs.getLong("conta.id")).setLogin(rs.getString("conta.login"))
                        .setSenha(rs.getString("conta.senha")).setTipo(rs.getString("conta.tipo"));
                Consumidor consumidor = new Consumidor();
                consumidor = consumidor.setId(rs.getLong("consumidor.id")).setNome(rs.getString("consumidor.nome"))
                        .setCpf(rs.getString("consumidor.cpf")).setNascimento(rs.getString("consumidor.nascimento")).setContato(contato).setConta(conta);
                Carrinho carrinho = new Carrinho();
                carrinho = carrinho.setId((rs.getLong("carrinho.id"))).setValor(rs.getString("carrinho.valor")).setData(rs.getString("carrinho.data"))
                        .setHora(rs.getString("carrinho.hora")).setPagamento(rs.getString("carrinho.pagamento"))
                        .setEstado(StateFactory.createCarrinhoEstado(rs.getString("carrinho.estado"))).setConsumidor(consumidor);
                carrinhos.add(carrinho);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CarrinhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return carrinhos;
    }

    public ArrayList<Carrinho> getAllByLoja(long idLoja) {
        ArrayList<Carrinho> carrinhos = new ArrayList();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT carrinho.*, entrega.*, carrinho.* "
                    + "FROM carrinho "
                    + "INNER JOIN carrinho ON entrega.carrinho_id = carrinho.id "
                    + "INNER JOIN loja ON entrega.loja_id = loja.id "
                    + "WHERE loja.id = '" + idLoja + "';");
            while (rs.next()) {
                Loja loja = LojaDAO.getInstance().get(rs.getLong("produto.loja_id"));

                Carrinho carrinho = new Carrinho();
                carrinho = carrinho.setId(rs.getLong("carrinho.id")).setValor(rs.getString("carrinho.valor")).setData(rs.getString("carrinho.data"))
                        .setHora(rs.getString("carrinho.hora")).setPagamento(rs.getString("carrinho.pagamento"))
                        .setEstado(StateFactory.createCarrinhoEstado(rs.getString("carrinho.estado")));

                Entrega entrega = new Entrega();
                entrega = entrega.setId((rs.getLong("entrega.id"))).setEstado(StateFactory.createEntregaEstado(rs.getString("entrega.estado")))
                        .setLoja(loja).setCarrinho(carrinho);

                carrinhos.add(carrinho);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return carrinhos;
    }

    public void update(Carrinho carrinho) {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE carrinho SET consumidor_id= " + carrinho.getConsumidor().getId() + ", "
                    + "valor = '" + carrinho.getValor() + "', "
                    + "data = '" + carrinho.getData() + "', "
                    + "hora = '" + carrinho.getHora() + "', "
                    + "pagamento = '" + carrinho.getPagamento() + "', "
                    + "estado = '" + carrinho.getEstado().toString() + "' "
                    + "WHERE id = " + carrinho.getId() + ";");

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
            st.executeUpdate("DELETE FROM carrinho WHERE id = " + id + "");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LojaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Carrinho carrinho) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO loja (consumidor_id, valor, data, hora, pagamento, estado) "
                    + "VALUES (" + carrinho.getConsumidor().getId() + ", "
                    + "" + carrinho.getValor() + ", "
                    + "'" + carrinho.getData() + "', "
                    + "'" + carrinho.getHora() + "', "
                    + "'" + carrinho.getPagamento() + "', "
                    + "'" + carrinho.getEstado().toString() + "', "
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
