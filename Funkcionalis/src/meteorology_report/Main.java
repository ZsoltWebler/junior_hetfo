package meteorology_report;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            List<MeteorologyReport> meteorologyReports = readReports(new File("src/meteorology_report/tavirathu13.txt"));
            MeteorologyReportAnalyzer analyzer = new MeteorologyReportAnalyzer(meteorologyReports);


            analyzer.mediumTemperatureForCity("BP");
            analyzer.temperatureFluctuation("BP");

            Scanner scanner = new Scanner(System.in);

            System.out.println("2. feladat\n" +
                    "Adja meg egy település kódját! Település: ");
            String cityCode = scanner.nextLine();

            LocalTime lastReportFromCity = analyzer.lastReportFromCity(cityCode);
            System.out.println("Az utolsó mérési adat a megadott településről "+lastReportFromCity+"-kor érkezett.");


            MeteorologyReport maxTemp = analyzer.maxTemperature();
            MeteorologyReport minTemp = analyzer.minTemperature();


            System.out.println("3. feladat\n" +
                    "A legalacsonyabb hőmérséklet: "+minTemp.getCityCode()+" "+minTemp.getReportTime()+" "+minTemp.getTemperature()+" fok.\n" +
                    "A legmagasabb hőmérséklet: "+maxTemp.getCityCode()+" "+maxTemp.getReportTime()+" "+maxTemp.getTemperature()+" fok.");


            List<MeteorologyReport> fromCalmWindCities = analyzer.reportsFromCalmWindCities();

            System.out.println("4. feladat");
            if(fromCalmWindCities.isEmpty()){
                System.out.println("Nem volt szélcsend a mérések idején");
            }

            fromCalmWindCities.forEach(
                    meteorologyReport -> System.out.println(meteorologyReport.getCityCode() + " " + meteorologyReport.getReportTime())
            );

            System.out.println("5. feladat");
            analyzer.getTemperatureStatistics().forEach(tps -> System.out.println(tps.getCityCode() + (tps.getMediumTemperature().isPresent() ? " Középhőmérséklet: " + tps.getMediumTemperature().get() : " NA") +"; Hőmérséklet-ingadozás: " + tps.getTemperatureFluctuation()));


            Map<String, List<RecordTimeAndWindStrengthAsString>> stringListMap = analyzer.reportsByCities();
            stringListMap.forEach((city, tempsAndStrengths) -> {
                System.out.println(city);
                tempsAndStrengths.forEach(System.out::println);
            });

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<MeteorologyReport> readReports(File file) throws FileNotFoundException {
        List<MeteorologyReport> meteorologyReports = new ArrayList<>();

        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()){
            String[] values = scanner.nextLine().split(" ");

            String cityCode = values[0];
            int hourPart = Integer.parseInt(values[1].substring(0,2));
            int minutePart = Integer.parseInt(values[1].substring(2,4));
            String windDirection = values[2].substring(0,3);
            int windStrength = Integer.parseInt(values[2].substring(3,5));
            int temperature = Integer.parseInt(values[3]);

            meteorologyReports.add(new MeteorologyReport(
                    cityCode,
                    LocalTime.of(hourPart, minutePart),
                    windDirection,
                    windStrength,
                    temperature
            ));

        }

        return meteorologyReports;
    }




}