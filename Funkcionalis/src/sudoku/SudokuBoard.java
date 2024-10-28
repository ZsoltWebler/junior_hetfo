package sudoku;

import java.util.List;
import java.util.Objects;

public class SudokuBoard {

    private final List<List<Integer>> fields;

    public SudokuBoard(List<List<Integer>> fields) {
        this.fields = fields;
    }

    public int getField(int row, int column) {
        return fields.get(row + 1).get(column + 1);
    }

    public void setField(int row, int column, int value) {
        fields.get(row + 1).set(column + 1, value);
    }

    public List<List<Integer>> getFields() {
        return fields;
    }

    @Override
    public String toString() {
        return super.toString(); // TODO házi olyan toString mi mutatja a táblázatot
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
