package rgb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Image image;
        try {
            image = new Image(readFile(new File("src/rgb/kep.txt")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        try {
            image.writeImageToFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("2. feladat:\n" +
                "Kérem egy képpont adatait!");

        System.out.print("Sor: ");
        int row = scanner.nextInt();
        System.out.print("Oszlop: ");
        int column = scanner.nextInt();
        Color color = image.getColor(row, column);

        System.out.println(color);

        System.out.println("3. feladat:\n" +
                "A világos képpontok száma: " + image.getBrightPixelCount());


        System.out.println("4. feladat:\n" +
                "A legsötétebb pont RGB összege: " + image.darkestColorIntensity().getIntensity());

        System.out.println("A legsötétebb pixelek színe:");
        image.listOfDarkestColors().forEach(System.out::println);

        for(int i = 1; i < image.getHeight(); i++){

            if(image.border(i,10)){
                System.out.println("A felhő legfelső sora: "+i);
                break;
            }

        }

    }

    private static List<List<Color>> readFile(File file) throws FileNotFoundException {
        List<List<Color>> pixels = new ArrayList<>();

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            List<Color> row = new ArrayList<>();
            String line = scanner.nextLine();
            String[] values = line.split(" ");

            for (int i = 0; i < values.length; i += 3) {
                row.add(new Color(Integer.parseInt(values[i]), Integer.parseInt(values[1 + i]), Integer.parseInt(values[2 + i])));
            }

            pixels.add(row);
        }

        return pixels;

    }
}