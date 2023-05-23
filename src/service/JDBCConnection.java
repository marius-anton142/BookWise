package service;
import java.sql.*;

public class JDBCConnection {
    private static JDBCConnection instance = null;
    private static Connection connection;

    private JDBCConnection() {
        String url = "jdbc:mysql://localhost:3306/bookwisedatabase";
        String username = "root";
        String password = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static JDBCConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new JDBCConnection();
        }
        return instance;
    }

    public static Connection getConnection() {
        return connection;
    }
}
