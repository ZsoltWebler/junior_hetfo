package sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SudokuBoard {

    private final List<List<Integer>> fields;
    private final List<List<Integer>> subBoards = List.of(
            List.of(1, 1, 1, 2, 2, 2, 3, 3, 3),
            List.of(1, 1, 1, 2, 2, 2, 3, 3, 3),
            List.of(1, 1, 1, 2, 2, 2, 3, 3, 3),
            List.of(4, 4, 4, 5, 5, 5, 6, 6, 6),
            List.of(4, 4, 4, 5, 5, 5, 6, 6, 6),
            List.of(4, 4, 4, 5, 5, 5, 6, 6, 6),
            List.of(7, 7, 7, 8, 8, 8, 9, 9, 9),
            List.of(7, 7, 7, 8, 8, 8, 9, 9, 9),
            List.of(7, 7, 7, 8, 8, 8, 9, 9, 9)
    );

    public SudokuBoard(List<List<Integer>> fields) {
        this.fields = fields;
    }

    public SudokuBoard() {
        this.fields = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            fields.add(new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0)));
        }
    }

    public String isValidStep(int row, int column, int number) {
        if (getField(row, column) != 0) {
            return "Az adott helyett már kitöltötték";
        }

        for (int _column = 1; _column <= 9; _column++) {
            if (getField(row, _column) == number) {
                return "Az adott sorban már szerepel a szám";
            }
        }

        for (int _row = 1; _row <= 9; _row++) {
            if (getField(_row, column) == number) {
                return "Az adott oszlopban már szerepel a szám";
            }
        }


        int subBoard = getSubBoard(row, column);

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (subBoards.get(i - 1).get(j - 1) == subBoard) {
                    if (getField(i, j) == number) {
                        return "Az adott résztáblázatban már szerepel a szám";
                    }
                }
            }
        }

        return "A lépés megtehető";

    }

    public int getField(int row, int column) {
        return fields.get(row - 1).get(column - 1);
    }

    public void setField(int row, int column, int value) {
        fields.get(row - 1).set(column - 1, value);
    }

    public int getSubBoard(int row, int column) {

        if (row <= 3 && row >= 1) {

            if (column <= 3 && column >= 1) {
                return 1;
            }
            if (column <= 6 && column >= 4) {
                return 2;
            }
            if (column <= 9 && column >= 5) {
                return 3;
            }

        }
        if (row <= 6 && row >= 4) {
            if (column <= 3 && column >= 1) {
                return 4;
            }
            if (column <= 6 && column >= 4) {
                return 5;
            }
            if (column <= 9 && column >= 5) {
                return 6;
            }
        }
        if (row <= 9 && row >= 5) {
            if (column <= 3 && column >= 1) {
                return 7;
            }
            if (column <= 6 && column >= 4) {
                return 8;
            }
            if (column <= 9 && column >= 5) {
                return 9;
            }
        }

        return -1;

    }

    public List<List<Integer>> getFields() {
        return fields;
    }


    @Override
    public String toString() {
        return fields.stream().map(row -> row.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SudokuBoard that = (SudokuBoard) o;
        return Objects.equals(fields, that.fields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fields);
    }
}
