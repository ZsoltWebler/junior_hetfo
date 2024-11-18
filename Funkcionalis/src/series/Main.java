package series;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        try {
            List<Series> series = readFile(new File("src/series/lista.txt"));

            System.out.println();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


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

            series.add(new Series(releaseDate,title,season,episode,playTime,watched));

        }


        return series;
    }

}