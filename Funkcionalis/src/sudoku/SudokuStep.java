package sudoku;

import java.util.Objects;

public class SudokuStep {

    private final int number;
    private final int rowNumber;
    private final int columnNumber;

    public SudokuStep(int number, int rowNumber, int columnNumber) {
        this.number = number;
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
    }

    public int getNumber() {
        return number;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SudokuStep that = (SudokuStep) o;
        return number == that.number && rowNumber == that.rowNumber && columnNumber == that.columnNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, rowNumber, columnNumber);
    }

    @Override
    public String toString() {
        return "SudokuStep{" +
                "number=" + number +
                ", rowNumber=" + rowNumber +
                ", columnNumber=" + columnNumber +
                '}';
    }
}
