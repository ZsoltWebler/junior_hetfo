package java_io;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        try {
            CrimeReader.readCrimesFromCSV(new File("W:\\Webler\\JuniorJava\\Git\\java\\Final\\src\\test_exam_5\\java_io\\atlcrime.csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
