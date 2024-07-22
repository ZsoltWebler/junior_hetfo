package practice.books;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class BookMain {

    public static void main(String[] args) {

        List<Book> books = readModel();
        System.out.println(findBookByIsbn("978-0345803481", books));
        System.out.println(listOfGenres(books));
        System.out.println(listOfAuthors(books));
        System.out.println(findBookByAuthor("George Orwell", books));
        System.out.println(findBookByTitle("The Da Vinci Code", books));
        System.out.println(findBookByGenre("Fantasy", books));
        System.out.println(findAllAvailableBooks(books));
        System.out.println(findAllUnAvailableBooks(books));
        System.out.println(mostPopularAuthor(books));
        System.out.println(findAllBooksGroupedByGenre(books));
        System.out.println(findAllBooksGroupedByAuthor(books));
        System.out.println();
        System.out.println(findAllBooksGroupedByAvailability(books));
        System.out.println();
        System.out.println(authorsWithBookCount(books));



    }

    private static List<Book> readModel() {
        List<Book> books = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("W:\\Webler\\Materials\\Git\\junior_hetfo\\junior_hetfo\\Funkcionalis\\src\\practice\\books\\books.csv"));
            String header = scanner.nextLine();

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                String[] values = line.split(";");

                Book book = new Book(values[0], values[1], values[2], values[3], values[4].equals("Yes"));
                books.add(book);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return books;
    }

    public static Book findBookByIsbn(String isbn, List<Book> books) {
        return books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst().orElseThrow();
    }

    public static List<String> listOfGenres(List<Book> books) {
        return books.stream()
                .map(Book::getGenre)
                .distinct()
                .toList();
    }

    public static List<String> listOfAuthors(List<Book> books) {
        return books.stream()
                .map(Book::getAuthor)
                .distinct()
                .toList();
    }

    public static List<Book> findBookByAuthor(String author, List<Book> books) {

        return books.stream().filter(book -> book.getAuthor().equals(author)).toList();
    }

    public static List<Book> findBookByTitle(String title, List<Book> books) {

        return books.stream().filter(book -> book.getTitle().equals(title)).toList();
    }

    public static List<Book> findBookByGenre(String genre, List<Book> books) {

        return books.stream().filter(book -> book.getGenre().equals(genre)).toList();
    }

    public static List<Book> findAllAvailableBooks(List<Book> books) {

        return books.stream().filter(Book::isAvailable).toList();
    }

    public static List<Book> findAllUnAvailableBooks(List<Book> books) {

        return books.stream().filter(book -> !book.isAvailable()).toList();
    }

    public static String mostPopularAuthor(List<Book> books) {

        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .orElseThrow()
                .getKey();
    }

    public static Map<String, List<Book>> findAllBooksGroupedByGenre(List<Book> books) {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getGenre));
    }

    public static Map<String, List<Book>> findAllBooksGroupedByAuthor(List<Book> books) {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor));
    }

    public static Map<Boolean, List<Book>> findAllBooksGroupedByAvailability(List<Book> books) {
        return books.stream()
                .collect(Collectors.groupingBy(Book::isAvailable));
    }
    public static Map<String, Long> authorsWithBookCount(List<Book> books) {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()));
    }

}
