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

public class LightNovelRepository {
    private static JDBCConnection jdbcconnection;
    static {
        try {
            jdbcconnection = JDBCConnection.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection connection = JDBCConnection.getConnection();

    public static @NotNull List<LightNovel> readLightNovels() throws SQLException {
        List<LightNovel> lightNovels = new ArrayList<>();
        String query = "SELECT * FROM LightNovel";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            LightNovel lightNovel = new LightNovel();
            lightNovel.setName(resultSet.getString("name"));
            lightNovel.setPrice(resultSet.getInt("price"));

            Section section = new Section();
            Object sectionObject = resultSet.getObject("section_id");
            if (sectionObject instanceof Section) {
                Section nestedSection = (Section) sectionObject;
                section.setTitle(nestedSection.getTitle());
                section.setPopularity(nestedSection.getPopularity());
            }

            lightNovel.setSection(section);

            Author author = new Author(
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getInt("age"),
                    resultSet.getInt("phone"),
                    resultSet.getString("penName"),
                    resultSet.getString("nationality"),
                    resultSet.getInt("awardsWon")
            );
            lightNovel.setAuthor(author);

            lightNovel.setArtist(resultSet.getString("artist"));
            lightNovel.setPages(resultSet.getInt("pages"));
            lightNovel.setVolumes(resultSet.getInt("volumes"));

            lightNovels.add(lightNovel);
        }

        return lightNovels;
    }

    public static void createLightNovel(@NotNull LightNovel lightNovel) throws SQLException {
        String query = "INSERT INTO LightNovel (name, price, section_id, author_id, artist, pages, volumes) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, lightNovel.getName());
        statement.setInt(2, lightNovel.getPrice());
        statement.setObject(3, lightNovel.getSection());
        statement.setObject(4, lightNovel.getAuthor());
        statement.setString(5, lightNovel.getArtist());
        statement.setInt(6, lightNovel.getPages());
        statement.setInt(7, lightNovel.getVolumes());
        statement.execute();
    }

    public static void updateLightNovelPrice(LightNovel lightNovel, int price) throws SQLException {
        String query = "UPDATE LightNovel SET price = ? WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, price);
        statement.setString(2, lightNovel.getName());
        statement.execute();
    }

    public static void deleteLightNovel(String name) throws SQLException {
        String query = "DELETE FROM LightNovel WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        statement.execute();
    }
}
