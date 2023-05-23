package repository;
import model.*;
import service.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AuthorRepository {
    private static JDBCConnection jdbcconnection;
    static {
        try {
            jdbcconnection = JDBCConnection.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection connection = JDBCConnection.getConnection();

    public static PriorityQueue<Author> readAuthors() throws SQLException {
        PriorityQueue<Author> authors = new PriorityQueue<Author>();
        String query = "SELECT * FROM Author";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet r = statement.executeQuery();
        Author aux = null;
        while(r.next()) {
            aux = new Author(r.getString("firstName"),
                    r.getString("lastName"),
                    r.getInt("age"),
                    r.getInt("phone"),
                    r.getString("penName"),
                    r.getString("nationality"),
                    r.getInt("awardsWon"));
            authors.add(aux);
        }
        return authors;
    }
}
