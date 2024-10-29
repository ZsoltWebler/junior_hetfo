package sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
            Scanner scanner = new Scanner(new File("src/sudoku/" + fileName));

            for (int i = 0; i < 9; i++) {

                List<Integer> row = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList();

                fields.add(row);
            }

            sudokuBoard = new SudokuBoard(fields);


            while (scanner.hasNextLine()) {
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

        System.out.println("3. feladat");
        System.out.println("Az adott helyen szereplő szám: " + (sudokuBoard.getField(rowNumber, columnNumber) == 0 ? "Az adott helyet még nem töltötték ki." : sudokuBoard.getField(rowNumber, columnNumber)));
        System.out.println("A hely a(z) " + sudokuBoard.getSubBoard(rowNumber, columnNumber) + " résztáblázathoz tartozik.");


        long zeroFields = sudokuBoard.getFields().stream().flatMap(Collection::stream).filter(number -> number == 0).count();

        double ratio = zeroFields / 81.0;

        System.out.println("4. feladat\n" +
                "Az üres helyek aránya: " + Math.round(ratio * 1000) / 10.0);


        for (SudokuStep sudokuStep : steps) {
            System.out.println("A kiválasztott sor: " + sudokuStep.getRowNumber() + " oszlop: " + sudokuStep.getColumnNumber() + " a szám: " + sudokuStep.getNumber());
            System.out.println(sudokuBoard.isValidStep(sudokuStep.getRowNumber(),sudokuStep.getColumnNumber(), sudokuStep.getNumber()));
        }
    }


}