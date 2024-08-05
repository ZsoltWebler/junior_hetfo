package practice.books;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class BookMain {


    public static void main(String[] args) {




        List<Book> books = readModel();




    }

    private static List<Book> readModel() {
        List<Book> books = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("W:\\Webler\\Materials\\Git\\junior_hetfo\\junior_hetfo\\Funkcionalis\\src\\practice\\books\\books.csv"));
            String header = scanner.nextLine();

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                String[] values = line.split(";");

                Book book = new Book(values[0], values[1], values[2], values[3], values[4].equals("Yes"));
                books.add(book);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return books;
    }



}
