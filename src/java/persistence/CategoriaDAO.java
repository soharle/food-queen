package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cartao;
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

    public Categoria get(long id) {
        ResultSet rs = DAO.executeQuery("SELECT * FROM categoria WHERE id =" + id + "");
        return create(rs);
    }

    public ArrayList<Categoria> getAll() {
        ResultSet rs = DAO.executeQuery("SELECT * FROM categoria;");
        return createAll(rs);
    }

    public void update(Categoria categoria) {
        DAO.executeQuery("UPDATE categoria SET nome = '" + categoria.getNome() + "' WHERE id = " + categoria.getId() + ";");
    }

    public void delete(long id) {
        DAO.executeQuery("DELETE FROM categoria WHERE id = " + id + ";");
    }

    public Categoria save(Categoria categoria) {
        long key = -1l;
        Statement st = DAO.executeQuery("INSERT INTO categoria (nome)" + " VALUES ('" + categoria.getNome() + "');", Statement.RETURN_GENERATED_KEYS);
        try {
            if (st.getGeneratedKeys().next()) {
                key = st.getGeneratedKeys().getLong(1);
                categoria.setId(key);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categoria;
    }

    private ArrayList<Categoria> createAll(ResultSet rs) {
        ArrayList<Categoria> categorias = new ArrayList<>();
        try {
            while (rs.next()) {
                categorias.add(builderCategoria(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return categorias;
    }

    private Categoria create(ResultSet rs) {

        Categoria categoria = null;
        try {
            rs.first();
            categoria = builderCategoria(rs);
            return categoria;
        } catch (SQLException ex) {
            Logger.getLogger(CartaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categoria;

    }

    private Categoria builderCategoria(ResultSet rs) {
        Categoria categoria = null;
        try {
            categoria = (Categoria) MainFactory.getObject(Categoria.class.getName() + rs.getString("nome"));
            categoria.setId(rs.getInt("id"));
        } catch (SQLException ex) {
            Logger.getLogger(CartaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categoria;
    }

}
