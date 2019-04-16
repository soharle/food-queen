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
import model.Endereco;
import model.Entrega;
import model.Loja;
import model.StateFactory;

/**
 *
 * @author Gabriel
 */
public class EntregaDAO {

    private static EntregaDAO instance = new EntregaDAO();

    public static EntregaDAO getInstance() {
        return instance;
    }

    private EntregaDAO() {
    }

    public Entrega get(long id) {
        Entrega entrega = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT entrega.*, "
                    + "loja.*, conta.*, contato.*, endereco.*, categoria.*, "
                    + "carrinho.*, consumidor.*, "
                    + "FROM entrega"
                    + "INNER JOIN loja ON entrega.loja_id = loja.id"
                    + "INNER JOIN conta conta_loja ON loja.conta_id = conta.id "
                    + "INNER JOIN contato ON loja.contato_id = contato.id "
                    + "INNER JOIN endereco ON loja.endereco_id = endereco.id "
                    + "INNER JOIN categoria ON loja.categoria_id = categoria.id "
                    + "INNER JOIN consumidor ON carrinho.consumidor_id = consumidor.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "INNER JOIN conta conta_consumidor ON consumidor.conta_id = conta.id "
                    + "WHERE entrega.id = " + id + ";");

            rs.first();

            Conta conta = new Conta();
            conta.setId(rs.getLong("conta.id")).setLogin(rs.getString("conta.login"))
                    .setSenha(rs.getString("conta.senha")).setTipo(rs.getString("conta.tipo"));
            Contato contato = new Contato();
            contato.setId((rs.getLong("contato.id"))).setTelefone(rs.getString("contato.telefone")).setDdd(rs.getString("contato.ddd"))
                    .setEmail((rs.getString("contato.email"))).setTelefoneComplementar(rs.getString("contato.telefone_complementar"));
            Endereco endereco = new Endereco();
            endereco.setId(rs.getInt("id")).setCep(rs.getString("cep")).setLogradouro(rs.getString("logradouro")).setNumero(rs.getString("numero"))
                    .setComplemento(rs.getString("complemento")).setBairro(rs.getString("bairro")).setCidade(rs.getString("cidade"))
                    .setEstado(rs.getString("estado")).setPais(rs.getString("pais"));
            Categoria categoria = new Categoria();
            categoria.setId(rs.getInt("id")).setNome(rs.getString("nome"));
            Loja loja = new Loja();
            loja.setId(rs.getLong("loja.id")).setNome(rs.getString("loja.nome")).setCnpj(rs.getString("loja.cnpj"))
                    .setDescricao(rs.getString("loja.descricao")).setImagem(rs.getString("loja.imagem")).setEndereco(endereco)
                    .setConta(conta).setContato(contato).setCategoria(categoria);
            Contato contatoConsumidor = new Contato();
            contatoConsumidor = contatoConsumidor.setId((rs.getLong("contato.id"))).setTelefone(rs.getString("contato.telefone")).setDdd(rs.getString("contato.ddd"))
                    .setEmail((rs.getString("contato.email"))).setTelefoneComplementar(rs.getString("contato.telefone_complementar"));
            Consumidor consumidor = new Consumidor();
            consumidor.setId(rs.getLong("consumidor.id")).setNome(rs.getString("consumidor.nome"))
                    .setCpf(rs.getString("consumidor.cpf")).setNascimento(rs.getString("consumidor.nascimento")).setContato(contato).setConta(conta);
            Carrinho carrinho = new Carrinho();
            carrinho.setId((rs.getLong("carrinho.id"))).setValor(rs.getString("carrinho.valor")).setData(rs.getString("carrinho.data"))
                    .setHora(rs.getString("carrinho.hora")).setPagamento(rs.getString("carrinho.pagamento"))
                    .setEstado(StateFactory.createCarrinhoEstado(rs.getString("carrinho.estado"))).setConsumidor(consumidor);
            entrega = new Entrega();
            entrega.setId((rs.getLong("entrega.id"))).setEstado(StateFactory.createEntregaEstado("entrega.estado")).setLoja(loja).setCarrinho(carrinho);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EntregaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entrega;
    }
    
    public Entrega getByCarrinho(long id) {
        Entrega entrega = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT entrega.*, "
                    + "loja.*, conta.*, contato.*, endereco.*, categoria.*, "
                    + "carrinho.*, consumidor.*, "
                    + "FROM entrega"
                    + "INNER JOIN loja ON entrega.loja_id = loja.id"
                    + "INNER JOIN conta conta_loja ON loja.conta_id = conta.id "
                    + "INNER JOIN contato ON loja.contato_id = contato.id "
                    + "INNER JOIN endereco ON loja.endereco_id = endereco.id "
                    + "INNER JOIN categoria ON loja.categoria_id = categoria.id "
                    + "INNER JOIN consumidor ON carrinho.consumidor_id = consumidor.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "INNER JOIN conta conta_consumidor ON consumidor.conta_id = conta.id "
                    + "WHERE carrinho.id = " + id + ";");

            rs.first();

            Conta conta = new Conta();
            conta.setId(rs.getLong("conta.id")).setLogin(rs.getString("conta.login"))
                    .setSenha(rs.getString("conta.senha")).setTipo(rs.getString("conta.tipo"));
            Contato contato = new Contato();
            contato.setId((rs.getLong("contato.id"))).setTelefone(rs.getString("contato.telefone")).setDdd(rs.getString("contato.ddd"))
                    .setEmail((rs.getString("contato.email"))).setTelefoneComplementar(rs.getString("contato.telefone_complementar"));
            Endereco endereco = new Endereco();
            endereco.setId(rs.getInt("id")).setCep(rs.getString("cep")).setLogradouro(rs.getString("logradouro")).setNumero(rs.getString("numero"))
                    .setComplemento(rs.getString("complemento")).setBairro(rs.getString("bairro")).setCidade(rs.getString("cidade"))
                    .setEstado(rs.getString("estado")).setPais(rs.getString("pais"));
            Categoria categoria = new Categoria();
            categoria.setId(rs.getInt("id")).setNome(rs.getString("nome"));
            Loja loja = new Loja();
            loja.setId(rs.getLong("loja.id")).setNome(rs.getString("loja.nome")).setCnpj(rs.getString("loja.cnpj"))
                    .setDescricao(rs.getString("loja.descricao")).setImagem(rs.getString("loja.imagem")).setEndereco(endereco)
                    .setConta(conta).setContato(contato).setCategoria(categoria);
            Contato contatoConsumidor = new Contato();
            contatoConsumidor = contatoConsumidor.setId((rs.getLong("contato.id"))).setTelefone(rs.getString("contato.telefone")).setDdd(rs.getString("contato.ddd"))
                    .setEmail((rs.getString("contato.email"))).setTelefoneComplementar(rs.getString("contato.telefone_complementar"));
            Consumidor consumidor = new Consumidor();
            consumidor.setId(rs.getLong("consumidor.id")).setNome(rs.getString("consumidor.nome"))
                    .setCpf(rs.getString("consumidor.cpf")).setNascimento(rs.getString("consumidor.nascimento")).setContato(contato).setConta(conta);
            Carrinho carrinho = new Carrinho();
            carrinho.setId((rs.getLong("carrinho.id"))).setValor(rs.getString("carrinho.valor")).setData(rs.getString("carrinho.data"))
                    .setHora(rs.getString("carrinho.hora")).setPagamento(rs.getString("carrinho.pagamento"))
                    .setEstado(StateFactory.createCarrinhoEstado(rs.getString("carrinho.estado"))).setConsumidor(consumidor);
            entrega = new Entrega();
            entrega.setId((rs.getLong("entrega.id"))).setEstado(StateFactory.createEntregaEstado("entrega.estado")).setLoja(loja).setCarrinho(carrinho);

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
                    + "loja.*, conta.*, contato.*, endereco.*, categoria.*, "
                    + "carrinho.*, consumidor.*, "
                    + "FROM entrega"
                    + "INNER JOIN loja ON entrega.loja_id = loja.id"
                    + "INNER JOIN conta conta_loja ON loja.conta_id = conta.id "
                    + "INNER JOIN contato ON loja.contato_id = contato.id "
                    + "INNER JOIN endereco ON loja.endereco_id = endereco.id "
                    + "INNER JOIN categoria ON loja.categoria_id = categoria.id "
                    + "INNER JOIN consumidor ON carrinho.consumidor_id = consumidor.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "INNER JOIN conta conta_consumidor ON consumidor.conta_id = conta.id ");

            while (rs.next()) {
                Conta conta = new Conta();
                conta.setId(rs.getLong("conta.id")).setLogin(rs.getString("conta.login"))
                        .setSenha(rs.getString("conta.senha")).setTipo(rs.getString("conta.tipo"));
                Contato contato = new Contato();
                contato.setId((rs.getLong("contato.id"))).setTelefone(rs.getString("contato.telefone")).setDdd(rs.getString("contato.ddd"))
                        .setEmail((rs.getString("contato.email"))).setTelefoneComplementar(rs.getString("contato.telefone_complementar"));
                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt("id")).setCep(rs.getString("cep")).setLogradouro(rs.getString("logradouro")).setNumero(rs.getString("numero"))
                        .setComplemento(rs.getString("complemento")).setBairro(rs.getString("bairro")).setCidade(rs.getString("cidade"))
                        .setEstado(rs.getString("estado")).setPais(rs.getString("pais"));
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id")).setNome(rs.getString("nome"));
                Loja loja = new Loja();
                loja.setId(rs.getLong("loja.id")).setNome(rs.getString("loja.nome")).setCnpj(rs.getString("loja.cnpj"))
                        .setDescricao(rs.getString("loja.descricao")).setImagem(rs.getString("loja.imagem")).setEndereco(endereco)
                        .setConta(conta).setContato(contato).setCategoria(categoria);
                Contato contatoConsumidor = new Contato();
                contatoConsumidor.setId((rs.getLong("contato.id"))).setTelefone(rs.getString("contato.telefone")).setDdd(rs.getString("contato.ddd"))
                        .setEmail((rs.getString("contato.email"))).setTelefoneComplementar(rs.getString("contato.telefone_complementar"));
                Consumidor consumidor = new Consumidor();
                consumidor.setId(rs.getLong("consumidor.id")).setNome(rs.getString("consumidor.nome"))
                        .setCpf(rs.getString("consumidor.cpf")).setNascimento(rs.getString("consumidor.nascimento")).setContato(contato).setConta(conta);
                Carrinho carrinho = new Carrinho();
                carrinho.setId((rs.getLong("carrinho.id"))).setValor(rs.getString("carrinho.valor")).setData(rs.getString("carrinho.data"))
                        .setHora(rs.getString("carrinho.hora")).setPagamento(rs.getString("carrinho.pagamento"))
                        .setEstado(StateFactory.createCarrinhoEstado(rs.getString("carrinho.estado"))).setConsumidor(consumidor);
                Entrega entrega = new Entrega();
                entrega.setId((rs.getLong("entrega.id"))).setEstado(StateFactory.createEntregaEstado("entrega.estado")).setLoja(loja).setCarrinho(carrinho);

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
