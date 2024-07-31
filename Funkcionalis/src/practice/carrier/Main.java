package practice.carrier;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        List<Order> orders = readModel();

        System.out.println(leastOrderDay(orders));
        System.out.println(getOrderByLocalDateTime(LocalDateTime.of(LocalDate.parse("2020-12-03"),LocalTime.parse("12:30")),orders));
        //System.out.println(getOrderByLocalDateTime(LocalDateTime.of(LocalDate.parse("2024-12-03"),LocalTime.parse("12:30")),orders));

        System.out.println(carrierStatistics(orders));
        System.out.println(mostFavoredAddress(orders));


        System.out.println();


    }

    private static Map<String,Long> carrierStatistics(List<Order> orders) {

        return orders.stream()
                .map(Order::getCarrier)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

    }


    private static Order getOrderByLocalDateTime(LocalDateTime localDateTime, List<Order> orders) {

        return orders.stream()
                .filter(order -> order.getLocalDateTime().equals(localDateTime))
                .findFirst()
                .orElseThrow();

    }

    private static LocalDate leastOrderDay(List<Order> orders) {

        return orders.stream()
                .map(order -> order.getLocalDateTime().toLocalDate())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .min(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElseThrow();

    }

    private static String mostFavoredAddress(List<Order> orders) {

        return orders.stream()
                .map(Order::getAddress)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElseThrow();

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