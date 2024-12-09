package java_io;

import java.time.LocalDate;
import java.util.Objects;

public class Crime {
    private final String crimeCategory;
    private final String reportNumber;
    private final LocalDate reportDate;
    private final String location;
    private final int policeBeat;
    private final String neighborhood;
    private final String neighborhoodPlanningUnits;
    private final double latitude;
    private final double longitude;

    public Crime(String crimeCategory, String reportNumber, LocalDate reportDate, String location, int policeBeat, String neighborhood, String neighborhoodPlanningUnits, double latitude, double longitude) {
        this.crimeCategory = crimeCategory;
        this.reportNumber = reportNumber;
        this.reportDate = reportDate;
        this.location = location;
        this.policeBeat = policeBeat;
        this.neighborhood = neighborhood;
        this.neighborhoodPlanningUnits = neighborhoodPlanningUnits;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCrimeCategory() {
        return crimeCategory;
    }

    public String getReportNumber() {
        return reportNumber;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public String getLocation() {
        return location;
    }

    public int getPoliceBeat() {
        return policeBeat;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getNeighborhoodPlanningUnits() {
        return neighborhoodPlanningUnits;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Crime{" +
                "crimeCategory='" + crimeCategory + '\'' +
                ", reportNumber='" + reportNumber + '\'' +
                ", reportDate=" + reportDate +
                ", location='" + location + '\'' +
                ", policeBeat=" + policeBeat +
                ", neighborhood='" + neighborhood + '\'' +
                ", neighborhoodPlanningUnits='" + neighborhoodPlanningUnits + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crime crime = (Crime) o;
        return policeBeat == crime.policeBeat && Double.compare(crime.latitude, latitude) == 0 && Double.compare(crime.longitude, longitude) == 0 && Objects.equals(crimeCategory, crime.crimeCategory) && Objects.equals(reportNumber, crime.reportNumber) && Objects.equals(reportDate, crime.reportDate) && Objects.equals(location, crime.location) && Objects.equals(neighborhood, crime.neighborhood) && Objects.equals(neighborhoodPlanningUnits, crime.neighborhoodPlanningUnits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crimeCategory, reportNumber, reportDate, location, policeBeat, neighborhood, neighborhoodPlanningUnits, latitude, longitude);
    }
}
