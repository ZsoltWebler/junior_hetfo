
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ReadTest {

    public static List<Movie> readModel() {

        List<Movie> movies = new ArrayList<Movie>();

        try {
            Scanner scanner = new Scanner(
                    new File("W:\\Webler\\Materials\\Git\\junior_hetfo\\junior_hetfo\\Algoritmusok\\src\\imdb_kaggle_updated.csv"));

            String line = scanner.nextLine();
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] values = line.split(";");
                //System.out.println();

                try {
                    movies.add(new Movie(
                            parseInt(values[0]),
                            parseInt(values[1]),
                            values[2],
                            values[3],
                            Double.parseDouble(values[4]),
                            !values[6].isBlank()? Integer.parseInt(values[6]):0,
                            values[7],
                            values[8]
                    ));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return movies;

    }



}