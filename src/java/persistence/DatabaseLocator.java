package persistence;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mathe
 */
public class DatabaseLocator {
    private static DatabaseLocator instance = new DatabaseLocator();

    public static DatabaseLocator getInstance() {
        return instance;
    }

    private DatabaseLocator() {
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn
                = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/food_queen", "root", "");
        return conn;
    }
}
