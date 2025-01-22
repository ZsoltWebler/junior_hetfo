package java_io.tests;

import java_io.Book;
import java_io.BookReader;
import java_io.Genre;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class BookReaderTest {

    private final String filePath = "src/java_io/amazon_books.csv";
    List<Book> bookList = BookReader.readBooksFromCsv(new File(filePath));

    public BookReaderTest() throws FileNotFoundException {
    }


    @Test
    public void bookReadTest_1() {
        assertEquals(bookList.size(), 550);
    }

    @Test
    public void bookReadTest_2() {
        Map<Genre, List<Book>> genreListMap = bookList.stream().collect(Collectors.groupingBy(Book::getGenre));

        assertEquals(genreListMap.get(Genre.FICTION).size(), 240);
        assertEquals(genreListMap.get(Genre.NON_FICTION).size(), 310);
        assertFalse(genreListMap.containsKey(Genre.UNKNOWN));
    }

    @Test
    public void bookReadTest_3() {
        double averagePrice = bookList.stream().mapToInt(Book::getPrice).average().orElseThrow();
        assertEquals(averagePrice, 13.1);
    }

    @Test
    public void bookReadTest_4() {
        assertEquals(bookList.stream().mapToLong(Book::getReviews).sum(), 6574305);
    }

    @Test
    public void bookReadTest_5() {

        throw new UnsupportedOperationException();
    }


}
