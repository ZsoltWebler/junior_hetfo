package test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookService {

    private final List<Book> books;

    public BookService(List<Book> books) {
        this.books = books;
    }

    public Book findBookByIsbn(String isbn) {
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .orElseThrow();
    }

    public List<String> listOfGenres() {
        return books.stream()
                .map(Book::getGenre)
                .distinct()
                .toList();
    }

    public List<String> listOfAuthors() {
        return books.stream()
                .map(Book::getAuthor)
                .distinct()
                .toList();
    }

    public List<Book> findBooksByAuthor(String author) {

        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .toList();

    }

    public List<Book> findBooksByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equals(title))
                .toList();
    }

    public String mostPopularAuthor() {
        return authorsWithBookCount()
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .orElseThrow()
                .getKey();
    }

    public Map<String, List<Book>> findAllBooksGroupedByGenre() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getGenre));
    }

    public Map<String, Long>  authorsWithBookCount(){
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()));
    }

}
