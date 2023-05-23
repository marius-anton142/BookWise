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


public class BookRepository {
    private static JDBCConnection jdbcconnection;
    static {
        try {
            jdbcconnection = JDBCConnection.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection connection = JDBCConnection.getConnection();

    public static @NotNull List<Book> readBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM Book";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Book book = new Book();
            book.setName(resultSet.getString("name"));
            book.setPrice(resultSet.getInt("price"));

            Section section = new Section();
            Object sectionObject = resultSet.getObject("section");
            if (sectionObject instanceof Section) {
                Section nestedSection = (Section) sectionObject;
                section.setTitle(nestedSection.getTitle());
                section.setPopularity(nestedSection.getPopularity());
            }

            book.setSection(section);

            Author author = new Author(
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getInt("age"),
                    resultSet.getInt("phone"),
                    resultSet.getString("penName"),
                    resultSet.getString("nationality"),
                    resultSet.getInt("awardsWon")
            );
            book.setAuthor(author);

            book.setDescription(resultSet.getString("description"));
            book.setPages(resultSet.getInt("pages"));
            book.setEdition(resultSet.getInt("edition"));

            books.add(book);
        }

        return books;
    }

    public static void createBook(@NotNull Book book) throws SQLException {
        String query = "INSERT INTO Book (name, price, section_id, author_id, description, pages, edition) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, book.getName());
        statement.setInt(2, book.getPrice());
        statement.setObject(3, book.getSection());
        statement.setObject(4, book.getAuthor());
        statement.setString(5, book.getDescription());
        statement.setInt(6, book.getPages());
        statement.setInt(7, book.getEdition());
        statement.execute();
    }

    public static void updateBookPrice(Book book, int price) throws SQLException {
        String query = "UPDATE Book SET price = ? WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, price);
        statement.setString(2, book.getName());
        statement.execute();
    }

    public static void deleteBook(String name) throws SQLException {
        String query = "DELETE FROM Book WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        statement.execute();
    }
}
