package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class BookServiceTest {

    private BookService bookService;

    private final List<Book> bookList = List.of(
            new Book("978-0141036137", "To Kill a Mockingbird", "Harper Lee", "Fiction", true),
            new Book("978-1984801258", "Becoming", "Michelle Obama", "Autobiography", true),
            new Book("978-0061120084", "The Catcher in the Rye", "J.D. Salinger", "Fiction", false)
    );

    @BeforeEach
    public void setUpScenario() {
        bookService = new BookService(bookList);
    }

    @Test
    public void findBookByIsbnTest() {
        Book expectedBook = new Book("978-0141036137", "To Kill a Mockingbird", "Harper Lee", "Fiction", true);
        Book actualBook = bookService.findBookByIsbn("978-0141036137");

        assertEquals(expectedBook, actualBook);


    }

    @Test
    public void findBookByIsbnShouldThrowExceptionIfISBNIsNotPresentTest() {
        assertThrows(NoSuchElementException.class, () -> bookService.findBookByIsbn("TEST_ISBN"));
    }

    @Test
    public void listOfGenresTest() {
        List<String> expectedGenres = List.of("Fiction", "Autobiography");
        List<String> actualGenres = bookService.listOfGenres();

        assertEquals(expectedGenres, actualGenres);

    }

    @Test
    public void listOfGenresShouldBeDistinctTest() {

        List<Book> books = new ArrayList<>(bookList);
        books.addAll(bookList);
        bookService = new BookService(books);

        List<String> expectedGenres = List.of("Fiction", "Autobiography");
        List<String> actualGenres = bookService.listOfGenres();

        assertEquals(expectedGenres, actualGenres);

    }


}
