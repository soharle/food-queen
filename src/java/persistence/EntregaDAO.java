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
import model.Categoria;
import model.Consumidor;
import model.Conta;
import model.Contato;
import model.EnderecoLoja;
import model.Entrega;
import model.Loja;
import model.StateFactory;

/**
 *
 * @author Gabriel
 */
public class EntregaDAO {

    private static EntregaDAO instance = new EntregaDAO();

    public EntregaDAO getInstance() {
        return instance;
    }

    public Entrega get(long id) {
        Entrega entrega = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT entrega.*, "
                    + "loja.*, conta.*, contato.*, endereco_loja.*, categoria.*, "
                    + "carrinho.*, consumidor.*, "
                    + "FROM entrega"
                    + "INNER JOIN loja ON entrega.loja_id = loja.id"
                    + "INNER JOIN conta conta_loja ON loja.conta_id = conta.id "
                    + "INNER JOIN contato ON loja.contato_id = contato.id "
                    + "INNER JOIN endereco_loja ON loja.endereco_loja_id = endereco_loja.id "
                    + "INNER JOIN categoria ON loja.categoria_id = categoria.id "
                    + "INNER JOIN consumidor ON carrinho.consumidor_id = consumidor.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "INNER JOIN conta conta_consumidor ON consumidor.conta_id = conta.id "
                    + "WHERE entrega.id = " + id + ";");

            rs.first();
            Conta conta = new Conta(rs.getLong("conta_loja.id"), rs.getString("conta_loja.login"),
                    rs.getString("conta_loja.senha"), rs.getString("conta_loja.tipo"));
            Contato contato = new Contato(rs.getLong("contato.id"), rs.getString("contato.telefone"),
                    rs.getString("contato.ddd"), rs.getString("contato.email"), rs.getString("contato.telefone_complementar"));
            EnderecoLoja enderecoLoja = new EnderecoLoja(rs.getLong("endereco_loja.id"), rs.getString("endereco_loja.logradouro"),
                    rs.getString("endereco_loja.numero"), rs.getString("endereco_loja.complemento"),
                    rs.getString("endereco_loja.bairro"), rs.getString("endereco_loja.cidade"),
                    rs.getString("endereco_loja.estado"), rs.getString("endereco_loja.pais"));
            Categoria categoria = new Categoria(rs.getInt("categoria.id"), rs.getString("categoria.nome"));
            Loja loja = new Loja(rs.getLong("loja.id"), rs.getString("loja.nome"), rs.getString("loja.cnpj"), rs.getString("loja.descricao"),
                    enderecoLoja, conta, contato, categoria);
            Contato contatoConsumidor = new Contato(rs.getLong("contato.id"), rs.getString("contato.telefone"),
                    rs.getString("contato.ddd"), rs.getString("contato.email"), rs.getString("contato.telefone_complementar"));
            Conta contaConsumidor = new Conta(rs.getLong("conta.id"), rs.getString("conta.login"),
                    rs.getString("conta.senha"), rs.getString("conta.tipo"));
            Consumidor consumidor = new Consumidor(rs.getLong("consumidor.id"), rs.getString("consumidor.nome"),
                    rs.getString("consumidor.cpf"), rs.getString("consumidor.nascimento"), contatoConsumidor, contaConsumidor);
            Carrinho carrinho = new Carrinho(rs.getLong("carrinho.id"), rs.getString("carrinho.valor"), rs.getString("carrinho.data"),
                    rs.getString("carrinho.hora"), rs.getString("carrinho.pagamento"),
                    StateFactory.createCarrinhoEstado(rs.getString("carrinho.estado")), consumidor);
            entrega = new Entrega(rs.getLong("entrega.id"), loja, carrinho);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EntregaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entrega;
    }

    public ArrayList<Entrega> getAll() {
        ArrayList<Entrega> entregas = new ArrayList<Entrega>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT entrega.*, "
                    + "loja.*, conta.*, contato.*, endereco_loja.*, categoria.*, "
                    + "carrinho.*, consumidor.*, "
                    + "FROM entrega"
                    + "INNER JOIN loja ON entrega.loja_id = loja.id"
                    + "INNER JOIN conta conta_loja ON loja.conta_id = conta.id "
                    + "INNER JOIN contato ON loja.contato_id = contato.id "
                    + "INNER JOIN endereco_loja ON loja.endereco_loja_id = endereco_loja.id "
                    + "INNER JOIN categoria ON loja.categoria_id = categoria.id "
                    + "INNER JOIN consumidor ON carrinho.consumidor_id = consumidor.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "INNER JOIN conta conta_consumidor ON consumidor.conta_id = conta.id ");

            while (rs.next()) {
                Conta conta = new Conta(rs.getLong("conta_loja.id"), rs.getString("conta_loja.login"),
                        rs.getString("conta_loja.senha"), rs.getString("conta_loja.tipo"));
                Contato contato = new Contato(rs.getLong("contato.id"), rs.getString("contato.telefone"),
                        rs.getString("contato.ddd"), rs.getString("contato.email"), rs.getString("contato.telefone_complementar"));
                EnderecoLoja enderecoLoja = new EnderecoLoja(rs.getLong("endereco_loja.id"), rs.getString("endereco_loja.logradouro"),
                        rs.getString("endereco_loja.numero"), rs.getString("endereco_loja.complemento"),
                        rs.getString("endereco_loja.bairro"), rs.getString("endereco_loja.cidade"),
                        rs.getString("endereco_loja.estado"), rs.getString("endereco_loja.pais"));
                Categoria categoria = new Categoria(rs.getInt("categoria.id"), rs.getString("categoria.nome"));
                Loja loja = new Loja(rs.getLong("loja.id"), rs.getString("loja.nome"), rs.getString("loja.cnpj"), rs.getString("loja.descricao"),
                        enderecoLoja, conta, contato, categoria);
                Contato contatoConsumidor = new Contato(rs.getLong("contato.id"), rs.getString("contato.telefone"),
                        rs.getString("contato.ddd"), rs.getString("contato.email"), rs.getString("contato.telefone_complementar"));
                Conta contaConsumidor = new Conta(rs.getLong("conta.id"), rs.getString("conta.login"),
                        rs.getString("conta.senha"), rs.getString("conta.tipo"));
                Consumidor consumidor = new Consumidor(rs.getLong("consumidor.id"), rs.getString("consumidor.nome"),
                        rs.getString("consumidor.cpf"), rs.getString("consumidor.nascimento"), contatoConsumidor, contaConsumidor);
                Carrinho carrinho = new Carrinho(rs.getLong("carrinho.id"), rs.getString("carrinho.valor"), rs.getString("carrinho.data"),
                        rs.getString("carrinho.hora"), rs.getString("carrinho.pagamento"),
                        StateFactory.createCarrinhoEstado(rs.getString("carrinho.estado")), consumidor);
                Entrega entrega = new Entrega(rs.getLong("entrega.id"), loja, carrinho);
                entregas.add(entrega);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EntregaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entregas;
    }

    public void update(Entrega entrega) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE entrega SET loja_id = '" + entrega.getLoja().getId() + "', "
                    + "carrinho_id = '" + entrega.getCarrinho().getId() + "', "
                    + "estado = '" + entrega.getEstado().toString() + "' "
                    + "WHERE id = " + entrega.getId() + ";");

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
            st.executeUpdate("DELETE FROM entrega WHERE id = " + id + ";");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Entrega entrega) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO entrega (loja_id, carrinho_id, estado)" + " "
                    + "VALUES ('" + entrega.getLoja().getId() + "', '"
                    + entrega.getLoja().getId() + ", '"
                    + entrega.getEstado().toString() + "');");

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
