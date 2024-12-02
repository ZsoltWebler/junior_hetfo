package meteorology_report;

import java.time.LocalTime;
import java.util.Objects;

public class RecordTimeAndWindStrengthAsString implements Comparable<RecordTimeAndWindStrengthAsString>{

    private final LocalTime recordTime;
    private final String windStrength;

    public RecordTimeAndWindStrengthAsString(LocalTime recordTime, int windStrength) {
        this.recordTime = recordTime;
        this.windStrength = "#".repeat(windStrength);
    }


    @Override
    public int compareTo(RecordTimeAndWindStrengthAsString o) {
        return this.recordTime.compareTo(o.recordTime);
    }

    public LocalTime getRecordTime() {
        return recordTime;
    }

    public String getWindStrength() {
        return windStrength;
    }

    @Override
    public String toString() {
        return recordTime + " " + windStrength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordTimeAndWindStrengthAsString that = (RecordTimeAndWindStrengthAsString) o;
        return Objects.equals(recordTime, that.recordTime) && Objects.equals(windStrength, that.windStrength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordTime, windStrength);
    }
}
