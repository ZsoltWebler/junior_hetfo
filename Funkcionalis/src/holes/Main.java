package holes;

import java.io.*;
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

        long untouched = depths.stream().filter(depth -> depth > 0).count();

        System.out.println("Az érintetlen terület aránya " + (Math.round((1.0 - (untouched * 1.0 / depths.size())) * 10000) / 100.0) + "%");


        List<List<Integer>> holes = new ArrayList<>();


        boolean inDaHole = false;
        List<Integer> hole = new ArrayList<>();
        for (int i = 0; i < depths.size(); i++) {

            if (depths.get(i) == 0 && inDaHole) {
                holes.add(hole);
                hole = new ArrayList<>();
                inDaHole = false;
                continue;
            }
            if (depths.get(i) != 0) {
                hole.add(depths.get(i));
                inDaHole = true;
            }
        }

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("godrok.txt"));

            holes.forEach(list -> {
                list.forEach(integer -> {
                    try {
                        bufferedWriter.write(integer + " ");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                try {
                    bufferedWriter.write("\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("5. feladat\n" +
                "A gödrök száma: " + holes.size());


        int leftBorder = -1;
        int rightBorder = -1;

        Integer userSelection = depths.get(userInput - 1);

        for (int i = (userInput - 1); i < depths.size(); i++) {
            if (depths.get(i) == 0) {
                rightBorder = i - 1;
                break;
            }
        }

        for (int i = (userInput - 1); i > 0; i--) {
            if (depths.get(i) == 0) {
                leftBorder = i + 1;
                break;
            }
        }

        System.out.println("A gödör kezdete: " + (leftBorder + 1) + " méter, a gödör vége: " + (rightBorder + 1) + " méter.");

        boolean depthChange = false;
        boolean monoton = true;
        for (int i = leftBorder; i < rightBorder; i++) {

            if (depths.get(i + 1) > depths.get(i)) {
                if (depthChange) {
                    monoton = false;
                    break;
                }
                depthChange = true;
            }

        }

        if (monoton) {
            System.out.println("Folyamatosan mélyül");
        } else {
            System.out.println("Nem mélyül folyamatosan");
        }


        int minDepth = Integer.MIN_VALUE;
        for (int i = leftBorder; i < rightBorder; i++) {

            if (depths.get(i) > minDepth) {
                minDepth = depths.get(i);
            }

        }

        System.out.println("A legnagyobb mélysége "+minDepth+" méter.");

        int sumDepth = 0;
        int otherSumDepth = 0;
        for (int i = leftBorder; i <= rightBorder; i++) {
            sumDepth+= depths.get(i);
            otherSumDepth+=depths.get(i)-1;
        }

        System.out.println("A térfogata "+(sumDepth*10)+" m^3.");
        System.out.println("A vízmennyiség "+(otherSumDepth*10)+" m^3");



    }
}