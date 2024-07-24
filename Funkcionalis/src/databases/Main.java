package databases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Car> cars = readModel();



    }

    private static List<Car> readModel() {
        List<Car> cars = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("W:\\Webler\\Materials\\Git\\junior_hetfo\\junior_hetfo\\Funkcionalis\\src\\databases\\cars.csv"));

            String headers = scanner.nextLine();

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] values = line.split(",");

                cars.add(new Car(
                        values[0],
                        Integer.parseInt(values[1]),
                        Integer.parseInt(values[2]),
                        Integer.parseInt(values[3]),
                        values[4],
                        values[5],
                        values[6],
                        values[7]
                ));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        return cars;
    }
}