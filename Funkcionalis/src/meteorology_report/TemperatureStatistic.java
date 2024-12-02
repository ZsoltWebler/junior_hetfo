package meteorology_report;

import java.util.Objects;
import java.util.Optional;

public class TemperatureStatistic {

    private final String cityCode;
    private final int mediumTemperature;
    private final boolean mediumTemperatureIsPresent;
    private final int temperatureFluctuation;


    public TemperatureStatistic(String cityCode, int mediumTemperature, int temperatureFluctuation) {
        this.cityCode = cityCode;
        this.mediumTemperature = mediumTemperature;
        this.temperatureFluctuation = temperatureFluctuation;
        this.mediumTemperatureIsPresent = true;
    }

    public TemperatureStatistic(String cityCode, int temperatureFluctuation) {
        this.cityCode = cityCode;
        this.mediumTemperature = Integer.MIN_VALUE;
        this.temperatureFluctuation = temperatureFluctuation;
        this.mediumTemperatureIsPresent = false;
    }

    public Optional<Integer> getMediumTemperature() {
        return mediumTemperatureIsPresent ? Optional.of(mediumTemperature) : Optional.empty();
    }

    public int getTemperatureFluctuation() {
        return temperatureFluctuation;
    }

    public String getCityCode() {
        return cityCode;
    }

    @Override
    public String toString() {
        return "TemperatureStatistic{" +
                "cityCode='" + cityCode + '\'' +
                ", mediumTemperature=" + mediumTemperature +
                ", mediumTemperatureIsPresent=" + mediumTemperatureIsPresent +
                ", temperatureFluctuation=" + temperatureFluctuation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemperatureStatistic that = (TemperatureStatistic) o;
        return mediumTemperature == that.mediumTemperature && mediumTemperatureIsPresent == that.mediumTemperatureIsPresent && temperatureFluctuation == that.temperatureFluctuation && Objects.equals(cityCode, that.cityCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityCode, mediumTemperature, mediumTemperatureIsPresent, temperatureFluctuation);
    }
}
