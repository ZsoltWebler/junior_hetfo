import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try {
            List<EmissionInfo> emissionInfoList = new ArrayList<>();
            Scanner scanner = new Scanner(new File("C:\\Users\\RN89\\junior_hetfo\\not_eclipse\\src\\usa_emission.csv"));
            scanner.nextLine();

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] values = line.split(",");
                emissionInfoList.add(new EmissionInfo(values[1],Integer.parseInt(values[0]),FuelName.parseFuelName(values[3]), Double.parseDouble(values[4]), values[2]));

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
