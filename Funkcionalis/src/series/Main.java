package series;

import java.io.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        Scanner scanner;
        try {
            List<Series> series = readFile(new File("src/series/lista.txt"));

            System.out.println("2. feladat");

            long episodesWithReleaseDateCount = series.stream().filter(s -> s.getReleaseDate().isPresent()).count();

            System.out.println("\tA listában " + episodesWithReleaseDateCount + " db vetítési dátummal rendelkező epizód van.");
            double watchedRate = series.stream().filter(Series::isWatched).count() / (series.size() * 1.0);

            System.out.println("3. feladat");
            System.out.println("\tA listában lévő epizódok " + (Math.round(watchedRate * 10000) / 100.0) + "%-át látta.");
            long totalWatchedTime = series.stream().filter(Series::isWatched).mapToLong(Series::getPlayTime).sum();

            Duration duration = Duration.ofMinutes(totalWatchedTime);
            System.out.println("4. feladat");
            System.out.println("\tSorozatnézéssel " + duration.toDaysPart() + " napot " + duration.toHoursPart() + " órát és " + duration.toMinutesPart() + " percet töltött.");

            System.out.println("5. feladat");
            System.out.print("Adjon meg egy dátumot! Dátum= ");
            scanner = new Scanner(System.in);
            LocalDate untilDate = LocalDate.parse(scanner.nextLine().replaceAll("\\.", "-"));


            series.stream().filter(s -> !s.isWatched() && s.getReleaseDate().isPresent() && s.getReleaseDate().get().compareTo(untilDate) < 1).forEach(s -> {
                System.out.println(s.getSeason() + "x" + (s.getEpisode() < 10 ? "0" + s.getEpisode() : s.getEpisode()) + " " + s.getName());
            });


            System.out.print("Adja meg a hét egy napját (például cs)! Nap= ");
            String dayOfTheWeek = scanner.nextLine();

            series.stream()
                    .filter(s -> s.getReleaseDate().isPresent())
                    .filter(s -> {
                        LocalDate localDate = s.getReleaseDate().get();

                        return dayOfTheWeek.equals(hetnapja(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth()));
                    })
                    .map(Series::getName)
                    .distinct()
                    .forEach(System.out::println);


            Map<String, Integer> seriesGroupedByLength = series.stream().collect(Collectors.groupingBy(Series::getName, Collectors.summingInt(Series::getPlayTime)));
            Map<String, List<Series>> seriesGroupedByEpisodeCount = series.stream().collect(Collectors.groupingBy(Series::getName));

            System.out.println();

            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/series/summa.txt"));

                seriesGroupedByLength.forEach((s, integer) -> {
                    try {
                        bufferedWriter.write(s + " " + integer + " " + seriesGroupedByEpisodeCount.get(s).size()+ "\n");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

                bufferedWriter.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static String hetnapja(int year, int month, int day) {
        List<String> daysOfTheWeek = List.of("v", "h", "k", "sz", "cs", "p", "sz");
        List<Integer> months = List.of(0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4);

        if (month < 3) {
            year--;
        }
        return daysOfTheWeek.get((year + year / 4 - year / 100 + year / 400 + months.get(month - 1) + day) % 7);

    }

    private static List<Series> readFile(File file) throws FileNotFoundException {
        List<Series> series = new ArrayList<>();

        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {

            String releaseDateString = scanner.nextLine().replaceAll("\\.", "-");
            Optional<LocalDate> releaseDate = releaseDateString.equalsIgnoreCase("NI")
                    ? Optional.empty()
                    : Optional.of(LocalDate.parse(releaseDateString));

            String title = scanner.nextLine();

            String[] seasonAndEpisode = scanner.nextLine().split("x");
            int season = Integer.parseInt(seasonAndEpisode[0]);
            int episode = Integer.parseInt(seasonAndEpisode[1]);

            int playTime = Integer.parseInt(scanner.nextLine());
            boolean watched = scanner.nextLine().equals("1");

            series.add(new Series(releaseDate, title, season, episode, playTime, watched));

        }


        return series;
    }

}