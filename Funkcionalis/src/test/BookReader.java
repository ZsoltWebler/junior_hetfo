package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookReader {



    public List<Book> readBooksFromCsv(File file){

        List<Book> books = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);

            String headers = scanner.nextLine();

            while (scanner.hasNextLine()){
                String[] bookValues = scanner.nextLine().split(";");

                Book book = new Book(
                        bookValues[0],
                        bookValues[1],
                        bookValues[2],
                        bookValues[3],
                        bookValues[4].equalsIgnoreCase("yes")
                );

                books.add(book);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return books;

    }

}
