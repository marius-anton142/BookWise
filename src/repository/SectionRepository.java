package repository;
import model.*;
import org.jetbrains.annotations.NotNull;
import service.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SectionRepository {
    private static JDBCConnection jdbcconnection;
    static {
        try {
            jdbcconnection = JDBCConnection.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection connection = JDBCConnection.getConnection();

    public static List<Section> readSections() throws SQLException {
        List<Section> sections = new ArrayList<Section>();
        String query = "SELECT * FROM Section";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet r = statement.executeQuery();
        Section aux = null;
        while(r.next())
        {
            aux = new Section(r.getString("title"), r.getInt("popularity"));
            sections.add(aux);
        }
        return sections;
    }

    public static void createSection(@NotNull Section section) throws SQLException {
        String query = "INSERT INTO Section (title, popularity) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, section.getTitle());
        statement.setInt(2, section.getPopularity());
        statement.execute();
    }

    public static void updateSectionPopularity(@NotNull Section section, int popularity) throws SQLException {
        String title = section.getTitle();
        String query = "UPDATE Section SET popularity = ? WHERE title = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, popularity);
        statement.setString(2, title);
        statement.execute();
    }

    public static void deleteSection(String title) throws SQLException {
        String query = "DELETE FROM Section WHERE title = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, title);
        statement.execute();
    }
}
