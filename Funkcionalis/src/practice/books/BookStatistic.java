package practice.books;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookStatistic {

    private final List<Book> bookList;

    public BookStatistic(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Book findBookByIsbn(String isbn) {
        return bookList.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst().orElseThrow();
    }

    public List<String> listOfGenres() {
        return bookList.stream()
                .map(Book::getGenre)
                .distinct()
                .toList();
    }

    public List<String> listOfAuthors() {
        return bookList.stream()
                .map(Book::getAuthor)
                .distinct()
                .toList();
    }

    public List<Book> findBookByAuthor(String author) {

        return bookList.stream().filter(book -> book.getAuthor().equals(author)).toList();
    }

    public List<Book> findBookByTitle(String title) {

        return bookList.stream().filter(book -> book.getTitle().equals(title)).toList();
    }

    public List<Book> findBookByGenre(String genre) {

        return bookList.stream().filter(book -> book.getGenre().equals(genre)).toList();
    }

    public List<Book> findAllAvailableBooks() {

        return bookList.stream().filter(Book::isAvailable).toList();
    }

    public List<Book> findAllUnAvailableBooks() {

        return bookList.stream().filter(book -> !book.isAvailable()).toList();
    }

    public String mostPopularAuthor() {

        return bookList.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .orElseThrow()
                .getKey();
    }

    public Map<String, List<Book>> findAllBooksGroupedByGenre() {
        return bookList.stream()
                .collect(Collectors.groupingBy(Book::getGenre));
    }

    public Map<String, List<Book>> findAllBooksGroupedByAuthor() {
        return bookList.stream()
                .collect(Collectors.groupingBy(Book::getAuthor));
    }

    public Map<Boolean, List<Book>> findAllBooksGroupedByAvailability() {
        return bookList.stream()
                .collect(Collectors.groupingBy(Book::isAvailable));
    }

    public Map<String, Long> authorsWithBookCount() {
        return bookList.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()));
    }
}
