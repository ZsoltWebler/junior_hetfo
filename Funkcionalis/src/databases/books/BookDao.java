package databases.books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDao implements Dao<Book, String> {

    private final Connection connection;

    public BookDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Optional<Book> get(String id) {
        String sql = "SELECT * FROM BOOKS WHERE ISBN = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String isbn = resultSet.getString(1);
                String title = resultSet.getString(2);
                String author = resultSet.getString(3);
                String genre = resultSet.getString(4);
                boolean available = resultSet.getBoolean(5);

                return Optional.of(new Book(isbn, title, author, genre, available));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public List<Book> getAll() {

        String sql = "SELECT * FROM BOOKS";
        List<Book> books = new ArrayList<>();

        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            while (resultSet.next()) {

                String isbn = resultSet.getString(1);
                String title = resultSet.getString(2);
                String author = resultSet.getString(3);
                String genre = resultSet.getString(4);
                boolean available = resultSet.getBoolean(5);

                books.add(new Book(isbn, title, author, genre, available));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public void save(Book book) {

        String sql = "insert into books (isbn, title, author, genre, available) values (?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, book.getIsbn());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setString(4, book.getGenre());
            preparedStatement.setBoolean(5, book.isAvailable());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(List<Book> t) {

        t.forEach(this::save);

    }

    @Override
    public void update(String id, Book book) {

        String sql = "UPDATE BOOKS SET title = ?, author = ?, genre = ?, available = ? WHERE isbn = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getGenre());
            preparedStatement.setBoolean(4, book.isAvailable());
            preparedStatement.setString(5, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String id) {

        String sql = "DELETE FROM Books WHERE isbn = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteAll(List<String> ids) {
        ids.forEach(this::delete);
    }
}
