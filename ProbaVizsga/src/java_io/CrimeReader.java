package java_io;


import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrimeReader {


    public static List<Crime> readCrimesFromCSV(File file) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);
        List<Crime> crimes = new ArrayList<>();

        scanner.nextLine();
        while (scanner.hasNextLine()) {

            String[] split = scanner.nextLine().split(",");
            String crimeCategory = split[1];
            String reportNumber = split[2];
            String[] date = split[3].split("/");
            LocalDate reportDate = LocalDate.of(Integer.parseInt(date[2]),Integer.parseInt(date[0]),Integer.parseInt(date[1]));
            String location = split[4];
            int beat = Integer.parseInt(split[5]);
            String neighborhood = split[6];
            String NPU = split[7];
            double latitude = Double.parseDouble(split[8]);
            double longitude = Double.parseDouble(split[9]);


            crimes.add(new Crime(crimeCategory,reportNumber,reportDate,location,beat,neighborhood,NPU,latitude,longitude));

        }
        return crimes;

    }



}
