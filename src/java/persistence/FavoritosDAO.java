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
import model.Favoritos;
import model.Loja;
import model.StateFactory;

/**
 *
 * @author Gabriel
 */
public class FavoritosDAO {

    private static FavoritosDAO instance = new FavoritosDAO();

    public static FavoritosDAO getInstance() {
        return instance;
    }

    private FavoritosDAO() {
    }

    public Favoritos get(long id) {
        Favoritos favorito = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT favoritos.*, "
                    + "loja.*, conta.*, contato.*, endereco.*, categoria.*, "
                    + "consumidor.*, conta.*, contato.* "
                    + "FROM favoritos "
                    + "INNER JOIN loja ON favoritos.loja_id = loja.id "
                    + "INNER JOIN conta ON loja.conta_id = conta.id "
                    + "INNER JOIN contato ON loja.contato_id = contato.id "
                    + "INNER JOIN endereco ON loja.endereco_id = endereco.id "
                    + "INNER JOIN categoria ON loja.categoria_id = categoria.id "
                    + "INNER JOIN consumidor ON favoritos.consumidor_id = consumidor.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id "
                    + "WHERE favoritos.id =" + id + ";");
            rs.first();

            Contato contatoLoja = new Contato();
            contatoLoja = contatoLoja.setId((rs.getLong("contato.id"))).setTelefone(rs.getString("contato.telefone")).setDdd(rs.getString("contato.ddd"))
                    .setEmail((rs.getString("contato.email"))).setTelefoneComplementar(rs.getString("contato.telefone_complementar"));
            Conta contaLoja = new Conta();
            contaLoja = contaLoja.setId(rs.getLong("conta.id")).setLogin(rs.getString("conta.login"))
                    .setSenha(rs.getString("conta.senha")).setTipo(rs.getString("conta.tipo"));
            Endereco enderecoLoja = new Endereco();
            enderecoLoja = enderecoLoja.setId(rs.getInt("id")).setCep(rs.getString("cep")).setLogradouro(rs.getString("logradouro")).setNumero(rs.getString("numero"))
                    .setComplemento(rs.getString("complemento")).setBairro(rs.getString("bairro")).setCidade(rs.getString("cidade"))
                    .setEstado(rs.getString("estado")).setPais(rs.getString("pais"));
            Categoria categoria = new Categoria();
            categoria = categoria.setId(rs.getInt("categoria.id")).setNome(rs.getString("categoria.nome"));
            Loja loja = new Loja();
            loja = loja.setId(rs.getLong("loja.id")).setNome(rs.getString("loja.nome")).setCnpj(rs.getString("loja.cnpj"))
                    .setDescricao(rs.getString("loja.descricao")).setImagem(rs.getString("loja.imagem"))
                    .setEndereco(enderecoLoja).setConta(contaLoja).setContato(contatoLoja).setCategoria(categoria);

            Contato contatoConsumidor = new Contato();
            contatoConsumidor = contatoConsumidor.setId((rs.getLong("consumidor.contato.id"))).setTelefone(rs.getString("consumidor.contato.telefone")).setDdd(rs.getString("consumidor.contato.ddd"))
                    .setEmail((rs.getString("consumidor.contato.email"))).setTelefoneComplementar(rs.getString("consumidor.contato.telefone_complementar"));
            Conta contaConsumidor = new Conta();
            contaConsumidor = contaConsumidor.setId(rs.getLong("consumidor.conta.id")).setLogin(rs.getString("consumidor.conta.login"))
                    .setSenha(rs.getString("consumidor.conta.senha")).setTipo(rs.getString("consumidor.conta.tipo"));
            Consumidor consumidor = new Consumidor();
            consumidor = consumidor.setId(rs.getLong("consumidor.id")).setNome(rs.getString("consumidor.nome"))
                    .setCpf(rs.getString("consumidor.cpf")).setNascimento(rs.getString("consumidor.nascimento")).setContato(contatoLoja).setConta(contaLoja);
            favorito = new Favoritos();
            favorito = favorito.setId(rs.getLong("favoritos.id")).setConsumidor(consumidor).setLoja(loja);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FavoritosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return favorito;
    }

    public ArrayList<Favoritos> getAll() {
        ArrayList<Favoritos> favoritos = new ArrayList<Favoritos>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT favoritos.*, "
                    + "loja.*, conta.*, contato.*, endereco.*, categoria.*, "
                    + "consumidor.*, conta.*, contato.* "
                    + "FROM favoritos "
                    + "INNER JOIN loja ON favoritos.loja_id = loja.id "
                    + "INNER JOIN conta ON loja.conta_id = conta.id "
                    + "INNER JOIN contato ON loja.contato_id = contato.id "
                    + "INNER JOIN endereco ON loja.endereco_id = endereco.id "
                    + "INNER JOIN categoria ON loja.categoria_id = categoria.id "
                    + "INNER JOIN consumidor ON favoritos.consumidor_id = consumidor.id "
                    + "INNER JOIN conta ON consumidor.conta_id = conta.id "
                    + "INNER JOIN contato ON consumidor.contato_id = contato.id ;");

            while (rs.next()) {
                Contato contatoLoja = new Contato();
                contatoLoja = contatoLoja.setId((rs.getLong("contato.id"))).setTelefone(rs.getString("contato.telefone")).setDdd(rs.getString("contato.ddd"))
                        .setEmail((rs.getString("contato.email"))).setTelefoneComplementar(rs.getString("contato.telefone_complementar"));
                Conta contaLoja = new Conta();
                contaLoja = contaLoja.setId(rs.getLong("conta.id")).setLogin(rs.getString("conta.login"))
                        .setSenha(rs.getString("conta.senha")).setTipo(rs.getString("conta.tipo"));
                Endereco enderecoLoja = new Endereco();
                enderecoLoja = enderecoLoja.setId(rs.getInt("id")).setCep(rs.getString("cep")).setLogradouro(rs.getString("logradouro")).setNumero(rs.getString("numero"))
                        .setComplemento(rs.getString("complemento")).setBairro(rs.getString("bairro")).setCidade(rs.getString("cidade"))
                        .setEstado(rs.getString("estado")).setPais(rs.getString("pais"));
                Categoria categoria = new Categoria();
                categoria = categoria.setId(rs.getInt("categoria.id")).setNome(rs.getString("categoria.nome"));
                Loja loja = new Loja();
                loja = loja.setId(rs.getLong("loja.id")).setNome(rs.getString("loja.nome")).setCnpj(rs.getString("loja.cnpj"))
                        .setDescricao(rs.getString("loja.descricao")).setImagem(rs.getString("loja.imagem"))
                        .setEndereco(enderecoLoja).setConta(contaLoja).setContato(contatoLoja).setCategoria(categoria);

                Contato contatoConsumidor = new Contato();
                contatoConsumidor = contatoConsumidor.setId((rs.getLong("consumidor.contato.id"))).setTelefone(rs.getString("consumidor.contato.telefone")).setDdd(rs.getString("consumidor.contato.ddd"))
                        .setEmail((rs.getString("consumidor.contato.email"))).setTelefoneComplementar(rs.getString("consumidor.contato.telefone_complementar"));
                Conta contaConsumidor = new Conta();
                contaConsumidor = contaConsumidor.setId(rs.getLong("consumidor.conta.id")).setLogin(rs.getString("consumidor.conta.login"))
                        .setSenha(rs.getString("consumidor.conta.senha")).setTipo(rs.getString("consumidor.conta.tipo"));
                Consumidor consumidor = new Consumidor();
                consumidor = consumidor.setId(rs.getLong("consumidor.id")).setNome(rs.getString("consumidor.nome"))
                        .setCpf(rs.getString("consumidor.cpf")).setNascimento(rs.getString("consumidor.nascimento")).setContato(contatoLoja).setConta(contaLoja);
                Favoritos favorito = new Favoritos();
                favorito = favorito.setId(rs.getLong("favoritos.id")).setConsumidor(consumidor).setLoja(loja);
                favoritos.add(favorito);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FavoritosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return favoritos;
    }

    public void update(Favoritos favoritos) {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String query = "UPDATE favoritos SET consumidor_id = " + favoritos.getConsumidor().getId() + ", "
                    + "loja_id = " + favoritos.getLoja().getId() + " "
                    + "WHERE id = " + favoritos.getId() + ";";
            st.execute(query);

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
            st.executeUpdate("DELETE FROM favoritos WHERE id = " + id + "");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LojaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Favoritos favorito) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO favoritos (consumidor_id, loja_id) "
                    + "VALUES (" + favorito.getConsumidor().getId() + ", "
                    + "" + favorito.getLoja().getId() + " "
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
