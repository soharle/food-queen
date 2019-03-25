package persistence;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Categoria;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mathe
 */
public class CategoriaDAO {

    private static CategoriaDAO instance = new CategoriaDAO();

    public static CategoriaDAO getInstance() {
        return instance;
    }

    public Categoria getCategoria(long id) throws ClassNotFoundException, SQLException {
        Categoria categoria = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from categoria where id =" + id + "");
            rs.first();
            categoria = new Categoria(rs.getInt("id"), rs.getString("nome"));
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return categoria;

    }

    public ArrayList<Categoria> getCategorias() throws ClassNotFoundException, SQLException {
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from categoria;");
            while (rs.next()) {
                Categoria categoria = new Categoria(rs.getInt("id"), rs.getString("nome"));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return categorias;

    }

    public void update(Categoria categoria) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("update categoria set nome = '" + categoria.getNome() + "' where id = " + categoria.getId() + ";");

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
            st.executeUpdate("delete from categoria where id =" + id + "");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Categoria categoria) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into categoria (login, senha, tipo)" + " values ('" + categoria.getNome() + "')");

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
