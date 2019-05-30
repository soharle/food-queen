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
import model.MainFactory;

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
            ResultSet rs = st.executeQuery("SELECT pedido.*, consumidor.*, contato.*, conta.*, loja.* "
                    + "FROM pedido "
                    + "INNER JOIN consumidor ON pedido.consumidor_id = consumidor.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "INNER JOIN loja On pedido.loja_id = loja.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                    + "WHERE pedido.id = " + id + ";");
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
            Loja loja = new Loja();
            loja.setId(rs.getLong("loja.id")).setNome(rs.getString("loja.nome")).setCnpj(rs.getString("loja.cnpj"))
                    .setDescricao(rs.getString("loja.descricao")).setImagem(rs.getString("loja.imagem"));

            pedido = new Pedido();
            pedido.setId((rs.getLong("pedido.id"))).setValor(rs.getString("pedido.valor")).setLoja(loja)
                    .setEstado((PedidoEstado) MainFactory.getObject(PedidoEstado.class.getName() + rs.getString("pedido.estado"))).setConsumidor(consumidor);
            pedido.setProdutosDoPedido(ProdutoHasPedidoDAO.getInstance().getByCarrinho(pedido.getId()));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pedido;
    }

    public ArrayList<Pedido> getAll() {
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT pedido.*, consumidor.*, contato.*, conta.*, loja.* "
                    + "FROM pedido "
                    + "INNER JOIN consumidor ON pedido.consumidor_id = consumidor.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "INNER JOIN loja ON pedido.loja_id = loja.id "
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
                Loja loja = new Loja();
                loja.setId(rs.getLong("loja.id")).setNome(rs.getString("loja.nome")).setCnpj(rs.getString("loja.cnpj"))
                        .setDescricao(rs.getString("loja.descricao")).setImagem(rs.getString("loja.imagem"));
                Pedido pedido = new Pedido();
                pedido.setId((rs.getLong("pedido.id"))).setValor(rs.getString("pedido.valor")).
                        setEstado((PedidoEstado) MainFactory.getObject((PedidoEstado.class.getName() + rs.getString("pedido.estado")))).setConsumidor(consumidor).setLoja(loja);

                pedidos.add(pedido);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pedidos;
    }

    public ArrayList<Pedido> getAllByLoja(long idLoja) {
        ArrayList<Pedido> pedidos = new ArrayList();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT pedido.*, loja.* "
                    + "FROM pedido "
                    + "INNER JOIN loja ON pedido.loja_id = loja.id "
                    + "WHERE pedido.loja_id = '" + idLoja + "';");
            while (rs.next()) {
                Loja loja = LojaDAO.getInstance().get(rs.getLong("produto.loja_id"));

                Pedido pedido = new Pedido();
                pedido = pedido.setId(rs.getLong("pedido.id")).setValor(rs.getString("pedido.valor"))
                        .setEstado((PedidoEstado) MainFactory.getObject(PedidoEstado.class.getName() + rs.getString("pedido.estado")));

                pedidos.add(pedido);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pedidos;
    }
    
    public void update(Pedido pedido) {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE pedido SET consumidor_id= " + pedido.getConsumidor().getId() + ", "
                    + "valor = '" + pedido.getValor() + "', "
                    + "estado = '" + pedido.getEstado().getEstadoNome() + "', "
                    + "loja_id = " + pedido.getLoja().getId() + " "
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

    public Pedido save(Pedido pedido) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        long key = -1;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO pedido (consumidor_id, loja_id, valor, estado) "
                    + "VALUES (" + pedido.getConsumidor().getId() + ", "
                    + "" + pedido.getLoja().getId() + ", "
                    + "" + pedido.getValor() + ", "
                    + "'" + pedido.getEstado().getEstadoNome() + "' "
                    + ");", Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            if (rs != null && rs.next()) {
                key = rs.getLong(1);
            }
            pedido.setId(key);
        } catch (SQLException e) {
            System.out.println(e);;
        } finally {
            closeResources(conn, st);
        }

        return pedido;

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

    public Pedido getByConsumidor(long idConsumidor) {
        Pedido pedido = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT pedido.*, consumidor.*, contato.*, conta.* , loja.*"
                    + "FROM pedido "
                    + "INNER JOIN consumidor ON pedido.consumidor_id = consumidor.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                    + "INNER JOIN loja ON pedido.loja_id = loja.id "
                    + "WHERE pedido.consumidor_id = " + idConsumidor + ";");
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

            Loja loja = new Loja();
            loja.setId(rs.getLong("loja.id")).setNome(rs.getString("loja.nome")).setCnpj(rs.getString("loja.cnpj"))
                    .setDescricao(rs.getString("loja.descricao")).setImagem(rs.getString("loja.imagem"));
            pedido = new Pedido();
            pedido.setId((rs.getLong("pedido.id"))).setValor(rs.getString("pedido.valor"))
                    .setEstado((PedidoEstado) MainFactory.getObject(PedidoEstado.class.getName() + rs.getString("pedido.estado"))).setConsumidor(consumidor).setLoja(loja);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pedido;
    }

    /*não meche aqui, faz parte de um recurso técnico avançado, um estado da arte da gambiarra*/
    public Pedido getByConsumidor(long idConsumidor, String estado) {
        Pedido pedido = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT pedido.*, consumidor.*, contato.*, conta.* , loja.*"
                    + "FROM pedido "
                    + "INNER JOIN consumidor ON pedido.consumidor_id = consumidor.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                    + "INNER JOIN loja ON pedido.loja_id = loja.id "
                    + "WHERE pedido.consumidor_id = " + idConsumidor + " "
                    + "AND pedido.estado = '" + estado + "';"
            );
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

            Loja loja = new Loja();
            loja.setId(rs.getLong("loja.id")).setNome(rs.getString("loja.nome")).setCnpj(rs.getString("loja.cnpj"))
                    .setDescricao(rs.getString("loja.descricao")).setImagem(rs.getString("loja.imagem"));
            pedido = new Pedido();
            pedido.setId((rs.getLong("pedido.id"))).setValor(rs.getString("pedido.valor"))
                    .setEstado((PedidoEstado) MainFactory.getObject(PedidoEstado.class.getName() + rs.getString("pedido.estado"))).setConsumidor(consumidor).setLoja(loja);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pedido;
    }

    public ArrayList<Pedido> getAllByConsumidor(long idConsumidor) {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT pedido.*, consumidor.*, contato.*, conta.* , loja.*"
                    + "FROM pedido "
                    + "INNER JOIN consumidor ON pedido.consumidor_id = consumidor.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                    + "INNER JOIN loja ON pedido.loja_id = loja.id "
                    + "WHERE pedido.consumidor_id = " + idConsumidor + ";"
            );
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

                Loja loja = new Loja();
                loja.setId(rs.getLong("loja.id")).setNome(rs.getString("loja.nome")).setCnpj(rs.getString("loja.cnpj"))
                        .setDescricao(rs.getString("loja.descricao")).setImagem(rs.getString("loja.imagem"));
                Pedido pedido = new Pedido();
                pedido.setId((rs.getLong("pedido.id"))).setValor(rs.getString("pedido.valor"))
                        .setEstado((PedidoEstado) MainFactory.getObject(PedidoEstado.class.getName() + rs.getString("pedido.estado"))).setConsumidor(consumidor).setLoja(loja);
                pedidos.add(pedido);

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pedidos;
    }

    public ArrayList<Pedido> getAllByLoja(long idLoja, String estado) {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT pedido.*, consumidor.*, contato.*, conta.* , loja.*"
                    + "FROM pedido "
                    + "INNER JOIN consumidor ON pedido.consumidor_id = consumidor.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                    + "INNER JOIN loja ON pedido.loja_id = loja.id "
                    + "WHERE pedido.loja_id = " + idLoja + " "
                    + "AND pedido.estado != '" + estado + "';"
            );
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

                Loja loja = new Loja();
                loja.setId(rs.getLong("loja.id")).setNome(rs.getString("loja.nome")).setCnpj(rs.getString("loja.cnpj"))
                        .setDescricao(rs.getString("loja.descricao")).setImagem(rs.getString("loja.imagem"));
                Pedido pedido = new Pedido();
                pedido.setId((rs.getLong("pedido.id"))).setValor(rs.getString("pedido.valor"))
                        .setEstado((PedidoEstado) MainFactory.getObject(PedidoEstado.class.getName() + rs.getString("pedido.estado"))).setConsumidor(consumidor).setLoja(loja);
                pedidos.add(pedido);

            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pedidos;
    }

}
