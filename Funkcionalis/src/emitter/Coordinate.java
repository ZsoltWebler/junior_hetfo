package emitter;

import java.util.Comparator;
import java.util.Objects;

public class Coordinate {

    private final int x;
    private final int y;

    public static double distance(Coordinate c1, Coordinate c2){

        return Math.sqrt(Math.pow(c1.x-c2.x,2)+Math.pow(c1.y-c2.y,2));
    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
