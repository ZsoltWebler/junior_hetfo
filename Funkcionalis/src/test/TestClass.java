package test;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {


    List<Integer> allEven = List.of(2, 4, 6);

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all");
    }


    @BeforeEach
    public void beforeEach() {
        System.out.println("Before each");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("After each");
    }


    private List<Integer> filterOdds(List<Integer> list) {
        return list.stream().filter(i -> i % 2 == 0).toList();
    }


    @Test
    public void elsoTeszt() {

        List<Integer> testList = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> evens = filterOdds(testList);
        evens.forEach(number -> assertEquals(0, number % 2));
    }

    @Test
    @DisplayName("Második teszt")
    public void masodikTeszt() {
        List<Integer> testList = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> expected = List.of(2, 4, 6, 8);
        List<Integer> actual = filterOdds(testList);

        assertEquals(expected,actual);


    }

    @Test
    @Disabled
    public void disabledTeszt() {
        System.out.println("Kikapcsolt Teszt");
    }

}
