package java_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PeopleReader {


    public static List<People> readPeoplesFromCsv(File file) {
        List<People> peoples = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);

            String headers = scanner.nextLine();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");

                People people = new People(
                        Integer.parseInt(values[0]),
                        values[1],
                        values[2],
                        values[3],
                        Gender.MALE.toString().equalsIgnoreCase(values[4]) ? Gender.MALE : Gender.FEMALE,
                        values[5]
                );

                peoples.add(people);

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return peoples;

    }

}
