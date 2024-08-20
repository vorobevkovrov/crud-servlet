package repository.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    public static Connection connect() {

        try {
            String jdbcUrl = DatabaseConfig.getDbUrl();
            String user = DatabaseConfig.getDbUsername();
            String password = DatabaseConfig.getDbPassword();
            Connection connection = null;
            Class.forName("org.postgresql.Driver");
            try {
                connection = DriverManager.getConnection(jdbcUrl, user, password);
            } catch (SQLException e) {

                e.printStackTrace();
            }
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}