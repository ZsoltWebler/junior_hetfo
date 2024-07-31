package practice.carrier;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        List<Order> orders = readModel();


    }

    private static boolean isDate(String str) {

        try {
            LocalDate.parse(str.replace(".", "-"));
        } catch (DateTimeParseException ex) {
            return false;
        }
        return true;

    }


    public static List<Order> readModel() {

        List<Order> orders = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("W:\\Webler\\Materials\\Git\\junior_hetfo\\junior_hetfo\\Funkcionalis\\src\\practice\\carrier\\orders.txt"));

            LocalDate currentDate = LocalDate.parse(scanner.nextLine().replace(".", "-"));

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                if (isDate(line)) {
                    currentDate = LocalDate.parse(line.replace(".", "-"));
                    line = scanner.nextLine();
                }

                String carrierId = line;
                String addressAndTime = scanner.nextLine();
                String[] values = addressAndTime.split(" ");

                LocalTime time = LocalTime.parse(values[3]);

                Order order = new Order(carrierId, LocalDateTime.of(currentDate, time), values[0] + " " + values[1] + " " + values[2]);
                orders.add(order);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }
}