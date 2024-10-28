package sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<List<Integer>> fields = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src/sudoku/nehez.txt"));

            for (int i = 0; i < 9; i++) {

                List<Integer> row = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList();

                fields.add(row);
            }

            SudokuBoard sudokuBoard = new SudokuBoard(fields);


            while (scanner.hasNextLine()){

            }

            System.out.println();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


}