package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void init() {
        calculator = new Calculator();
    }

    @Test
    public void addTest() {

        Random random = new Random();

        int numberToAdd = random.nextInt();
        int otherNumberToAdd = random.nextInt();

        int expected = numberToAdd + otherNumberToAdd;

        int actual = calculator.add(numberToAdd, otherNumberToAdd);

        assertEquals(expected, actual);

    }

    @Test
    public void subtractTest() {

        Random random = new Random();

        int numberToSubtract = random.nextInt();
        int otherNumberToSubtract = random.nextInt();

        int expected = numberToSubtract - otherNumberToSubtract;

        int actual = calculator.subtract(numberToSubtract, otherNumberToSubtract);

        assertEquals(expected, actual);

    }

    @Test
    public void multiplyTest() {

        Random random = new Random();

        int numberToMultiply = random.nextInt();
        int otherNumberToMultiply = random.nextInt();

        int expected = numberToMultiply * otherNumberToMultiply;

        int actual = calculator.multiply(numberToMultiply, otherNumberToMultiply);

        assertEquals(expected, actual);

    }

    @Test
    public void divideTest() {

        Random random = new Random();

        int numberToDivide = random.nextInt();
        int otherNumberToDivide = random.nextInt();

        int expected = numberToDivide / otherNumberToDivide;

        int actual = calculator.divide(numberToDivide, otherNumberToDivide);

        assertEquals(expected, actual);

    }

    @Test
    public void divideShouldThrowsExceptionIfDivisorIsZero() {

        Random random = new Random();

        int numberToDivide = random.nextInt();
        int zero = 0;

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->
                calculator.divide(numberToDivide, zero));


        assertEquals("Cannot divide by zero!",illegalArgumentException.getMessage());


    }


}
