package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class UsaEmission {

    public static void main(String[] args) {
        List<EmissionRecord> recordList = readModel();

        System.out.println();
        mostEmitterSectorByStateAndYear(2005, "Alabama", recordList);
        mostEmitterStateByYear(2006,recordList);
    }

    private static List<EmissionRecord> readModel() {
        List<EmissionRecord> recordList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("W:\\Webler\\Materials\\Git\\junior_hetfo\\junior_hetfo\\Funkcionalis\\src\\practice\\usa_emission_.csv"));


            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                EmissionRecord record = new EmissionRecord(Integer.parseInt(values[0]), values[1], values[2], Fuel.parseFuel(values[3]), Double.parseDouble(values[4]));
                recordList.add(record);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return recordList;
    }

    private static void mostEmitterSectorByStateAndYear(int year, String stateName, List<EmissionRecord> recordList) {

        recordList
                .stream()
                .filter(emissionRecord -> emissionRecord.getYear() == year && emissionRecord.getStateName().equals(stateName))
                .collect(Collectors.groupingBy(EmissionRecord::getSectorName, Collectors.summingDouble(EmissionRecord::getValue)))
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .ifPresent(entry -> System.out.println(entry.getKey()));


    }

    private static void  mostEmitterStateByYear(int year, List<EmissionRecord> recordList){
        recordList
                .stream()
                .filter(emissionRecord -> emissionRecord.getYear() == year && !emissionRecord.getStateName().equals("United States"))
                .collect(Collectors.groupingBy(EmissionRecord::getStateName, Collectors.summingDouble(EmissionRecord::getValue)))
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .ifPresent(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
    }

}
