import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {
    private final List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public Book findBookByIsbn(String isbn) {
        Optional<Book> book = books.stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst();
        return book.orElse(null);
    }

    public List<String> listOfGenres() {
        return books.stream()
                .map(Book::getGenre)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> listOfAuthors() {
        return books.stream()
                .map(Book::getAuthor)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Book> findBookByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    public List<Book> findBookByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equals(title))
                .collect(Collectors.toList());
    }

    public List<Book> findBookByGenre(String genre) {
        return books.stream()
                .filter(book -> book.getGenre().equals(genre))
                .collect(Collectors.toList());
    }

    public List<Book> findAllAvailableBooks() {
        return books.stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }

    public List<Book> findAllUnavailableBooks() {
        return books.stream()
                .filter(book -> !book.isAvailable())
                .collect(Collectors.toList());
    }

    public String mostPopularAuthor() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No authors found");
    }

    public Map<String, List<Book>> findAllBooksGroupedByGenre() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getGenre));
    }

    public Map<String, List<Book>> findAllBooksGroupedByAuthor(){
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor));
    }

    public Map<Boolean, List<Book>> findAllBooksGroupedByAvailability(){
        return books.stream()
                .collect(Collectors.groupingBy(Book::isAvailable));
    }

    public Map<String, Integer> authorsWithBookCount(){
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.reducing(0, e -> 1, Integer::sum)));
    }


}
