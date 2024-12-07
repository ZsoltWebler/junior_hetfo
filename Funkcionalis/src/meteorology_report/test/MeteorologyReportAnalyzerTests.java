package meteorology_report.test;

import meteorology_report.MeteorologyReport;
import meteorology_report.MeteorologyReportAnalyzer;
import meteorology_report.RecordTimeAndWindStrengthAsString;
import meteorology_report.TemperatureStatistic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MeteorologyReportAnalyzerTests {


    private MeteorologyReportAnalyzer analyzer;

    @BeforeEach
    public void init() {
        analyzer = new MeteorologyReportAnalyzer(List.of(
                new MeteorologyReport("BP", LocalTime.of(20, 0), "200", 5, 10),
                new MeteorologyReport("ST", LocalTime.of(23, 0), "200", 0, 11),
                new MeteorologyReport("BP", LocalTime.of(22, 0), "200", 5, 12),
                new MeteorologyReport("DE", LocalTime.of(21, 0), "200", 0, 13)
        ));
    }

    @Test
    public void lastReportFromCityTest() {
        LocalTime expected = LocalTime.of(22, 0);
        LocalTime actual = analyzer.lastReportFromCity("BP");

        assertEquals(expected, actual);
    }

    @Test
    public void lastReportFromCityTestShouldThrowException() {
        assertThrows(NoSuchElementException.class, () -> {
            analyzer.lastReportFromCity("SZE");
        });

    }

    @Test
    public void maxTemperatureTest() {
        MeteorologyReport expected = new MeteorologyReport("DE", LocalTime.of(21, 0), "200", 0, 13);
        MeteorologyReport actual = analyzer.maxTemperature();

        assertEquals(expected, actual);

    }

    @Test
    public void maxTemperatureTestShouldThrowException() {
        analyzer = new MeteorologyReportAnalyzer(new ArrayList<>());

        assertThrows(NoSuchElementException.class, () -> {
            analyzer.maxTemperature();
        });

    }

    @Test
    public void minTemperatureTest() {
        MeteorologyReport expected = new MeteorologyReport("BP", LocalTime.of(20, 0), "200", 5, 10);
        MeteorologyReport actual = analyzer.minTemperature();

        assertEquals(expected, actual);

    }

    @Test
    public void minTemperatureTestShouldThrowException() {
        analyzer = new MeteorologyReportAnalyzer(new ArrayList<>());

        assertThrows(NoSuchElementException.class, () -> {
            analyzer.minTemperature();
        });
    }

    @Test
    public void reportsFromCalmWindCitiesTest() {


        List<MeteorologyReport> expected = List.of(
                new MeteorologyReport("ST", LocalTime.of(23, 0), "200", 0, 11),
                new MeteorologyReport("DE", LocalTime.of(21, 0), "200", 0, 13));
        List<MeteorologyReport> actual = analyzer.reportsFromCalmWindCities();

        assertEquals(expected, actual);

    }

    @Test
    public void reportsFromCalmWindCitiesTest2() {

        List<MeteorologyReport> actual = analyzer.reportsFromCalmWindCities();

        assertEquals(2, actual.size());
        actual.forEach(meteorologyReport -> assertTrue(meteorologyReport.isCalm()));

    }
    @Test
    public void mediumTemperatureForCityTestShouldReturnNanIfNotEnoughValuePresent(){

        Double expected = Double.NaN;
        Double actual = analyzer.mediumTemperatureForCity("BP");

        assertEquals(expected,actual);
    }

    @Test
    public void mediumTemperatureForCityTest(){

        analyzer = new MeteorologyReportAnalyzer(List.of(
                new MeteorologyReport("BP", LocalTime.of(1, 0), "200", 5, 2),
                new MeteorologyReport("BP", LocalTime.of(7, 0), "200", 5, 4),
                new MeteorologyReport("BP", LocalTime.of(13, 0), "200", 5, 6),
                new MeteorologyReport("BP", LocalTime.of(19, 0), "200", 5, 8),
                new MeteorologyReport("BP", LocalTime.of(19, 0), "200", 5, 10),
                new MeteorologyReport("DE", LocalTime.of(1, 0), "200", 5, 12),
                new MeteorologyReport("BP", LocalTime.of(20, 0), "200", 5, 14)
        ));

        Double expected = 6.0;
        Double actual = analyzer.mediumTemperatureForCity("BP");

        assertEquals(expected,actual);
    }

    @Test
    public void temperatureFluctuationTest(){

        int expected = 2;
        int actual = analyzer.temperatureFluctuation("BP");

        assertEquals(expected,actual);

    }

    @Test
    public void temperatureFluctuationTestShouldThrownException(){

        assertThrows(NoSuchElementException.class, () -> {
            analyzer.temperatureFluctuation("SZV");
        });

    }

    @Test
    public void getTemperatureStatisticsTest(){

        analyzer = new MeteorologyReportAnalyzer(List.of(
                new MeteorologyReport("BP", LocalTime.of(1, 0), "200", 5, 2),
                new MeteorologyReport("BP", LocalTime.of(7, 0), "200", 5, 4),
                new MeteorologyReport("BP", LocalTime.of(13, 0), "200", 5, 6),
                new MeteorologyReport("BP", LocalTime.of(19, 0), "200", 5, 8),
                new MeteorologyReport("BP", LocalTime.of(19, 0), "200", 5, 10),
                new MeteorologyReport("DE", LocalTime.of(1, 0), "200", 5, 12),
                new MeteorologyReport("DE", LocalTime.of(1, 0), "200", 5, 16),
                new MeteorologyReport("BP", LocalTime.of(20, 0), "200", 5, 14)
        ));

        List<TemperatureStatistic> expected = List.of(
                new TemperatureStatistic("BP",6,12),
                new TemperatureStatistic("DE",4)
        );

        List<TemperatureStatistic> actual = analyzer.getTemperatureStatistics();


        assertEquals(expected,actual);

    }

    @Test
    public void reportsByCities(){
        Map<String, List<RecordTimeAndWindStrengthAsString>> actual = analyzer.reportsByCities();

        String BPCode = "BP";
        String DECode = "DE";
        String STCode = "ST";

        assertEquals(Set.of(BPCode,DECode,STCode),actual.keySet());

        List<RecordTimeAndWindStrengthAsString> actualBPList = actual.get(BPCode);

        List<RecordTimeAndWindStrengthAsString> expectedBPList = List.of(
                new RecordTimeAndWindStrengthAsString(LocalTime.of(20, 0), 5),
                new RecordTimeAndWindStrengthAsString(LocalTime.of(22, 0), 5)
        );

        assertEquals(expectedBPList,actualBPList);

        List<RecordTimeAndWindStrengthAsString> actualDEList = actual.get(DECode);

        List<RecordTimeAndWindStrengthAsString> expectedDEList = List.of(
                new RecordTimeAndWindStrengthAsString(LocalTime.of(21, 0), 0)
        );

        assertEquals(expectedDEList,actualDEList);

        List<RecordTimeAndWindStrengthAsString> actualSTList = actual.get(STCode);

        List<RecordTimeAndWindStrengthAsString> expectedSTList = List.of(
                new RecordTimeAndWindStrengthAsString(LocalTime.of(23, 0), 0)
        );

        assertEquals(expectedSTList,actualSTList);
    }

}
