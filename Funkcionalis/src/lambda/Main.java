package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);


        integerList.sort((o1, o2) -> Integer.compare(o2,o1));


        Lambda l = (s) -> {
            System.out.println("Fire " + s);
        };

        l.fire("Kutya");

        System.out.println(integerList);

        List<String> messages = Arrays.asList("hello", "backend", "csoport!");

        messages.forEach(new Consumer<String>() { //Anonym
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        messages.forEach(word -> System.out.println(word)); //Lambda

        messages.forEach(System.out::println);






    }
}