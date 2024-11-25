package java_basics.tests;

import java_basics.TimestampGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TimestampGeneratorTest {


    @Test
    public void testGenerateTimeStampHappyPath() {
        String actual = TimestampGenerator.generateTimeStampDayAccuracy(2000, 11, 27);
        String expected = "20001127";

        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateTimeStampSecondAccuracyHappyPath() {
        String actual = TimestampGenerator.generateTimeStampDayAccuracy(2000, 11, 27,12,11);
        String expected = "200011271211";

        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateTimeStampShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> TimestampGenerator.generateTimeStampDayAccuracy(2000, 13, 27));
    }

    @Test
    public void testGenerateTimeStampSecondAccuracyShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> TimestampGenerator.generateTimeStampDayAccuracy(2000, 12, 27,61,30));
    }


}
