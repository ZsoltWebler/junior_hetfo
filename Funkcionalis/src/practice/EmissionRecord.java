package practice;

import java.util.Objects;

public class EmissionRecord {

    private final int year;
    private final String stateName;
    private final String sectorName;
    private final Fuel fuelName;
    private final double value;

    public EmissionRecord(int year, String stateName, String sectorName, Fuel fuelName, double value) {
        this.year = year;
        this.stateName = stateName;
        this.sectorName = sectorName;
        this.fuelName = fuelName;
        this.value = value;
    }

    public int getYear() {
        return year;
    }

    public String getStateName() {
        return stateName;
    }

    public String getSectorName() {
        return sectorName;
    }

    public Fuel getFuelName() {
        return fuelName;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "EmissionRecord{" +
                "year=" + year +
                ", stateName='" + stateName + '\'' +
                ", sectorName='" + sectorName + '\'' +
                ", fuelName=" + fuelName +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmissionRecord that = (EmissionRecord) o;
        return year == that.year && Double.compare(that.value, value) == 0 && Objects.equals(stateName, that.stateName) && Objects.equals(sectorName, that.sectorName) && fuelName == that.fuelName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, stateName, sectorName, fuelName, value);
    }
}
