package sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String fileName = "";
        int rowNumber = -1;
        int columnNumber = -1;
        SudokuBoard sudokuBoard = null;
        List<SudokuStep> steps = new ArrayList<>();

        Scanner consoleScanner = new Scanner(System.in);
        System.out.println("1. feladat");
        System.out.print("Adja meg a bemeneti fájl nevét! ");
        fileName = consoleScanner.nextLine();
        System.out.print("Adja meg egy sor számát! ");
        rowNumber = consoleScanner.nextInt();
        System.out.print("Adja meg egy oszlop számát!");
        columnNumber = consoleScanner.nextInt();



        List<List<Integer>> fields = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src/sudoku/"+fileName));

            for (int i = 0; i < 9; i++) {

                List<Integer> row = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList();

                fields.add(row);
            }

            sudokuBoard = new SudokuBoard(fields);



            while (scanner.hasNextLine()){
                String[] stepValues = scanner.nextLine().split(" ");
                steps.add(new SudokuStep(
                        Integer.parseInt(stepValues[0]),
                        Integer.parseInt(stepValues[1]),
                        Integer.parseInt(stepValues[2])
                ));
            }

            System.out.println();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sudokuBoard);
        System.out.println(steps);

    }


}