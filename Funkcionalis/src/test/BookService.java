package test;

import java.util.List;

public class BookService {

    private final List<Book> books;

    public BookService(List<Book> books) {
        this.books = books;
    }

    public Book findBookByIsbn(String isbn){
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .orElseThrow();
    }

    public List<String> listOfGenres(){
        return books.stream()
                .map(Book::getGenre)
                .distinct()
                .toList();
    }

    public List<String> listOfAuthors(){
        return books.stream()
                .map(Book::getAuthor)
                .distinct()
                .toList();
    }

    public List<Book> findBooksByAuthor(String author){

        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .toList();

    }
}
