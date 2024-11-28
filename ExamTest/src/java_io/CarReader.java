package java_io;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarReader {

    public static List<Car> readCarsFromCSV(File file) throws FileNotFoundException {

        List<Car> cars = new ArrayList<>();
        Scanner scanner = new Scanner(file);

        String headers = scanner.nextLine();

        while (scanner.hasNextLine()){

            String[] values = scanner.nextLine().split(",");

            Car car = new Car(
                    values[0],
                    Integer.parseInt(values[1]),
                    Integer.parseInt(values[2]),
                    Integer.parseInt(values[3]),
                    FuelType.of(values[4]),
                    Transmission.of(values[6])
            );
            cars.add(car);
        }



        return cars;
    }

}
