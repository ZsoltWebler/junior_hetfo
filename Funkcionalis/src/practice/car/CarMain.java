package practice.car;

import practice.Fuel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarMain {

    public static void main(String[] args) {
        List<CarEmissionInfo> carEmissionInfos = readModel();

        System.out.println(getMinCo2Emission(carEmissionInfos));
        System.out.println(getMaxCo2Emission(carEmissionInfos));
        System.out.println(getUniqueEngineSizeCount(carEmissionInfos));
        System.out.println(getAllManufacturer(carEmissionInfos));
        System.out.println(getAllEmissionInfoByEngineSize(8.0, carEmissionInfos));
        //System.out.println(getAllEmissionInfoOrderByCo2EmissionDesc(carEmissionInfos));
        Map<FuelType, List<CarEmissionInfo>> emissionInfoGroupByFuelType = getEmissionInfoGroupByFuelType(carEmissionInfos);
        System.out.println();
    }

    private static Map<FuelType, List<CarEmissionInfo>> getEmissionInfoGroupByFuelType(List<CarEmissionInfo> carEmissionInfos) {
        return carEmissionInfos.stream()
                .collect(Collectors.groupingBy(CarEmissionInfo::getFuelType));
    }

    private static List<CarEmissionInfo> getAllEmissionInfoOrderByCo2EmissionDesc(List<CarEmissionInfo> carEmissionInfos) {
        return carEmissionInfos.stream()
                .sorted((o1, o2) -> Integer.compare(o2.getCo2Emission(), o1.getCo2Emission()))
                .toList();
    }

    private static List<CarEmissionInfo> getAllEmissionInfoByEngineSize(double engineSize, List<CarEmissionInfo> carEmissionInfos) {
        return carEmissionInfos.stream()
                .filter(carEmissionInfo -> carEmissionInfo.getEngineSize() == engineSize)
                .toList();
    }

    private static List<String> getAllManufacturer(List<CarEmissionInfo> carEmissionInfos) {
        return carEmissionInfos.stream()
                .map(CarEmissionInfo::getManufacturer)
                .distinct()
                .toList();


    }

    private static long getUniqueEngineSizeCount(List<CarEmissionInfo> carEmissionInfos) {
        return carEmissionInfos.stream()
                .map(CarEmissionInfo::getEngineSize)
                .distinct()
                .count();
    }

    private static int getMinCo2Emission(List<CarEmissionInfo> carEmissionInfos) {
        return carEmissionInfos.stream()
                .min((o1, o2) -> Double.compare(o1.getCo2Emission(), o2.getCo2Emission())) // Comparator.comparingDouble(CarEmissionInfo::getCo2Emission)
                .orElseThrow()
                .getCo2Emission();
    }

    private static int getMaxCo2Emission(List<CarEmissionInfo> carEmissionInfos) {
        return carEmissionInfos.stream()
                .max((o1, o2) -> Double.compare(o1.getCo2Emission(), o2.getCo2Emission())) // Comparator.comparingDouble(CarEmissionInfo::getCo2Emission)
                .orElseThrow()
                .getCo2Emission();
    }

    private static List<CarEmissionInfo> readModel() {
        List<CarEmissionInfo> carEmissionInfoList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("W:\\Webler\\Materials\\Git\\junior_hetfo\\junior_hetfo\\Funkcionalis\\src\\practice\\car\\emission.csv"));

            String headers = scanner.nextLine();

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");

                CarEmissionInfo carEmissionInfo = new CarEmissionInfo(
                        values[0],
                        values[1],
                        Double.parseDouble(values[3]),
                        FuelType.parseFuelType(values[6]),
                        Integer.parseInt(values[11])
                );

                carEmissionInfoList.add(carEmissionInfo);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return carEmissionInfoList;
    }

}
