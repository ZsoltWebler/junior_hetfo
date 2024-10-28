package property_tax;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static Map<String, Integer> taxCategoryMap;

    public static void main(String[] args) {


        List<Property> properties = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("src/property_tax/utca.txt"));

            String[] taxCategories = scanner.nextLine().split(" ");
            taxCategoryMap = Map.of("A", Integer.parseInt(taxCategories[0]), "B", Integer.parseInt(taxCategories[1]), "C", Integer.parseInt(taxCategories[2]));


            while (scanner.hasNextLine()) {

                String[] propertyValues = scanner.nextLine().split(" ");
                properties.add(new Property(
                        Integer.parseInt(propertyValues[0]),
                        propertyValues[1],
                        propertyValues[2],
                        propertyValues[3],
                        Integer.parseInt(propertyValues[4])
                ));

            }

        } catch (FileNotFoundException e) {

        }


        System.out.println("2. feladat. A mintában " + properties.size() + " telek szerepel.");

        System.out.print("3. feladat. Egy tulajdonos adószáma: ");
        Scanner scanner = new Scanner(System.in);
        int taxNumber = Integer.parseInt(scanner.nextLine());
        properties.stream().filter(property -> property.getTaxNumber() == taxNumber).forEach(
                property -> {
                    System.out.println(property.getStreet() + " " + property.getHouseNumber());
                }
        );

        System.out.println("5. feladat");
        properties.stream().collect(Collectors.groupingBy(Property::getTaxRate)).forEach(
                (taxCategory, propertyList) -> {
                    int value = propertyList
                            .stream()
                            .mapToInt(property -> property.getArea() * taxCategoryMap.get(taxCategory))
                            .filter(price -> price >= 10000)
                            .sum();

                    System.out.println(taxCategory + " sávba " + propertyList.size() + " telek esik, az adó " + value + " Ft.");
                }
        );

        System.out.println("6. feladat");

        properties.stream().collect(Collectors.groupingBy(Property::getStreet)).forEach(
                (street, propertyList) -> {
                    if (propertyList.stream().map(Property::getTaxRate).distinct().count() > 1) {
                        System.out.println(street);
                    }
                }
        );

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("src/property_tax/fizetendo.txt")));

            properties.stream().collect(Collectors.groupingBy(Property::getTaxNumber)).forEach(
                    (taxCode, propertyList) -> {
                        int value = propertyList
                                .stream()
                                .mapToInt(property -> property.getArea() * taxCategoryMap.get(property.getTaxRate()))
                                .filter(price -> price >= 10000)
                                .sum();

                        try {
                            bufferedWriter.write(taxCode + " " + value + "\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );

            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private static int tax(String taxCategory, int area) {
        return taxCategoryMap.get(taxCategory) * area;
    }
}