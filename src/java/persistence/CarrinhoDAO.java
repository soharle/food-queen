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
import model.CarrinhoEstado;
import model.Consumidor;
import model.Conta;
import model.Contato;
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
            ResultSet rs = st.executeQuery("SELECT carrinho.*, consumidor.*, contato.*, conta.*, loja.* "
                    + "FROM carrinho "
                    + "INNER JOIN consumidor ON carrinho.consumidor_id = consumidor.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "INNER JOIN loja On carrinho.loja_id = loja.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                    + "WHERE carrinho.id = " + id + ";");
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

            carrinho = new Carrinho();
            carrinho.setId((rs.getLong("carrinho.id"))).setValor(rs.getString("carrinho.valor")).setLoja(loja)
                    .setEstado((CarrinhoEstado) StateFactory.getObject(CarrinhoEstado.class.getName() + rs.getString("carrinho.estado"))).setConsumidor(consumidor);
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
            ResultSet rs = st.executeQuery("SELECT carrinho.*, consumidor.*, contato.*, conta.*, loja.* "
                    + "FROM carrinho "
                    + "INNER JOIN consumidor ON carrinho.consumidor_id = consumidor.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "INNER JOIN loja ON carrinho.loja_id = loja.id "
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
                Carrinho carrinho = new Carrinho();
                carrinho.setId((rs.getLong("carrinho.id"))).setValor(rs.getString("carrinho.valor")).
                        setEstado((CarrinhoEstado) StateFactory.getObject((CarrinhoEstado.class.getName() + rs.getString("carrinho.estado")))).setConsumidor(consumidor).setLoja(loja);

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
            ResultSet rs = st.executeQuery("SELECT carrinho.*, loja.* "
                    + "FROM carrinho "
                    + "INNER JOIN loja ON carrinho.loja_id = loja.id "
                    + "WHERE carrinho.loja_id = '" + idLoja + "';");
            while (rs.next()) {
                Loja loja = LojaDAO.getInstance().get(rs.getLong("produto.loja_id"));

                Carrinho carrinho = new Carrinho();
                carrinho = carrinho.setId(rs.getLong("carrinho.id")).setValor(rs.getString("carrinho.valor"))
                        .setEstado((CarrinhoEstado) StateFactory.getObject( CarrinhoEstado.class.getName() + rs.getString("carrinho.estado")));

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
                    + "estado = '" + carrinho.getEstado().getEstadoNome() + "', "
                    + "loja_id = " + carrinho.getLoja().getId() + " "
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

    public Carrinho save(Carrinho carrinho) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        long key = -1;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO carrinho (consumidor_id, loja_id, valor, estado) "
                    + "VALUES (" + carrinho.getConsumidor().getId() + ", "
                    + "" + carrinho.getLoja().getId() + ", "
                    + "" + carrinho.getValor() + ", "
                    + "'" + carrinho.getEstado().getEstadoNome() + "' "
                    + ");", Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            if (rs != null && rs.next()) {
                key = rs.getLong(1);
            }
            carrinho.setId(key);
        } catch (SQLException e) {
            System.out.println(e);;
        } finally {
            closeResources(conn, st);
        }

        return carrinho;

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

    public Carrinho getByConsumidor(long idConsumidor) {
        Carrinho carrinho = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT carrinho.*, consumidor.*, contato.*, conta.* , loja.*"
                    + "FROM carrinho "
                    + "INNER JOIN consumidor ON carrinho.consumidor_id = consumidor.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                    + "INNER JOIN loja ON carrinho.loja_id = loja.id "
                    + "WHERE carrinho.consumidor_id = " + idConsumidor + ";");
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
            carrinho = new Carrinho();
            carrinho.setId((rs.getLong("carrinho.id"))).setValor(rs.getString("carrinho.valor"))
                    .setEstado((CarrinhoEstado) StateFactory.getObject( CarrinhoEstado.class.getName() + rs.getString("carrinho.estado"))).setConsumidor(consumidor).setLoja(loja);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CarrinhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return carrinho;
    }

    /*não meche aqui, faz parte de um recurso técnico avançado, um estado da arte da gambiarra*/
    public Carrinho getByConsumidor(long idConsumidor, String estado) {
        Carrinho carrinho = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT carrinho.*, consumidor.*, contato.*, conta.* , loja.*"
                    + "FROM carrinho "
                    + "INNER JOIN consumidor ON carrinho.consumidor_id = consumidor.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                    + "INNER JOIN loja ON carrinho.loja_id = loja.id "
                    + "WHERE carrinho.consumidor_id = " + idConsumidor + " "
                    + "AND carrinho.estado = '" + estado + "';"
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
            carrinho = new Carrinho();
            carrinho.setId((rs.getLong("carrinho.id"))).setValor(rs.getString("carrinho.valor"))
                    .setEstado((CarrinhoEstado) StateFactory.getObject(CarrinhoEstado.class.getName() + rs.getString("carrinho.estado"))).setConsumidor(consumidor).setLoja(loja);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CarrinhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return carrinho;
    }

    public ArrayList<Carrinho> getAllByConsumidor(long idConsumidor) {
        ArrayList<Carrinho> carrinhos = new ArrayList<>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT carrinho.*, consumidor.*, contato.*, conta.* , loja.*"
                    + "FROM carrinho "
                    + "INNER JOIN consumidor ON carrinho.consumidor_id = consumidor.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                    + "INNER JOIN loja ON carrinho.loja_id = loja.id "
                    + "WHERE carrinho.consumidor_id = " + idConsumidor + ";"
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
                Carrinho carrinho = new Carrinho();
                carrinho.setId((rs.getLong("carrinho.id"))).setValor(rs.getString("carrinho.valor"))
                        .setEstado((CarrinhoEstado) StateFactory.getObject( CarrinhoEstado.class.getName() + rs.getString("carrinho.estado"))).setConsumidor(consumidor).setLoja(loja);
                carrinhos.add(carrinho);

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CarrinhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return carrinhos;
    }

    public ArrayList<Carrinho> getAllByLoja(long idLoja, String estado) {
        ArrayList<Carrinho> carrinhos = new ArrayList<>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT carrinho.*, consumidor.*, contato.*, conta.* , loja.*"
                    + "FROM carrinho "
                    + "INNER JOIN consumidor ON carrinho.consumidor_id = consumidor.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                    + "INNER JOIN loja ON carrinho.loja_id = loja.id "
                    + "WHERE carrinho.loja_id = " + idLoja + " "
                    + "AND carrinho.estado != '" + estado + "';"
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
                Carrinho carrinho = new Carrinho();
                carrinho.setId((rs.getLong("carrinho.id"))).setValor(rs.getString("carrinho.valor"))
                        .setEstado((CarrinhoEstado) StateFactory.getObject(CarrinhoEstado.class.getName() + rs.getString("carrinho.estado"))).setConsumidor(consumidor).setLoja(loja);
                carrinhos.add(carrinho);

            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CarrinhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return carrinhos;
    }

}
