package databases.books;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {


        Connection connection = Database.getConnection();
        BookDao bookDao = new BookDao(connection);


        bookDao.listOfGenres().forEach(System.out::println);
        bookDao.listOfAuthors().forEach(System.out::println);
        bookDao.findBooksByAuthor("Harper Lee").forEach(System.out::println);
        bookDao.findBooksByTitle("The Secret").forEach(System.out::println);
        bookDao.findBooksByGenre("Thriller").forEach(System.out::println);
        System.out.println();

        System.out.println(bookDao.authorsWithBookCount());

        System.out.println(bookDao.findAllBooksGroupedByGenre());

    }



    private static List<Book> readModel() {

        List<Book> books = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("W:\\Webler\\Materials\\Git\\junior_hetfo\\junior_hetfo\\Funkcionalis\\src\\databases\\books\\books.csv"));

            String headers = scanner.nextLine();


            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(";");

                books.add(new Book(
                        values[0],
                        values[1],
                        values[2],
                        values[3],
                        values[4].equalsIgnoreCase("yes")
                ));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return books;
    }


}