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
import model.StateFactory;

/**
 *
 * @author raiss
 */
public class ConsumidorDAO {
     private static ConsumidorDAO instance = new ConsumidorDAO();

    public ConsumidorDAO getInstance() {
        return instance;
    }

    public Consumidor get(long id) {
        Consumidor consumidor = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT consumidor.*, contato.*, conta.* "
                    + "FROM consumidor "
                    + "INNER JOIN contato ON contato.id = consumidor.contato_id"
                    + "INNER JOIN conta ON conta.id = consumidor.conta_id "
                    + "WHERE consumidor.id = " + id + ";");
            rs.first();
            Contato contato = new Contato(rs.getLong("contato.id"), rs.getString("contato.telefone"), 
                    rs.getString("contato.ddd"), rs.getString("contato.email"), rs.getString("contato.telefone_complementar"));
            Conta conta = new Conta(rs.getLong("conta.id"), rs.getString("conta.login"), 
                    rs.getString("conta.senha"), rs.getString("conta.tipo"));
            consumidor = new Consumidor(rs.getLong("consumidor.id"), rs.getString("consumidor.nome"), 
                    rs.getString("consumidor.cpf"), rs.getString("consumidor.nascimento"), contato, conta);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CarrinhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return consumidor;
    }
    
    public ArrayList<Consumidor> getAll() {
        ArrayList<Consumidor> consumidores = new ArrayList<Consumidor>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT consumidor.*, contato.*, conta.* "
                    + "FROM consumidor "
                    + "INNER JOIN contato ON contato.id = consumidor.contato_id"
                    + "INNER JOIN conta ON conta.id = consumidor.conta_id ");
            
            while(rs.next()){
            Contato contato = new Contato(rs.getLong("contato.id"), rs.getString("contato.telefone"), 
                    rs.getString("contato.ddd"), rs.getString("contato.email"), rs.getString("contato.telefone_complementar"));
            Conta conta = new Conta(rs.getLong("conta.id"), rs.getString("conta.login"), 
                    rs.getString("conta.senha"), rs.getString("conta.tipo"));
            Consumidor consumidor = new Consumidor(rs.getLong("consumidor.id"), rs.getString("consumidor.nome"), 
                    rs.getString("consumidor.cpf"), rs.getString("consumidor.nascimento"), contato, conta);
            consumidores.add(consumidor);
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CarrinhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return consumidores;
    }
    
        public void update(Consumidor consumidor) {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE consumidor SET consumidor_id= " + carrinho.getConsumidor().getId() + ", "
                    + "valor = '" + carrinho.getValor()+ "', "
                    + "data = '" + carrinho.getData()+ "', "
                    + "hora = '" + carrinho.getHora()+ "', "
                    + "pagamento = '" + carrinho.getPagamento()+ "', "
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
                    + "'" + carrinho.getData()+ "', "
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

