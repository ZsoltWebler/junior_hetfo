import java.util.Objects;

public class EmissionRecord {

    private final int year;
    private final String stateName;
    private final String sectorName;
    private final FuelName fuelName;
    private final double emissionValue;

    public EmissionRecord(int year, String stateName, String sectorName, FuelName fuelName, double emissionValue) {
        this.year = year;
        this.stateName = stateName;
        this.sectorName = sectorName;
        this.fuelName = fuelName;
        this.emissionValue = emissionValue;
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

    public FuelName getFuelName() {
        return fuelName;
    }

    public double getEmissionValue() {
        return emissionValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmissionRecord that = (EmissionRecord) o;
        return year == that.year && Double.compare(that.emissionValue, emissionValue) == 0 && Objects.equals(stateName, that.stateName) && Objects.equals(sectorName, that.sectorName) && fuelName == that.fuelName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, stateName, sectorName, fuelName, emissionValue);
    }

    @Override
    public String toString() {
        return "EmissionRecord{" +
                "year=" + year +
                ", stateName='" + stateName + '\'' +
                ", sectorName='" + sectorName + '\'' +
                ", fuelName=" + fuelName +
                ", emissionValue=" + emissionValue +
                '}';
    }
}
