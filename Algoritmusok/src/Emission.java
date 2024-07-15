import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Emission {

    public static void main(String... args) {

        List<EmissionRecord> emissionRecordList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("W:\\Webler\\Materials\\Git\\junior_hetfo\\junior_hetfo\\Algoritmusok\\src\\usa_emission.csv"));


            String line = scanner.nextLine();

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] values = line.split(",");

                emissionRecordList.add(
                        new EmissionRecord(
                                Integer.parseInt(values[0]),
                                values[1],
                                values[2],
                                FuelName.parseFuelName(values[3]),
                                Double.parseDouble(values[4]))
                );


            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println();

    }
}
