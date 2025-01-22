package java_basics.tests;

import java_basics.TextAnalyzer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextAnalyzerTest {

    @Test
    public void testCountLetters() {

        String text = "96alm?afa27%!";
        int expectedNumberOfLetters = 6;

        int actualNumberOfLetters = new TextAnalyzer().countLetters(text);

        assertEquals(expectedNumberOfLetters,actualNumberOfLetters);

    }

    @Test
    public void testCountDigits() {

        String text = "96alm?afa27%!";
        int expectedNumberOfDigits = 4;

        int actualNumberOfDigits = new TextAnalyzer().countDigits(text);

        assertEquals(expectedNumberOfDigits,actualNumberOfDigits);

    }

    @Test
    public void testCountSpecialCharacters() {

        throw new UnsupportedOperationException();

    }

    @Test
    public void testWords() {

        throw new UnsupportedOperationException();

    }



}
