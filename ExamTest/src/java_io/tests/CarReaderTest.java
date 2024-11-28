package java_io.tests;

import java_io.Car;
import java_io.CarReader;
import java_io.FuelType;
import java_io.Transmission;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarReaderTest {

    private final String filePath = "src/java_io/cars.csv";
    List<Car> cars = CarReader.readCarsFromCSV(new File(filePath));

    public CarReaderTest() throws FileNotFoundException {
    }


    @Test
    public void carReaderTest_1() {
        assertEquals(4340, cars.size());
    }

    @Test
    public void carReaderTest_2() {
        assertEquals(new Car("Maruti 800 AC", 2007, 60000, 70000, FuelType.PETROL, Transmission.MANUAL), cars.get(0));
        assertEquals(new Car("Mahindra Scorpio M2DI", 2014, 550000, 90000, FuelType.DIESEL, Transmission.MANUAL), cars.get(2000));
        assertEquals(new Car("Hyundai i20 Active 1.2 SX", 2016, 650000, 26000, FuelType.PETROL, Transmission.MANUAL), cars.get(4000));
    }

    @Test
    public void carReaderTest_3() {

        assertEquals(3892, cars.stream().collect(Collectors.groupingBy(Car::getTransmission)).get(Transmission.MANUAL).size());
        assertEquals(448, cars.stream().collect(Collectors.groupingBy(Car::getTransmission)).get(Transmission.AUTOMATIC).size());
    }

    @Test
    public void carReaderTest_4() {

        long expected = 504127;

        long actual = Math.round(cars.stream().mapToDouble(Car::getPrice).average().orElseThrow());

        assertEquals(actual, expected);


    }

    @Test
    public void carReaderTest_5() {

        Map<FuelType, List<Car>> carsByFuelType = cars.stream().collect(Collectors.groupingBy(Car::getFuelType));
        assertEquals(2123, carsByFuelType.get(FuelType.PETROL).size());
        assertEquals(2153, carsByFuelType.get(FuelType.DIESEL).size());
        assertEquals(40, carsByFuelType.get(FuelType.CNG).size());
        assertEquals(23, carsByFuelType.get(FuelType.LPG).size());
        assertEquals(1, carsByFuelType.get(FuelType.ELECTRIC).size());

    }

    @Test
    public void carReaderTest_6() {
        int newestCar = 2020;
        int oldestCar = 1992;

        IntSummaryStatistics intSummaryStatistics = cars.stream().mapToInt(Car::getYear).summaryStatistics();

        assertEquals(newestCar, intSummaryStatistics.getMax());
        assertEquals(oldestCar, intSummaryStatistics.getMin());
    }
}
