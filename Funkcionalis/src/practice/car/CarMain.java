package practice.car;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarMain {

    public static void main(String[] args) {
        List<CarEmissionInfo> carEmissionInfos = readModel();

    }

    private static List<CarEmissionInfo> readModel() {
        List<CarEmissionInfo> carEmissionInfoList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("W:\\Webler\\Materials\\Git\\junior_hetfo\\junior_hetfo\\Funkcionalis\\src\\practice\\car\\emission.csv"));

            String headers = scanner.nextLine();

            while(scanner.hasNext()){
                String line = scanner.nextLine();
                String[] values = line.split(",");

                CarEmissionInfo carEmissionInfo = new CarEmissionInfo(
                        values[0],
                        values[1],
                        Double.parseDouble(values[3]),
                        FuelType.parseFuelType(values[6]),
                        Integer.parseInt(values[11])
                );
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return carEmissionInfoList;
    }

}
