package Date;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Set;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        Set<String> allZoneIds= ZoneId.getAvailableZoneIds();
        ZoneId zoneId=ZoneId.of("Europe/Paris");

        ZonedDateTime zonedDateTime=ZonedDateTime.of(LocalDateTime.now(),zoneId);
        ZonedDateTime.parse("2015-05-03T10:15:30+01:00[Europe/Paris]");

        Period between = Period.between(LocalDate.now(), LocalDate.now().plusWeeks(3));


    }
}