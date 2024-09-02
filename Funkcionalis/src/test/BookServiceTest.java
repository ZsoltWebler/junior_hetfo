package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

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

    @Test
    public void listOfAuthorsTest() {
        List<String> expectedAuthors = List.of("Harper Lee", "Michelle Obama", "J.D. Salinger");
        List<String> actualAuthors = bookService.listOfAuthors();

        assertEquals(expectedAuthors, actualAuthors);

    }

    @Test
    public void listOfAuthorsShouldBeDistinctTest() {

        List<Book> books = new ArrayList<>(bookList);
        books.addAll(bookList);
        bookService = new BookService(books);

        List<String> expectedAuthors = List.of("Harper Lee", "Michelle Obama", "J.D. Salinger");
        List<String> actualAuthors = bookService.listOfAuthors();

        assertEquals(expectedAuthors, actualAuthors);

    }

    @Test
    public void findBooksByAuthorTest() {

        List<Book> expectedBooks = List.of(new Book("978-1984801258", "Becoming", "Michelle Obama", "Autobiography", true));
        List<Book> actualBooks = bookService.findBooksByAuthor("Michelle Obama");

        assertEquals(expectedBooks, actualBooks);

    }

    @Test
    public void findBooksByAuthorAllBooksShouldBeFoundTest() {

        List<Book> books = new ArrayList<>(bookList);
        books.add(new Book("978-1984801256", "Becoming 2", "Michelle Obama", "Autobiography", false));
        bookService = new BookService(books);

        List<Book> expectedBooks = List.of(
                new Book("978-1984801258", "Becoming", "Michelle Obama", "Autobiography", true),
                new Book("978-1984801256", "Becoming 2", "Michelle Obama", "Autobiography", false)
        );

        List<Book> actualBooks = bookService.findBooksByAuthor("Michelle Obama");

        assertEquals(expectedBooks, actualBooks);

    }

    @Test
    public void findBooksByTitleTest() {

        List<Book> expectedBooks = List.of(new Book("978-1984801258", "Becoming", "Michelle Obama", "Autobiography", true));
        List<Book> actualBooks = bookService.findBooksByTitle("Becoming");

        assertEquals(expectedBooks, actualBooks);

    }

    @Test
    public void findBooksByTitleAllBooksShouldBeFoundTest() {

        List<Book> books = new ArrayList<>(bookList);
        books.add(new Book("978-1984801256", "Becoming", "Michelle Obama", "Autobiography", false));
        bookService = new BookService(books);

        List<Book> expectedBooks = List.of(
                new Book("978-1984801258", "Becoming", "Michelle Obama", "Autobiography", true),
                new Book("978-1984801256", "Becoming", "Michelle Obama", "Autobiography", false)
        );

        List<Book> actualBooks = bookService.findBooksByTitle("Becoming");

        assertEquals(expectedBooks, actualBooks);

    }
    @Test
    public void mostPopularAuthorTest(){
        List<Book> books = new ArrayList<>(bookList);
        books.add(new Book("978-1984801256", "Becoming 2", "Michelle Obama", "Autobiography", false));
        bookService = new BookService(books);

        String expectedAuthor = "Michelle Obama";
        String actualAuthor = bookService.mostPopularAuthor();

        assertEquals(expectedAuthor, actualAuthor);
    }

    @Test
    public void mostPopularAuthorShouldThrowExceptionTest(){
        bookService = new BookService(List.of());

        assertThrows(NoSuchElementException.class,() -> bookService.mostPopularAuthor());
    }

    @Test
    public void  findAllBooksGroupedByGenreTest(){

        Map<String, List<Book>> expectedBookMap = Map.of(
                "Autobiography",List.of(
                        new Book("978-1984801258", "Becoming", "Michelle Obama", "Autobiography", true)
                ),
                "Fiction",List.of(
                        new Book("978-0141036137", "To Kill a Mockingbird", "Harper Lee", "Fiction", true),
                        new Book("978-0061120084", "The Catcher in the Rye", "J.D. Salinger", "Fiction", false)
                ));

        Map<String, List<Book>> actualBookMap = bookService.findAllBooksGroupedByGenre();

        assertEquals(expectedBookMap, actualBookMap);


    }

    @Test
    public void  authorsWithBookCount(){

        Map<String, Long> expectedBookMap = Map.of(
                "Harper Lee", 1L,
                "J.D. Salinger", 1L,
                "Michelle Obama", 1L
        );


        Map<String, Long> actualBookMap = bookService.authorsWithBookCount();

        assertEquals(expectedBookMap, actualBookMap);
    }


}
