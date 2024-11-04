package holes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Integer> depths = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("src/holes/melyseg.txt"));

            while (scanner.hasNextLine()) {
                int depth = Integer.parseInt(scanner.nextLine());
                depths.add(depth);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("1. feladat\n" +
                "A fájl adatainak száma: " + depths.size());

        System.out.println("2. feladat");
        System.out.print("Adjon meg egy távolság értéket: ");
        Scanner consoleScanner = new Scanner(System.in);
        int userInput = consoleScanner.nextInt();
        System.out.println("Ezen a helyen a felszín " + depths.get(userInput - 1) + " méter mélyen van.\n");
    }
}