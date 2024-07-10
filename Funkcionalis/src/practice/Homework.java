package practice;

import java.util.ArrayList;
import java.util.List;

public class Homework {
    public static void main(String[] args) {

        String s1 = "valami";
        String s2 = "";

        applyRule(str -> str.isEmpty(), s1);
        applyRule(str -> str.isEmpty(), s2);


        reverseOrder(new ArrayList<>(List.of("a", "b", "c", "d")));


        List<Integer> numbers = new ArrayList<>();

        for(int i = 1; i <= 100 ; i++){
            numbers.add(i);
        }

        numbers.forEach(Homework::isPrime);

    }

    //1. Feladat
    public static void applyRule(StringRule rule, String str) {


        String isEmpty = rule.apply(str) ? "" : "nem ";
        System.out.println("A kapott string " + isEmpty + "üres!");

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