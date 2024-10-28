package emitter;

import java.time.LocalTime;
import java.util.Objects;

public class EmitterInfo {

    private final LocalTime timestamp;
    private final Coordinate coordinate;

    public EmitterInfo(int hour, int minute, int seconds, int x, int y) {
        timestamp = LocalTime.of(hour, minute, seconds);
        coordinate = new Coordinate(x, y);
    }

    public LocalTime getTimestamp() {
        return timestamp;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String toString() {
        return "EmitterInfo{" +
                "timestamp=" + timestamp +
                ", coordinate=" + coordinate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmitterInfo that = (EmitterInfo) o;
        return Objects.equals(timestamp, that.timestamp) && Objects.equals(coordinate, that.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, coordinate);
    }
}
