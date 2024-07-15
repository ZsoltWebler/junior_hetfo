package anonym;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Trigger trigger = new TriggerImpl();

        Trigger anonym = new Trigger() {
            @Override
            public void trigger() {
                System.out.println("Trigger from anonym class");
            }
        };

        trigger.trigger();
        anonym.trigger();

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);

        integerList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }
        });

        Animal animal = new Animal("Kutya") {
            @Override
            public void makeSound() {
                System.out.println("Vau Vau");
            }

        };

        System.out.println(animal.getName());
        animal.makeSound();

        System.out.println(integerList);





    }
}