package java_io.tests;

import org.junit.jupiter.api.Test;
import java_io.Car;
import java_io.CarReader;
import java_io.FuelType;
import java_io.Transmission;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class CarReaderTest {

    private final String filePath = "W:\\Webler\\JuniorJava\\Git\\java\\Final\\src\\test_exam_4\\java_io\\cars.csv";
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
        //todo
        fail();
    }

    @Test
    public void carReaderTest_5() {
        //todo
        fail();
    }

    @Test
    public void carReaderTest_6() {
        //todo
        fail();
    }
}
