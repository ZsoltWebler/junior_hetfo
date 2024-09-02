package boardgame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        List<String> routes = readLines(new File("src/boardgame/osvenyek.txt"));
        List<Integer> rolls = Arrays.stream(readLines(new File("src/boardgame/dobasok.txt")).get(0).split(" ")).map(Integer::parseInt).toList();

        System.out.println("2. feladat");
        System.out.println("A dobások száma: " + rolls.size());
        System.out.println("Az ösvények száma: " + routes.size());

        System.out.println("3. feladat");
        int longestRouteIndex = longestRoute(routes);
        System.out.println("Az egyik leghosszabb a(z) " + (longestRouteIndex + 1) + " ösvény, hossza: " + routes.get(longestRouteIndex).length());

        Scanner scanner = new Scanner(System.in);

        System.out.print("Adja meg az ösvény sorszámát! ");
        int selectedRoute = scanner.nextInt();
        System.out.print("Adja meg a játékosok számát! ");
        int numberOfPlayers = scanner.nextInt();


    }

    private static List<String> readLines(File file) {
        List<String> lines = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return lines;
    }


    private static int longestRoute(List<String> routes) {

        return IntStream
                .range(0, routes.size())
                .mapToObj(index -> Map.entry(index, routes.get(index)))
                .max(Comparator.comparingInt(o -> o.getValue().length()))
                .orElseThrow()
                .getKey();


    }

}