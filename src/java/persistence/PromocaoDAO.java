package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.promocao.Promocao;
import model.MainFactory;

public class PromocaoDAO {

    private static PromocaoDAO instance = new PromocaoDAO();

    public static PromocaoDAO getInstance() {
        return instance;
    }

    private PromocaoDAO() {
    }

    public ArrayList<Promocao> get(){
        Connection conn = null;
        Statement st = null;
        ArrayList<Promocao> promocoes = new ArrayList<Promocao>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from promocao");

            while (rs.next()) {
                Promocao promocao
                        = (Promocao) MainFactory.getObject(Promocao.class.getName() + rs.getString("nome"));
                promocoes.add(promocao);

            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st);
        }
        return promocoes;
    }

    public Promocao get(int promocaoId){
        Connection conn = null;
        Statement st = null;
        Promocao promocao = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from promocao where promocao.id ='" + promocaoId + "'");

            while (rs.next()) {
                promocao = (Promocao) MainFactory.getObject(Promocao.class.getName() + rs.getString("nome"));

            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(conn, st);
        }
        return promocao;
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
