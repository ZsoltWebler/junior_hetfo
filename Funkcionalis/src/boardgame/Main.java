package boardgame;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
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

        System.out.println("4. feladat");
        System.out.print("Adja meg az ösvény sorszámát! ");
        int selectedRoute = scanner.nextInt();
        System.out.print("Adja meg a játékosok számát! ");
        int numberOfPlayers = scanner.nextInt();


        Map<String, Long> routeStatistics = routeStatistics(routes.get(selectedRoute - 1));
        System.out.println("5. feladat");
        System.out.println("M: " + routeStatistics.get("M") + " darab");
        System.out.println("V: " + routeStatistics.get("V") + " darab");
        System.out.println("E: " + routeStatistics.get("E") + " darab");

        Map<Integer, Character> specialFields = specialFields(routes.get(selectedRoute - 1));
        writeSpecialFieldsToFile(new File("src/boardgame/kulonleges.txt"), specialFields);

        getWinnerEasy(routes.get(selectedRoute - 1), rolls, numberOfPlayers);

    }

    public static List<String> readLines(File file) {
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


    public static int longestRoute(List<String> routes) {

        return IntStream.range(0, routes.size()).mapToObj(index -> Map.entry(index, routes.get(index))).max(Comparator.comparingInt(o -> o.getValue().length())).orElseThrow().getKey();


    }


    public static Map<String, Long> routeStatistics(String route) {

        return Arrays.stream(route.split("")).collect(Collectors.groupingBy(o -> o, Collectors.counting()));
    }

    public static Map<Integer, Character> specialFields(String route) {


        String[] characters = route.split("");
        List<String> fields = Arrays.stream(characters).toList();

        Map<Integer, Character> specFields = new HashMap<>();

        for (int i = 0; i < fields.size(); i++) {
            String field = fields.get(i);
            if (!field.equals("M")) {
                specFields.put(i, field.charAt(0));
            }
        }


        return IntStream.range(0, route.length()).filter(index -> route.charAt(index) != 'M').mapToObj(index -> Map.entry(index, route.charAt(index))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }

    public static void writeSpecialFieldsToFile(File file, Map<Integer, Character> specialFields) {


        ArrayList<Map.Entry<Integer, Character>> entries = new ArrayList<>(specialFields.entrySet());

        entries.sort(Comparator.comparingInt(Map.Entry::getKey));

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

            for (Map.Entry<Integer, Character> entry : entries) {
                bufferedWriter.write(entry.getKey() + "\t" + entry.getValue() + "\n");
            }

            bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static void getWinnerEasy(String route, List<Integer> rolls, int numberOfPlayers) {
        int goalIndex = route.length();

        Map<Integer, Integer> players = new HashMap<>();

        for (int currentPlayer = 1; currentPlayer <= numberOfPlayers; currentPlayer++) {
            players.put(currentPlayer, 0);
        }


        int rollIndex = 0;
        int round = 1;

        while (rollIndex<rolls.size()) {
            for (Map.Entry<Integer, Integer> player : players.entrySet()) {

                int newPosition = players.get(player.getKey()) + rolls.get(rollIndex);
                players.put(player.getKey(), newPosition);

                if(newPosition >= goalIndex){
                    System.out.println("A játék a(z) "+round+". körben fejeződött be. A legtávolabb jutó sorszáma: " + player.getKey());
                    return;
                }

                rollIndex++;
            }
            round++;

        }
    }
}