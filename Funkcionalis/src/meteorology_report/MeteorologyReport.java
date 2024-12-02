package meteorology_report;

import java.time.LocalTime;
import java.util.Objects;

public class MeteorologyReport {

    private final String cityCode;
    private final LocalTime reportTime;
    private final String windDirection;
    private final int windStrength;
    private final int temperature;


    public MeteorologyReport(String cityCode, LocalTime reportTime, String windDirection, int windStrength, int temperature) {
        this.cityCode = cityCode;
        this.reportTime = reportTime;
        this.windDirection = windDirection;
        this.windStrength = windStrength;
        this.temperature = temperature;
    }

    public boolean isCalm() {
        return windStrength == 0;
    }

    public String getCityCode() {
        return cityCode;
    }

    public LocalTime getReportTime() {
        return reportTime;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public int getWindStrength() {
        return windStrength;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeteorologyReport that = (MeteorologyReport) o;
        return windStrength == that.windStrength && temperature == that.temperature && Objects.equals(cityCode, that.cityCode) && Objects.equals(reportTime, that.reportTime) && Objects.equals(windDirection, that.windDirection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityCode, reportTime, windDirection, windStrength, temperature);
    }

    @Override
    public String toString() {
        return "MeteorologyReport{" +
                "cityCode='" + cityCode + '\'' +
                ", reportTime=" + reportTime +
                ", windDirection='" + windDirection + '\'' +
                ", windStrength=" + windStrength +
                ", temperature=" + temperature +
                '}';
    }
}
