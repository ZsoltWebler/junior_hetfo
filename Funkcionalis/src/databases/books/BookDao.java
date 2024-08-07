package databases.books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
                return Optional.of(extractFromResultSet(resultSet));
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


    /*
    *

List findBookByTitle(String title) : Keresse meg az összes könyvet cím alapján.
List findBookByGenre(String genre) : Keresse meg az összes könyvet műfaj alapján.
List findAllAvailableBooks() : Keresse meg az összes elérhető könyvet.
List findAllUnAvailableBooks() : Keresse meg az összes nem elérhető könyvet.
    *
    * */

    public Book findBookByIsbn(String isbn){
        return get(isbn).orElseThrow();
    }

    public List<String> listOfGenres(){
        String sql = "SELECT DISTINCT genre FROM BOOKS";
        List<String> genres = new ArrayList<>();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            while(resultSet.next()){
                genres.add(resultSet.getString(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return genres;
    }
    public List<String> listOfAuthors(){
        String sql = "SELECT DISTINCT author FROM BOOKS";
        List<String> authors = new ArrayList<>();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            while(resultSet.next()){
                authors.add(resultSet.getString(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return authors;
    }


    public List<Book> findBooksByAuthor(String author){
        String sql = "SELECT * FROM BOOKS WHERE author = ?";
        List<Book> booksByAuthor = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, author);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                booksByAuthor.add(extractFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return booksByAuthor;
    }
    public List<Book> findBooksByTitle(String author){
        String sql = "SELECT * FROM BOOKS WHERE title = ?";
        List<Book> booksByAuthor = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, author);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                booksByAuthor.add(extractFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return booksByAuthor;
    }
    public List<Book> findBooksByGenre(String author){
        String sql = "SELECT * FROM BOOKS WHERE genre = ?";
        List<Book> booksByAuthor = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, author);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                booksByAuthor.add(extractFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return booksByAuthor;
    }

    public List<Book> findAvailableBooks(){
        String sql = "SELECT * FROM BOOKS WHERE available = true";
        List<Book> booksByAuthor = new ArrayList<>();

        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                booksByAuthor.add(extractFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return booksByAuthor;
    }

    public List<Book> findUnAvailableBooks(){
        String sql = "SELECT * FROM BOOKS WHERE available = false";
        List<Book> booksByAuthor = new ArrayList<>();

        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                booksByAuthor.add(extractFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return booksByAuthor;
    }

    public String mostPopularAuthor(){
        String sql = "SELECT author, COUNT(ISBN) AS BC FROM BOOKS GROUP BY author ORDER BY BC DESC LIMIT 1";
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            while(resultSet.next()){
                return resultSet.getString(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;

    }

    public Map<String,Integer> authorsWithBookCount(){

        Map<String,Integer> map = new HashMap<>();
        String sql = "SELECT author, COUNT(ISBN) AS BC FROM BOOKS GROUP BY author ORDER BY BC DESC";
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            while(resultSet.next()){
                String author = resultSet.getString(1);
                int bookCount = resultSet.getInt(2);

                map.put(author,bookCount);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return map;
    }

    public Map<String,List<Book>> findAllBooksGroupedByGenre(){

        List<String> genres = listOfGenres();

        Map<String, List<Book>> collect = genres.stream()
                .collect(Collectors.toMap(s -> s, this::findBooksByGenre));


        return collect;
    }
    public Map<String,List<Book>> findAllBooksGroupedByAuthor(){

        List<String> authors = listOfAuthors();

        Map<String, List<Book>> collect = authors.stream()
                .collect(Collectors.toMap(s -> s, s -> findBooksByAuthor(s)));


        return collect;
    }

    public Map<String,List<Book>> findAllBooksGroupedByAvailability(){

        Map<String, List<Book>> map = new HashMap<>();
        map.put("Available",findAvailableBooks());
        map.put("Unavailable",findUnAvailableBooks());

        return map;
    }


    private Book extractFromResultSet(ResultSet resultSet) throws SQLException {
        String isbn = resultSet.getString(1);
        String title = resultSet.getString(2);
        String author = resultSet.getString(3);
        String genre = resultSet.getString(4);
        boolean available = resultSet.getBoolean(5);

        return new Book(isbn, title, author, genre, available);
    }
}
