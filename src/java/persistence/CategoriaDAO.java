package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.categoria.Categoria;
import model.MainFactory;

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

    private CategoriaDAO() {
    }

    public Categoria get(long id) throws ClassNotFoundException, SQLException {
        Categoria categoria = null;
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM categoria WHERE id =" + id + "");
            rs.first();
            categoria = (Categoria) MainFactory.getObject( Categoria.class.getName()+ rs.getString("nome"));
            categoria.setId(rs.getInt("id"));
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return categoria;

    }

    public ArrayList<Categoria> getAll() throws ClassNotFoundException, SQLException {
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM categoria;");
            while (rs.next()) {
                Categoria categoria = (Categoria) MainFactory.getObject( Categoria.class.getName()+ rs.getString("nome"));
                categoria.setId(rs.getInt("id"));
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
            st.execute("UPDATE categoria SET nome = '" + categoria.getNome() + "' WHERE id = " + categoria.getId() + ";");

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
            st.executeUpdate("DELETE FROM categoria WHERE id = " + id + ";");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public Categoria save(Categoria categoria) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        long key = -1l;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("INSERT INTO categoria (nome)" + " VALUES ('" + categoria.getNome() + "');", Statement.RETURN_GENERATED_KEYS);
            if (st.getGeneratedKeys().next()) {
                key = st.getGeneratedKeys().getLong(1);
            }
            categoria.setId(key);

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
            return categoria;
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
