public class EmissionInfo {
    private final String stateName;
    private final int year;

    private final String sectorName;
    private final FuelName fuelName;
    private final double emission;

    public EmissionInfo(String stateName, int year, FuelName fuelName, double emission, String sectorName) {
        this.stateName = stateName;
        this.year = year;
        this.fuelName = fuelName;
        this.emission = emission;
        this.sectorName = sectorName;
    }
}
