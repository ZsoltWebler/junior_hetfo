package practice;

import java.util.ArrayList;
import java.util.List;

public class Homework {
    public static void main(String[] args) {

        String s1 = "valami";
        String s2 = "";




        reverseOrder(new ArrayList<>(List.of("a", "b", "c", "d")));


        List<Integer> numbers = new ArrayList<>();

        for(int i = 1; i <= 100 ; i++){
            numbers.add(i);
        }

        numbers.forEach(Homework::isPrime);

    }

    //1. Feladat
    public static void applyRule( String str) {


    }

    //2. Feladat
    public static void reverseOrder(List<String> list) {


        list.sort((o1, o2) -> o2.compareTo(o1));
        System.out.println(list);

    }

    public static void isPrime(int number) {

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                System.out.println(number + " is not a prime!");
            }
        }

        System.out.println(number + " is a prime!");

    }

}