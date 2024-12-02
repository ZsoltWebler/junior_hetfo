package meteorology_report;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class MeteorologyReportAnalyzer {

    private final List<MeteorologyReport> meteorologyReports;

    public MeteorologyReportAnalyzer(List<MeteorologyReport> meteorologyReports) {
        this.meteorologyReports = meteorologyReports;
    }

    public LocalTime lastReportFromCity(String cityCode) {

        return meteorologyReports.stream()
                .filter(meteorologyReport -> meteorologyReport.getCityCode().equalsIgnoreCase(cityCode))
                .max(Comparator.comparing(MeteorologyReport::getReportTime))
                .orElseThrow()
                .getReportTime();

    }

    public MeteorologyReport maxTemperature() {
        return meteorologyReports.stream()
                .max(Comparator.comparing(MeteorologyReport::getTemperature))
                .orElseThrow();
    }

    public MeteorologyReport minTemperature() {
        return meteorologyReports.stream()
                .min(Comparator.comparing(MeteorologyReport::getTemperature))
                .orElseThrow();
    }

    public List<MeteorologyReport> reportsFromCalmWindCities() {
        return meteorologyReports.stream()
                .filter(MeteorologyReport::isCalm)
                .toList();
    }

    public Double mediumTemperatureForCity(String cityCode) {

        Map<Integer, List<MeteorologyReport>> collect = meteorologyReports.stream()
                .filter(meteorologyReport -> meteorologyReport.getCityCode().equalsIgnoreCase(cityCode))
                .filter(meteorologyReport ->
                        meteorologyReport.getReportTime().getHour() == 1 ||
                                meteorologyReport.getReportTime().getHour() == 7 ||
                                meteorologyReport.getReportTime().getHour() == 13 ||
                                meteorologyReport.getReportTime().getHour() == 19)
                .collect(Collectors.groupingBy(meteorologyReport -> meteorologyReport.getReportTime().getHour()));

        if (collect.size() != 4) {
            return Double.NaN;
        }

        return collect.entrySet()
                .stream()
                .flatMap(integerListEntry -> integerListEntry.getValue().stream())
                .mapToDouble(MeteorologyReport::getTemperature)
                .average()
                .orElseThrow();
    }

    public int temperatureFluctuation(String cityCode) {
        IntSummaryStatistics temperatureStatistics = meteorologyReports.stream()
                .filter(meteorologyReport -> meteorologyReport.getCityCode().equalsIgnoreCase(cityCode))
                .mapToInt(MeteorologyReport::getTemperature)
                .summaryStatistics();

        return temperatureStatistics.getMax() - temperatureStatistics.getMin();

    }

    public List<TemperatureStatistic> getTemperatureStatistics() {


        return meteorologyReports.stream()
                .map(MeteorologyReport::getCityCode)
                .distinct()
                .map(cityCode -> {
                    Double mediumTemp = mediumTemperatureForCity(cityCode);
                    int tempFluctuation = temperatureFluctuation(cityCode);

                    return mediumTemp.isNaN() ?
                            new TemperatureStatistic(cityCode, tempFluctuation) :
                            new TemperatureStatistic(cityCode, Math.toIntExact(Math.round(mediumTemp)), tempFluctuation);
                })
                .toList();

    }

    public Map<String,List<RecordTimeAndWindStrengthAsString>> reportsByCities(){

        return meteorologyReports.stream()
                .collect(Collectors.groupingBy(
                        MeteorologyReport::getCityCode,
                        Collectors.mapping(
                                meteorologyReport -> new RecordTimeAndWindStrengthAsString(meteorologyReport.getReportTime(),meteorologyReport.getWindStrength()),
                                Collectors.toList())));



    }

}
