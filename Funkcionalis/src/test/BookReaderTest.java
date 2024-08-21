package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookReaderTest {

    @Test
    public void readBooksFromCsvTest() {


        List<Book> expectedBooks = List.of(
                new Book("978-0141036137","To Kill a Mockingbird","Harper Lee","Fiction",true),
                new Book("978-1984801258","Becoming","Michelle Obama","Autobiography",true),
                new Book("978-0061120084","The Catcher in the Rye","J.D. Salinger","Fiction",false)
        );

        BookReader bookReader = new BookReader();
        List<Book> actualBooks = bookReader.readBooksFromCsv(new File("W:\\Webler\\Materials\\Git\\junior_hetfo\\junior_hetfo\\Funkcionalis\\src\\test\\books_test.csv"));

       assertEquals(expectedBooks,actualBooks);


    }
}
