package practice.books;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookTest {

    List<Book> testBooks;

    @BeforeEach
    public void initBooks(){
        testBooks = new ArrayList<>(List.of(
                new Book("978-0141036137", "To Kill a Mockingbird", "Harper Lee", "Fiction", true),
                new Book("978-1984801258", "Becoming", "Harper Lee", "Fiction", true),
                new Book("978-0061120084", "The Catcher in the Rye", "Harper Lee", "Fiction", true),
                new Book("978-0345803481", "1984", "Harper Lee", "Fiction", true),
                new Book("978-0062315007", "The Great Novel", "Harper Lee", "Fiction", true)
        ));
    }

    @Test
    public void findBookByIsbnTest(){

        String ISBN = UUID.randomUUID().toString();

        Book expected = new Book(ISBN, "To Kill a Mockingbird", "Harper Lee", "Fiction", true);

        testBooks.add(expected);

        Collections.shuffle(testBooks);

        BookStatistic bookStatistic = new BookStatistic(testBooks);

        Book actual = bookStatistic.findBookByIsbn(ISBN);

        assertEquals(expected,actual);
    }

    @Test
    public void findBookByIsbnThrowsExceptionIfISBNNotPresents(){

        String ISBN = UUID.randomUUID().toString();

        BookStatistic bookStatistic = new BookStatistic(testBooks);

        assertThrows(NoSuchElementException.class, () -> {
            bookStatistic.findBookByIsbn(ISBN);
        });
    }


}
